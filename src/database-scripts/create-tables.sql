DROP SCHEMA IF EXISTS `customer_tracker`;

CREATE SCHEMA `customer_tracker`;
USE `customer_tracker`;

CREATE TABLE `customer`(
	id int NOT NULL AUTO_INCREMENT,
	first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    email varchar(100) NOT NULL,
    PRIMARY KEY(id)
);

