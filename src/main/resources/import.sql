insert into cozinha(nome) values ('Tailandesa'), ('Italiana'), ('Brasileira'), ('Moçambicana');

insert into restaurante(nome,taxa_frete,codigo_cozinha) values('Doce sabor', 500.0,3), ('Continental', 750,4);

insert into forma_pagamento(descricao) values("Cartão de crédito"), ("Cartão de débito"), ("Dinheiro");

insert into restaurante_forma_pagamento(codigo_restaurante, codigo_forma_pagamento) values(1,1),(1,2),(2,1),(2,2), (2,3);

insert into estado(nome) values ('Minas Gerais'), ('Havaí'),('Nova York');

insert into cidade(nome,codigo_estado) values('Belo horizonte',1), ('Kailua',2), ('Albany',3);