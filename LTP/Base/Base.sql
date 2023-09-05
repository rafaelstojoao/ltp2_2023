/*
SQLyog Enterprise v12.08 (64 bit)
MySQL - 8.0.31 : Database - faindmapdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`faindmapdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `faindmapdb`;

/*Table structure for table `andares` */

DROP TABLE IF EXISTS `andares`;

CREATE TABLE `andares` (
  `cod_andar` int NOT NULL AUTO_INCREMENT,
  `and_descricao` varchar(255) NOT NULL,
  `and_status` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`cod_andar`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `andares` */

insert  into `andares`(`cod_andar`,`and_descricao`,`and_status`) values (1,'Primeiro','ATIVO');

/*Table structure for table `aresta` */

DROP TABLE IF EXISTS `aresta`;

CREATE TABLE `aresta` (
  `cod_aresta` int NOT NULL AUTO_INCREMENT,
  `are_origem` int NOT NULL,
  `are_destino` int NOT NULL,
  `are_direcao` varchar(30) NOT NULL,
  `are_distancia` float DEFAULT NULL,
  PRIMARY KEY (`cod_aresta`,`are_origem`,`are_destino`),
  KEY `are_origem` (`are_origem`),
  KEY `are_destino` (`are_destino`),
  CONSTRAINT `aresta_ibfk_1` FOREIGN KEY (`are_origem`) REFERENCES `vertices` (`cod_vertice`),
  CONSTRAINT `aresta_ibfk_2` FOREIGN KEY (`are_destino`) REFERENCES `vertices` (`cod_vertice`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `aresta` */

insert  into `aresta`(`cod_aresta`,`are_origem`,`are_destino`,`are_direcao`,`are_distancia`) values (1,2,1,'DIREITA',10);

/*Table structure for table `blocos` */

DROP TABLE IF EXISTS `blocos`;

CREATE TABLE `blocos` (
  `cod_bloco` int NOT NULL AUTO_INCREMENT,
  `cod_campos` int NOT NULL,
  `blo_descricao` varchar(255) NOT NULL,
  `blo_status` varchar(30) NOT NULL,
  PRIMARY KEY (`cod_bloco`,`cod_campos`),
  KEY `cod_campos` (`cod_campos`),
  CONSTRAINT `blocos_ibfk_1` FOREIGN KEY (`cod_campos`) REFERENCES `campos` (`cod_campos`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `blocos` */

insert  into `blocos`(`cod_bloco`,`cod_campos`,`blo_descricao`,`blo_status`) values (1,1,'Bloco 4','ATIVO');

/*Table structure for table `campos` */

DROP TABLE IF EXISTS `campos`;

CREATE TABLE `campos` (
  `cod_campos` int NOT NULL AUTO_INCREMENT,
  `cam_nome` varchar(255) NOT NULL,
  PRIMARY KEY (`cod_campos`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `campos` */

insert  into `campos`(`cod_campos`,`cam_nome`) values (1,'Campos 2');

/*Table structure for table `vertices` */

DROP TABLE IF EXISTS `vertices`;

CREATE TABLE `vertices` (
  `cod_vertice` int NOT NULL AUTO_INCREMENT,
  `cod_campos` int NOT NULL,
  `ver_nome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ver_coordenadas` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cod_bloco` int NOT NULL,
  `cod_andar` int NOT NULL,
  `ver_numero_sala` int NOT NULL,
  `ver_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`cod_vertice`,`cod_campos`,`ver_numero_sala`),
  KEY `cod_campos` (`cod_campos`),
  KEY `cod_andar` (`cod_andar`),
  KEY `cod_bloco` (`cod_bloco`),
  CONSTRAINT `vertices_ibfk_1` FOREIGN KEY (`cod_campos`) REFERENCES `campos` (`cod_campos`),
  CONSTRAINT `vertices_ibfk_2` FOREIGN KEY (`cod_andar`) REFERENCES `andares` (`cod_andar`),
  CONSTRAINT `vertices_ibfk_3` FOREIGN KEY (`cod_bloco`) REFERENCES `blocos` (`cod_bloco`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `vertices` */

insert  into `vertices`(`cod_vertice`,`cod_campos`,`ver_nome`,`ver_coordenadas`,`cod_bloco`,`cod_andar`,`ver_numero_sala`,`ver_status`) values (1,1,'Lab 8','43.0, 897.0, 564.0',1,1,6,'ATIVO'),(2,1,'Lab 9','23.0, 898.0, 543.0',1,1,7,'ATIVO');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
