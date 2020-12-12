insert into cozinha(nome) values ('Tailandesa'), ('Italiana'), ('Brasileira'), ('Moçambicana');

insert into estado(nome) values ('Minas Gerais'), ('Havaí'),('Nova York');

insert into cidade(nome,codigo_estado) values('Belo horizonte',1), ('Kailua',2), ('Albany',3);

insert into restaurante(nome,taxa_frete,codigo_cozinha,data_cadastro,data_actualizacao) values('Doce sabor', 500.0,3, utc_timestamp,utc_timestamp);

insert into restaurante(nome,taxa_frete,codigo_cozinha, endereco_cep, endereco_logradouro, endereco_numero,endereco_complemento,endereco_bairro, endereco_cidade, data_cadastro,data_actualizacao) values('Continental', 750,4,"38400-999","Rua João Pinheiro", "1000","teste","centro",1,utc_timestamp,utc_timestamp);

insert into forma_pagamento(descricao) values("Cartão de crédito"), ("Cartão de débito"), ("Dinheiro");

insert into restaurante_forma_pagamento(codigo_restaurante, codigo_forma_pagamento) values(1,1);

