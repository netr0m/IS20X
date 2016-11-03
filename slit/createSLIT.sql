create database slit;
use slit; 


CREATE TABLE Users
(
	userID INT AUTO_INCREMENT PRIMARY KEY,
    fName VARCHAR(64) NOT NULL, 
    lName VARCHAR(64) NOT NULL,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(64) NOT NULL, 
    email VARCHAR(64) NOT NULL,
    userrole VARCHAR(20) NOT NULL
);

CREATE TABLE Module 
(
	moduleID INT AUTO_INCREMENT PRIMARY KEY, 
    moduleName VARCHAR(128) NOT NULL, 
    moduleSummary TEXT NULL, 
    moduleDescription TEXT NULL
); 

CREATE TABLE ModuleDelivery(
	userID INT, 
    moduleID INT, 
    uploadDate TIMESTAMP NOT NULL DEFAULT NOW(), 
    moduleStatus BOOLEAN NOT NULL DEFAULT FALSE, 
    moduleDelivery TEXT NULL, 
    moduleAssesmentComment TEXT NULL,
    CONSTRAINT moduleDelivery_pk PRIMARY KEY(userID, moduleID), 
    CONSTRAINT moduleDelivery_module_fk FOREIGN KEY(moduleID) REFERENCES Module(moduleID), 
    CONSTRAINT moduleDelivery_user_fk FOREIGN KEY(userID) REFERENCES Users(userID)
); 

INSERT INTO Users VALUES(null, 'Admin', 'UiA', 'admin', 'admin', 'admin@uia.no', 'ADMIN');
INSERT INTO Users VALUES(null, 'Hallgeir', 'Nilsen', 'hallgeir', 'hallgeir', 'hallgeir@uia.no', 'TEACHER');
INSERT INTO Users VALUES(null, 'Morten', 'Amundsen', 'mortea15', 'mortea15', 'mortea15@uia.no', 'STUDENT'); 
INSERT INTO Users VALUES(null, 'Svenn-Roger', 'Sørensen', 'srsore15', 'srsore15', 'srsore15@uia.no', 'STUDENT');

INSERT INTO Module(moduleName, moduleSummary, moduleDescription) VALUES ('Module 1', 'Module 1 - Basic Introduction', 'Go to the gym, lift one weirdly shaped weightbar, and go home.'); 
INSERT INTO Module(moduleName, moduleSummary, moduleDescription) VALUES ('Module 2', 'Module 2 - Get rekt', 'Yell to a man of ungodly size at the gym, expect a knockdown.'); 

INSERT INTO ModuleDelivery (userID, moduleID, moduleDelivery) VALUES (1, 1, 'Test delivery. Autism is trendy again :)'); 
  
