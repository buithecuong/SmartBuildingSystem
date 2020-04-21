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