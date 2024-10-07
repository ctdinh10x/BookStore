CREATE DATABASE  IF NOT EXISTS `bookmanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bookmanagement`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: bookmanagement
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `idComment` int NOT NULL AUTO_INCREMENT,
  `idUser` int NOT NULL,
  `BookCode` int NOT NULL,
  `SoSao` int DEFAULT NULL,
  `NoiDung` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `ThoiGian` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idComment`),
  KEY `idUser_idx` (`idUser`),
  KEY `BookCode_idx` (`BookCode`),
  CONSTRAINT `BookCode` FOREIGN KEY (`BookCode`) REFERENCES `book` (`BookCode`),
  CONSTRAINT `idUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=237 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (226,100,102,4,'hay','1:05:41 - Thứ 5 Ngày 8/12/2022'),(227,103,102,3,'bình thường','1:13:36 - Thứ 5 Ngày 8/12/2022'),(228,103,103,5,'Sách rất hay','1:13:55 - Thứ 5 Ngày 8/12/2022'),(229,103,104,4,'sách hay','1:14:9 - Thứ 5 Ngày 8/12/2022'),(230,100,102,4,'sách hay','10:09:18 - Thứ 4 Ngày 14/12/2022'),(231,100,104,5,'tuyệt','11:25:40 - Thứ 6 Ngày 16/12/2022'),(232,100,104,4,'sách hay','11:26:10 - Thứ 6 Ngày 16/12/2022'),(233,100,113,5,'Tốt','15:52:02 - Thứ 6 Ngày 30/12/2022'),(234,103,102,4,'hay','09:23:22 - Thứ 5 Ngày 02/02/2023'),(235,100,102,3,'giở tệ','09:15:50 - Thứ 4 Ngày 15/02/2023'),(236,109,102,4,'tôi đã mua','10:42:42 - Thứ 2 Ngày 06/05/2024');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-07 23:47:34
