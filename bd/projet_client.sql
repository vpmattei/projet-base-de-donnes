-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: projet
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nom` char(15) NOT NULL,
  `prenom` char(15) DEFAULT NULL,
  `adr_mail` varchar(45) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  `adr_postale` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Vinicius','Mattei','viniciuspmattei@gmail.com','matteiv123','38100'),(2,'Roberto','Ribeiro','robribeiro@gmail.com','robebobe123','38000'),(3,'Bundao','Do Caraio','bundao@docaraio.com','cuzao123','123456789'),(4,'prenomTest','nomTest','mailTest','mdpTest','123'),(5,'Da Silva','Jorge','silvajorge@hotmail.com','silvinhoBemDemais123','88000'),(6,'Brabo','Bundao 2.0','bundabraba@cu.com','baitacu123','1038'),(7,'Brabo','Bundao 2.0','bundabraba@cu.com','baitacu123','1038'),(8,'Brabo','Bundao 2.0','bundabraba@cu.com','baitacu123','1038'),(9,'Brabo','Bundao 2.0','bundabraba@cu.com','baitacu123','1038'),(10,'Brabo','Bundao 2.0','bundabraba@cu.com','baitacu123','1038'),(11,'Brabo','Bundao 2.0','bundabraba@cu.com','baitacu123','1038'),(12,'Brabo','Bundao 2.0','bundabraba@cu.com','baitacu123','1038'),(13,'Brabo','Bundao 2.0','bundabraba@cu.com','baitacu123','1038'),(14,'Da Berimbau','Marcos','berimmarcos@eita.com.br','marcaodoberimbau123','997346');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-26 23:45:11
