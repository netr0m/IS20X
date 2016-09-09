-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema uia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema uia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `uia` DEFAULT CHARACTER SET utf8 ;
USE `uia` ;

-- -----------------------------------------------------
-- Table `uia`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uia`.`user` (
  `userID` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `userrole` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE INDEX `userID_UNIQUE` (`userID` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `uia`.`module`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uia`.`module` (
  `moduleID` INT(11) NOT NULL,
  PRIMARY KEY (`moduleID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `uia`.`approval`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uia`.`approval` (
  `approvalID` INT(11) NOT NULL AUTO_INCREMENT,
  `studentID` INT(11) NOT NULL,
  `approverID` INT(11) NOT NULL,
  `moduleID` INT(11) NOT NULL,
  PRIMARY KEY (`approvalID`),
  UNIQUE INDEX `approvalID_UNIQUE` (`approvalID` ASC),
  INDEX `studentID_idx` (`studentID` ASC),
  INDEX `approverID_idx` (`approverID` ASC),
  INDEX `moduleID_idx` (`moduleID` ASC),
  CONSTRAINT `approverID`
    FOREIGN KEY (`approverID`)
    REFERENCES `uia`.`user` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `moduleID`
    FOREIGN KEY (`moduleID`)
    REFERENCES `uia`.`module` (`moduleID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `studentID`
    FOREIGN KEY (`studentID`)
    REFERENCES `uia`.`user` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
