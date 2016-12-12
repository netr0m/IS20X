CREATE DATABASE slit;
USE slit;


CREATE TABLE Users (
    userID INT AUTO_INCREMENT PRIMARY KEY,
    fName VARCHAR(64) NOT NULL,
    lName VARCHAR(64) NOT NULL,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(64) NOT NULL,
    email VARCHAR(64) NOT NULL,
    userrole INT(1) NOT NULL DEFAULT 4 # SET DEFAULT STUDENT AKA '4'
);

CREATE TABLE Module (
    moduleID INT AUTO_INCREMENT PRIMARY KEY,
    moduleName VARCHAR(128) NOT NULL,
    moduleSummary TEXT NULL,
    moduleDescription TEXT NULL
);

CREATE TABLE ModuleDelivery (
	deliveryID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    moduleID INT NOT NULL,
    uploadDate TIMESTAMP NOT NULL DEFAULT NOW(),
    moduleStatus INT(1) NOT NULL DEFAULT 0,
    moduleDelivery TEXT NULL,
    moduleFile VARCHAR(300) NULL,
    moduleAssesmentComment TEXT NULL,
    PRIMARY KEY (deliveryID),
    CONSTRAINT moduleDelivery_module_fk FOREIGN KEY (moduleID)
        REFERENCES Module (moduleID),
    CONSTRAINT moduleDelivery_user_fk FOREIGN KEY (userID)
        REFERENCES Users (userID)
);

INSERT INTO Users VALUES(null, 'Admin', 'UiA', 'admin', 'admin', 'admin@uia.no', '1'); #Admin
INSERT INTO Users VALUES(null, 'Hallgeir', 'Nilsen', 'hallgeir', 'hallgeir', 'hallgeir@uia.no', '2'); #Teacher
INSERT INTO Users VALUES(null, 'Even Åby', 'Larsen', 'even', 'even', 'even@uia.no', '2'); #Teacher
INSERT INTO Users VALUES(null, 'Assistant', 'Assistantsen', 'assistant', 'assistant', 'assistant@student.uia.no', '3'); #Assistant teacher
INSERT INTO Users VALUES(null, 'Morten', 'Amundsen', 'mortea15', 'mortea15', 'mortea15@uia.no', '4'); #Student
INSERT INTO Users VALUES(null, 'Svenn-Roger', 'Sørensen', 'srsore15', 'srsore15', 'srsore15@uia.no', '4'); #Student

INSERT INTO Module(moduleName, moduleSummary, moduleDescription) VALUES ('Module 1', 'Meet a teacher/assistant, and show them how to open BlueJ', 'No delivery necessary. Meet with an assistant/teacher to get approval'); 
INSERT INTO Module(moduleName, moduleSummary, moduleDescription) VALUES ('Module 2', 'Cool module where you should record while you create a class in Java.', 'Filedelivery is necessary. Please deliver a zipped folder containing the file.');

INSERT INTO ModuleDelivery (userID, moduleID, moduleDelivery) VALUES (5, 1, 'Test delivery 123. Excellent system with a touch of elegance :)');