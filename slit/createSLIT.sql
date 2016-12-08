CREATE DATABASE slit;
USE slit;


CREATE TABLE Users (
    userID INT AUTO_INCREMENT PRIMARY KEY,
    fName VARCHAR(64) NOT NULL,
    lName VARCHAR(64) NOT NULL,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(64) NOT NULL,
    email VARCHAR(64) NOT NULL,
    userrole INT(1) NOT NULL DEFAULT 4
);

CREATE TABLE Module (
    moduleID INT AUTO_INCREMENT PRIMARY KEY,
    moduleName VARCHAR(128) NOT NULL,
    moduleSummary TEXT NULL,
    moduleDescription TEXT NULL
);

CREATE TABLE ModuleDelivery (
    userID INT,
    moduleID INT,
    uploadDate TIMESTAMP NOT NULL DEFAULT NOW(),
    moduleStatus INT(1) NOT NULL DEFAULT 0,
    moduleDelivery TEXT NULL,
    moduleVideo BLOB NULL,
    moduleAssesmentComment TEXT NULL,
    CONSTRAINT moduleDelivery_pk PRIMARY KEY (userID , moduleID),
    CONSTRAINT moduleDelivery_module_fk FOREIGN KEY (moduleID)
        REFERENCES Module (moduleID),
    CONSTRAINT moduleDelivery_user_fk FOREIGN KEY (userID)
        REFERENCES Users (userID)
);

CREATE VIEW Overlook AS
    SELECT 
        u.username AS Username,
        m.moduleName AS ModuleName,
        md.uploadDate AS UploadDate,
        md.moduleDelivery AS ModuleDelivery,
        md.moduleFile AS ModuleFile
    FROM
        moduleDelivery md
			INNER JOIN
        users u ON md.userID = u.userID
			INNER JOIN
		module m ON md.moduleID = m.moduleID
    WHERE
        md.moduleStatus = '0'
    ORDER BY md.uploadDate;

INSERT INTO Users VALUES(null, 'Admin', 'UiA', 'admin', 'admin', 'admin@uia.no', '1'); #Admin
INSERT INTO Users VALUES(null, 'Hallgeir', 'Nilsen', 'hallgeir', 'hallgeir', 'hallgeir@uia.no', '2'); #Teacher
INSERT INTO Users VALUES(null, 'Morten', 'Amundsen', 'mortea15', 'mortea15', 'mortea15@uia.no', '4'); #Student
INSERT INTO Users VALUES(null, 'Svenn-Roger', 'Sørensen', 'srsore15', 'srsore15', 'srsore15@uia.no', '4'); #Student

INSERT INTO Module(moduleName, moduleSummary, moduleDescription) VALUES ('Module 1', 'Module 1 - Basic Introduction', 'Open up a laptop. If its a Lenovo, give it to your grandfather.'); 
INSERT INTO Module(moduleName, moduleSummary, moduleDescription) VALUES ('Module 2', 'Module 2 - Get a new PC', 'Buy a new computer if you had a Lenovo. Trust me');

INSERT INTO ModuleDelivery (userID, moduleID, moduleDelivery, moduleVideo) VALUES (3, 1, 'Test delivery. Have a gr8 l8 n8 m8 :)', 'modulvideo1.mp4');