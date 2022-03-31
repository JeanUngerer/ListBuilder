insert into allBooks values 
	(1, 'GBR', 'V8', 'C:/Bouquins'),
	(2, 'Guerriers_du_chaos', 'V8', 'C:/Bouquins');
	
insert into units values
	(1, 'Seigneur du chaos', 2, 'infanterie', 'seigneur', false, false, 4, 8, 3, 5, 5, 3, 7, 5, 9, 0, 0, 0, 210),
	(2, 'Guerrier du chaos', 2, 'infanterie', 'base', false, false, 4, 5, 3, 4, 4, 1, 5, 2, 8, 0, 0, 0, 15);
	
insert into specialRules values
	(1, 'eye of the gods', 2, 'combat', 'sur kill de monstre ou h�ros faire un jet sur la table des r�compenses d�moniaques'),
	(2, 'frappe toujours en dernier', 1, 'combat', 'la figurine combat apr�s toutes les autres. si frappe toujours en premmier alors combat � init'),
	(3, 'peur', 1, 'combat', 'la figurine cause la peur'),
	(4, 'parade', 1, 'combat', 'la figurine gagne une sauvegarde invlun�rable de 6 contre les attaques au CAC de face');
	
insert into equipments values
	(1, 'armure du chaos', 2, 'normal', '+3 points armor'),
	(2, 'bouclier', 1, 'normal', '+1 point armor quand utilis� (utilise une main)'),
	(3, 'arme lourde', 1, 'normal', '+2 force au CAC, 2 mains, gagne la r�gle frappe toujours en dernier'),
	(4, 'talisman de pr�servation', 1, 'magique', 'sauvegarde invuln�rable � 4');

insert into mountsList values
	(1, 'destrier du chaos capara�onn�', 2, 'cavalerie', false, 8, 3, 0, 4, 3, 1, 3, 1, 5, 0);

insert into magicDomains values
	(1, 'feu', 1, '+1D3 au cast si la cible a d�ja �t� touch�e ce tour par un sort du domaine du feu');

insert into spellsList values
	(1, 1, 'boule de feu', 'dommages directs', 'normal casting : 1d6 touches F4 enflamm�es, enhanced cast : 2d6 touches F4 enflamm�es', 0, true, 6, 12);
	
insert into unitRulesRel values
	(1, 1, 1, 0, false),
	(2, 2, 1, 0, false);

insert into unitEquipmentRel values
	(1, 1, 1, 0, false),
	(2, 1, 2, 5, true),
	(3, 1, 3, 8, true),
	(4, 1, 4, 45, true),
	(5, 2, 1, 0, false),
	(6, 2, 2, 1, true),
	(7, 2, 3, 3, true);
	
insert into unitMountRel values
	(1, 1, 1, 24, true);

insert into mountRulesRel values
	(1, 1, 3, 0, false);
	
insert into equipmentRulesRel values
	(1, 3, 2),
	(2, 2, 4);