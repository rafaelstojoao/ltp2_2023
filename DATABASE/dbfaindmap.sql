/*
SQLyog Enterprise v12.08 (64 bit)
MySQL - 8.0.11 : Database - dbfaindmap
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `andares` */

DROP TABLE IF EXISTS `andares`;

CREATE TABLE `andares` (
  `id_andar` int(11) NOT NULL AUTO_INCREMENT,
  `id_status` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_andar`),
  KEY `id_status` (`id_status`),
  CONSTRAINT `andares_ibfk_1` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `andares` */

insert  into `andares`(`id_andar`,`id_status`,`nome`) values (1,1,'1º Andar'),(2,1,'2º Andar'),(3,1,'3º Andar'),(4,1,'4º Andar'),(5,1,'5º Andar'),(6,1,'6º Andar');

/*Table structure for table `arestas` */

DROP TABLE IF EXISTS `arestas`;

CREATE TABLE `arestas` (
  `id_aresta` int(11) NOT NULL AUTO_INCREMENT,
  `id_vertice_origem` int(11) NOT NULL,
  `id_vertice_destino` int(11) NOT NULL,
  `id_direcao` int(11) NOT NULL,
  `descricao_vertice_origem` varchar(255) NOT NULL,
  `descricao_vertice_destino` varchar(255) NOT NULL,
  `distancia` double NOT NULL,
  PRIMARY KEY (`id_aresta`),
  KEY `id_vertice_origem` (`id_vertice_origem`),
  KEY `id_vertice_destino` (`id_vertice_destino`),
  KEY `id_direcao` (`id_direcao`),
  CONSTRAINT `arestas_ibfk_1` FOREIGN KEY (`id_vertice_origem`) REFERENCES `vertices` (`id_vertice`),
  CONSTRAINT `arestas_ibfk_2` FOREIGN KEY (`id_vertice_destino`) REFERENCES `vertices` (`id_vertice`),
  CONSTRAINT `arestas_ibfk_3` FOREIGN KEY (`id_direcao`) REFERENCES `direcao` (`id_direcao`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `arestas` */

insert  into `arestas`(`id_aresta`,`id_vertice_origem`,`id_vertice_destino`,`id_direcao`,`descricao_vertice_origem`,`descricao_vertice_destino`,`distancia`) values (1,1,2,1,'Sala 7','Sala 8',10),(2,2,4,2,'Sala 8','Sala 5',9),(3,2,3,3,'Sala 8','Sala 10',19),(4,4,5,4,'Sala 5','Sala 6',3),(5,5,3,5,'Sala 6','Sala 10',34),(6,1,4,1,'Sala 7','Sala 5',32);

/*Table structure for table `blocos` */

DROP TABLE IF EXISTS `blocos`;

CREATE TABLE `blocos` (
  `id_bloco` int(11) NOT NULL AUTO_INCREMENT,
  `id_status` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_bloco`),
  KEY `id_status` (`id_status`),
  CONSTRAINT `blocos_ibfk_1` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `blocos` */

insert  into `blocos`(`id_bloco`,`id_status`,`nome`) values (1,1,'Bloco 1'),(2,2,'Bloco 2'),(3,1,'Bloco 3'),(4,1,'Bloco 4'),(5,1,'Bloco 5');

/*Table structure for table `campus` */

DROP TABLE IF EXISTS `campus`;

CREATE TABLE `campus` (
  `id_campus` int(11) NOT NULL AUTO_INCREMENT,
  `id_status` int(11) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_campus`),
  KEY `id_status` (`id_status`),
  CONSTRAINT `campus_ibfk_1` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `campus` */

insert  into `campus`(`id_campus`,`id_status`,`descricao`) values (1,1,'Câmpus 1'),(2,1,'Câmpus 2'),(3,1,'Câmpus 3');

/*Table structure for table `direcao` */

DROP TABLE IF EXISTS `direcao`;

CREATE TABLE `direcao` (
  `id_direcao` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_direcao`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `direcao` */

insert  into `direcao`(`id_direcao`,`descricao`) values (1,'DIREITA'),(2,'ESQUERDA'),(3,'SUBIR'),(4,'DESCER'),(5,'EM FRENTE');

/*Table structure for table `status` */

DROP TABLE IF EXISTS `status`;

CREATE TABLE `status` (
  `id_status` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `status` */

insert  into `status`(`id_status`,`descricao`) values (1,'ABERTO'),(2,'FECHADO');

/*Table structure for table `vertices` */

DROP TABLE IF EXISTS `vertices`;

CREATE TABLE `vertices` (
  `id_vertice` int(11) NOT NULL AUTO_INCREMENT,
  `id_bloco` int(11) NOT NULL,
  `id_andar` int(11) NOT NULL,
  `numero_sala` int(11) NOT NULL,
  `id_status` int(11) NOT NULL,
  `id_campus` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`id_vertice`),
  KEY `id_status` (`id_status`),
  KEY `id_bloco` (`id_bloco`),
  KEY `id_andar` (`id_andar`),
  KEY `id_campus` (`id_campus`),
  CONSTRAINT `vertices_ibfk_1` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`),
  CONSTRAINT `vertices_ibfk_2` FOREIGN KEY (`id_bloco`) REFERENCES `blocos` (`id_bloco`),
  CONSTRAINT `vertices_ibfk_3` FOREIGN KEY (`id_andar`) REFERENCES `andares` (`id_andar`),
  CONSTRAINT `vertices_ibfk_4` FOREIGN KEY (`id_campus`) REFERENCES `campus` (`id_campus`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `vertices` */

insert  into `vertices`(`id_vertice`,`id_bloco`,`id_andar`,`numero_sala`,`id_status`,`id_campus`,`nome`,`latitude`,`longitude`) values (1,4,6,7,1,2,'Sala 7',-21.66873550415039,-51.0775032043457),(2,4,6,8,1,2,'Sala 8',-21.66871,-51.077196),(3,4,6,10,1,2,'Sala 10',-21.66851,-51.077222),(4,4,6,5,1,2,'Sala 5',-21.67851,-51.089296),(5,4,6,6,1,2,'Sala 6',-21.616851,-51.097136),(6,4,3,-1,1,2,'Cantina',-22.46729,-52.174571),(7,4,6,9,1,2,'Sala 7',-21.66873550415039,-51.0775032043457);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
