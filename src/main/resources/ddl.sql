create table cidade (codigo bigint not null auto_increment, nome varchar(255) not null, codigo_estado bigint not null, primary key (codigo)) engine=InnoDB
create table cozinha (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table estado (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table forma_pagamento (codigo bigint not null auto_increment, descricao varchar(255) not null, primary key (codigo)) engine=InnoDB
create table grupo (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table grupo_permissao (codigo_grupo bigint not null, codigo_permissao bigint not null) engine=InnoDB
create table permissao (codigo bigint not null auto_increment, descricao varchar(255) not null, primary key (codigo)) engine=InnoDB
create table produto (codigo bigint not null auto_increment, activo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, codigo_restaurante bigint, primary key (codigo)) engine=InnoDB
create table restaurante (codigo bigint not null auto_increment, data_actualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, codigo_cozinha bigint not null, endereco_cidade bigint, primary key (codigo)) engine=InnoDB
create table restaurante_forma_pagamento (codigo_restaurante bigint not null, codigo_forma_pagamento bigint not null) engine=InnoDB
create table usuario (codigo bigint not null auto_increment, data_cadastro datetime not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (codigo)) engine=InnoDB
create table usuario_grupo (codigo_usuario bigint not null, codigo_grupo bigint not null) engine=InnoDB
alter table cidade add constraint FK3p3ii5fk4vpyyp0bju26kggbb foreign key (codigo_estado) references estado (codigo)
alter table grupo_permissao add constraint FKfp14wb9mt832y4jlw2rx3pf6p foreign key (codigo_permissao) references permissao (codigo)
alter table grupo_permissao add constraint FKh1lvrl72de4u5xhr1u3jvo0rq foreign key (codigo_grupo) references grupo (codigo)
alter table produto add constraint FK72yd5o424fmiwtb0p1ermyhjt foreign key (codigo_restaurante) references restaurante (codigo)
alter table restaurante add constraint FKu6dhrpslegys0822r2delivq foreign key (codigo_cozinha) references cozinha (codigo)
alter table restaurante add constraint FKa3ii9yjt0c00jbq7pjxi59jfm foreign key (endereco_cidade) references cidade (codigo)
alter table restaurante_forma_pagamento add constraint FKkf5s2cf9pa6nd9ssp3x16w12t foreign key (codigo_forma_pagamento) references forma_pagamento (codigo)
alter table restaurante_forma_pagamento add constraint FKm4bm37c5mdhpf16ad908hles0 foreign key (codigo_restaurante) references restaurante (codigo)
alter table usuario_grupo add constraint FK4yweq9u2sokki6o060mejfw8r foreign key (codigo_grupo) references grupo (codigo)
alter table usuario_grupo add constraint FKcx5f61jsftmpnlu4ec8fyndg3 foreign key (codigo_usuario) references usuario (codigo)
insert into cozinha(nome) values ('Tailandesa'), ('Italiana'), ('Brasileira'), ('Moçambicana')
insert into estado(nome) values ('Minas Gerais'), ('Havaí'),('Nova York')
insert into cidade(nome,codigo_estado) values('Belo horizonte',1), ('Kailua',2), ('Albany',3)
insert into restaurante(nome,taxa_frete,codigo_cozinha,data_cadastro,data_actualizacao) values('Doce sabor', 500.0,3, utc_timestamp,utc_timestamp)
insert into restaurante(nome,taxa_frete,codigo_cozinha, endereco_cep, endereco_logradouro, endereco_numero,endereco_complemento,endereco_bairro, endereco_cidade, data_cadastro,data_actualizacao) values('Continental', 750,4,"38400-999","Rua João Pinheiro", "1000","teste","centro",1,utc_timestamp,utc_timestamp)
insert into forma_pagamento(descricao) values("Cartão de crédito"), ("Cartão de débito"), ("Dinheiro")
insert into restaurante_forma_pagamento(codigo_restaurante, codigo_forma_pagamento) values(1,1)
insert into produto(nome,descricao,preco,activo, codigo_restaurante) values("Chouriço","Chouriço importado de portugal", 350,true,1)
create table cidade (codigo bigint not null auto_increment, nome varchar(255) not null, codigo_estado bigint not null, primary key (codigo)) engine=InnoDB
create table cozinha (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table estado (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table forma_pagamento (codigo bigint not null auto_increment, descricao varchar(255) not null, primary key (codigo)) engine=InnoDB
create table grupo (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table grupo_permissao (codigo_grupo bigint not null, codigo_permissao bigint not null) engine=InnoDB
create table permissao (codigo bigint not null auto_increment, descricao varchar(255) not null, primary key (codigo)) engine=InnoDB
create table produto (codigo bigint not null auto_increment, activo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, codigo_restaurante bigint, primary key (codigo)) engine=InnoDB
create table restaurante (codigo bigint not null auto_increment, data_actualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, codigo_cozinha bigint not null, endereco_cidade bigint, primary key (codigo)) engine=InnoDB
create table restaurante_forma_pagamento (codigo_restaurante bigint not null, codigo_forma_pagamento bigint not null) engine=InnoDB
create table usuario (codigo bigint not null auto_increment, data_cadastro datetime not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (codigo)) engine=InnoDB
create table usuario_grupo (codigo_usuario bigint not null, codigo_grupo bigint not null) engine=InnoDB
alter table cidade add constraint FK3p3ii5fk4vpyyp0bju26kggbb foreign key (codigo_estado) references estado (codigo)
alter table grupo_permissao add constraint FKfp14wb9mt832y4jlw2rx3pf6p foreign key (codigo_permissao) references permissao (codigo)
alter table grupo_permissao add constraint FKh1lvrl72de4u5xhr1u3jvo0rq foreign key (codigo_grupo) references grupo (codigo)
alter table produto add constraint FK72yd5o424fmiwtb0p1ermyhjt foreign key (codigo_restaurante) references restaurante (codigo)
alter table restaurante add constraint FKu6dhrpslegys0822r2delivq foreign key (codigo_cozinha) references cozinha (codigo)
alter table restaurante add constraint FKa3ii9yjt0c00jbq7pjxi59jfm foreign key (endereco_cidade) references cidade (codigo)
alter table restaurante_forma_pagamento add constraint FKkf5s2cf9pa6nd9ssp3x16w12t foreign key (codigo_forma_pagamento) references forma_pagamento (codigo)
alter table restaurante_forma_pagamento add constraint FKm4bm37c5mdhpf16ad908hles0 foreign key (codigo_restaurante) references restaurante (codigo)
alter table usuario_grupo add constraint FK4yweq9u2sokki6o060mejfw8r foreign key (codigo_grupo) references grupo (codigo)
alter table usuario_grupo add constraint FKcx5f61jsftmpnlu4ec8fyndg3 foreign key (codigo_usuario) references usuario (codigo)
insert into cozinha(nome) values ('Tailandesa'), ('Italiana'), ('Brasileira'), ('Moçambicana')
insert into estado(nome) values ('Minas Gerais'), ('Havaí'),('Nova York')
insert into cidade(nome,codigo_estado) values('Belo horizonte',1), ('Kailua',2), ('Albany',3)
insert into restaurante(nome,taxa_frete,codigo_cozinha,data_cadastro,data_actualizacao) values('Doce sabor', 500.0,3, utc_timestamp,utc_timestamp)
insert into restaurante(nome,taxa_frete,codigo_cozinha, endereco_cep, endereco_logradouro, endereco_numero,endereco_complemento,endereco_bairro, endereco_cidade, data_cadastro,data_actualizacao) values('Continental', 750,4,"38400-999","Rua João Pinheiro", "1000","teste","centro",1,utc_timestamp,utc_timestamp)
insert into forma_pagamento(descricao) values("Cartão de crédito"), ("Cartão de débito"), ("Dinheiro")
insert into restaurante_forma_pagamento(codigo_restaurante, codigo_forma_pagamento) values(1,1)
insert into produto(nome,descricao,preco,activo, codigo_restaurante) values("Chouriço","Chouriço importado de portugal", 350,true,1)
create table cidade (codigo bigint not null auto_increment, nome varchar(255) not null, codigo_estado bigint not null, primary key (codigo)) engine=InnoDB
create table cozinha (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table estado (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table forma_pagamento (codigo bigint not null auto_increment, descricao varchar(255) not null, primary key (codigo)) engine=InnoDB
create table grupo (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table grupo_permissao (codigo_grupo bigint not null, codigo_permissao bigint not null) engine=InnoDB
create table permissao (codigo bigint not null auto_increment, descricao varchar(255) not null, primary key (codigo)) engine=InnoDB
create table produto (codigo bigint not null auto_increment, activo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, codigo_restaurante bigint, primary key (codigo)) engine=InnoDB
create table restaurante (codigo bigint not null auto_increment, data_actualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, codigo_cozinha bigint not null, endereco_cidade bigint, primary key (codigo)) engine=InnoDB
create table restaurante_forma_pagamento (codigo_restaurante bigint not null, codigo_forma_pagamento bigint not null) engine=InnoDB
create table usuario (codigo bigint not null auto_increment, data_cadastro datetime not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (codigo)) engine=InnoDB
create table usuario_grupo (codigo_usuario bigint not null, codigo_grupo bigint not null) engine=InnoDB
alter table cidade add constraint FK3p3ii5fk4vpyyp0bju26kggbb foreign key (codigo_estado) references estado (codigo)
alter table grupo_permissao add constraint FKfp14wb9mt832y4jlw2rx3pf6p foreign key (codigo_permissao) references permissao (codigo)
alter table grupo_permissao add constraint FKh1lvrl72de4u5xhr1u3jvo0rq foreign key (codigo_grupo) references grupo (codigo)
alter table produto add constraint FK72yd5o424fmiwtb0p1ermyhjt foreign key (codigo_restaurante) references restaurante (codigo)
alter table restaurante add constraint FKu6dhrpslegys0822r2delivq foreign key (codigo_cozinha) references cozinha (codigo)
alter table restaurante add constraint FKa3ii9yjt0c00jbq7pjxi59jfm foreign key (endereco_cidade) references cidade (codigo)
alter table restaurante_forma_pagamento add constraint FKkf5s2cf9pa6nd9ssp3x16w12t foreign key (codigo_forma_pagamento) references forma_pagamento (codigo)
alter table restaurante_forma_pagamento add constraint FKm4bm37c5mdhpf16ad908hles0 foreign key (codigo_restaurante) references restaurante (codigo)
alter table usuario_grupo add constraint FK4yweq9u2sokki6o060mejfw8r foreign key (codigo_grupo) references grupo (codigo)
alter table usuario_grupo add constraint FKcx5f61jsftmpnlu4ec8fyndg3 foreign key (codigo_usuario) references usuario (codigo)
insert into cozinha(nome) values ('Tailandesa'), ('Italiana'), ('Brasileira'), ('Moçambicana')
insert into estado(nome) values ('Minas Gerais'), ('Havaí'),('Nova York')
insert into cidade(nome,codigo_estado) values('Belo horizonte',1), ('Kailua',2), ('Albany',3)
insert into restaurante(nome,taxa_frete,codigo_cozinha,data_cadastro,data_actualizacao) values('Doce sabor', 500.0,3, utc_timestamp,utc_timestamp)
insert into restaurante(nome,taxa_frete,codigo_cozinha, endereco_cep, endereco_logradouro, endereco_numero,endereco_complemento,endereco_bairro, endereco_cidade, data_cadastro,data_actualizacao) values('Continental', 750,4,"38400-999","Rua João Pinheiro", "1000","teste","centro",1,utc_timestamp,utc_timestamp)
insert into forma_pagamento(descricao) values("Cartão de crédito"), ("Cartão de débito"), ("Dinheiro")
insert into restaurante_forma_pagamento(codigo_restaurante, codigo_forma_pagamento) values(1,1)
insert into produto(nome,descricao,preco,activo, codigo_restaurante) values("Chouriço","Chouriço importado de portugal", 350,true,1)
create table cidade (codigo bigint not null auto_increment, nome varchar(255) not null, codigo_estado bigint not null, primary key (codigo)) engine=InnoDB
create table cozinha (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table estado (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table forma_pagamento (codigo bigint not null auto_increment, descricao varchar(255) not null, primary key (codigo)) engine=InnoDB
create table grupo (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table grupo_permissao (codigo_grupo bigint not null, codigo_permissao bigint not null) engine=InnoDB
create table permissao (codigo bigint not null auto_increment, descricao varchar(255) not null, primary key (codigo)) engine=InnoDB
create table produto (codigo bigint not null auto_increment, activo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, codigo_restaurante bigint, primary key (codigo)) engine=InnoDB
create table restaurante (codigo bigint not null auto_increment, data_actualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, codigo_cozinha bigint not null, endereco_cidade bigint, primary key (codigo)) engine=InnoDB
create table restaurante_forma_pagamento (codigo_restaurante bigint not null, codigo_forma_pagamento bigint not null) engine=InnoDB
create table usuario (codigo bigint not null auto_increment, data_cadastro datetime not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (codigo)) engine=InnoDB
create table usuario_grupo (codigo_usuario bigint not null, codigo_grupo bigint not null) engine=InnoDB
alter table cidade add constraint FK3p3ii5fk4vpyyp0bju26kggbb foreign key (codigo_estado) references estado (codigo)
alter table grupo_permissao add constraint FKfp14wb9mt832y4jlw2rx3pf6p foreign key (codigo_permissao) references permissao (codigo)
alter table grupo_permissao add constraint FKh1lvrl72de4u5xhr1u3jvo0rq foreign key (codigo_grupo) references grupo (codigo)
alter table produto add constraint FK72yd5o424fmiwtb0p1ermyhjt foreign key (codigo_restaurante) references restaurante (codigo)
alter table restaurante add constraint FKu6dhrpslegys0822r2delivq foreign key (codigo_cozinha) references cozinha (codigo)
alter table restaurante add constraint FKa3ii9yjt0c00jbq7pjxi59jfm foreign key (endereco_cidade) references cidade (codigo)
alter table restaurante_forma_pagamento add constraint FKkf5s2cf9pa6nd9ssp3x16w12t foreign key (codigo_forma_pagamento) references forma_pagamento (codigo)
alter table restaurante_forma_pagamento add constraint FKm4bm37c5mdhpf16ad908hles0 foreign key (codigo_restaurante) references restaurante (codigo)
alter table usuario_grupo add constraint FK4yweq9u2sokki6o060mejfw8r foreign key (codigo_grupo) references grupo (codigo)
alter table usuario_grupo add constraint FKcx5f61jsftmpnlu4ec8fyndg3 foreign key (codigo_usuario) references usuario (codigo)
insert into cozinha(nome) values ('Tailandesa'), ('Italiana'), ('Brasileira'), ('Moçambicana')
insert into estado(nome) values ('Minas Gerais'), ('Havaí'),('Nova York')
insert into cidade(nome,codigo_estado) values('Belo horizonte',1), ('Kailua',2), ('Albany',3)
insert into restaurante(nome,taxa_frete,codigo_cozinha,data_cadastro,data_actualizacao) values('Doce sabor', 500.0,3, utc_timestamp,utc_timestamp)
insert into restaurante(nome,taxa_frete,codigo_cozinha, endereco_cep, endereco_logradouro, endereco_numero,endereco_complemento,endereco_bairro, endereco_cidade, data_cadastro,data_actualizacao) values('Continental', 750,4,"38400-999","Rua João Pinheiro", "1000","teste","centro",1,utc_timestamp,utc_timestamp)
insert into forma_pagamento(descricao) values("Cartão de crédito"), ("Cartão de débito"), ("Dinheiro")
insert into restaurante_forma_pagamento(codigo_restaurante, codigo_forma_pagamento) values(1,1)
insert into produto(nome,descricao,preco,activo, codigo_restaurante) values("Chouriço","Chouriço importado de portugal", 350,true,1)
create table cidade (codigo bigint not null auto_increment, nome varchar(255) not null, codigo_estado bigint not null, primary key (codigo)) engine=InnoDB
create table cozinha (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table estado (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table forma_pagamento (codigo bigint not null auto_increment, descricao varchar(255) not null, primary key (codigo)) engine=InnoDB
create table grupo (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table grupo_permissao (codigo_grupo bigint not null, codigo_permissao bigint not null) engine=InnoDB
create table permissao (codigo bigint not null auto_increment, descricao varchar(255) not null, primary key (codigo)) engine=InnoDB
create table produto (codigo bigint not null auto_increment, activo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, codigo_restaurante bigint, primary key (codigo)) engine=InnoDB
create table restaurante (codigo bigint not null auto_increment, data_actualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, codigo_cozinha bigint not null, endereco_cidade bigint, primary key (codigo)) engine=InnoDB
create table restaurante_forma_pagamento (codigo_restaurante bigint not null, codigo_forma_pagamento bigint not null) engine=InnoDB
create table usuario (codigo bigint not null auto_increment, data_cadastro datetime not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (codigo)) engine=InnoDB
create table usuario_grupo (codigo_usuario bigint not null, codigo_grupo bigint not null) engine=InnoDB
alter table cidade add constraint FK3p3ii5fk4vpyyp0bju26kggbb foreign key (codigo_estado) references estado (codigo)
alter table grupo_permissao add constraint FKfp14wb9mt832y4jlw2rx3pf6p foreign key (codigo_permissao) references permissao (codigo)
alter table grupo_permissao add constraint FKh1lvrl72de4u5xhr1u3jvo0rq foreign key (codigo_grupo) references grupo (codigo)
alter table produto add constraint FK72yd5o424fmiwtb0p1ermyhjt foreign key (codigo_restaurante) references restaurante (codigo)
alter table restaurante add constraint FKu6dhrpslegys0822r2delivq foreign key (codigo_cozinha) references cozinha (codigo)
alter table restaurante add constraint FKa3ii9yjt0c00jbq7pjxi59jfm foreign key (endereco_cidade) references cidade (codigo)
alter table restaurante_forma_pagamento add constraint FKkf5s2cf9pa6nd9ssp3x16w12t foreign key (codigo_forma_pagamento) references forma_pagamento (codigo)
alter table restaurante_forma_pagamento add constraint FKm4bm37c5mdhpf16ad908hles0 foreign key (codigo_restaurante) references restaurante (codigo)
alter table usuario_grupo add constraint FK4yweq9u2sokki6o060mejfw8r foreign key (codigo_grupo) references grupo (codigo)
alter table usuario_grupo add constraint FKcx5f61jsftmpnlu4ec8fyndg3 foreign key (codigo_usuario) references usuario (codigo)
insert into cozinha(nome) values ('Tailandesa'), ('Italiana'), ('Brasileira'), ('Moçambicana')
insert into estado(nome) values ('Minas Gerais'), ('Havaí'),('Nova York')
insert into cidade(nome,codigo_estado) values('Belo horizonte',1), ('Kailua',2), ('Albany',3)
insert into restaurante(nome,taxa_frete,codigo_cozinha,data_cadastro,data_actualizacao) values('Doce sabor', 500.0,3, utc_timestamp,utc_timestamp)
insert into restaurante(nome,taxa_frete,codigo_cozinha, endereco_cep, endereco_logradouro, endereco_numero,endereco_complemento,endereco_bairro, endereco_cidade, data_cadastro,data_actualizacao) values('Continental', 750,4,"38400-999","Rua João Pinheiro", "1000","teste","centro",1,utc_timestamp,utc_timestamp)
insert into forma_pagamento(descricao) values("Cartão de crédito"), ("Cartão de débito"), ("Dinheiro")
insert into restaurante_forma_pagamento(codigo_restaurante, codigo_forma_pagamento) values(1,1)
insert into produto(nome,descricao,preco,activo, codigo_restaurante) values("Chouriço","Chouriço importado de portugal", 350,true,1)
create table cidade (codigo bigint not null auto_increment, nome varchar(255) not null, codigo_estado bigint not null, primary key (codigo)) engine=InnoDB
create table cozinha (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table estado (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table forma_pagamento (codigo bigint not null auto_increment, descricao varchar(255) not null, primary key (codigo)) engine=InnoDB
create table grupo (codigo bigint not null auto_increment, nome varchar(255) not null, primary key (codigo)) engine=InnoDB
create table grupo_permissao (codigo_grupo bigint not null, codigo_permissao bigint not null) engine=InnoDB
create table permissao (codigo bigint not null auto_increment, descricao varchar(255) not null, primary key (codigo)) engine=InnoDB
create table produto (codigo bigint not null auto_increment, activo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, codigo_restaurante bigint, primary key (codigo)) engine=InnoDB
create table restaurante (codigo bigint not null auto_increment, data_actualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, codigo_cozinha bigint not null, endereco_cidade bigint, primary key (codigo)) engine=InnoDB
create table restaurante_forma_pagamento (codigo_restaurante bigint not null, codigo_forma_pagamento bigint not null) engine=InnoDB
create table usuario (codigo bigint not null auto_increment, data_cadastro datetime not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (codigo)) engine=InnoDB
create table usuario_grupo (codigo_usuario bigint not null, codigo_grupo bigint not null) engine=InnoDB
alter table cidade add constraint FK3p3ii5fk4vpyyp0bju26kggbb foreign key (codigo_estado) references estado (codigo)
alter table grupo_permissao add constraint FKfp14wb9mt832y4jlw2rx3pf6p foreign key (codigo_permissao) references permissao (codigo)
alter table grupo_permissao add constraint FKh1lvrl72de4u5xhr1u3jvo0rq foreign key (codigo_grupo) references grupo (codigo)
alter table produto add constraint FK72yd5o424fmiwtb0p1ermyhjt foreign key (codigo_restaurante) references restaurante (codigo)
alter table restaurante add constraint FKu6dhrpslegys0822r2delivq foreign key (codigo_cozinha) references cozinha (codigo)
alter table restaurante add constraint FKa3ii9yjt0c00jbq7pjxi59jfm foreign key (endereco_cidade) references cidade (codigo)
alter table restaurante_forma_pagamento add constraint FKkf5s2cf9pa6nd9ssp3x16w12t foreign key (codigo_forma_pagamento) references forma_pagamento (codigo)
alter table restaurante_forma_pagamento add constraint FKm4bm37c5mdhpf16ad908hles0 foreign key (codigo_restaurante) references restaurante (codigo)
alter table usuario_grupo add constraint FK4yweq9u2sokki6o060mejfw8r foreign key (codigo_grupo) references grupo (codigo)
alter table usuario_grupo add constraint FKcx5f61jsftmpnlu4ec8fyndg3 foreign key (codigo_usuario) references usuario (codigo)
insert into cozinha(nome) values ('Tailandesa'), ('Italiana'), ('Brasileira'), ('Moçambicana')
insert into estado(nome) values ('Minas Gerais'), ('Havaí'),('Nova York')
insert into cidade(nome,codigo_estado) values('Belo horizonte',1), ('Kailua',2), ('Albany',3)
insert into restaurante(nome,taxa_frete,codigo_cozinha,data_cadastro,data_actualizacao) values('Doce sabor', 500.0,3, utc_timestamp,utc_timestamp)
insert into restaurante(nome,taxa_frete,codigo_cozinha, endereco_cep, endereco_logradouro, endereco_numero,endereco_complemento,endereco_bairro, endereco_cidade, data_cadastro,data_actualizacao) values('Continental', 750,4,"38400-999","Rua João Pinheiro", "1000","teste","centro",1,utc_timestamp,utc_timestamp)
insert into forma_pagamento(descricao) values("Cartão de crédito"), ("Cartão de débito"), ("Dinheiro")
insert into restaurante_forma_pagamento(codigo_restaurante, codigo_forma_pagamento) values(1,1)
insert into produto(nome,descricao,preco,activo, codigo_restaurante) values("Chouriço","Chouriço importado de portugal", 350,true,1)
