create table forma_pagamento 
(
	codigo bigint not null auto_increment, 
	descricao varchar(100) not null, 
	primary key (codigo)
)engine=InnoDB default charset=utf8;

create table grupo 
(
	codigo bigint not null auto_increment, 
	nome varchar(80) not null, 
	primary key (codigo)
)engine=InnoDB default charset=utf8;

create table grupo_permissao 
(
	codigo_grupo bigint not null, 
	codigo_permissao bigint not null
)engine=InnoDB default charset = utf8;


create table permissao 
(
	codigo bigint not null auto_increment,
	nome varchar(80) not null, 
	descricao varchar(80) not null, 
	primary key (codigo)
)engine=InnoDB default charset=utf8;

create table produto 
(
	codigo bigint not null auto_increment, 
	activo tinyint(1) not null, 
	descricao varchar(255) not null, 
	nome varchar(80) not null, 
	preco decimal(10,2) not null, 
	codigo_restaurante bigint, 
	primary key (codigo)
) engine=InnoDB default charset=utf8;

create table restaurante (
	codigo bigint not null auto_increment, 
	data_actualizacao datetime not null, 
	data_cadastro datetime not null, 
	endereco_bairro varchar(80), 
	endereco_cep varchar(80), 
	endereco_complemento varchar(80), 
	endereco_logradouro varchar(80), 
	endereco_numero varchar(80), 
	nome varchar(80) not null, 
	taxa_frete decimal(10,2) not null, 
	codigo_cozinha bigint not null, 
	codigo_endereco_cidade bigint, 
	primary key (codigo)
) engine=InnoDB default charset=utf8;

create table restaurante_forma_pagamento 
(
	codigo_restaurante bigint not null, 
	codigo_forma_pagamento bigint not null
) engine=InnoDB default charset=utf8;

create table usuario (
	codigo bigint not null auto_increment, 
	data_cadastro datetime not null, 
	email varchar(80) not null, 
	nome varchar(80) not null,
	senha varchar(80) not null, 
	primary key (codigo)
) engine=InnoDB default charset = utf8;

create table usuario_grupo 
(
	codigo_usuario bigint not null, 
	codigo_grupo bigint not null
) engine=InnoDB default charset=utf8;


alter table grupo_permissao 
add constraint FK_grupo_permissao_permissao foreign key (codigo_permissao) references permissao (codigo);

alter table grupo_permissao 
add constraint FK_grupo_permissao_grupo foreign key (codigo_grupo) references grupo (codigo);

alter table produto 
add constraint FK_produto_restaurante foreign key (codigo_restaurante) references restaurante (codigo);

alter table restaurante 
add constraint FK_restaurente_cozinha foreign key (codigo_cozinha) references cozinha (codigo);

alter table restaurante 
add constraint FK_restaurante_cidade foreign key (codigo_endereco_cidade) references cidade (codigo);

alter table restaurante_forma_pagamento 
add constraint FK_restaurante_forma_pagamento_forma_pagamento foreign key (codigo_forma_pagamento) references forma_pagamento (codigo);

alter table restaurante_forma_pagamento 
add constraint FK_restaurante_forma_pagamento_restaurante foreign key (codigo_restaurante) references restaurante (codigo);

alter table usuario_grupo 
add constraint FK_usuario_grupo_grupo foreign key (codigo_grupo) references grupo (codigo);

alter table usuario_grupo 
add constraint FK_usuario_grupo_usuario foreign key (codigo_usuario) references usuario (codigo);
