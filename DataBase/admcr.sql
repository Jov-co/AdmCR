
-- -----------------------------------------------------
-- Schema admcr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `admcr` DEFAULT CHARACTER SET utf8 ;
USE `admcr` ;

-- -----------------------------------------------------
-- Table `admcr`.`apartamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admcr`.`apartamentos` (
  `id_apto` INT(11) NOT NULL,
  `no_Apto` VARCHAR(10) NOT NULL,
  `no_Torre` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_apto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `admcr`.`pagos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admcr`.`pagos` (
  `id_pagos` INT(11) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `estado` TINYINT(4) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `ref_apto` INT(11) NOT NULL,
  PRIMARY KEY (`id_pagos`),
  INDEX `fk_ref_apto` (`ref_apto` ASC) ,
  CONSTRAINT `fk_ref_apto`
    FOREIGN KEY (`ref_apto`)
    REFERENCES `admcr`.`apartamentos` (`id_apto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `admcr`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admcr`.`usuario` (
  `id_usuario` VARCHAR(12) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `ref_apartamento` INT(11) NOT NULL,
  `rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `uk_email` (`email` ASC) ,
  INDEX `fk_ref_apartamento` (`ref_apartamento` ASC) ,
  CONSTRAINT `fk_ref_apartamento`
    FOREIGN KEY (`ref_apartamento`)
    REFERENCES `admcr`.`apartamentos` (`id_apto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
