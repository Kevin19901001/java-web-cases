drop table user;

/* create table 'article' */
create table article(
	id			int(20) auto_increment,
	publisher	varchar(20),
	publishtime	date,
	title		varchar(50),
	content		text,
	constraint pk_id_title_publisher primary key (id, title, publisher)
);

desc article;


/* create table video */
create table video(
	id			int auto_increment,
	title		varchar(50),
	publisher	varchar(20),
	pubtime		date,
	constraint pk_id_title primary key (id, title)
);

desc video;


/* create table user */
create table user (
	id			int(20) auto_increment,
	email		varchar(50) unique not null,
	username	varchar(20) unique not null,
	password	varchar(16),
	level		varchar(10),
	tel			varchar(20),
	sex			varchar(1),
	age			int(3),
	job			varchar(25),
	signdate	date,
	brief		varchar(200),
	constraint pk_id primary key(id)
);

desc user;


/* create table team */
create table team (
	name		varchar(40) primary key,
	city		varchar(40) not null,
	boss		varchar(40) not null,
	main_coach	varchar(40) not null,
	assis_coach	varchar(100) not null
);


/* create table player */
create table player (
	id			int primary key auto_increment,
	first_name	varchar(20) not null,
	last_name	varchar(20) not null,
	age			int not null,
	stature		decimal not null,
	weight		decimal not null,
	city		varchar(40) not null,
	score		int,
	nationality	varchar(20) not null,
	contract	varchar(40) not null,
	interest	varchar(200) not null,
	breif		text,
	team		varchar(40) not null,
	constraint	fk_team foreign key (team) references team (name)
);

desc player;


alter table article modify publishtime datetime;

alter table video modify pubtime datetime;

alter table user change signtime signdate datetime;

select * from user;

delete from user where id=3;

select * from player limit 15; 

select * from user where username='scott19901001';

delete from user where username='scott19901001';

delete from user;