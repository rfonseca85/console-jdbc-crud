
CREATE DATABASE knowroaming_db;
 
CREATE TABLE IF NOT EXISTS user_tb (
    user_id 	 int(10) 	  NOT NULL AUTO_INCREMENT,
    name    	 varchar(100) DEFAULT NULL,
    email   	 varchar(100) DEFAULT NULL,
    country      varchar(50)  DEFAULT NULL,	
    phone_number varchar(45)  DEFAULT NULL,

    PRIMARY KEY (user_id)
)   ENGINE=InnoDB AUTO_INCREMENT=1;


CREATE TABLE IF NOT EXISTS usage_information_tb (
    usage_information_id 	 int(10)   NOT NULL AUTO_INCREMENT,
    typeOfUsage    	 		 int(1)    DEFAULT NULL,
    dateOfUsage   	 		 DATE,
    user_id					 int(10)   NOT NULL,
    PRIMARY KEY (usage_information_id)
)   ENGINE=InnoDB AUTO_INCREMENT=1;

