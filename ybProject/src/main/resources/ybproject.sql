-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.32 - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- ybproject 의 데이터베이스 구조 덤핑
CREATE DATABASE IF NOT EXISTS `ybproject` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ybproject`;


-- 테이블 ybproject의 구조를 덤프합니다. account
CREATE TABLE IF NOT EXISTS `account` (
  `account_number` varchar(200) NOT NULL,
  `client_id` varchar(200) NOT NULL,
  `account_name` varchar(200) DEFAULT NULL,
  `deposit` int(11) DEFAULT NULL,
  `account_create_branch` varchar(200) DEFAULT NULL,
  `account_manager` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`account_number`),
  KEY `FK_account_client` (`client_id`),
  CONSTRAINT `FK_account_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ybproject.account: ~4 rows (대략적)
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`account_number`, `client_id`, `account_name`, `deposit`, `account_create_branch`, `account_manager`) VALUES
	('130-26223417-621', '2', '적금통장', 10000, '중앙점', '양'),
	('130-26223509-567', '1', '투자통장', 10000, '중앙점', '양'),
	('130-26223533-763', '1', '생명줄', 10000, '중앙점', '양'),
	('640-26223523-872', '1', '지불용', 100000, '서신점', '백');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;


-- 테이블 ybproject의 구조를 덤프합니다. branch
CREATE TABLE IF NOT EXISTS `branch` (
  `branch_code` varchar(200) NOT NULL,
  `branch_name` varchar(200) DEFAULT NULL,
  `manager` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`branch_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ybproject.branch: ~2 rows (대략적)
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` (`branch_code`, `branch_name`, `manager`) VALUES
	('130', '중앙점', '양'),
	('640', '서신점', '백');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;


-- 테이블 ybproject의 구조를 덤프합니다. client
CREATE TABLE IF NOT EXISTS `client` (
  `client_id` varchar(200) NOT NULL,
  `client_pw` varchar(200) DEFAULT NULL,
  `client_name` varchar(200) DEFAULT NULL,
  `client_address` varchar(200) DEFAULT NULL,
  `client_phone` varchar(200) DEFAULT NULL,
  `branch_code` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  KEY `FK_client_branch` (`branch_code`),
  CONSTRAINT `FK_client_branch` FOREIGN KEY (`branch_code`) REFERENCES `branch` (`branch_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ybproject.client: ~2 rows (대략적)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`client_id`, `client_pw`, `client_name`, `client_address`, `client_phone`, `branch_code`) VALUES
	('1', '123', '백', '서신동', '001', NULL),
	('2', '123', '양', '중앙동', '002', NULL);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;


-- 테이블 ybproject의 구조를 덤프합니다. userorder
CREATE TABLE IF NOT EXISTS `userorder` (
  `order_day` date NOT NULL,
  `order_number` varchar(200) NOT NULL,
  `account_number` varchar(200) NOT NULL,
  `client_id` varchar(200) NOT NULL,
  `item_code` int(100) DEFAULT NULL,
  `order_count` int(100) DEFAULT NULL,
  `order_pay` int(100) DEFAULT NULL,
  PRIMARY KEY (`order_day`,`order_number`),
  KEY `FK_order_account` (`account_number`),
  KEY `FK_order_account_2` (`client_id`),
  CONSTRAINT `FK_order_account` FOREIGN KEY (`account_number`) REFERENCES `account` (`account_number`),
  CONSTRAINT `FK_order_account_2` FOREIGN KEY (`client_id`) REFERENCES `account` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ybproject.userorder: ~7 rows (대략적)
/*!40000 ALTER TABLE `userorder` DISABLE KEYS */;
INSERT INTO `userorder` (`order_day`, `order_number`, `account_number`, `client_id`, `item_code`, `order_count`, `order_pay`) VALUES
	('2019-02-26', '26223553', '130-26223533-763', '1', 300, 100, 4500000),
	('2019-02-26', '26232835', '130-26223509-567', '1', 200, 12, 420000),
	('2019-02-26', '26232907', '130-26223509-567', '1', 100, 2, 50000),
	('2019-02-26', '26232913', '130-26223509-567', '1', 20, 2, 10000),
	('2019-02-26', '26232917', '130-26223509-567', '1', 50, 3, 165000),
	('2019-02-26', '26232925', '130-26223509-567', '1', 200, 2, 70000),
	('2019-02-27', '27194855', '130-26223417-621', '2', 300, 10, 1945000);
/*!40000 ALTER TABLE `userorder` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
