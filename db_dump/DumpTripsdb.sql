CREATE DATABASE  IF NOT EXISTS `trips` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `trips`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: trips
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `place_accommodation`
--

DROP TABLE IF EXISTS `place_accommodation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `place_accommodation` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `booking_link` varchar(255) DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `date_created` datetime(6) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  `property_name` varchar(255) DEFAULT NULL,
  `place_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhyxlgsoc8h4ab6m4g5k12frtr` (`place_id`),
  CONSTRAINT `FKhyxlgsoc8h4ab6m4g5k12frtr` FOREIGN KEY (`place_id`) REFERENCES `places` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place_accommodation`
--

LOCK TABLES `place_accommodation` WRITE;
/*!40000 ALTER TABLE `place_accommodation` DISABLE KEYS */;
INSERT INTO `place_accommodation` VALUES ('40289d748c2e8935018c2e8956000000','Sher Ghari Mussoorie','https://www.sterlingholidays.com/resorts-hotels/mussoorie','','',NULL,'The 5.5-acre resort is perched on a cliff and the rooms below the main block provide mesmerising views of the picturesque Doon valley. Enjoy the tranquil surroundings and burn calories as you take the stairs up from your room to the restaurant to gorge on Garhwali cuisine.Did you know that winterline is visible only at two places in the whole world? One is in Switzerland and the other is right here at Mussoorie.The resort has 111 well-appointed rooms with a huge window in each room, from where you can enjoy the beauty of the alluring Doon valley. You can just grab a cup of tea and watch the clouds dancing around. If you are feeling adventurous, the rocky forest terrain has many trekking routes. And the resort\'s Holiday Activity Centre has a list of experiences like rope adventures, zip line, paintball, etc.As a courtesy to all our guests: Hookah / Sheesha are not permitted in the resort. Portable speakers also are not allowed in the resort.','','Sterling Mussoorie','40289d748c2b39f4018c2b3c41f70000'),('40289d748c2f1220018c2f1abbe50000','Village Bagori, PO, opposite Buddha Temple, Harsil, Uttarakhand ','https://hotelroyalhillcrest.com','','',NULL,'Royal Hill Crest is a beautiful hotel located in the serene and picturesque village of Bagori in Harsil. The hotel offers a comfortable stay with its range of well-appointed rooms, including Standard and Deluxe rooms. The rooms are spacious, elegantly designed, and equipped with all modern amenities to ensure a pleasant and memorable stay for guests.','','Hotel Royal HillCrest','40289d748c2b39f4018c2b3c99260001'),('40289d748c2fa339018c2fafcbf20000','Barrage Road, 237, Virbhadra Rd, near AIIMS, Sturida Colony, Rishikesh, Uttarakhand 249201 ','https://www.gangakinare.com/ganga-kinare-rishikesh-hotel-resort/','','',NULL,'Nestled snugly on the banks of a tranquil River Ganges, GANGA KINARE - by A Riverside Boutique Resort is a charming boutique hotel in the sanctum of Rishikesh, a land where spirituality and Mother Nature blend into a heady concoction. The only hotel resort in Rishikesh built right on the banks of the Ganges, Ganga Kinare overlooks the Rajaji National Park, one of North India’s expansive sanctuaries and a melting pot of diverse flora and fauna. Ganga Kinare - hotel and resort boasts a waterside esplanade, where guests can stroll alongside the sinuous river, soak in the sight of the mountains and revel in the sheer verdancy of the surroundings.','','Ganga Kinare','40289d748c2b39f4018c2b3cc1af0002');
/*!40000 ALTER TABLE `place_accommodation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `places`
--

DROP TABLE IF EXISTS `places`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `places` (
  `id` varchar(255) NOT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `date_created` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `place_name` varchar(255) DEFAULT NULL,
  `state_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `places`
--

LOCK TABLES `places` WRITE;
/*!40000 ALTER TABLE `places` DISABLE KEYS */;
INSERT INTO `places` VALUES ('40289d748c2b39f4018c2b3c41f70000','','',NULL,'About Mussorie',NULL,NULL,'Mussorie','Uttrakhand'),('40289d748c2b39f4018c2b3c99260001','','',NULL,'About Harshil',NULL,NULL,'Harshil','Uttrakhand'),('40289d748c2b39f4018c2b3cc1af0002','','',NULL,'About Rishikesh',NULL,NULL,'Rishikesh','Uttrakhand');
/*!40000 ALTER TABLE `places` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip_place`
--

DROP TABLE IF EXISTS `trip_place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip_place` (
  `trip_id` varchar(255) NOT NULL,
  `place_id` varchar(255) NOT NULL,
  PRIMARY KEY (`trip_id`,`place_id`),
  KEY `FKb462cxen8j60xnnkv0necb0h2` (`place_id`),
  CONSTRAINT `FK954igupc3q7hdsndan9oa0lm4` FOREIGN KEY (`trip_id`) REFERENCES `trips` (`id`),
  CONSTRAINT `FKb462cxen8j60xnnkv0necb0h2` FOREIGN KEY (`place_id`) REFERENCES `places` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_place`
--

LOCK TABLES `trip_place` WRITE;
/*!40000 ALTER TABLE `trip_place` DISABLE KEYS */;
INSERT INTO `trip_place` VALUES ('40289d748c25be13018c25c5427b0002','40289d748c2b39f4018c2b3c41f70000'),('40289d748c25be13018c25c5427b0002','40289d748c2b39f4018c2b3c99260001'),('40289d748c25be13018c25c5427b0002','40289d748c2b39f4018c2b3cc1af0002');
/*!40000 ALTER TABLE `trip_place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip_user`
--

DROP TABLE IF EXISTS `trip_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip_user` (
  `trip_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`trip_id`,`user_id`),
  KEY `FKagp96gd68brgg2clb8dtvf6rr` (`user_id`),
  CONSTRAINT `FKagp96gd68brgg2clb8dtvf6rr` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKbnvka9iwjv3vpdh1u2jl08k28` FOREIGN KEY (`trip_id`) REFERENCES `trips` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_user`
--

LOCK TABLES `trip_user` WRITE;
/*!40000 ALTER TABLE `trip_user` DISABLE KEYS */;
INSERT INTO `trip_user` VALUES ('40289d748c25be13018c25c5427b0002','40289d748c1fa4ef018c1fa575340000'),('40289d748c25be13018c25c5427b0002','40289d748c203d05018c203e42340000'),('40289d748c25be13018c25c5427b0002','40289d748c203d05018c203ee47b0001'),('40289d748c2634b5018c2670dbc00000','40289d748c203d05018c203ee47b0001'),('40289d748c25be13018c25c5427b0002','40289d748c2a6c8b018c2a74812e0000');
/*!40000 ALTER TABLE `trip_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trips`
--

DROP TABLE IF EXISTS `trips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trips` (
  `id` varchar(255) NOT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `date_created` datetime(6) DEFAULT NULL,
  `departure_time` time(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `essentials` varchar(255) DEFAULT NULL,
  `pickup_point` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trips`
--

LOCK TABLES `trips` WRITE;
/*!40000 ALTER TABLE `trips` DISABLE KEYS */;
INSERT INTO `trips` VALUES ('40289d748c25be13018c25c5427b0002','','',NULL,'08:00:00.000000','Can write description of total days of trips.','2023-12-10 05:30:00.000000','Explore Mountains','2023-12-04 05:30:00.000000','Sport shoes,Warm clothes,Rain Coat,Sleeping Bag','XYZ loccation'),('40289d748c2634b5018c2670dbc00000','','',NULL,'08:00:00.000000','Can write description of total days of trips.','2023-12-06 05:30:00.000000','River Rafting','2023-12-04 05:30:00.000000','Acc to your needs.','XYZ loccation'),('40289d748c2a6c8b018c2a81466a0003','','',NULL,'08:00:00.000000','Can write description of total days of trips.','2023-12-06 05:30:00.000000','ParaGliding','2023-12-04 05:30:00.000000','Acc to your needs.','XYZ loccation'),('40289d748c2a6c8b018c2a8fb3010004','','',NULL,'08:00:00.000000','Can write description of total days of trips.','2023-12-06 05:30:00.000000','ParaGliding','2023-12-04 05:30:00.000000','Adhar card,medical certificate.','XYZ loccation');
/*!40000 ALTER TABLE `trips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `age` int NOT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `date_created` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `mobile_no` decimal(38,0) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('40289d748c1fa4ef018c1fa575340000',32,'','',NULL,'mitchell.marsh@gmail.com','Male',6397893498,'Mitchell Marsh','GoPlaces'),('40289d748c203d05018c203e42340000',52,'','',NULL,'tony.stark@gmail.com','Male',9897158861,'Tony Stark','GoPlaces'),('40289d748c203d05018c203ee47b0001',28,'','',NULL,'tony.stark@gmail.com','Male',9897158255,'Ayush Bisht','GoPlaces12'),('40289d748c2a6c8b018c2a74812e0000',24,'','',NULL,'ankitnegi17@gmail.com','Male',6397895428,'Ankit Negi','GoPlaces123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'trips'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-04 12:18:42
