-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_lottery_list`
--

DROP TABLE IF EXISTS `t_lottery_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lottery_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lottery_id` varchar(10) NOT NULL COMMENT '彩票ID',
  `lottery_type_id` varchar(8) NOT NULL COMMENT ' 彩票类型，1:福利彩票 2:体育彩票',
  `lottery_name` varchar(20) NOT NULL COMMENT '彩票名称',
  `datetime` datetime NOT NULL,
  `remarks` varchar(45) DEFAULT NULL COMMENT ' 描述信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_lottery_list`
--

LOCK TABLES `t_lottery_list` WRITE;
/*!40000 ALTER TABLE `t_lottery_list` DISABLE KEYS */;
INSERT INTO `t_lottery_list` VALUES (1,'ssq','1','双色球','2018-04-10 17:27:38','每周二、四、日开奖'),(2,'dlt','2','超级大乐透','2018-04-10 17:27:39','每周一、三、六开奖'),(3,'qlc','1','七乐彩','2018-04-10 17:27:39','每周一、三、五开奖'),(4,'fcsd','1','福彩3D','2018-04-10 17:27:39','每日开奖'),(5,'qxc','2','七星彩','2018-04-10 17:27:39','每周二、五、日开奖'),(6,'pls','2','排列3','2018-04-10 17:27:39','每日开奖'),(7,'plw','2','排列5','2018-04-10 17:27:39','每日开奖');
/*!40000 ALTER TABLE `t_lottery_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-10 17:38:57
