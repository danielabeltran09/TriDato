CREATE USER 'username'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'username'@'%';
/* UPDATE mysql.user SET Host='%' WHERE Host='localhost' AND User='username' */
ALTER USER 'username'@'%' IDENTIFIED WITH mysql_native_password BY 'password';
CREATE DATABASE dev;
USE dev;
CREATE TABLE `data_entries` (
	`acuerdo_id` INT NOT NULL,
	`numero` INT NOT NULL,
	`area_id` INT NOT NULL,
	`documento` VARCHAR(255) NOT NULL,
	`naturaleza` VARCHAR(255) NOT NULL,
	`partes` TEXT NOT NULL,
	`permiso_ver_texto` VARCHAR(255) NOT NULL,
	`extracto` TEXT NOT NULL,
	`tipo_acuerdo_id` INT NOT NULL,
	`fecha_publicacion` VARCHAR(255) NOT NULL,
	`fec_dictado` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`acuerdo_id`)
);
