package com.listBuilder.back.service.allBooks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.listBuilder.back.buisness.error.ListBuilderEventCode;
import com.listBuilder.back.buisness.error.ListBuilderException;

import com.listBuilder.back.db.allBooks.entity.AllBooksEntity;
import com.listBuilder.back.db.allBooks.repository.AllBooksRepository;
import com.listBuilder.back.service.allBooks.adapter.AllBooksBackAdapter;
import com.listBuilder.back.service.allBooks.domain.AllBooks;
import lombok.Data;

@Data
@Service
public class AllBooksServiceImpl implements AllBooksService {
	private final AllBooksRepository allBooksRepository;
	private final PlatformTransactionManager transactionManager;
	
	@Autowired
	public AllBooksServiceImpl(AllBooksRepository allBooksRepository, PlatformTransactionManager transactionManager)
	{
		this.allBooksRepository = allBooksRepository;
		this.transactionManager = transactionManager;
	}
	
	
	@Override
	public AllBooks getAllBooksById(long id)
	{
		validateId(id);
		
		AllBooksEntity allBooks = allBooksRepository.findById(id).orElseThrow(() -> new ListBuilderException(ListBuilderEventCode.NOT_FOUND, "no allBooks found"));
		return AllBooksBackAdapter.adaptToBusinessObject(allBooks);
		
	}
	
	@Override
	public List<AllBooks> getAllAllBooks() throws ListBuilderException {
		List<AllBooksEntity> allBooks = allBooksRepository.findAll();
		if (allBooks == null || allBooks.isEmpty()) {
			throw new ListBuilderException(ListBuilderEventCode.NOT_FOUND, "No allBooks found in DB");
		}
		return AllBooksBackAdapter.adaptToBusinessObject(allBooks);
	}
	

	private void validateId(Long id) {
		if (id == null) {
			throw new ListBuilderException(ListBuilderEventCode.INVALID_DATA, "no allBooks id defined");
		}
	}
	
	@Override
	public void deleteAllBooks(Long id) {
		allBooksRepository.deleteById(id);
	}
	
	@Override
	public String createAllBooks(Long id, String name, String version, String linkPath) {
		
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		AllBooksEntity entity = new AllBooksEntity();
		return transactionTemplate.execute(new TransactionCallback<String>() {
			@Override
			public String doInTransaction(TransactionStatus transactionStatus) {
				try {
					entity.setId(id);
					entity.setName(name);
					entity.setVersion(version);
					entity.setLinkPath(linkPath);
					
					AllBooksEntity result = allBooksRepository.save(entity);
					return result.getId().toString();
				} catch (Throwable t) {
					transactionStatus.setRollbackOnly();
					throw new RuntimeException("Error during the recording of the allBooks in database", t);
				}
			}
		});
	}
	
	@Override
	public AllBooks updateAllBooks(Long id, Long id2, Long id3, String name, String version, String linkPath) {
		
		AllBooksEntity entity = allBooksRepository.findById(id)
				.orElseThrow(() -> new ListBuilderException(ListBuilderEventCode.NOT_FOUND, "allBooks not found"));
		
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		
		return transactionTemplate.execute(new TransactionCallback<AllBooks>() {
			@Override
			public AllBooks doInTransaction(TransactionStatus transactionStatus) {
				try {
					entity.setId(id != null ? id : entity.getId());
					entity.setName(name != null ? name : entity.getName());
					entity.setVersion(version != null ? version : entity.getVersion());
					entity.setLinkPath(linkPath != null ? linkPath : entity.getLinkPath());
					
					AllBooksEntity result = allBooksRepository.save(entity);
					return AllBooksBackAdapter.adaptToBusinessObject(result);
				} catch (Throwable t) {
					transactionStatus.setRollbackOnly();
					throw new RuntimeException("Error during the update of the allBooks in database", t);
				}
			}
		});
	}

	
	
	
	
	
}