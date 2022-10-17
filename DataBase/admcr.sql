
CREATE database admcr DEFAULT CHARACTER SET utf8mb3 ;

USE admcr;


-- -----------------------------------------------------
-- Table `admcr`.`apartamentos`
-- -----------------------------------------------------
CREATE TABLE apartamentos (
  idApto INT NOT NULL,
  no_Apto VARCHAR(10) NOT NULL,
  no_Torre VARCHAR(10) NOT NULL,
  CONSTRAINT pk_idApto PRIMARY KEY (idApto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `admcr`.`pagos`
-- -----------------------------------------------------
CREATE TABLE pagos (
  idPagos INT NOT NULL AUTO_INCREMENT,
  fecha DATETIME NOT NULL,
  estado TINYINT NOT NULL,
  valor DOUBLE NOT NULL,
  ref_apto INT NOT NULL,
  CONSTRAINT pk_idpagos PRIMARY KEY (idPagos),
  CONSTRAINT fk_ref_apto FOREIGN KEY (ref_apto) REFERENCES apartamentos (idApto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `admcr`.`usuario`
-- -----------------------------------------------------
CREATE TABLE usuario (
  idUsuario VARCHAR(12) NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  apellidos VARCHAR(45) NOT NULL,
  telefono VARCHAR(20) NOT NULL,
  email VARCHAR(100) NOT NULL,
  ref_apartamento INT NOT NULL,
  rol VARCHAR(45) NOT NULL,
  CONSTRAINT pk_idUsuario PRIMARY KEY (idUsuario),
  CONSTRAINT uk_email UNIQUE(email),
  CONSTRAINT fk_ref_apartamento FOREIGN KEY (ref_apartamento) REFERENCES apartamentos (idApto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

