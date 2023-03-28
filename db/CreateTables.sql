-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`order` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `id_customer` VARCHAR(45) NOT NULL,
  `id_item` INT NOT NULL,
  `order_date` VARCHAR(45) NOT NULL,
  `quantity` VARCHAR(45) NULL,
  `created_date` TIMESTAMP NULL,
  `updated_date` TIMESTAMP NULL,
  PRIMARY KEY (`id_order`),
  UNIQUE INDEX `id_UNIQUE` (`id_order` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`customer` (
  `id_customer` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone` INT NULL,
  `birthday` DATE NULL,
  `address` VARCHAR(100) NULL,
  `gender` CHAR(1) NULL,
  `type_customer` VARCHAR(45) NULL,
  `created_date` TIMESTAMP NULL,
  `updated_date` TIMESTAMP NULL,
  PRIMARY KEY (`id_customer`),
  UNIQUE INDEX `idCustomer_UNIQUE` (`id_customer` ASC) VISIBLE,
  CONSTRAINT `fk_customer_order1`
    FOREIGN KEY (`id_customer`)
    REFERENCES `mydb`.`order` (`id_customer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`item`
-- -----------------------------------------------------

CREATE TABLE `item` (
  `id_item` int NOT NULL,
  `id_category` int NOT NULL,
  `id_customer` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `price` double DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `end_date` timestamp NULL DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_item`,`id_customer`),
  UNIQUE INDEX `id_item_UNIQUE` (`id_item` ASC) VISIBLE,
  CONSTRAINT `fk_item_order1`
    FOREIGN KEY (`id_item`)
    REFERENCES `mydb`.`order` (`id_item`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`category` (
  `id_category` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  `created_date` TIMESTAMP NULL,
  `updated_date` TIMESTAMP NULL,
  PRIMARY KEY (`id_category`),
  UNIQUE INDEX `id_category_UNIQUE` (`id_category` ASC) VISIBLE,
  CONSTRAINT `fk_category_item1`
    FOREIGN KEY (`id_category`)
    REFERENCES `mydb`.`item` (`id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
