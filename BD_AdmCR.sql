-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Roles` (
  `idRoles` INT NOT NULL,
  `rol` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idRoles`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Apartamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Apartamentos` (
  `referencia` INT NOT NULL,
  `no_Apto` VARCHAR(10) NOT NULL,
  `no_Torre` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`referencia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
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
    REFERENCES `mydb`.`Roles` (`idRoles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ref_apartamento`
    FOREIGN KEY (`ref_apartamento`)
    REFERENCES `mydb`.`Apartamentos` (`referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`table1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`table1` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pagos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pagos` (
  `idPagos` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  `estado` TINYINT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `ref_apartamento` INT NOT NULL,
  PRIMARY KEY (`idPagos`),
  INDEX `fk_ref_apartamento_idx` (`ref_apartamento` ASC) VISIBLE,
  CONSTRAINT `fk_ref_apartamento`
    FOREIGN KEY (`ref_apartamento`)
    REFERENCES `mydb`.`Apartamentos` (`referencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
