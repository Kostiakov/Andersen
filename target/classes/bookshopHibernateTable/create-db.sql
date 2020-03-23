
DROP TABLE IF EXISTS `literatureNew`;
DROP TABLE IF EXISTS `bookNew`;
DROP TABLE IF EXISTS `magazineNew`;

CREATE TABLE `bookNew` (
   id int PRIMARY KEY,
   author varchar(20),
   CONSTRAINT `DETAIL` FOREIGN KEY (`id`) REFERENCES `literatureNew` (`id`) 
);

CREATE TABLE `magazineNew` (
   id int PRIMARY KEY,
   `numbers_per_year` int(10) DEFAULT NULL,
   CONSTRAINT `DETAIL2` FOREIGN KEY (`id`) REFERENCES `literatureNew` (`id`) 
);

CREATE TABLE `literatureNew` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `publisher` varchar(128) DEFAULT NULL,
  `year` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
