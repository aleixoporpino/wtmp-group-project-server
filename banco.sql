-- MySQL Workbench Synchronization
-- Generated: 2018-01-23 14:45
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: José Aleixo Araujo Porpino Filho

SET
@
OLD_UNIQUE_CHECKS
=
@
@
UNIQUE_CHECKS,
UNIQUE_CHECKS
=
0;
SET
@
OLD_FOREIGN_KEY_CHECKS
=
@
@
FOREIGN_KEY_CHECKS,
FOREIGN_KEY_CHECKS
=
0;
SET
@
OLD_SQL_MODE
=
@
@
SQL_MODE,
SQL_MODE
=
'TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `agendacontato` DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `agendacontato`.`Usuario`
(
  `idUsuario` INT
(
  11
) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR
(
  20
) NOT NULL,
  `senha` VARCHAR
(
  100
) NOT NULL,
  `email` VARCHAR
(
  100
) NOT NULL,
  PRIMARY KEY
(
  `idUsuario`
))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `agendacontato`.`Contato`
(
  `idContato` INT
(
  11
) NOT NULL AUTO_INCREMENT,
  `idUsuario` INT
(
  11
) NOT NULL,
  `nome` VARCHAR
(
  50
) NOT NULL,
  `sobrenome` VARCHAR
(
  50
) NULL DEFAULT NULL,
  `email` VARCHAR
(
  100
) NULL DEFAULT NULL,
  `endereco` VARCHAR
(
  200
) NULL DEFAULT NULL,
  `dataNascimento` DATE NULL DEFAULT NULL,
  `telefone` VARCHAR
(
  14
) NULL DEFAULT NULL,
  `celular` VARCHAR
(
  14
) NULL DEFAULT NULL,
  `celular2` VARCHAR
(
  14
) NULL DEFAULT NULL,
  PRIMARY KEY
(
  `idContato`
),
  INDEX `fk_Contato_Usuario_idx`
(
  `idUsuario` ASC
),
  CONSTRAINT `fk_Contato_Usuario`
  FOREIGN KEY
(
  `idUsuario`
)
  REFERENCES `agendacontato`.`Usuario`
(
  `idUsuario`
)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `agendacontato`.`Perfil`
(
  `idPerfil` INT
(
  11
) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR
(
  20
) NOT NULL,
  PRIMARY KEY
(
  `idPerfil`
))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `agendacontato`.`UsuarioPerfil`
(
  `idUsuario` INT
(
  11
) NOT NULL,
  `idPerfil` INT
(
  11
) NOT NULL,
  PRIMARY KEY
(
  `idUsuario`,
  `idPerfil`
),
  INDEX `fk_Usuario_has_Perfil_Perfil1_idx`
(
  `idPerfil` ASC
),
  INDEX `fk_Usuario_has_Perfil_Usuario1_idx`
(
  `idUsuario` ASC
),
  CONSTRAINT `fk_Usuario_has_Perfil_Usuario1`
  FOREIGN KEY
(
  `idUsuario`
)
  REFERENCES `agendacontato`.`Usuario`
(
  `idUsuario`
)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Perfil_Perfil1`
  FOREIGN KEY
(
  `idPerfil`
)
  REFERENCES `agendacontato`.`Perfil`
(
  `idPerfil`
)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;



CREATE TABLE `agendacontato`.`Patient`
(
  `id`              INT          NOT NULL AUTO_INCREMENT,
  `firstName`       VARCHAR(200) NOT NULL,
  `lastName`        VARCHAR(200) NOT NULL,
  `age`             INT          NOT NULL,
  `address`         VARCHAR(200) NOT NULL,
  `roomNumber`      VARCHAR(200) NOT NULL,
  `emergencyNumber` VARCHAR(200) NOT NULL,
  `department`      VARCHAR(200) NOT NULL,
  `doctor`          VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `agendacontato`.`User`
(
  `id`       INT          NOT NULL AUTO_INCREMENT,
  `login`    VARCHAR(200) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email`    VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`)
);

-- auto-generated definition
create table Restaurant
(
  id                int auto_increment
    primary key,
  name              varchar(50)          not null,
  description       varchar(500)         not null,
  brief_description varchar(50)          null,
  address           varchar(200)         not null,
  tags              varchar(200)         not null,
  phone             varchar(20)          not null,
  favorite          tinyint(1) default 0 not null,
  stars             int        default 0 not null
);

alter table restaurant
  add latitude double null;

alter table restaurant
  add longitude double null;

INSERT INTO agendacontato.Restaurant (id, name, description, brief_description, address, tags, phone, favorite, stars) VALUES (2, 'Red Lobster', 'ticaratica', 'Fresh Fish - Live Lobster', '10 Cardwell ave
Unit 2', 'lobster, shrimp, seafood', '6475617767', 0, 3);
INSERT INTO agendacontato.Restaurant (id, name, description, brief_description, address, tags, phone, favorite, stars) VALUES (3, 'Chipotle', 'Mexican Grill', 'Mexican Grill', '300 Borough Dr UNIT 17/18, Scarborough, ON M1P 4P5', 'mexican, taco, burrito, bowl', '(647) 348-4750', 1, 3);

SET
SQL_MODE
=
@
OLD_SQL_MODE;
SET
FOREIGN_KEY_CHECKS
=
@
OLD_FOREIGN_KEY_CHECKS;
SET
UNIQUE_CHECKS
=
@
OLD_UNIQUE_CHECKS;
