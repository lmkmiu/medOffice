DROP DATABASE IF EXISTS medOffice;
CREATE DATABASE medOffice;

USE medOffice;

CREATE TABLE physician (
    physician_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(30),
    passwords VARCHAR(20) NOT NULL
);

CREATE TABLE user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(30),
    passwords VARCHAR(20) NOT NULL
);

CREATE TABLE appointment (
    app_id INT PRIMARY KEY AUTO_INCREMENT,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    physician_id INT,
    FOREIGN KEY (physician_id) REFERENCES physician(physician_id),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE note (
    note_id INT PRIMARY KEY AUTO_INCREMENT,
    note VARCHAR(200),
    physician_id INT,
    FOREIGN KEY (physician_id) REFERENCES physician(physician_id),
    app_id INT,
    FOREIGN KEY (app_id) REFERENCES appointment(app_id)
);

INSERT INTO user (first_name, last_name, phone, email, passwords) VALUES
	("Hello", "Kitty", "524617182", "hello@kitty.com", "1234");

INSERT INTO physician (first_name, last_name, phone, email, passwords) VALUES
	("Dr", "A", "1234567890", "a@dr.com", "5678");

