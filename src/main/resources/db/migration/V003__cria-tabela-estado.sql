CREATE TABLE estado
(
	codigo BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
	
	PRIMARY KEY(codigo)
)engine=InnoDB Default charset=utf8;

ALTER TABLE cidade 
ADD COLUMN codigo_estado BIGINT NOT NULL;

ALTER TABLE cidade 
ADD CONSTRAINT fk_cidade_estado FOREIGN KEY (codigo_estado) REFERENCES estado(codigo);

ALTER TABLE cidade
DROP COLUMN nome_estado;

ALTER TABLE cidade
CHANGE nome_cidade nome VARCHAR(80) NOT NULL; 