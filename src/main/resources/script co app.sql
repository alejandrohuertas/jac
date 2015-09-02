
create database jacdb;

use jacdb;



CREATE TABLE Users( 
	uid int(20) NOT NULL AUTO_INCREMENT, 
	username VARCHAR(60) NOT NULL, 
	password VARCHAR(60) NOT NULL, 
PRIMARY KEY(uid));

INSERT INTO Users VALUES(1, 'admin','admin');