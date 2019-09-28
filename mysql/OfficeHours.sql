-- MySQL dump 10.17  Distrib 10.3.17-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: OfficeHours
-- ------------------------------------------------------
-- Server version	10.3.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `OfficeHours`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `OfficeHours` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `OfficeHours`;

--
-- Table structure for table `Department`
--

DROP TABLE IF EXISTS `Department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Department` (
  `DepartmentName` varchar(30) NOT NULL,
  `CollegeName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`DepartmentName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Department`
--

LOCK TABLES `Department` WRITE;
/*!40000 ALTER TABLE `Department` DISABLE KEYS */;
INSERT INTO `Department` VALUES ('Bilogical Sciences','College Of Science'),('Chemistry & Biochemistry','College Of Science'),('Computer Science','College Of Science'),('Geological Sciences','College Of Science'),('Kinekiology & HealthPromotion','College Of Science'),('Mathematics & Statistics','College Of Science'),('Physics & Astronomy','College Of Science');
/*!40000 ALTER TABLE `Department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Faculty`
--

DROP TABLE IF EXISTS `Faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Faculty` (
  `FacultyId` int(11) NOT NULL,
  `FirstName` varchar(30) DEFAULT NULL,
  `LastName` varchar(30) DEFAULT NULL,
  `PhoneNumber` varchar(20) DEFAULT NULL,
  `EmailAddress` varchar(30) DEFAULT NULL,
  `OfficeLocation` varchar(30) DEFAULT NULL,
  `DepartmentName` varchar(30) DEFAULT NULL,
  `PassPhrase` varchar(130) DEFAULT NULL,
  PRIMARY KEY (`FacultyId`),
  KEY `DepartmentName` (`DepartmentName`),
  CONSTRAINT `Faculty_ibfk_1` FOREIGN KEY (`DepartmentName`) REFERENCES `Department` (`DepartmentName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Faculty`
--

LOCK TABLES `Faculty` WRITE;
/*!40000 ALTER TABLE `Faculty` DISABLE KEYS */;
INSERT INTO `Faculty` VALUES (1,'Abdelfattah','Amamra','(909) 869-3447','aamamra@cpp.edu','8-11','Computer Science',' '),(2,'Dominick','Atanasio','(909) 869-4195','daatanasio@cpp.edu','8-47','Computer Science',' '),(3,'Tingting','Chen','(909) 869-4842','tingtingchen@cpp.edu','8-9','Computer Science',' '),(4,'Nima','Davarpanah','(909) 869-5519','ndavarpanah@cpp.edu','8-45','Computer Science',' '),(5,'Tony','Diaz','(909) 869-5519','tadiaz@cpp.edu','8-45','Computer Science',' '),(6,'Sander','Eller','(909) 869-4195','smeller@cpp.edu','8-47','Computer Science',' '),(7,'David','Gershman','(909) 869-4195','dagershman@cpp.edu','8-47','Computer Science',' '),(8,'Thomas','Huang','(909) 869-3451','thuang@cpp.edu','8-40','Computer Science',' '),(9,'Mohamed','Ibrahim','(909) 869-3451','moibrahim@cpp.edu','8-40','Computer Science',' '),(10,'Hao','Ji','(909) 869-5521','hji@cpp.edu','8-42','Computer Science',' '),(11,'Dave','Johannsen','(909) 979-4195','dljohannsen@cpp.edu','8-47','Computer Science',' '),(12,'Jonathan','Johannsen','(909) 869-5519','jdjohannsen@cpp.edu','8-45','Computer Science',' '),(13,'John','Korah','(909) 869-3441','jkorah@cpp.edu','8-15','Computer Science',' '),(14,'Devika','Maini','(909) 869-3451','dkakkar@cpp.edu','8-40','Computer Science',' '),(15,'Thanh','Nguyen','(909) 869-3451','tvnguyen7@cpp.edu','8-40','Computer Science',' '),(16,'Amar','Raheja','(909) 869-4412','raheja@cpp.edu','8-10','Computer Science',' '),(17,'Lajpat Rai','Raheja','(909) 869-4195','lraheja@cpp.edu','8-47','Computer Science',' '),(18,'Tannaz','Rezaei Damavandi','(909) 869-5519','tannazr@cpp.edu','8-45','Computer Science',' '),(19,'Edwin','Rodriguez','(909) 869-3451','earodriguez@cpp.edu','8-40','Computer Science',' '),(20,'Salam','Salluom','(909) 869-5317','ssalloum@cpp.edu','8-8','Computer Science',' '),(21,'Daisy','Sang','(909) 869-3469','fcsang@cpp.edu','8-43','Computer Science',' '),(22,'Ben','Steichen','(909) 869-3437','bsteichen@cpp.edu','8-44','Computer Science',' '),(23,'Adam','Summerville','(909) 869-3145','asummerville@cpp.edu','8-46','Computer Science',' '),(24,'Yu','Sun','(909) 869-3449','yusun@cpp.edu','8-13','Computer Science','7fde208824c5f238d4c30793ed3c7e4949aedbeda1f5781eb4c6d8b6558a853fc461d157faf3ed3186336016f82d9d6e90eea9274df72fd5802306fe4d741773'),(25,'Rahul','Talari','(909) 869-3451','rtalari@cpp.edu','8-40','Computer Science',' '),(26,'Lan','Yang','(909) 869-4052','lyang@cpp.edu','8-12','Computer Science',' '),(27,'Gilbert S.','Young','(909) 869-4413','gsyoung@cpp.edu','8-14','Computer Science',' '),(28,'Hussain','Zaidi','(909) 869-5519','hmzaidi@cpp.edu','8-45','Computer Science',' ');
/*!40000 ALTER TABLE `Faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OfficeHour`
--

DROP TABLE IF EXISTS `OfficeHour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OfficeHour` (
  `FacultyId` int(11) NOT NULL,
  `DayTime` varchar(100) NOT NULL,
  `Comment` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`FacultyId`,`DayTime`),
  CONSTRAINT `OfficeHour_ibfk_1` FOREIGN KEY (`FacultyId`) REFERENCES `Faculty` (`FacultyId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OfficeHour`
--

LOCK TABLES `OfficeHour` WRITE;
/*!40000 ALTER TABLE `OfficeHour` DISABLE KEYS */;
INSERT INTO `OfficeHour` VALUES (1,'M 11:00 AM - 1:00 PM;W 11:00 AM - 12:00 PM & 5:00 PM - 6:00 PM',' '),(2,'M 5:30 PM - 7:30 PM;Tu 2:00 PM - 4:00 PM','or via zoom video conference (appointment)'),(3,'MWF 9:30 AM - 10:40 AM',' '),(4,' ',' '),(5,'MWF 11:00 AM - 12:00 PM',' '),(6,'TuTh 8:30 AM - 9:40 AM & 11:30 AM - 12:40 PM',' & by appointment'),(7,'TuTh 8:30 PM - 9:30 PM',' '),(8,'W 6:00 PM - 7:00 PM',' '),(9,'TuTh 7:00 PM - 8:00 PM',' '),(10,'TuTh 1:00 PM - 3:00 PM',' '),(11,'Tu 1:00 PM - 2:00 PM;Th 2:00 PM - 3:00 PM',' '),(12,'Tu 1:15 PM - 2:15 PM;Th 4:00 PM - 5:00 PM',' '),(13,'MTuWTh 3:00 PM - 4:00 PM',' '),(14,'Tu 11:45 AM - 12:45 PM & 4:30 - 5:30 PM;Th 3:00 PM - 5:00 PM',' '),(15,'MWF 12:00 PM - 1:00 PM;TuTh 9:00 AM - 9:45 AM','(or by appointment)'),(16,'W 10:00 AM - 12:00 PM & 2:15 PM - 4:00 PM',' '),(17,'TuTh 1:00 PM - 2:00 PM',' '),(18,'MW 12:30 PM - 2:30 PM',' & by appointment'),(19,'MWF 8:00 AM - 9:00 AM',' '),(20,'TuTh 2:50 PM - 3:50 PM;F 11:00 AM - 1:00 PM (via email only)','(or by appointment)'),(21,'TuTh 9:00 AM - 10:00 AM & 3:00 PM - 4:00 PM',' '),(22,'TuTh 12:00 - 1:00 PM',' '),(23,'TuTh 10:00 AM - 12:00 PM',' '),(24,'TuTh 11:00 AM - 1:00 PM',' '),(25,'MW 10:00 AM - 11:00 AM',' '),(26,'MW 2:30 PM - 4:00 PM;TuTh 11:30 AM - 12:00 PM',' '),(27,'Tu 1:45 PM - 2:25 PM & 5:20 - 6:00 PM;Th 1:45 PM - 2:25 PM & 5:20 - 7:20 PM',' '),(28,'MW 8:15 PM - 8:45 PM',' ');
/*!40000 ALTER TABLE `OfficeHour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Section`
--

DROP TABLE IF EXISTS `Section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Section` (
  `Semester` varchar(30) NOT NULL,
  `CourseTitle` varchar(30) NOT NULL,
  `Section` varchar(10) NOT NULL,
  `FacultyId` int(11) NOT NULL,
  `DayTime` varchar(30) DEFAULT NULL,
  `RoomLocation` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Semester`,`CourseTitle`,`Section`,`FacultyId`),
  KEY `FacultyId` (`FacultyId`),
  CONSTRAINT `Section_ibfk_1` FOREIGN KEY (`FacultyId`) REFERENCES `Faculty` (`FacultyId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Section`
--

LOCK TABLES `Section` WRITE;
/*!40000 ALTER TABLE `Section` DISABLE KEYS */;
INSERT INTO `Section` VALUES ('Fall-2019','CS-1260','01',7,'TuTh 7:00 - 8:15 PM','8-4'),('Fall-2019','CS-1280','01',15,'MW 5:30 - 6:45 PM','3-2636'),('Fall-2019','CS-1300','01',3,'MWF 10:45 - 11:50 AM','8-302'),('Fall-2019','CS-1300','02',1,'MW 3:00 - 4:50 PM','8-302'),('Fall-2019','CS-1300','03',10,'TuTh 3:00 - 4:50 PM','8-302'),('Fall-2019','CS-1300','04',12,'TuTh 7:00 - 8:50 PM','8-345'),('Fall-2019','CS-1400','01',21,'TuTh 1:00 - 2:50 PM','8-52'),('Fall-2019','CS-1400','02',22,'TuTh 10:00 - 11:50 AM','8-52'),('Fall-2019','CS-1400','03',15,'MWF 9:30 - 10:35 AM','8-302'),('Fall-2019','CS-1400','04',5,'MW 1:00 - 2:50 PM','3-1616'),('Fall-2019','CS-2400','01',15,'TuTh 10:00 - 11:50 AM','8-302'),('Fall-2019','CS-2400','02',2,'TuTh 5:00 - 6:50 PM','8-52'),('Fall-2019','CS-2400','03',18,'MWF 10:45-11:50 AM ','8-52'),('Fall-2019','CS-2400','04',5,'MW 3:00 - 4:50 PM','8-52'),('Fall-2019','CS-2450','01',5,'MWF 10:00 - 10:50 AM','8-348'),('Fall-2019','CS-2450','02',12,'TuTh 2:30 - 3:45 PM','8-4'),('Fall-2019','CS-2560','01',5,'MWF 9:00 - 9:50 AM','8-348'),('Fall-2019','CS-2560','02',16,'MW 1:00 - 2:15 PM','3-2636'),('Fall-2019','CS-2600','01',7,'TuTh 5:30 - 6:45 PM','8-348'),('Fall-2019','CS-2640','01',4,'MW 7:00 - 8:15 PM','8-345'),('Fall-2019','CS-2640','02',15,'MWF 11:00 - 11:50 AM','8-348'),('Fall-2019','CS-2640','03',11,'TuTh 5:30 - 6:45 PM','1-309'),('Fall-2019','CS-2990','02',11,'TuTh 7:00 - 8:15 PM','3-2636'),('Fall-2019','CS-3010','01',17,'TuTh 2:30 - 3:45 PM','8-348'),('Fall-2019','CS-3010','02',19,'MWF 11:00 - 11:50 AM','8-345'),('Fall-2019','CS-3110','01',21,'TuTh 4:00 - 5:15 PM','8-345'),('Fall-2019','CS-3110','02',19,'MWF 10:00 - 10:50 AM','8-345'),('Fall-2019','CS-3110','03',19,'MWF 12:00 - 12:50 PM','8-345'),('Fall-2019','CS-3310','01',20,'TuTh 1:00 - 2:50 PM','8-302'),('Fall-2019','CS-3310','02',18,'MWF 9:30 - 10:35 AM','8-4'),('Fall-2019','CS-3310','03',12,'TuTh 5:00 - 6:50 PM','8-302'),('Fall-2019','CS-3560','01',18,'TuTh 10:00 - 11:15 AM','1-309'),('Fall-2019','CS-3650','01',1,'MW 1:00 - 2:50 PM','8-302'),('Fall-2019','CS-3650','02',11,'TuTh 3:00 - 4:50 PM','24C-1228'),('Fall-2019','CS-3650','03',14,'TuTh 7:00 - 8:50 PM','8-302'),('Fall-2019','CS-3700','01',8,'MW 7:00 - 8:15 PM','8-302'),('Fall-2019','CS-3750','01',6,'TuTh 10:00 - 11:15 AM','9-247'),('Fall-2019','CS-3750','02',6,'TuTh 1:00 - 2:15 PM','1-109'),('Fall-2019','CS-3750','04',2,'MW 4:00 - 5:15 PM','8-345'),('Fall-2019','CS-3750','05',9,'TuTh 5:30 - 6:45 PM','3-2636'),('Fall-2019','CS-3750','06',18,'MW 2:30 - 3:45 PM','3-2636'),('Fall-2019','CS-3800','01',13,'TuTh 7:00 - 8:15 PM','8-348'),('Fall-2019','CS-3800','02',13,'MW 5:30 - 6:45 PM','8-302'),('Fall-2019','CS-4080','01',26,'MW 1:00 - 2:15 PM','8-348'),('Fall-2019','CS-4080','02',26,'TuTh 10:00 - 11:15 AM','8-345'),('Fall-2019','CS-4080','03',19,'MWF 9:00 - 9:50 AM','8-345'),('Fall-2019','CS-4110','01',21,'TuTh 10:00 - 11:15 AM','8-348'),('Fall-2019','CS-4200','01',2,'TuTh 7:00 - 8:15 PM','8-52'),('Fall-2019','CS-4200','02',28,'MW 7:00 - 8:15 PM','8-52'),('Fall-2019','CS-4310','01',25,'MW 4:00 - 5:15 PM','3-2636'),('Fall-2019','CS-4310','02',14,'TuTh 1:00 - 2:15 PM','8-348'),('Fall-2019','CS-4310','03',27,'TuTh 2:30 - 3:45 PM','8-345'),('Fall-2019','CS-4350','01',20,'MW 1:00 - 2:15 PM','8-345'),('Fall-2019','CS-4350','02',9,'TuTh 4:00 - 5:15 PM','8-348'),('Fall-2019','CS-4600','01',2,'MW 2:30 - 3:45 PM','9-247'),('Fall-2019','CS-4630','01',3,'M 1:00 - 1:50 PM','8-48'),('Fall-2019','CS-4630','02',3,'W 1:00 - 1:50 PM','8-48'),('Fall-2019','CS-4630','03',23,'Tu 1:00 - 1:50 PM','8-48'),('Fall-2019','CS-4630','05',23,'Th 1:00 - 1:50 PM','8-48'),('Fall-2019','CS-4630','06',1,'Th 2:00 - 2:50 PM','8-48'),('Fall-2019','CS-4650','01',26,'TuTh 1:00 - 2:15 PM','8-345'),('Fall-2019','CS-4800','01',24,'TuTh 1:00 - 2:15 PM','24C-1228'),('Fall-2019','CS-4990','01',10,'TuTh 10:00 - 11:15 AM','3-2636'),('Fall-2019','CS-5300','01',27,'TuTh 4:00 - 5:15 PM','3-2636'),('Fall-2019','CS-5550','01',16,'TuTh 2:30 - 3:45 PM','3-2636'),('Fall-2019','CS-5700','01',22,'TuTh 1:00 - 2:15 PM','3-2636'),('Fall-2019','CS-5800','01',4,'MW 5:30 - 6:45 PM','8-52'),('Fall-2019','CS-5860','01',20,'MW 2:30 - 3:45 PM','8-348'),('Fall-2019','CS-6640','01',27,'Tu 6:00 - 6:50 PM','8-48');
/*!40000 ALTER TABLE `Section` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-28 16:17:48
