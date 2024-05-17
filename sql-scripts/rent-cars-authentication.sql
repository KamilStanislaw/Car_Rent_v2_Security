USE `m1180_rent_car`;

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `role`;
SET foreign_key_checks = 1;

-- create table `user`

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(50) NOT NULL,
`password` char(80) NOT NULL,
`enabled` tinyint NOT NULL,
PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- The passwords are encrypted using BCrypt
-- Passwords : maranello90

INSERT INTO `user` (`username`, `password`, `enabled`)
VALUES 
('janek', '$2a$10$bqgNU1sh10Ru5npsgSwEJOxHu03yRr/pl2yQylH8n9iBBOHeKSoou', 1),
('maria', '$2a$10$bqgNU1sh10Ru5npsgSwEJOxHu03yRr/pl2yQylH8n9iBBOHeKSoou', 1),
('zofia', '$2a$10$bqgNU1sh10Ru5npsgSwEJOxHu03yRr/pl2yQylH8n9iBBOHeKSoou', 1);


-- table `role`

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(50) NOT NULL,
PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `role` (name)
VALUES
('ROLE_EMPLOYEE'), ('ROLE_MANAGER'), ('ROLE_ADMIN');

SET FOREIGN_KEY_CHECKS = 0;


-- table `users_roles`

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles`(
`user_id` int(11) NOT NULL,
`role_id` int(11) NOT NULL,

CONSTRAINT `FK_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
ON DELETE NO ACTION ON UPDATE NO ACTION,

CONSTRAINT `FK_ROLE_ID` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES 
(1, 1), -- janek - as employee - main role
-- -----------------------
(2, 1), -- maria - as employee
(2, 2), -- maria - as manager - main role
-- -----------------------
(3, 1), -- zofia - as employee
(3, 2), -- zofia - as manager
(3, 3); -- zofia - as admin - main role

