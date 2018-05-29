-- liquibase formatted sql

-- changeset developer:initial-data

-- -----------------------------------------------------
-- Table tblUser
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tblUser (
  id INT NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(100) NULL,
  lastName VARCHAR(100) NULL,
  email VARCHAR(45)  NULL,
  phone VARCHAR(45) NULL,
  creationDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updateDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table tblPoliceRecord
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tblPoliceRecord (
  id INT NOT NULL AUTO_INCREMENT,
  idUser INT NOT NULL,
  result TEXT NOT NULL,
  status VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_POLICE_USER
    FOREIGN KEY (idUser)
    REFERENCES tblUser (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

