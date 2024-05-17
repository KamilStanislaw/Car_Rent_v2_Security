CREATE DATABASE IF NOT EXISTS `m1180_rent_car`;
USE `m1180_rent_car`;

DROP TABLE IF EXISTS `cars`;

CREATE TABLE `cars` (
`id` bigint NOT NULL AUTO_INCREMENT,
`brand` varchar(50) DEFAULT NULL,
`model` varchar(50) DEFAULT NULL,
`color` varchar(50) DEFAULT NULL,
`vin` long DEFAULT NULL,
`rented` boolean DEFAULT NULL,
`fixing` boolean DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `cars` VALUES 
(1, 'Skoda', 'Fabia', 'white', 1243534536, false,true),
(2, 'Skoda', 'Fabia', 'white', 3566797232, true,false),
(3, 'Skoda', 'Superb', 'grey', 8679363434, true,false),
(4, 'Skoda', 'Superb', 'grey', 1234809642, false,false),
(5, 'Volkswagen', 'Golf', 'silver', 1985534522, true,false),
(6, 'Volkswagen', 'Golf', 'white', 7980435323, false,true),
(7, 'Volkswagen', 'Polo', 'white', 3215467676, true,false),
(8, 'Volkswagen', 'Polo', 'black', 3287798042, true,false),
(9, 'Opel', 'Astra', 'silver', 3456088742, true,false),
(10, 'Opel', 'Astra', 'silver', 6769782324, false,true),
(11, 'Opel', 'Astra', 'white', 7052669102, false,false),
(12, 'Opel', 'Insignia', 'white', 7052663487, false,false),
(13, 'Kia', 'Ceed', 'silver', 6769783434, true,false),
(14, 'Kia', 'Ceed', 'white', 6768994323, true,false),
(15, 'Toyota', 'Yaris', 'grey', 1235767434, true,false),
(16, 'Toyota', 'Yaris', 'grey', 1235767434, true,false),
(17, 'Toyota', 'Corolla', 'silver', 1235767434, true,false),
(18, 'Toyota', 'Corolla', 'white', 2368790255, false,false),
(19, 'BMW', 'M3', 'black', 1877352351, true,false),
(20, 'BMW', 'M3', 'black', 1125476888, true,false);



