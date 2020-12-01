-- -----------------------------------------------------
-- Database `lets_be_fit`
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `lets_be_fit` DEFAULT CHARACTER SET UTF8MB4 COLLATE utf8mb4_unicode_ci;
USE `lets_be_fit`;
-- -----------------------------------------------------
-- Table `lets_be_fit`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lets_be_fit`.`users`
(
    `id`         INT          NOT NULL AUTO_INCREMENT COMMENT 'Table primary key.',
    `first_name` VARCHAR(245) NULL COMMENT 'First name',
    `last_name`  VARCHAR(245) NULL COMMENT 'Last name',
    `email`      VARCHAR(245) NULL COMMENT 'E-mail address',
    `password`   VARCHAR(60)  NULL COMMENT 'Password',
    `superadmin` TINYINT(1)   NULL COMMENT 'Is user an admin?',
    `enable`     TINYINT(1)   NOT NULL DEFAULT '1' COMMENT 'Is user active and can log in?',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = 'Table containing users data.';
-- -----------------------------------------------------
-- Table `lets_be_fit`.`users_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lets_be_fit`.`users_details`
(
    `id`       INT          NOT NULL AUTO_INCREMENT COMMENT 'Table primary key.',
    `nickname` VARCHAR(245) NULL COMMENT 'User nickname',
    `sex`      VARCHAR(6)   NULL COMMENT 'User sex',
    `birthday` DATETIME     NULL COMMENT 'User date of birth',
    `weight`   DECIMAL(4,1) NULL COMMENT 'User weight',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = 'Table containing additional, variable users data.';
-- -----------------------------------------------------
-- Table `lets_be_fit`.`plans`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lets_be_fit`.`plans`
(
    `id`           INT          NOT NULL AUTO_INCREMENT COMMENT 'Table primary key.',
    `name` VARCHAR(245) NULL COMMENT 'Name of the plan',
    `start_weight`   DECIMAL(4,1) NULL COMMENT 'User weight when starting the plan',
    `target_weight` DECIMAL(4,1) NULL COMMENT 'Target weight',
    `target_time` DATETIME  NULL COMMENT 'Deadline to lose weight',
    `daily_BMR` INT NULL COMMENT 'Current MBR',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = 'Table containing plans created by users.';
-- -----------------------------------------------------
-- Table `lets_be_fit`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lets_be_fit`.`products`
(
    `id`           INT          NOT NULL AUTO_INCREMENT COMMENT 'Table primary key.',
    `name` VARCHAR(245) NULL COMMENT 'Name of the product',
    `calories`     INT          NOT NULL COMMENT 'Number of calories in 100g/100ml',
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = 'Table containing products and the number of calories in them.';