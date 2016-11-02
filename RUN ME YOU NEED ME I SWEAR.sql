-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
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
    `userrole` VARCHAR(70) NOT NULL,
    PRIMARY KEY (`userID`),
    UNIQUE INDEX `userID_UNIQUE` (`userID` ASC),
    UNIQUE INDEX `email` (`email` ASC),
    UNIQUE INDEX `username` (`username` ASC)
)  ENGINE=INNODB AUTO_INCREMENT=37 DEFAULT CHARACTER SET=UTF8;


-- -----------------------------------------------------
-- Table `uia`.`approvals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uia`.`approvals` (
    `studentID` INT(11) NOT NULL,
    `mod1` DATE NULL DEFAULT NULL,
    `mod2` DATE NULL DEFAULT NULL,
    `mod3` DATE NULL DEFAULT NULL,
    `mod4` DATE NULL DEFAULT NULL,
    `mod5` DATE NULL DEFAULT NULL,
    `mod6` DATE NULL DEFAULT NULL,
    `mod7` DATE NULL DEFAULT NULL,
    `mod8` DATE NULL DEFAULT NULL,
    `mod9` DATE NULL DEFAULT NULL,
    `mod10` DATE NULL DEFAULT NULL,
    `mod11` DATE NULL DEFAULT NULL,
    `mod12` DATE NULL DEFAULT NULL,
    `mod13` DATE NULL DEFAULT NULL,
    `mod14` DATE NULL DEFAULT NULL,
    `mod1Approver` INT(11) NULL DEFAULT NULL,
    `mod2Approver` INT(11) NULL DEFAULT NULL,
    `mod3Approver` INT(11) NULL DEFAULT NULL,
    `mod4Approver` INT(11) NULL DEFAULT NULL,
    `mod5Approver` INT(11) NULL DEFAULT NULL,
    `mod6Approver` INT(11) NULL DEFAULT NULL,
    `mod7Approver` INT(11) NULL DEFAULT NULL,
    `mod8Approver` INT(11) NULL DEFAULT NULL,
    `mod9Approver` INT(11) NULL DEFAULT NULL,
    `mod10Approver` INT(11) NULL DEFAULT NULL,
    `mod11Approver` INT(11) NULL DEFAULT NULL,
    `mod12Approver` INT(11) NULL DEFAULT NULL,
    `mod13Approver` INT(11) NULL DEFAULT NULL,
    `mod14Approver` INT(11) NULL DEFAULT NULL,
    INDEX `studentID` (`studentID` ASC),
    INDEX `mod1Approver` (`mod1Approver` ASC),
    INDEX `mod2Approver` (`mod2Approver` ASC),
    INDEX `mod3Approver` (`mod3Approver` ASC),
    INDEX `mod4Approver` (`mod4Approver` ASC),
    INDEX `mod5Approver` (`mod5Approver` ASC),
    INDEX `mod6Approver` (`mod6Approver` ASC),
    INDEX `mod7Approver` (`mod7Approver` ASC),
    INDEX `mod8Approver` (`mod8Approver` ASC),
    INDEX `mod9Approver` (`mod9Approver` ASC),
    INDEX `mod10Approver` (`mod10Approver` ASC),
    INDEX `mod11Approver` (`mod11Approver` ASC),
    INDEX `mod12Approver` (`mod12Approver` ASC),
    INDEX `mod13Approver` (`mod13Approver` ASC),
    INDEX `mod14Approver` (`mod14Approver` ASC),
    CONSTRAINT `approvals_ibfk_1` FOREIGN KEY (`studentID`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_10` FOREIGN KEY (`mod9Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_11` FOREIGN KEY (`mod10Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_12` FOREIGN KEY (`mod11Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_13` FOREIGN KEY (`mod12Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_14` FOREIGN KEY (`mod13Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_15` FOREIGN KEY (`mod14Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_2` FOREIGN KEY (`mod1Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_3` FOREIGN KEY (`mod2Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_4` FOREIGN KEY (`mod3Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_5` FOREIGN KEY (`mod4Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_6` FOREIGN KEY (`mod5Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_7` FOREIGN KEY (`mod6Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_8` FOREIGN KEY (`mod7Approver`)
        REFERENCES `uia`.`user` (`userID`),
    CONSTRAINT `approvals_ibfk_9` FOREIGN KEY (`mod8Approver`)
        REFERENCES `uia`.`user` (`userID`)
)  ENGINE=INNODB DEFAULT CHARACTER SET=UTF8;


-- -----------------------------------------------------
-- Table `uia`.`module`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uia`.`module` (
    `moduleID` INT(11) NOT NULL,
    PRIMARY KEY (`moduleID`)
)  ENGINE=INNODB DEFAULT CHARACTER SET=UTF8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO user (name, username, password, email, userrole)
VALUES ('Admin', 'admin', 'admin', 'admin@uia.no', 'ADMIN');