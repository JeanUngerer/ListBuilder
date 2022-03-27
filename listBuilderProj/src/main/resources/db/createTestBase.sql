create table allBooks (
   ID serial,
   name varchar(255),
   version varchar(255),
   linkPath varchar(255)
);

create table units (
	ID serial,
	name varchar(255),
	bookId bigint,
	unitType varchar(255),
	unitCategory varchar(255),
	namedUnique boolean,
	defaultMount boolean,
	movement integer,
	closeCombatSkills integer,
	shootingSkills integer,
	strengh integer,
	toughness integer,
	wounds integer,
	initiative integer,
	attacks integer,
	leadership integer,
	baseArmor integer,
	baseInvul integer,
	magicLvl integer,
	baseCost integer
);

create table specialRules (
	ID serial,
	name varchar(255),
	bookId bigint,
	phaseOfApplication varchar(255),
	ruleText varchar(255)
);

create table equipments (
	ID serial,
	name varchar(255),
	bookId bigint,
	type varchar(255),          /*  magic items are destructible and concealed  */
	effectStats varchar(255)
);

create table mountsList (
	ID serial,
	name varchar(255),
	bookId bigint,
	type varchar(255),
	namedUnique boolean,
	movement integer,
	closeCombatSkills integer,
	shootingSkills integer,
	strengh integer,
	toughness integer,
	wounds integer,
	initiative integer,
	attacks integer,
	leadership integer,
	baseArmor integer
);

create table magicDomains (
	ID serial,
	name varchar(255),
	bookId bigint,
	domainAttribute varchar(255)
);

create table spellsList (
	ID serial,
	domainId bigint,
	name varchar(255),
	type varchar(255),
	effects varchar(255),
	wheeleNumber integer,
	improvable boolean,
	castingValue integer,
	augmentedCastingValue integer
);

create table unitRulesRel (
	ID serial,
	unitId bigint,
	ruleId bigint,
	cost integer,
	optional boolean
);

create table unitEquipmentRel (
	ID serial,
	unitId bigint,
	equipmentId bigint,
	cost integer,
	optional boolean
);

create table unitMountRel (
	ID serial,
	unitId bigint,
	mountId bigint,
	cost integer,
	optional boolean
	
);

create table unitDomainRel (
	ID serial,
	unitId bigint,
	domainId bigint
);


create table mountRulesRel (
	ID serial,
	mountId bigint,
	ruleId bigint,
	cost integer,
	optional boolean
);

create table equipmentRulesRel (
	ID serial,
	equipmentId bigint,
	ruleId bigint
);