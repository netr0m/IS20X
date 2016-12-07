-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema slit
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema slit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `slit` DEFAULT CHARACTER SET utf8 ;
USE `slit` ;

-- -----------------------------------------------------
-- Table `slit`.`module`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slit`.`module` (
  `moduleID` INT(11) NOT NULL AUTO_INCREMENT,
  `moduleName` VARCHAR(128) NOT NULL,
  `moduleSummary` TEXT NULL DEFAULT NULL,
  `moduleDescription` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`moduleID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `slit`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slit`.`users` (
  `userID` INT(11) NOT NULL AUTO_INCREMENT,
  `fName` VARCHAR(64) NOT NULL,
  `lName` VARCHAR(64) NOT NULL,
  `username` VARCHAR(64) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `email` VARCHAR(64) NOT NULL,
  `userrole` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userID`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `slit`.`moduledelivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slit`.`moduledelivery` (
  `userID` INT(11) NOT NULL,
  `moduleID` INT(11) NOT NULL,
  `uploadDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `moduleStatus` TINYINT(1) NOT NULL DEFAULT '0',
  `moduleDelivery` TEXT NULL DEFAULT NULL,
  `moduleAssesmentComment` TEXT NULL DEFAULT NULL,
  `moduleFile` BLOB NULL DEFAULT NULL,
  PRIMARY KEY (`userID`, `moduleID`),
  INDEX `moduleDelivery_module_fk` (`moduleID` ASC),
  CONSTRAINT `moduleDelivery_module_fk`
    FOREIGN KEY (`moduleID`)
    REFERENCES `slit`.`module` (`moduleID`),
  CONSTRAINT `moduleDelivery_user_fk`
    FOREIGN KEY (`userID`)
    REFERENCES `slit`.`users` (`userID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `slit` ;

-- -----------------------------------------------------
-- Placeholder table for view `slit`.`overlook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slit`.`overlook` (`username` INT, `moduleName` INT, `uploadDate` INT, `moduleDelivery` INT, `moduleFile` INT);

-- -----------------------------------------------------
-- View `slit`.`overlook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `slit`.`overlook`;
USE `slit`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `slit`.`overlook` AS select `u`.`username` AS `username`,`m`.`moduleName` AS `moduleName`,`md`.`uploadDate` AS `uploadDate`,`md`.`moduleDelivery` AS `moduleDelivery`,`md`.`moduleFile` AS `moduleFile` from ((`slit`.`moduledelivery` `md` join `slit`.`users` `u` on((`md`.`userID` = `u`.`userID`))) join `slit`.`module` `m` on((`md`.`moduleID` = `m`.`moduleID`))) where (`md`.`moduleStatus` = '0') group by `md`.`moduleID` order by `md`.`uploadDate`;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
