-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.13


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema demo
--

CREATE DATABASE IF NOT EXISTS demo;
USE demo;

DROP TABLE IF EXISTS `demo`.`account`;
CREATE TABLE  `demo`.`account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ac_type` enum('Current','Savings','Fixed') NOT NULL,
  `balance` decimal(10,0) NOT NULL,
  `customer_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `newfk3` (`customer_id`),
  CONSTRAINT `newfk3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;
INSERT INTO `demo`.`account` (`id`,`ac_type`,`balance`,`customer_id`) VALUES 
 (66,'Savings','1000',101),
 (67,'Current','1000',101);

DROP TABLE IF EXISTS `demo`.`address`;
CREATE TABLE  `demo`.`address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `line1` varchar(50) DEFAULT NULL,
  `line2` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=222 DEFAULT CHARSET=utf8;
INSERT INTO `demo`.`address` (`id`,`line1`,`line2`,`country`,`city`) VALUES 
 (220,'L4JJ8FNZU864G85R7GU4569993E39A772W02DR8836QRC7FFKX','SMFUEQN929IXV4O906640640W4Z3W2G32U3GV0957F648L5291','48HLV4F8Y371OFLB4LCH1C4NLESV5109K1415N85OS86P2YYX9','FVI6A8W693R9EF7T6CBBHGB4WY0QU4R3RD37S0B4WTPASH0711'),
 (221,'558R1AT389N0801923V477SR494G6L6728W03D7F1WRT4I9NQK','YZ35R5OBAQ42N7Q6O24E6UTH99QI237POSTMY6225GN2911537','6XX2G07QCCESH0FPUW92607WHXR2T1M5Q16N6VWJMV594XV1B4','VE3193MI0R72SOR5WV9947D1285H8EU47M52TMLQJ46M0HK05Z');

DROP TABLE IF EXISTS `demo`.`customer`;
CREATE TABLE  `demo`.`customer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `address1` int(10) unsigned NOT NULL,
  `address2` int(10) unsigned NOT NULL,
  `current_account_opening_balance` decimal(10,0) NOT NULL,
  `savings_account_opening_balance` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `newfk` (`address1`),
  KEY `newfk2` (`address2`),
  CONSTRAINT `newfk2` FOREIGN KEY (`address2`) REFERENCES `address` (`id`),
  CONSTRAINT `newfk` FOREIGN KEY (`address1`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
INSERT INTO `demo`.`customer` (`id`,`name`,`surname`,`address1`,`address2`,`current_account_opening_balance`,`savings_account_opening_balance`) VALUES 
 (101,'Wallace','Wadge',220,221,'1000','1000');

DROP TABLE IF EXISTS `demo`.`customer_transaction`;
CREATE TABLE  `demo`.`customer_transaction` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) unsigned NOT NULL,
  `originating_account` int(10) unsigned NOT NULL,
  `destination_account` int(10) unsigned NOT NULL,
  `DRCR` enum('DR','CR') NOT NULL DEFAULT 'DR',
  `transaction_date` datetime NOT NULL,
  `amount` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `newfk5` (`destination_account`),
  KEY `newfk4` (`originating_account`),
  KEY `ctrans` (`customer_id`),
  CONSTRAINT `ctrans` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `newfk4` FOREIGN KEY (`originating_account`) REFERENCES `account` (`id`),
  CONSTRAINT `newfk5` FOREIGN KEY (`destination_account`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
INSERT INTO `demo`.`customer_transaction` (`id`,`customer_id`,`originating_account`,`destination_account`,`DRCR`,`transaction_date`,`amount`) VALUES 
 (27,101,67,66,'DR','2013-07-07 16:39:42','5'),
 (28,101,66,67,'CR','2013-07-06 17:39:42','5');



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
