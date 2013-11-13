 DROP SCHEMA c3p0; 
 CREATE SCHEMA IF NOT EXISTS c3p0;
 USE c3p0;
 CREATE TABLE IF NOT EXISTS `user` (
 `id` int auto_increment,
 `username` varchar(12) DEFAULT NULL,
 `password` varchar(12) DEFAULT NULL,
 `birthday` date DEFAULT NULL,
 PRIMARY KEY(id))
 ENGINE=InnoDB DEFAULT CHARSET=utf8;


 GRANT ALL ON c3p0.* TO 'c3p0'@'127.0.0.1' IDENTIFIED BY 'c3p0';
