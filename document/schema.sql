 DROP SCHEMA spring_datasource_c3p0; 
 CREATE SCHEMA IF NOT EXISTS spring_datasource_c3p0;
 USE spring_datasource_c3p0;
 CREATE TABLE IF NOT EXISTS `user` (
 `id` int auto_increment,
 `username` varchar(12) DEFAULT NULL,
 `password` varchar(12) DEFAULT NULL,
 `birthday` date DEFAULT NULL,
 PRIMARY KEY(id))
 ENGINE=InnoDB DEFAULT CHARSET=utf8;

 GRANT ALL ON spring_datasource_c3p0.* TO 'c3p0'@'127.0.0.1' IDENTIFIED BY 'c3p0';
