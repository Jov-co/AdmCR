-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema admcr
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema admcr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `admcr` DEFAULT CHARACTER SET utf8 ;
USE `admcr` ;

-- -----------------------------------------------------
-- Table `admcr`.`Roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admcr`.`Roles` (
  `idRoles` INT NOT NULL AUTO_INCREMENT,
  `rol` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idRoles`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `admcr`.`Apartamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admcr`.`Apartamentos` (
  `referencia` INT NOT NULL,
  `no_Apto` VARCHAR(10) NOT NULL,
  `no_Torre` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`referencia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `admcr`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admcr`.`Usuario` (
  `idUsuario` VARCHAR(12) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `ref_apartamento` INT NOT NULL,
  `idRoles` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_idRoles_idx` (`idRoles` ASC) VISIBLE,
  INDEX `fk_ref_apartamento_idx` (`ref_apartamento` ASC) VISIBLE,
  CONSTRAINT `fk_idRoles`
    FOREIGN KEY (`idRoles`)
    REFERENCES `admcr`.`Roles` (`idRoles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ref_apartamento`
    FOREIGN KEY (`ref_apartamento`)
    REFERENCES `admcr`.`Apartamentos` (`referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `admcr`.`Pagos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admcr`.`Pagos` (
  `idPagos` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `estado` TINYINT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `ref_apto` INT NOT NULL,
  PRIMARY KEY (`idPagos`),
  INDEX `fk_ref_apartamento_idx` (`ref_apto` ASC) VISIBLE,
  CONSTRAINT `fk_ref_apartamento_pagos`
    FOREIGN KEY (`ref_apto`)
    REFERENCES `admcr`.`Apartamentos` (`referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
