DROP table IF EXISTS `employees`;

CREATE TABLE `employees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) NULL,
  `job` VARCHAR(250) NULL,
  `salary` DECIMAL(10,2) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `employees` (`name`, `job`, `salary`) VALUES ('Xavi', 'EMPLOYEE', '35000');
INSERT INTO `employees` (`name`, `job`, `salary`) VALUES ('Maria', 'EMPLOYEE', '35000');
INSERT INTO `employees` (`name`, `job`, `salary`) VALUES ('Pedro', 'MANAGER', '50000');
INSERT INTO `employees` (`name`, `job`, `salary`) VALUES ('Sara', 'BOSS', '60000');
INSERT INTO `employees` (`name`, `job`, `salary`) VALUES ('Silvia', 'DIRECTOR', '70000');
