# ---------------------------------------------------------------------- #
# Script generated with: DeZign for Databases v6.2.1                     #
# Target DBMS:           MySQL 5                                         #
# Project file:          DER.dez                                         #
# Project name:                                                          #
# Author:                                                                #
# Script type:           Database creation script                        #
# Created on:            2019-01-13 21:05                                #
# ---------------------------------------------------------------------- #


# ---------------------------------------------------------------------- #
# Tables                                                                 #
# ---------------------------------------------------------------------- #

# ---------------------------------------------------------------------- #
# Add table "users"                                                      #
# ---------------------------------------------------------------------- #

CREATE TABLE `users` (
    `user_id` INTEGER NOT NULL AUTO_INCREMENT,
    `cpf` VARCHAR(16),
    `user_name` VARCHAR(100),
    `age` INTEGER,
    `password` VARCHAR(100),
    `profile` CHAR(1),
    PRIMARY KEY (`user_id`)
);

# ---------------------------------------------------------------------- #
# Add table "hotels"                                                     #
# ---------------------------------------------------------------------- #

CREATE TABLE `hotels` (
    `hotel_id` INTEGER NOT NULL AUTO_INCREMENT,
    `cnpj` VARCHAR(14) NOT NULL,
    `hotel_name` VARCHAR(100),
    `hotel_daily_rate` DOUBLE,
    `hotel_description` VARCHAR(1000),
    `bedrooms_number` INTEGER,
    `add_date` DATETIME,
    `last_updated` DATETIME,
    `user_id` INTEGER NOT NULL,
    CONSTRAINT `PK_hotels` PRIMARY KEY (`hotel_id`)
);

# ---------------------------------------------------------------------- #
# Add table "hotel_photos"                                               #
# ---------------------------------------------------------------------- #

CREATE TABLE `hotel_photos` (
    `photo_id` INTEGER NOT NULL AUTO_INCREMENT,
    `hotel_id` INTEGER NOT NULL,
    `photo_path` VARCHAR(100),
    `D_E_L_E_T_` CHAR(1),
    CONSTRAINT `PK_hotel_photos` PRIMARY KEY (`photo_id`)
);

# ---------------------------------------------------------------------- #
# Add table "comments"                                                   #
# ---------------------------------------------------------------------- #

CREATE TABLE `comments` (
    `comment_id` INTEGER NOT NULL AUTO_INCREMENT,
    `hotel_id` INTEGER NOT NULL,
    `user_id` INTEGER NOT NULL,
    `comment_date` DATETIME,
    `comment` VARCHAR(500),
    `note` INTEGER,
    CONSTRAINT `PK_comments` PRIMARY KEY (`comment_id`)
);

# ---------------------------------------------------------------------- #
# Add table "addresses"                                                  #
# ---------------------------------------------------------------------- #

CREATE TABLE `addresses` (
    `address_id` INTEGER NOT NULL AUTO_INCREMENT,
    `city_id` INTEGER NOT NULL,
    `address` VARCHAR(100),
    `address_type` CHAR(1),
    `user_id` INTEGER,
    `hotel_id` INTEGER,
    CONSTRAINT `PK_addresses` PRIMARY KEY (`address_id`)
);

# ---------------------------------------------------------------------- #
# Add table "cities"                                                     #
# ---------------------------------------------------------------------- #

CREATE TABLE `cities` (
    `city_id` INTEGER NOT NULL AUTO_INCREMENT,
    `city_name` VARCHAR(100),
    `state_id` INTEGER,
    CONSTRAINT `PK_cities` PRIMARY KEY (`city_id`)
);

# ---------------------------------------------------------------------- #
# Add table "states"                                                     #
# ---------------------------------------------------------------------- #

CREATE TABLE `states` (
    `state_id` INTEGER NOT NULL AUTO_INCREMENT,
    `country_id` INTEGER NOT NULL,
    `state_name` VARCHAR(40),
    `state_abbreviation` CHAR(4),
    CONSTRAINT `PK_states` PRIMARY KEY (`state_id`)
);

# ---------------------------------------------------------------------- #
# Add table "countries"                                                  #
# ---------------------------------------------------------------------- #

CREATE TABLE `countries` (
    `country_id` INTEGER NOT NULL AUTO_INCREMENT,
    `country_name` VARCHAR(100),
    `country_abbreviation` CHAR(2),
    CONSTRAINT `PK_countries` PRIMARY KEY (`country_id`)
);

# ---------------------------------------------------------------------- #
# Foreign key constraints                                                #
# ---------------------------------------------------------------------- #

ALTER TABLE `hotels` ADD CONSTRAINT `users_hotels` 
    FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `hotel_photos` ADD CONSTRAINT `hotels_hotel_photos` 
    FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`hotel_id`);

ALTER TABLE `comments` ADD CONSTRAINT `hotels_comments` 
    FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`hotel_id`);

ALTER TABLE `comments` ADD CONSTRAINT `users_comments` 
    FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `addresses` ADD CONSTRAINT `cities_addresses` 
    FOREIGN KEY (`city_id`) REFERENCES `cities` (`city_id`);

ALTER TABLE `addresses` ADD CONSTRAINT `users_addresses` 
    FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `addresses` ADD CONSTRAINT `hotels_addresses` 
    FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`hotel_id`);

ALTER TABLE `cities` ADD CONSTRAINT `states_cities` 
    FOREIGN KEY (`state_id`) REFERENCES `states` (`state_id`);

ALTER TABLE `states` ADD CONSTRAINT `countries_states` 
    FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`);
