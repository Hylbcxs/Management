-- Database Name:
CREATE DATABASE STUDENTMANAGEMENT;

GRANT ALL PRIVILEGES  ON STUDENTMANAGEMENT.* TO 'root'@'localhost' IDENTIFIED BY '12345678';

USE STUDENTMANAGEMENT;

--USER TABLE STRUCTURE:
CREATE TABLE students(
                           id INT NOT NULL AUTO_INCREMENT,
                           name VARCHAR(100),
                           number VARCHAR(100),
                           classname VARCHAR(100),
                           role VARCHAR(50),
                           email VARCHAR(255),
                           password VARCHAR(255),
                           PRIMARY KEY(id)
  );

CREATE TABLE expenses(
    id INT NOT NULL AUTO_INCREMENT,
    content VARCHAT(255),
    data VARCHAR(255),
    amount DOUBLE,
    goodspicture VARCHAR(255),
    receipt VARCHAR(255),
    acceptor VARCHAR(100),
    PRIMARY KEY(id)
);

CREATE TABLE question(
    id INT NOT NULL AUTO_INCREMENT,
    content VARCHAR(255),
    question VARCHAR(255),
    initiator VARCHAR(255),
    PRIMARY KEY(id)
)

CREATE TABLE response(
    id INT NOT NULL AUTO_INCREMENT,
    content VARCHAR(255),
    question VARCHAR(255),
    initiator VARCHAR(255),
    response VARCHAR(255),
    PRIMARY KEY(id)
)


CREATE TABLE confirm(
    content VARCHAR(255),
    number INT
)