CREATE TABLE pedido
(
	codigo BIGINT NOT NULL AUTO_INCREMENT,
	subtotal DECIMAL(10,2) NOT NULL,
	taxa_frete DECIMAL(10,2) NOT NULL,
	valor_total DECIMAL(10,2) NOT NULL,
	data_criacao DATETIME NOT NULL,
	data_confirmacao DATETIME,
	data_cancelamento DATETIME,
	data_entrega DATETIME,
	status VARCHAR(45) NOT NULL,
	endereco_cep VARCHAR(45) NOT NULL,
	endereco_logradouro VARCHAR(45) NOT NULL,
	endereco_numero VARCHAR(45) NOT NULL,
	endereco_complemento VARCHAR(45) NOT NULL,
	endereco_bairro VARCHAR(45) NOT NULL,
	codigo_endereco_cidade BIGINT NOT NULL,
	codigo_restaurante BIGINT NOT NULL,
	codigo_cliente BIGINT NOT NULL,
	codigo_forma_pagamento BIGINT NOT NULL,
	
	PRIMARY KEY(codigo)		
)engine=InnoDB default charset=utf8;

CREATE TABLE item_pedido
(
	codigo BIGINT NOT NULL AUTO_INCREMENT,
	quantidade BIGINT NOT NULL,
	preco_unitario DECIMAL(10,2) NOT NULL,
	preco_total DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(80),
	codigo_pedido BIGINT NOT NULL,
	codigo_produto BIGINT NOT NULL,
	
	PRIMARY KEY(codigo)
)engine=InnoDB default charset=utf8;

ALTER TABLE item_pedido
ADD CONSTRAINT FK_item_pedido_pedido FOREIGN KEY(codigo_pedido) REFERENCES pedido(codigo);

ALTER TABLE item_pedido
ADD CONSTRAINT FK_item_pedido_produto FOREIGN KEY(codigo_produto) REFERENCES produto(codigo);

ALTER TABLE pedido
ADD CONSTRAINT FK_pedido_endereco_cidade FOREIGN KEY(codigo_endereco_cidade) REFERENCES cidade(codigo);

ALTER TABLE pedido
ADD CONSTRAINT FK_pedido_restaurante FOREIGN KEY(codigo_restaurante) REFERENCES restaurante(codigo);

ALTER TABLE pedido
ADD CONSTRAINT FK_pedido_cliente FOREIGN KEY(codigo_cliente) REFERENCES usuario(codigo);

ALTER TABLE pedido
ADD CONSTRAINT FK_pedido_forma_pagamento FOREIGN KEY(codigo_forma_pagamento) REFERENCES forma_pagamento(codigo);
