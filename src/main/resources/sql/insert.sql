-- -----------------------------------------------------
-- Database insertion
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `lets_be_fit` DEFAULT CHARACTER SET UTF8MB4 COLLATE utf8mb4_unicode_ci;
USE `lets_be_fit`;
-- -----------------------------------------------------
-- Table `lets_be_fit`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scrumlab`.`admins`
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