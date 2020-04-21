# SmartCollegeSystem
Steps:
Step 1: Create MySQL DB following below commands
create database smartbuilding;

use smartbuilding;

CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) UNIQUE,
    password VARCHAR(30) NOT NULL,
    firstname VARCHAR(20)  NOT NULL,
    lastname VARCHAR(20)  NOT NULL,
    email VARCHAR(30)  NOT NULL
);

CREATE TABLE IF NOT EXISTS device_temp (
    device_temp_id INT AUTO_INCREMENT PRIMARY KEY,
    device_id VARCHAR(30) UNIQUE,
    temp VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS temperature (
    temp_id INT AUTO_INCREMENT PRIMARY KEY,
    date timestamp  UNIQUE default current_time,
    temp double NOT NULL
);
Step 2: Open/Import Java EE project SmartBuildingSystem in Eclipse. 
Step 3: Add library (activation.jar, mail.jar, mysql-connector jar) under WEB-INF-> Lib
Step 2: at login page, register new user then login
