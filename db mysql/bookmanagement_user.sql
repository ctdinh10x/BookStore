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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID` int NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(200) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `PHONENUMBER` int NOT NULL,
  `ROLE` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USERNAME_UNIQUE` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (100,'tamdinh01','$2a$12$yIfgr5R6TGPWt2CPDWN6wOicCCwyeUV1bBdvvvt/Au0KA2oVEJiXe','chutamdinh3010@gmail.com',344670365,'ROLE_ADMIN'),(101,'quangiang01','$2a$12$qktMTSpkfpd821pkNKhHmOkzS2p6Pnpa6xdpVlbGX86MmVOa3x1YG','giang@gmail.com',456345678,'ROLE_USER'),(102,'chutamdinh3010','$2a$10$f32OgMGb9C/cluwF5qSmRunx2Ou8lffQ6loh7QDa53HkpfGyBm.hO','chutamdinh3010@gmail.com',344670365,'ROLE_USER'),(103,'tamdinh3010','$2a$10$egqBdx2nlSATBEPHQhfRDuJ/6z.ngYi90R2E47tm4jcfQteU8lS2q','chutamdinh3010@gmail.com',3434543,'ROLE_USER'),(104,'dinh01','$2a$10$czAZh6cM5dxs13dKomfVY.K89/xoreuR.OlzNcb4Ah3c6XJTiQW76','quanghuy3010@gmail.com',343567546,'ROLE_USER'),(105,'tdinh','$2a$10$tYhcfTrIf0ZsdsiAoGBSQuuYx4HmUDa6WBcxAGX6H7Agkq3eEBHgW','chutamdinh3010@gmail.com',343567546,'ROLE_USER'),(106,'tdinhhhh','$2a$10$sUoZ23oYj46cRLc.o4M0f.LLoFba944MZa8xUsZ4.Uxf0QEEplDtm','chutamdinh3010@gmail.com',344560463,'ROLE_USER'),(107,'giaduy','$2a$10$OqKis0yatJiOzDAF2/oNJezlbYuCzQFuUyw/9SfiXf5By.QcujMJq','giahuy@gmail.com',344670365,'ROLE_USER'),(108,'tamdinh2001','123456789','tamdinh@gmail.com',344670365,'ROLE_ADMIN'),(109,'saobietyeu3010','$2a$10$kKPlGhOGag582v.fKAlBmuiOPYQw4n1tjV26DvowOzJKcZDYMDDGO','saobietyeu3010@gmail.com',344670365,'ROLE_ADMIN');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
