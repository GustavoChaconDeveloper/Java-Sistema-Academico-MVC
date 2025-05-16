-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 17-Maio-2023 às 13:42
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
-- Banco de dados: `dbaluno`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

DROP TABLE IF EXISTS `aluno`;
CREATE TABLE IF NOT EXISTS `aluno` (
  `rgm` int NOT NULL,
  `nome` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `dtanascimento` varchar(12) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `cep` varchar(12) DEFAULT NULL,
  `endereco` varchar(60) NOT NULL,
  `numero` int DEFAULT NULL,
  `bairro` varchar(20) NOT NULL,
  `municipio` varchar(20) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `telefone` varchar(50) NOT NULL,
  `campus` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `curso` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `turno` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`rgm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `notasfaltas`
--

DROP TABLE IF EXISTS `notasfaltas`;
CREATE TABLE IF NOT EXISTS `notasfaltas` (
  `disciplina` varchar(60) NOT NULL,
  `semestre` varchar(6) NOT NULL,
  `notas` varchar(20) NOT NULL,
  `faltas` int NOT NULL,
  `rgm` int NOT NULL,
  PRIMARY KEY (`disciplina`),
  KEY `FK_ALUNO_2_NOTASFALTAS` (`rgm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `notasfaltas`
--
ALTER TABLE `notasfaltas`
  ADD CONSTRAINT `FK_ALUNO_2_NOTASFALTAS` FOREIGN KEY (`rgm`) REFERENCES `aluno` (`rgm`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
