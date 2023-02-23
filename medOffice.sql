DROP DATABASE IF EXISTS medOffice;
CREATE DATABASE medOffice;

USE medOffice;

CREATE TABLE physician (
    physicianId INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(50)
);

CREATE TABLE user (
    userId INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(50),
    notifications BOOLEAN
);

CREATE TABLE appointment (
    appId INT PRIMARY KEY AUTO_INCREMENT,
    startTime DATE NOT NULL,
    endTime DATE NOT NULL,
    physicianId INT,
    FOREIGN KEY (physicianId) REFERENCES physician(physicianId),
    userId INT,
    FOREIGN KEY (userId) REFERENCES user(userId)
);

CREATE TABLE note (
    noteId INT PRIMARY KEY AUTO_INCREMENT,
    note VARCHAR(200),
    physicianId INT,
    FOREIGN KEY (physicianId) REFERENCES physician(physicianId),
    userId INT,
    FOREIGN KEY (userId) REFERENCES user(userId)
);