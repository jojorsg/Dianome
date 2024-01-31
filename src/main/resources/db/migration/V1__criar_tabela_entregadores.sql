CREATE TABLE entregadores (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 cpf varchar(11) NOT NULL UNIQUE,
 nome varchar(100) DEFAULT NULL,
 veiculo varchar(255) NOT NULL,
 PRIMARY KEY (id)
)