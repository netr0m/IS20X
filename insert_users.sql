CREATE DATABASE IS201;

USE IS201;

CREATE TABLE `customer` (
	`customerID` int(11) NOT NULL AUTO_INCREMENT,
    `fName` varchar(45) NOT NULL,
    `lName` varchar(45) NOT NULL,
    `email` varchar(45) NOT NULL,
    `phone` int(8) NOT NULL,
    `address` varchar(45) NOT NULL,
    PRIMARY KEY(`customerID`)
);
    