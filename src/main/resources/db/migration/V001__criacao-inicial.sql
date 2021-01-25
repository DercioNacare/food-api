create table cozinha
(
	codigo bigint not null auto_increment,
	nome varchar(60) not null,
	
	primary key(codigo)
)engine=InnoDB default charset=utf8;