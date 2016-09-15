CREATE TABLE gender
(
  id_gender INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  description VARCHAR(9) NOT NULL
) ENGINE=InnoDB;
CREATE UNIQUE INDEX descript ON gender (description);

CREATE TABLE users
(
  id_user INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  CPF VARCHAR(14) NOT NULL,
  date_register DATE NOT NULL,
  date_birth DATE NOT NULL,
  email VARCHAR(80) NOT NULL,
  name VARCHAR(80) NOT NULL,
  phone VARCHAR(15) NOT NULL,
  id_gender INT(11) NOT NULL,
  username VARCHAR(25),
  role VARCHAR(36),
  password VARCHAR(40),
  CONSTRAINT id_gender_foreign FOREIGN KEY (id_gender) REFERENCES gender (id_gender)
) ENGINE=InnoDB;

CREATE TABLE address
(
  id_address INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  complement INT(11),
  street VARCHAR(80),
  number INT(11),
  zip INT(11) NOT NULL,
  id_user INT(11),
  CONSTRAINT id_user_foreign FOREIGN KEY (id_user) REFERENCES users (id_user)
) ENGINE=InnoDB;

CREATE UNIQUE INDEX login_unique ON users (username);
CREATE INDEX user ON gender (id_gender);

INSERT INTO gender(description) VALUE ('Male');
INSERT INTO gender(description) VALUE ('Female');

INSERT INTO users(id_user, CPF, date_register, date_birth, email, name, phone, id_gender, username, role, password) VALUES
  (3, 12345667644, NOW(), '1993-01-12', 'admin@admin.com', 'Admin', '002266445588', 1, 'admin1', 'Administrator', 'd033e22ae348aeb5660fc2140aec35850c4da997');

INSERT INTO address(id_address, complement, street, number, zip, id_user) VALUES
(1, 0, 'Groovy Str', 123, 1234, 3);





-- -----------------------------------

DROP TABLE IF EXISTS `endereco`;
CREATE TABLE `endereco` (
  `IdEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `Bairro` varchar(80) DEFAULT NULL,
  `CEP` varchar(9) DEFAULT NULL,
  `Complemento` int(11) DEFAULT NULL,
  `NomeLogradouro` varchar(80) DEFAULT NULL,
  `Numero` int(11) DEFAULT NULL,
  `IdCidade` int(11) NOT NULL,
  `IdEstado` int(11) NOT NULL,
  `IdPessoa` int(11) DEFAULT NULL,
  `IdTipoEndereco` int(11) NOT NULL,
  `IdTipoLogradouro` int(11) NOT NULL,
  PRIMARY KEY (`IdEndereco`),
  KEY `EnderecoTipoLogradouro` (`IdTipoLogradouro`),
  KEY `EnderecoCidade` (`IdCidade`),
  KEY `EnderecoTipoEndereco` (`IdTipoEndereco`),
  KEY `EnderecoEstado` (`IdEstado`),
  KEY `EnderecoPessoa` (`IdPessoa`),
  CONSTRAINT `EnderecoCidade` FOREIGN KEY (`IdCidade`) REFERENCES `cidade` (`IdCidade`),
  CONSTRAINT `EnderecoEstado` FOREIGN KEY (`IdEstado`) REFERENCES `estado` (`IdEstado`),
  CONSTRAINT `EnderecoPessoa` FOREIGN KEY (`IdPessoa`) REFERENCES `pessoa` (`IdPessoa`),
  CONSTRAINT `EnderecoTipoEndereco` FOREIGN KEY (`IdTipoEndereco`) REFERENCES `tipoendereco` (`IdTipoEndereco`),
  CONSTRAINT `EnderecoTipoLogradouro` FOREIGN KEY (`IdTipoLogradouro`) REFERENCES `tipologradouro` (`IdTipoLogradouro`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE `pessoa` (
  `IdPessoa` int(11) NOT NULL AUTO_INCREMENT,
  `CPF` varchar(14) NOT NULL,
  `DataDeCadastro` date NOT NULL,
  `DataDeNascimento` date NOT NULL,
  `Email` varchar(80) NOT NULL,
  `Name` varchar(80) NOT NULL,
  `Telefone` varchar(15) NOT NULL,
  `IdSexo` int(11) NOT NULL,
  `Login` varchar(25) DEFAULT NULL,
  `Permissao` varchar(36) DEFAULT NULL,
  `Senha` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`IdPessoa`),
  UNIQUE KEY `Login` (`Login`),
  KEY `PessoaSexo` (`IdSexo`),
  CONSTRAINT `PessoaSexo` FOREIGN KEY (`IdSexo`) REFERENCES `sexo` (`IdSexo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;