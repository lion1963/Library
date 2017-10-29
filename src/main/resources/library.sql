create database if not exists library;

create table if not exists `library`.`books`(
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `author` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;