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

##--t_lottery_result_ssq(彩票开奖-双色球)
DROP TABLE IF EXISTS `t_lottery_result_ssq`;
create table `t_lottery_result_ssq`(
	`id` int not null AUTO_INCREMENT,
	`lottery_no`varchar(10) not null comment '开奖期号',
	`lottery_red`varchar(20) not null comment '开奖结果-红球',
	`lottery_blue`varchar(2) not null comment '开奖结果-篮球',
	`lottery_date`varchar(12) not null comment '开奖日期',
	`lottery_exdate`varchar(12) not null comment '兑奖截止日期',
	`lottery_sale_amount`varchar(20)  comment '本期销售额(投注总额)',
	`lottery_pool_amount`varchar(20)  comment '奖池滚存',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='彩票开奖-双色球';


#--t_lottery_result_ssq_prize(彩票开奖-双色球-详情)
DROP TABLE IF EXISTS `t_lottery_result_ssq_prize`;
create table `t_lottery_result_ssq_prize`(
	`id` int not null AUTO_INCREMENT,
	`lottery_no`varchar(10)  comment '开奖期号',
	`prize_name`varchar(15)  comment '奖项名称',
	`prize_num`varchar(24)  comment '中奖数量',
	`prize_amount`varchar(24)  comment '中奖金额',
	`prize_require`varchar(24)  comment '中奖条件',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='彩票开奖-双色球-详情';


#--t_lottery_result_dlt(彩票开奖-超级大乐透)
DROP TABLE IF EXISTS `t_lottery_result_dlt`;
create table t_lottery_result_dlt(
	`id` int not null AUTO_INCREMENT,
	`lottery_no`varchar(10) not null comment '开奖期号',
	`lottery_red`varchar(16) not null comment '开奖结果-红球',
	`lottery_blue`varchar(5) not null comment '开奖结果-篮球',
	`lottery_date`varchar(12) not null comment '开奖日期',
	`lottery_exdate`varchar(12) not null comment '兑奖截止日期',
	`lottery_sale_amount`varchar(20)  comment '本期销售额(投注总额)',
	`lottery_pool_amount`varchar(20)  comment '奖池滚存',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='彩票开奖-超级大乐透';


#--t_lottery_result_dlt_prize(彩票开奖-大乐透球-详情)	
DROP TABLE IF EXISTS `t_lottery_result_dlt_prize`;
create table `t_lottery_result_dlt_prize`(
	`id` int not null AUTO_INCREMENT,
	`lottery_no`varchar(10)  comment '开奖期号',
	`prize_name` varchar(15)  comment '奖项名称',
	`prize_num`varchar(24)  comment '中奖数量',
	`prize_amount`varchar(24)  comment '中奖金额',
	`prize_require`varchar(24)  comment '中奖条件',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='彩票开奖-大乐透球-详情';

#--t_lottery_result_qxc(彩票开奖-七星彩)
DROP TABLE IF EXISTS `t_lottery_result_qxc`;
create table `t_lottery_result_qxc`(
	`id` int not null AUTO_INCREMENT,
	`lottery_no`varchar(10) not null comment '开奖期号',
	`lottery_red`varchar(16) not null comment '开奖结果-红球',
	`lottery_date`varchar(12) not null comment '开奖日期',
	`lottery_exdate`varchar(12) not null comment '兑奖截止日期',
	`lottery_sale_amount`varchar(20)  comment '本期销售额(投注总额)',
	`lottery_pool_amount`varchar(20)  comment '奖池滚存',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='彩票开奖-七星彩';


#--t_lottery_result_qxc_prize(彩票开奖-七星彩-详情)	
DROP TABLE IF EXISTS `t_lottery_result_qxc_prize`;
create table `t_lottery_result_qxc_prize`(
	`id` int not null AUTO_INCREMENT,
	`lottery_no`varchar(10)  comment '开奖期号',
	`prize_name`varchar(15)  comment '奖项名称',
	`prize_num`varchar(24)  comment '中奖数量',
	`prize_amount`varchar(24)  comment '中奖金额',
	`prize_require`varchar(24)  comment '中奖条件',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='彩票开奖-七星彩-详情';


#--t_lottery_result_qcl(彩票开奖-七彩乐)
DROP TABLE IF EXISTS `t_lottery_result_qcl`;
create table `t_lottery_result_qcl`(
	`id` int not null AUTO_INCREMENT,
	`lottery_no`varchar(10) not null comment '开奖期号',
	`lottery_red`varchar(16) not null comment '开奖结果-红球',
	`lottery_blue`varchar(2) not null comment '开奖结果-篮球',
	`lottery_date`varchar(12) not null comment '开奖日期',
	`lottery_exdate`varchar(12) not null comment '兑奖截止日期',
	`lottery_sale_amount`varchar(20)  comment '本期销售额(投注总额)',
	`lottery_pool_amount`varchar(20)  comment '奖池滚存',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='彩票开奖-七彩乐';


#--t_lottery_result_qcl_prize(彩票开奖-七彩乐-详情)
DROP TABLE IF EXISTS `t_lottery_result_qcl_prize`;
create table `t_lottery_result_qcl_prize`(
	`id` int not null AUTO_INCREMENT,
	`lottery_no`varchar(10)  comment '开奖期号',
	`prize_name`varchar(15)  comment '奖项名称',
	`prize_num`varchar(24)  comment '中奖数量',
	`prize_amount`varchar(24)  comment '中奖金额',
	`prize_require`varchar(24)  comment '中奖条件',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='彩票开奖-七彩乐-详情';



#--t_lottery_result_fcsd(彩票开奖-福彩3D)
DROP TABLE IF EXISTS `t_lottery_result_fcsd`;
create table `t_lottery_result_fcsd`(
	`id` int not null AUTO_INCREMENT,
	`lottery_no`varchar(10) not null comment '开奖期号',
	`lottery_red`varchar(16) not null comment '开奖结果-红球',
	`lottery_date`varchar(12) not null comment '开奖日期',
	`lottery_exdate`varchar(12) not null comment '兑奖截止日期',
	`lottery_sale_amount`varchar(20)  comment '本期销售额(投注总额)',
	`lottery_pool_amount`varchar(20)  comment '奖池滚存',
	`z3_prize_num` int  comment '直选3-中奖注数,每注金额1040' DEFAULT 0,
	`g3_prize_num` int   comment '组选3-中奖注数,每注金额346' DEFAULT 0,
	`g6_prize_num` int   comment '组选6-中奖注数,每注金额173' DEFAULT 0,
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='彩票开奖-福彩3D';


#--t_lottery_result_pls(彩票开奖-排列三)
DROP TABLE IF EXISTS `t_lottery_result_pls`;
create table `t_lottery_result_pls`(
	`id` int not null AUTO_INCREMENT,
	`lottery_no`varchar(10) not null comment '开奖期号',
	`lottery_red`varchar(16) not null comment '开奖结果-红球',
	`lottery_date`varchar(12) not null comment '开奖日期',
	`lottery_exdate`varchar(12) not null comment '兑奖截止日期',
	`lottery_sale_amount`varchar(20)  comment '本期销售额(投注总额)',
	`lottery_pool_amount`varchar(20)  comment '奖池滚存',
	`z3_prize_num` int  comment '直选3-中奖注数,每注金额1040' DEFAULT 0,
	`g3_prize_num` int   comment '组选3-中奖注数,每注金额346' DEFAULT 0,
	`g6_prize_num` int   comment '组选6-中奖注数,每注金额173' DEFAULT 0,
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='彩票开奖-排列三';


#--t_lottery_result_plw(彩票开奖-排列五)
DROP TABLE IF EXISTS `t_lottery_result_plw`;
create table `t_lottery_result_plw`(
	`id` int not null AUTO_INCREMENT,
	`lottery_no`varchar(10) not null comment '开奖期号',
	`lottery_red`varchar(16) not null comment '开奖结果-红球',
	`lottery_date`varchar(12) not null comment '开奖日期',
	`lottery_exdate`varchar(12) not null comment '兑奖截止日期',
	`lottery_sale_amount`varchar(20)  comment '本期销售额(投注总额)',
	`lottery_pool_amount`varchar(20)  comment '奖池滚存',
	`prize_num` int  comment '直选-中奖注数,每注金额100000.00' DEFAULT 0,
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment='彩票开奖-排列三';
