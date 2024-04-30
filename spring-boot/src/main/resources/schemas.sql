DROP DATABASE IF EXISTS `demo`;
CREATE DATABASE IF NOT EXISTS `demo` CHARSET `utf8mb4` COLLATE `utf8mb4_general_ci`;
USE `demo`;

CREATE TABLE `article` (
    `id` int NOT NULL AUTO_INCREMENT,
    `title` varchar(100) NOT NULL,
    `content` text NOT NULL,
    `author_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_author_id` (`author_id`)
);

CREATE TABLE `author` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_name` (`name`)
);
