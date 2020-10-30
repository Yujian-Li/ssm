/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : sportsjobs

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-10-30 15:32:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `applicantinfo`
-- ----------------------------
DROP TABLE IF EXISTS `applicantinfo`;
CREATE TABLE `applicantinfo` (
  `applicantId` int(11) NOT NULL,
  `applicantName` varchar(32) CHARACTER SET utf8 NOT NULL,
  `applicantAccount` varchar(45) CHARACTER SET utf8 NOT NULL,
  `applicantPwd` varchar(45) CHARACTER SET utf8 NOT NULL,
  `applicantGender` enum('男','女') CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`applicantId`),
  UNIQUE KEY `applicantId_UNIQUE` (`applicantId`),
  UNIQUE KEY `applicantAccount_UNIQUE` (`applicantAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of applicantinfo
-- ----------------------------
INSERT INTO `applicantinfo` VALUES ('1', 'Li', 'xiaoli@tbbt.com', 'xiaoli', '男');
INSERT INTO `applicantinfo` VALUES ('2', 'Lily', 'zhongli@tbbt.com', 'zhongli', '男');
INSERT INTO `applicantinfo` VALUES ('3', 'Linda', 'dali@tbbt.com', 'dali', '女');
INSERT INTO `applicantinfo` VALUES ('4', 'Goofy', 'gaofei@tbbt.com', 'gaofei', '男');
INSERT INTO `applicantinfo` VALUES ('5', 'MiToo', 'mitu@tbbt.com', 'mitu', '女');
INSERT INTO `applicantinfo` VALUES ('6', 'Miao', 'miao@tbbt.com', 'miao', '男');
INSERT INTO `applicantinfo` VALUES ('7', 'Whale', 'jingyu@tbbt.com', 'jingyu', '男');

-- ----------------------------
-- Table structure for `applicantskills`
-- ----------------------------
DROP TABLE IF EXISTS `applicantskills`;
CREATE TABLE `applicantskills` (
  `applicantId` int(11) NOT NULL,
  `skillId` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`applicantId`,`skillId`),
  KEY `skillId_idx` (`skillId`),
  CONSTRAINT `applicantId` FOREIGN KEY (`applicantId`) REFERENCES `applicantinfo` (`applicantId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `skillId` FOREIGN KEY (`skillId`) REFERENCES `skills` (`skillId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of applicantskills
-- ----------------------------
INSERT INTO `applicantskills` VALUES ('2', 'AGENT001');
INSERT INTO `applicantskills` VALUES ('1', 'COMM001');
INSERT INTO `applicantskills` VALUES ('4', 'COMM001');
INSERT INTO `applicantskills` VALUES ('1', 'COMM002');
INSERT INTO `applicantskills` VALUES ('1', 'EVENT001');
INSERT INTO `applicantskills` VALUES ('5', 'EVENT001');
INSERT INTO `applicantskills` VALUES ('1', 'EVENT002');
INSERT INTO `applicantskills` VALUES ('5', 'EVENT002');
INSERT INTO `applicantskills` VALUES ('6', 'EVENT002');
INSERT INTO `applicantskills` VALUES ('6', 'EVENT003');
INSERT INTO `applicantskills` VALUES ('2', 'STATD001');
INSERT INTO `applicantskills` VALUES ('3', 'STATD002');

-- ----------------------------
-- Table structure for `applications`
-- ----------------------------
DROP TABLE IF EXISTS `applications`;
CREATE TABLE `applications` (
  `applicantId` int(11) NOT NULL,
  `jobId` int(11) NOT NULL,
  PRIMARY KEY (`applicantId`,`jobId`),
  KEY `jobId_idx` (`jobId`),
  CONSTRAINT `key1` FOREIGN KEY (`applicantId`) REFERENCES `applicantinfo` (`applicantId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `key2` FOREIGN KEY (`jobId`) REFERENCES `jobs` (`jobId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of applications
-- ----------------------------
INSERT INTO `applications` VALUES ('1', '10001');
INSERT INTO `applications` VALUES ('4', '10001');
INSERT INTO `applications` VALUES ('2', '10002');
INSERT INTO `applications` VALUES ('3', '10002');
INSERT INTO `applications` VALUES ('4', '10002');
INSERT INTO `applications` VALUES ('3', '10003');
INSERT INTO `applications` VALUES ('1', '10005');
INSERT INTO `applications` VALUES ('4', '10005');

-- ----------------------------
-- Table structure for `base_dict`
-- ----------------------------
DROP TABLE IF EXISTS `base_dict`;
CREATE TABLE `base_dict` (
  `dict_id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `dict_type_code` varchar(45) CHARACTER SET utf8 NOT NULL,
  `dict_type_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `dict_item_name` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of base_dict
-- ----------------------------
INSERT INTO `base_dict` VALUES ('0011', '001', '类别', 'Event');
INSERT INTO `base_dict` VALUES ('0012', '001', '类别', 'Stadium');
INSERT INTO `base_dict` VALUES ('0013', '001', '类别', 'Marketing');
INSERT INTO `base_dict` VALUES ('0014', '001', '类别', 'Agent');
INSERT INTO `base_dict` VALUES ('0015', '001', '类别', 'Coach');
INSERT INTO `base_dict` VALUES ('0016', '001', '类别', 'Other');
INSERT INTO `base_dict` VALUES ('0017', '001', '类别', 'Media');
INSERT INTO `base_dict` VALUES ('0021', '002', '地点', 'Shanghai');
INSERT INTO `base_dict` VALUES ('0022', '002', '地点', 'Beijing');
INSERT INTO `base_dict` VALUES ('0023', '002', '地点', 'Guangzhou');
INSERT INTO `base_dict` VALUES ('0024', '002', '地点', 'Shenzhen');
INSERT INTO `base_dict` VALUES ('0025', '002', '地点', 'Other');
INSERT INTO `base_dict` VALUES ('0031', '003', '薪资', '5000-6000');
INSERT INTO `base_dict` VALUES ('0032', '003', '薪资', '6000-7000');
INSERT INTO `base_dict` VALUES ('0033', '003', '薪资', '7000-10000');
INSERT INTO `base_dict` VALUES ('0034', '003', '薪资', 'Over 10000');

-- ----------------------------
-- Table structure for `enterpriseinfo`
-- ----------------------------
DROP TABLE IF EXISTS `enterpriseinfo`;
CREATE TABLE `enterpriseinfo` (
  `enterpriseId` int(11) NOT NULL,
  `enterpriseName` varchar(45) CHARACTER SET utf8 NOT NULL,
  `enterpriseSpec` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `enterpriseAccount` varchar(45) CHARACTER SET utf8 NOT NULL,
  `enterprisePwd` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`enterpriseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of enterpriseinfo
-- ----------------------------
INSERT INTO `enterpriseinfo` VALUES ('901', 'Square Sports', 'Chance to work in a square office', 'zhengfang', 'zhengfang');
INSERT INTO `enterpriseinfo` VALUES ('902', 'Aid Sports', 'Lorem ipsum dolor sit amet, consectetur', 'yuanzhu', 'yuanzhu');
INSERT INTO `enterpriseinfo` VALUES ('903', 'RecTangular Sports', 'Lorem ipsum dolor sit amet, consectetur', 'changfang', 'changfang');
INSERT INTO `enterpriseinfo` VALUES ('904', 'Ball Sports', 'Earth is a ball...', 'qiu', 'qiu');
INSERT INTO `enterpriseinfo` VALUES ('905', 'Sky Sports', '是sky sky.不是skr skr', 'tian', 'tian');
INSERT INTO `enterpriseinfo` VALUES ('906', 'AHH Sports', 'AHHHHHH', 'AHH', 'ahh');

-- ----------------------------
-- Table structure for `jobs`
-- ----------------------------
DROP TABLE IF EXISTS `jobs`;
CREATE TABLE `jobs` (
  `jobId` int(11) NOT NULL,
  `enterpriseId` int(11) NOT NULL,
  `jobSpec` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `contact` varchar(45) CHARACTER SET utf8 NOT NULL,
  `monthlySalaryId` varchar(45) CHARACTER SET utf8 NOT NULL,
  `jobTypeId` varchar(45) CHARACTER SET utf8 NOT NULL,
  `locationId` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`jobId`),
  KEY `enterpriseId_idx` (`enterpriseId`),
  KEY `jobTypeId_idx` (`jobTypeId`),
  KEY `monthlySalaryId_idx` (`monthlySalaryId`),
  KEY `locationId_idx` (`locationId`),
  CONSTRAINT `enterpriseId` FOREIGN KEY (`enterpriseId`) REFERENCES `enterpriseinfo` (`enterpriseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `jobTypeId` FOREIGN KEY (`jobTypeId`) REFERENCES `base_dict` (`dict_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `locationId` FOREIGN KEY (`locationId`) REFERENCES `base_dict` (`dict_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `monthlySalaryId` FOREIGN KEY (`monthlySalaryId`) REFERENCES `base_dict` (`dict_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of jobs
-- ----------------------------
INSERT INTO `jobs` VALUES ('10001', '901', 'Sports Event Manager, 3-5 years experience required', '9559555', '0034', '0011', '0021');
INSERT INTO `jobs` VALUES ('10002', '902', 'Stadium Operation Assistant. Familar with MS Office.', '123456', '0031', '0012', '0022');
INSERT INTO `jobs` VALUES ('10003', '903', 'Sales', '23232323', '0032', '0013', '0023');
INSERT INTO `jobs` VALUES ('10005', '901', 'Football Coach', '565656', '0031', '0015', '0021');
INSERT INTO `jobs` VALUES ('10007', '901', 'Football Media Content', 'zqnryy@163.com', '0031', '0017', '0023');
INSERT INTO `jobs` VALUES ('10008', '902', 'Journalist for Sports', '9876567', '0032', '0017', '0022');
INSERT INTO `jobs` VALUES ('10009', '903', 'Stadium Design and Operation', '5466474(⊙﹏⊙)', '0033', '0012', '0021');
INSERT INTO `jobs` VALUES ('10010', '902', 'Tennis Coach', '3423536', '0033', '0015', '0025');
INSERT INTO `jobs` VALUES ('10011', '905', 'Weibo Operation', '9876578', '0031', '0017', '0025');
INSERT INTO `jobs` VALUES ('10012', '904', 'Event Operation Assistant', 'sxzx@zhuli', '0032', '0011', '0021');

-- ----------------------------
-- Table structure for `skills`
-- ----------------------------
DROP TABLE IF EXISTS `skills`;
CREATE TABLE `skills` (
  `skillId` varchar(10) CHARACTER SET utf8 NOT NULL,
  `skillSpec` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`skillId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of skills
-- ----------------------------
INSERT INTO `skills` VALUES ('AGENT001', 'Agent Certificate');
INSERT INTO `skills` VALUES ('AGENT002', 'Work experience as an agent');
INSERT INTO `skills` VALUES ('COMM001', 'Marketing Negotiation');
INSERT INTO `skills` VALUES ('COMM002', 'Marketing Plan Writing');
INSERT INTO `skills` VALUES ('EVENT001', 'Event Plan Writing');
INSERT INTO `skills` VALUES ('EVENT002', 'Indoor Event Operation');
INSERT INTO `skills` VALUES ('EVENT003', 'Outdoor Event Operation');
INSERT INTO `skills` VALUES ('GENE001', 'MS Office');
INSERT INTO `skills` VALUES ('GENE002', 'Photoshop');
INSERT INTO `skills` VALUES ('GENE003', 'CET-6');
INSERT INTO `skills` VALUES ('STATD001', 'Stadium Operation');
INSERT INTO `skills` VALUES ('STATD002', 'Work experience at reception');
