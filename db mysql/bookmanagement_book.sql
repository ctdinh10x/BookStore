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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `BookCode` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Author` varchar(45) NOT NULL,
  `Title` varchar(45) NOT NULL,
  `ReleaseDate` varchar(45) NOT NULL,
  `NumberOfPages` int NOT NULL,
  `Type` varchar(45) NOT NULL,
  `Painted` varchar(45) DEFAULT NULL,
  `Img` varchar(200) DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  PRIMARY KEY (`BookCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (102,'Thế giới như tôi thấy','Albert Einstein','Thế giới như tôi thấy','1931',100,'Tập hợp các bài viết, bài phát biểu','Sách còn mới','sach-hay-toi-ac-va-hinh-phat.jpg',94),(103,'Người dưng','Albert Camus','Người dưng','1942',1000,'Tiểu thuyết','Sách còn mới','camus.jpg',95),(104,'Gullible du ký ','Ken Schoolland','Trường ca Odyssey về thị trường tự do','2008',1000,'Truyện ngụ ngôn về kinh tế học','Sách còn mới','Gullible-du-ky-Tony.jpg',98),(105,'Đắc Nhân Tâm','Dale Carnegie','How to Win Friends and Influence People','1890',1000,'Triết học, xã hội học','Sách còn mới','sach-hay-dac-nhan-tam .jpg',98),(106,'Nhà Giả Kim','Paulo Coelho','Nhà Giả Kim','1990',1000,'Triết học, xã hội học','Sách còn mới','sach-hay-nha-gia-kim.jpg',100),(107,'Tội Ác Và Hình Phạt','Fyodor Dostoevsky','Tội Ác Và Hình Phạt','1920',1000,'Xã hội học','Sách mới','sach-hay-toi-ac-va-hinh-phat.jpg',100),(109,'Mỗi lần vấp ngã là một lần Trưởng Thành','Liêu Trí Phong','Mỗi lần vấp ngã là một lần Trưởng Thành','2000',1000,'Danh ngôn','Sách còn mới','sach-hay-moi-lan-vap-nga-la-mot-lan-truong-thanh.jpg',100),(110,'Tuổi Trẻ Đáng Giá Bao Nhiêu?','Rosie Nguyễn','Tuổi Trẻ Đáng Giá Bao Nhiêu?','1990',1000,'Đường đời, trải nghiệm','sách còn mới','sach-hay-tuoi-tre-dang-gia-bao-nhieu.jpg',100),(111,'Đời thay đổi khi chúng ta thay đổi','Andrew Matthews','Đời thay đổi khi chúng ta thay đổi','2001',1000,'xã hội học','sách còn mới','sach-hay-doi-thay-doi-khi-chung-ta-thay-doi.jpg',100),(112,'Dạy Con Làm Giàu','Robert Kiyosaki','Để không có tiền vẫn tạo ra tiền','1990',1000,'Cách làm giàu','Sách còn mới','sach-hay-day-con-lam-giau.jpg',100),(113,'Những Tấm Lòng Cao Cả','Edmondo De Amicis','Những Tấm Lòng Cao Cả','1920',1000,'Văn học ','Sách còn mới','sach-hay-nhung-tam-long-cao-ca.jpg',99),(115,'Nhà Lãnh Đạo không Chức Danh','Robin Sharma','Nhà Lãnh Đạo không Chức Danh','1990',1000,'Xã hội học','Sách mới','sach-hay-nha-lanh-dao-khong-chuc-danh.jpg',100),(116,'Cho tôi xin 1 vé đi tuổi thơ','Nguyễn Nhật Ánh','Cho tôi xin 1 vé đi tuổi thơ','2010',1000,'Đời sống,Văn học','Sách mới','sach-hay-cho-toi-xin-mot-ve-di-tuoi-tho.jpg',100);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
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
