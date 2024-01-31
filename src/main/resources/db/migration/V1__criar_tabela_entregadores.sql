CREATE TABLE entregadores (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 cpf bigint(11) NOT NULL,
 nome varchar(100) DEFAULT NULL,
 tipo varchar(255) NOT NULL,
 PRIMARY KEY (id)
)