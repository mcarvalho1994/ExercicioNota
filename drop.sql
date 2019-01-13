# ---------------------------------------------------------------------- #
# Script generated with: DeZign for Databases v6.2.1                     #
# Target DBMS:           MySQL 5                                         #
# Project file:          DER.dez                                         #
# Project name:                                                          #
# Author:                                                                #
# Script type:           Database drop script                            #
# Created on:            2019-01-05 16:49                                #
# ---------------------------------------------------------------------- #


# ---------------------------------------------------------------------- #
# Drop foreign key constraints                                           #
# ---------------------------------------------------------------------- #

ALTER TABLE `hotels` DROP FOREIGN KEY `users_hotels`;

ALTER TABLE `hotel_photos` DROP FOREIGN KEY `hotels_hotel_photos`;

ALTER TABLE `comments` DROP FOREIGN KEY `hotels_comments`;

ALTER TABLE `comments` DROP FOREIGN KEY `users_comments`;

ALTER TABLE `adresses` DROP FOREIGN KEY `cities_adresses`;

ALTER TABLE `adresses` DROP FOREIGN KEY `users_adresses`;

ALTER TABLE `adresses` DROP FOREIGN KEY `hotels_adresses`;

ALTER TABLE `cities` DROP FOREIGN KEY `states_cities`;

ALTER TABLE `states` DROP FOREIGN KEY `countries_states`;

# ---------------------------------------------------------------------- #
# Drop table "adresses"                                                  #
# ---------------------------------------------------------------------- #

# Remove autoinc for PK drop #

ALTER TABLE `adresses` MODIFY `adress_id` INTEGER NOT NULL;

# Drop constraints #

ALTER TABLE `adresses` DROP PRIMARY KEY;

# Drop table #

DROP TABLE `adresses`;

# ---------------------------------------------------------------------- #
# Drop table "cities"                                                    #
# ---------------------------------------------------------------------- #

# Remove autoinc for PK drop #

ALTER TABLE `cities` MODIFY `city_id` INTEGER NOT NULL;

# Drop constraints #

ALTER TABLE `cities` DROP PRIMARY KEY;

# Drop table #

DROP TABLE `cities`;

# ---------------------------------------------------------------------- #
# Drop table "states"                                                    #
# ---------------------------------------------------------------------- #

# Remove autoinc for PK drop #

ALTER TABLE `states` MODIFY `state_id` INTEGER NOT NULL;

# Drop constraints #

ALTER TABLE `states` DROP PRIMARY KEY;

# Drop table #

DROP TABLE `states`;

# ---------------------------------------------------------------------- #
# Drop table "countries"                                                 #
# ---------------------------------------------------------------------- #

# Remove autoinc for PK drop #

ALTER TABLE `countries` MODIFY `country_id` INTEGER NOT NULL;

# Drop constraints #

ALTER TABLE `countries` DROP PRIMARY KEY;

# Drop table #

DROP TABLE `countries`;

# ---------------------------------------------------------------------- #
# Drop table "comments"                                                  #
# ---------------------------------------------------------------------- #

# Remove autoinc for PK drop #

ALTER TABLE `comments` MODIFY `comment_id` INTEGER NOT NULL;

# Drop constraints #

ALTER TABLE `comments` DROP PRIMARY KEY;

# Drop table #

DROP TABLE `comments`;

# ---------------------------------------------------------------------- #
# Drop table "hotel_photos"                                              #
# ---------------------------------------------------------------------- #

# Remove autoinc for PK drop #

ALTER TABLE `hotel_photos` MODIFY `photo_id` INTEGER NOT NULL;

# Drop constraints #

ALTER TABLE `hotel_photos` DROP PRIMARY KEY;

# Drop table #

DROP TABLE `hotel_photos`;

# ---------------------------------------------------------------------- #
# Drop table "hotels"                                                    #
# ---------------------------------------------------------------------- #

# Remove autoinc for PK drop #

ALTER TABLE `hotels` MODIFY `hotel_id` INTEGER NOT NULL;

# Drop constraints #

ALTER TABLE `hotels` DROP PRIMARY KEY;

# Drop table #

DROP TABLE `hotels`;

# ---------------------------------------------------------------------- #
# Drop table "users"                                                     #
# ---------------------------------------------------------------------- #

# Remove autoinc for PK drop #

ALTER TABLE `users` MODIFY `user_id` INTEGER NOT NULL;

# Drop constraints #

ALTER TABLE `users` DROP PRIMARY KEY;

# Drop table #

DROP TABLE `users`;
