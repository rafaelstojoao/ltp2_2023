-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 28-Ago-2023 às 23:52
-- Versão do servidor: 8.0.31
-- versão do PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `faindmap`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `vertices`
--

DROP TABLE IF EXISTS `vertices`;
CREATE TABLE IF NOT EXISTS `vertices` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) COLLATE latin1_general_ci DEFAULT NULL,
  `bloco` int DEFAULT NULL,
  `andar` int DEFAULT NULL,
  `numero_sala` int DEFAULT NULL,
  `campos` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `coordenadas` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
