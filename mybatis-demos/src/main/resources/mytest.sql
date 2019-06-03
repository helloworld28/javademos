/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-06-03 14:33:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `country`
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryname` varchar(255) DEFAULT NULL,
  `countrycode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO country VALUES ('1', '中国', 'CN');
INSERT INTO country VALUES ('2', '美国', 'US');
INSERT INTO country VALUES ('3', '俄罗斯', 'RU');
INSERT INTO country VALUES ('4', '英国', 'GB');
INSERT INTO country VALUES ('5', '法国', 'FR');

-- ----------------------------
-- Table structure for `failure`
-- ----------------------------
DROP TABLE IF EXISTS `failure`;
CREATE TABLE `failure` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `robot_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '机器人名称',
  `discoverer` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '发现人',
  `error_time` timestamp NULL DEFAULT NULL COMMENT '报错时间',
  `discovery_time` timestamp NULL DEFAULT NULL COMMENT '发现时间',
  `current_location` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '当前位置',
  `failure_type` int(11) DEFAULT NULL COMMENT '故障类型',
  `remarks` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `failure_reason` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '故障原因',
  `processing_scheme` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '处理方案',
  `is_resolve` int(11) DEFAULT NULL COMMENT '是否解决',
  `handle_person` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '处理人',
  `handle_time` timestamp NULL DEFAULT NULL COMMENT '处理时间',
  `parts_change` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '[]' COMMENT '配件更换',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of failure
-- ----------------------------
INSERT INTO failure VALUES ('1', 'robot1', 'devin', '2017-10-13 16:22:33', null, '', '1', '', '', '', '2', 'sam', null, '');
INSERT INTO failure VALUES ('2', 'robo32', 'devin', '2017-10-10 09:10:10', null, '', '1', '', '', '', '2', 'sam', null, '');
INSERT INTO failure VALUES ('3', 'R11', '0004323217', '2017-10-13 19:50:00', '2017-10-13 19:50:02', '( 23 , 0 )', null, null, null, null, null, null, null, null);
INSERT INTO failure VALUES ('4', 'wqe3311qqq1111', '11', '2017-10-13 19:52:47', '2017-10-13 19:52:55', '( 4 , 4 )', null, null, null, null, null, null, null, null);
INSERT INTO failure VALUES ('5', 'R10', '11', '2017-10-13 19:53:17', '2017-10-13 19:53:20', '( 24 , 0 )', null, null, null, null, null, null, null, null);
INSERT INTO failure VALUES ('6', 'R11', '11', '2017-10-13 19:56:12', '2017-10-13 19:56:14', '( 23 , 0 )', null, null, null, null, null, null, null, null);
INSERT INTO failure VALUES ('7', 'R10', '11', '2017-10-16 10:31:32', '2017-10-16 10:32:57', '( 24 , 0 )', null, null, null, null, null, null, null, '[]');
INSERT INTO failure VALUES ('8', 'R10', '11', '2017-10-16 11:28:36', '2017-10-16 11:28:44', '( 24 , 0 )', null, null, null, null, null, null, null, '[]');
INSERT INTO failure VALUES ('9', 'robot4', 'devin', '2017-10-10 09:10:10', null, '', '1', '', '', '', '2', 'sam', null, '');
INSERT INTO failure VALUES ('10', 'robot4', 'devin', '2017-10-10 09:10:10', null, '', null, '', '', '', null, 'sam', null, '');
INSERT INTO failure VALUES ('11', 'robot4', 'devin', '2017-10-10 09:10:10', null, '', '1', '', '', '', '2', 'sam', null, '');
INSERT INTO failure VALUES ('12', 'R10', '333', '2017-10-10 09:10:10', '2017-10-16 14:03:26', '', '1', '', '', '', '2', 'sam', null, '');
INSERT INTO failure VALUES ('13', 'robot4', 'devin', '1970-10-10 09:10:10', null, '', null, '', '', '', null, 'sam', null, '');
INSERT INTO failure VALUES ('14', 'robot4', 'devin', '1970-01-01 09:10:10', null, '', null, '', '', '', null, 'sam', null, '');
INSERT INTO failure VALUES ('15', 'R10', 'EREWREW', '2001-01-01 08:00:00', '2017-10-16 14:06:57', '( 24 , 0 )', '1', '', '', '', '2', 'sam', null, '');
INSERT INTO failure VALUES ('16', 'R10', 'EREWREW', '2001-01-01 08:00:00', '2017-10-16 14:06:57', '( 24 , 0 )', '1', '', '', '', '2', '', null, '');
INSERT INTO failure VALUES ('17', 'R10', 'EREWREW', '2001-01-01 08:00:00', '2017-10-16 14:06:57', '( 24 , 0 )', null, '', '', '', '2', '', null, '');
INSERT INTO failure VALUES ('18', 'R10', '343434', '2017-10-16 14:11:11', '2017-10-16 14:13:02', '( 24 , 0 )', null, '', '', '', '2', '', null, '');
INSERT INTO failure VALUES ('19', 'R10', '???', '2017-10-16 14:11:11', '2017-10-16 14:13:38', '( 24 , 0 )', null, '', '', '', '2', '', null, '');
INSERT INTO failure VALUES ('20', 'R10', '3433434', '2017-10-16 14:11:11', '2017-10-16 14:14:05', '( 24 , 0 )', null, '', '', '', '2', '', null, '');
INSERT INTO failure VALUES ('21', 'R10', '333', '2017-10-16 14:11:11', '2017-10-16 15:37:24', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('22', 'R10', '233', '2017-10-16 14:11:11', '2017-10-16 15:38:25', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('23', 'R10', '3434', '2017-10-16 14:11:11', '2017-10-16 15:40:32', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('24', 'robot4', 'devin', '1970-01-01 09:10:10', null, '', null, '', '', '', null, 'sam', null, '');
INSERT INTO failure VALUES ('25', 'R10', '33', '2017-10-16 14:11:11', '2017-10-16 15:53:29', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('26', 'robot4', 'devin', '1970-01-01 09:10:10', null, '', null, '', '', '', null, 'sam', null, '');
INSERT INTO failure VALUES ('27', 'R10', '5656', '2017-10-16 14:11:11', '2017-10-16 15:55:42', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('28', 'R10', '343434', '2017-10-16 14:11:11', '2017-10-16 15:56:46', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('29', 'R10', '32423423', '2017-10-16 14:11:11', '2017-10-16 16:18:58', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('30', 'R10', '435345', '2017-10-16 14:11:11', '2017-10-16 16:21:07', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('31', 'R10', '325453', '2017-10-16 14:11:11', '2017-10-16 16:22:43', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('32', 'R10', '3252352345', '2017-10-16 14:11:11', '2017-10-16 16:24:42', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('33', 'R10', 'wrwerewr', '2017-10-16 14:11:11', '2017-10-16 16:26:35', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('34', 'R10', '324234', '2017-10-16 14:11:11', '2017-10-16 16:27:03', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('35', 'R10', '4w53454', '2017-10-16 14:11:11', '2017-10-16 16:31:18', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('36', 'R10', '435345', '2017-10-16 14:11:11', '2017-10-16 16:35:18', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('37', 'R10', '435345', '2017-10-16 14:11:11', '2017-10-16 16:35:22', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('38', 'R10', '23423432', '2017-10-16 14:11:11', '2017-10-16 16:36:11', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('39', 'R10', '35235432', '2017-10-16 14:11:11', '2017-10-16 16:36:53', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('40', 'R10', '324234', '2017-10-16 14:11:11', '2017-10-16 16:37:37', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('41', 'R10', '342', '2017-10-16 14:11:11', '2017-10-16 16:38:20', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('42', 'R10', '?????', '2017-10-16 14:11:11', '2017-10-16 16:40:00', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('43', 'R10', '24234', '2017-10-16 14:11:11', '2017-10-16 16:41:55', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('44', 'R10', '24234', '2017-10-16 14:11:11', '2017-10-16 16:43:11', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('45', 'R10', '324234', '2017-10-16 14:11:11', '2017-10-16 16:45:16', '( 24 , 0 )', '2', '', '', '', '2', '', '2017-10-17 16:43:08', '[{\"type\":3,\"oldItem\":\"11\",\"newItem\":\"22\"}]');
INSERT INTO failure VALUES ('46', 'R10', '2141414', '2017-10-16 14:11:11', '2017-10-16 17:00:44', '( 24 , 0 )', '2', '', '', '', '1', 'asdfasfd', null, '[{\"type\":4,\"oldItem\":\"1\",\"newItem\":\"1\"}]');
INSERT INTO failure VALUES ('47', 'R10', 'safasf', '2017-10-16 14:11:11', '2017-10-16 17:14:14', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('48', 'R10', '2343242', '2017-10-16 14:11:11', '2017-10-16 17:15:12', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('49', 'R10', 'ewrwer', '2017-10-16 14:11:11', '2017-10-16 17:16:26', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('50', 'R10', '324234', '2017-10-16 14:11:11', '2017-10-16 17:17:30', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('51', 'R10', 'wrwer', '2017-10-16 14:11:11', '2017-10-16 17:18:18', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('52', 'R10', '234324', '2017-10-16 14:11:11', '2017-10-16 17:24:15', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('53', 'R10', '21312313', '2017-10-16 14:11:11', '2017-10-16 17:24:28', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('54', 'R10', 'qeqwe', '2017-10-16 14:11:11', '2017-10-16 17:24:53', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('55', 'R10', '12312', '2017-10-16 14:11:11', '2017-10-16 17:25:59', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('56', 'R10', '111', '2017-10-16 14:11:11', '2017-10-16 17:27:35', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('57', 'R10', 'asdfasdf', '2017-10-16 14:11:11', '2017-10-16 17:32:23', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('58', 'R10', 'sadfasdf', '2017-10-16 14:11:11', '2017-10-16 17:33:46', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('59', 'R10', '232', '2017-10-16 14:11:11', '2017-10-16 17:41:15', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('60', 'R10', '11', '2017-10-16 14:11:11', '2017-10-16 17:41:42', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('61', 'R10', '1232', '2017-10-16 14:11:11', '2017-10-16 17:42:33', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('62', 'R10', '123123', '2017-10-16 14:11:11', '2017-10-16 17:44:10', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('63', 'R10', '1231', '2017-10-16 14:11:11', '2017-10-16 17:49:17', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('64', 'R10', '1111', '2017-10-16 14:11:11', '2017-10-16 17:50:35', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('65', 'R10', '?????', '2017-10-16 14:11:11', '2017-10-16 17:53:57', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('66', 'R10', '???????', '2017-10-16 14:11:11', '2017-10-16 17:54:11', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('67', 'R10', '????', '2017-10-16 14:11:11', '2017-10-16 17:54:34', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('68', 'R10', '11', '2017-10-16 14:11:11', '2017-10-16 17:55:36', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('69', 'R10', '222', '2017-10-16 14:11:11', '2017-10-16 18:01:12', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('70', 'R10', '333', '2017-10-16 14:11:11', '2017-10-16 18:02:00', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('71', 'R10', '222', '2017-10-16 14:11:11', '2017-10-16 18:02:38', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('72', 'R10', '333', '2017-10-16 14:11:11', '2017-10-16 18:03:13', '( 24 , 0 )', '3', '', '', '', '1', '12222', '2017-10-16 18:03:46', '[]');
INSERT INTO failure VALUES ('73', 'R10', '333', '2017-10-16 14:11:11', '2017-10-16 18:05:07', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('74', 'R10', '222', '2017-10-16 14:11:11', '2017-10-16 18:07:50', '( 24 , 0 )', '3', '', '', '', '1', '3333', '2017-10-17 16:22:12', '[{\"type\":2,\"oldItem\":\"22\",\"newItem\":\"33\"}]');
INSERT INTO failure VALUES ('75', 'R10', '222', '2017-10-16 14:11:11', '2017-10-16 18:09:50', '( 24 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('76', 'R10', '22', '2017-10-16 14:11:11', '2017-10-16 18:58:23', '( 24 , 0 )', '3', '', '', '', '1', '333', null, '[]');
INSERT INTO failure VALUES ('77', 'R10', '2222', '2017-10-16 14:11:11', '2017-10-17 16:32:42', '( 27 , 5 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('78', 'R10', '11', '2017-10-16 14:11:11', '2017-10-17 16:33:42', '( 27 , 5 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('79', 'R10', '222', '2017-10-16 14:11:11', '2017-10-17 16:34:53', '( 27 , 5 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('80', 'R10', '2222', '2017-10-16 14:11:11', '2017-10-17 16:35:07', '( 27 , 5 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('81', 'R10', '1111', '2017-10-16 14:11:11', '2017-10-17 16:36:39', '( 27 , 5 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('82', 'R11', '222', '2017-10-16 14:11:11', '2017-10-17 16:40:34', '( 22 , 10 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('83', 'R10', 'www', '2017-10-16 14:11:11', '2017-10-17 16:41:27', '( 27 , 5 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('84', 'R10', '3333', '2017-10-16 14:11:11', '2017-10-17 16:42:35', '( 27 , 5 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('85', 'R11', '222', '2017-10-16 14:11:11', '2017-10-17 16:42:57', '( 16 , 10 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('86', 'R11', '333', '2017-10-16 14:11:11', '2017-10-17 16:43:11', '( 12 , 9 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('87', 'R11', '45454', '2017-10-16 14:11:11', '2017-10-17 16:43:29', '( 15 , 10 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('88', 'R10', '34343', '2017-10-16 14:11:11', '2017-10-17 16:43:38', '( 27 , 5 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('89', 'R10', '1111', '2017-10-16 14:11:11', '2017-10-17 19:40:22', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('90', 'R10', '1111', '2017-10-16 14:11:11', '2017-10-17 19:40:30', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('91', 'R10', '1111', '2017-10-16 14:11:11', '2017-10-17 20:06:06', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('92', 'R10', '222', '2017-10-16 14:11:11', '2017-10-17 20:11:44', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('93', 'R10', '343434', '2017-10-16 14:11:11', '2017-10-17 20:38:13', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('94', 'R10', '222', '2017-10-16 14:11:11', '2017-10-17 20:40:29', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('95', 'R10', '3333', '2017-10-16 14:11:11', '2017-10-17 20:42:04', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('96', 'R10', '111', '2017-10-16 14:11:11', '2017-10-17 20:44:54', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('97', 'R11', '3333', '2017-10-16 14:11:11', '2017-10-17 20:44:59', '( 7 , 4 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('98', 'R10', '333', '2017-10-16 14:11:11', '2017-10-17 20:45:07', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('99', 'R10', '111', '2017-10-16 14:11:11', '2017-10-17 20:45:29', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('100', 'R10', '111', '2017-10-16 14:11:11', '2017-10-17 20:45:59', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('101', 'R10', '222', '2017-10-16 14:11:11', '2017-10-17 20:46:28', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('102', 'R10', '111', '2017-10-16 14:11:11', '2017-10-17 20:47:09', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('103', 'R10', '1111', '2017-10-16 14:11:11', '2017-10-17 20:48:26', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('104', 'R10', '111', '2017-10-16 14:11:11', '2017-10-17 20:51:35', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('105', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 09:48:38', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('106', 'R10', '22', '2017-10-16 14:11:11', '2017-10-18 09:55:27', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('107', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 09:55:55', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('108', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 09:57:10', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('109', 'R10', '11', '2017-10-16 14:11:11', '2017-10-18 09:57:49', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('110', 'R10', '11', '2017-10-16 14:11:11', '2017-10-18 09:58:33', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('111', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:00:46', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('112', 'R10', '1111', '2017-10-16 14:11:11', '2017-10-18 10:01:23', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('113', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:01:50', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('114', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:02:10', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('115', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:03:08', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('116', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:03:54', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('117', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:04:29', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('118', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:05:07', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('119', 'R10', '1111', '2017-10-16 14:11:11', '2017-10-18 10:06:55', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('120', 'R10', '11', '2017-10-16 14:11:11', '2017-10-18 10:14:13', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('121', 'R10', '11', '2017-10-16 14:11:11', '2017-10-18 10:16:02', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('122', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:16:38', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('123', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:16:36', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('124', 'R10', '11', '2017-10-16 14:11:11', '2017-10-18 10:16:49', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('125', 'R10', '11', '2017-10-16 14:11:11', '2017-10-18 10:18:03', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('126', 'R10', '11', '2017-10-16 14:11:11', '2017-10-18 10:18:22', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('127', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:20:19', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('128', 'R10', '11', '2017-10-16 14:11:11', '2017-10-18 10:23:14', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('129', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:34:35', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('130', 'R10', '11', '2017-10-16 14:11:11', '2017-10-18 10:35:00', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('131', 'R10', '222', '2017-10-16 14:11:11', '2017-10-18 10:38:26', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('132', 'R11', '222', '2017-10-16 14:11:11', '2017-10-18 10:38:39', '( 7 , 4 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('133', 'R10', '11', '2017-10-16 14:11:11', '2017-10-18 10:38:49', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('134', 'R11', '11', '2017-10-16 14:11:11', '2017-10-18 10:38:54', '( 7 , 4 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('135', 'R11', '11', '2017-10-16 14:11:11', '2017-10-18 10:38:57', '( 7 , 4 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('136', 'R11', '11', '2017-10-16 14:11:11', '2017-10-18 10:38:59', '( 7 , 4 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('137', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:39:43', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('138', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:40:12', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('139', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:40:36', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('140', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:41:21', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('141', 'R11', '111', '2017-10-16 14:11:11', '2017-10-18 10:41:30', '( 7 , 4 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('142', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:41:44', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('143', 'R10', '1111', '2017-10-16 14:11:11', '2017-10-18 10:42:14', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('144', 'R11', '1111', '2017-10-16 14:11:11', '2017-10-18 10:42:16', '( 7 , 4 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('145', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:44:19', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('146', 'R10', '1111', '2017-10-16 14:11:11', '2017-10-18 10:45:33', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('147', 'R10', '111', '2017-10-16 14:11:11', '2017-10-18 10:47:30', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('148', 'R11', '222', '2017-10-16 14:11:11', '2017-10-18 10:47:34', '( 7 , 4 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('149', 'R10', '11', '2017-10-16 14:11:11', '2017-10-18 10:48:11', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('150', 'R11', '111', '2017-10-16 14:11:11', '2017-10-18 10:51:50', '( 7 , 4 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('151', 'R20', '1111', '2017-10-18 11:13:49', '2017-10-18 11:13:49', '( 14 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('152', 'R08', '111', '2017-10-18 11:14:47', '2017-10-18 11:14:47', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('153', 'R08', '1111', '2017-10-18 11:15:14', '2017-10-18 11:15:14', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('154', 'R08', '1111', '2017-10-18 11:15:45', '2017-10-18 11:15:45', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('155', 'R08', '1111', '2017-10-18 11:16:11', '2017-10-18 11:16:11', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('156', 'R08', '1111', '2017-10-18 11:17:07', '2017-10-18 11:17:07', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('157', 'R08', '111', '2017-10-18 11:17:24', '2017-10-18 11:17:24', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('158', 'R08', '111', '2017-10-18 11:20:20', '2017-10-18 11:20:20', '( 26 , 0 )', '2', '', '', '', '1', '111', null, '[]');
INSERT INTO failure VALUES ('159', 'R10', '111', '2017-10-18 11:35:43', '2017-10-18 11:35:43', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('160', 'R11', '3333', '2017-10-18 11:35:52', '2017-10-18 11:35:52', '( 7 , 4 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('161', 'R10', '11', '2017-10-18 11:36:09', '2017-10-18 11:36:09', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('162', 'R10', '111', '2017-10-18 11:39:57', '2017-10-18 11:39:57', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('163', 'R11', '222', '2017-10-18 11:40:02', '2017-10-18 11:40:02', '( 7 , 4 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('164', 'R11', '111', '2017-10-18 11:45:02', '2017-10-18 11:45:02', '( 7 , 4 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('165', 'R10', '222', '2017-10-18 11:45:08', '2017-10-18 11:45:08', '( 12 , 7 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('166', 'R08', '1111', '2017-10-18 15:28:50', '2017-10-18 15:28:50', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('167', 'R06', '111', '2017-10-18 18:27:16', '2017-10-18 18:27:16', '( 28 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('168', 'R08', '1111', '2017-09-11 12:12:12', '2017-10-18 18:30:22', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('169', 'R20', '0004323217', '2017-09-11 12:12:12', '2017-10-18 18:37:54', '( 14 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('170', 'R08', '111', '2017-09-11 12:12:12', '2017-10-18 18:57:07', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('171', 'R08', '', '2017-10-19 11:05:27', '2017-10-19 11:05:27', '( 26 , 0 )', '0', '111', '', '', '1', '111', '2017-10-19 11:05:45', '[]');
INSERT INTO failure VALUES ('172', 'R20', '3424234', '2017-10-19 11:05:49', '2017-10-19 11:05:49', '( 14 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('173', 'R11', '122', '2017-10-19 11:06:02', '2017-10-19 11:06:02', '( 23 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('174', 'R09', '33', '2017-10-19 11:06:06', '2017-10-19 11:06:06', '( 25 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('175', 'R08', '', '2017-10-19 11:07:09', '2017-10-19 11:07:09', '( 26 , 0 )', '6', '', '', '', '2', '', '2017-10-19 11:07:21', '[]');
INSERT INTO failure VALUES ('176', 'R08', '111', '2017-10-19 11:08:51', '2017-10-19 11:08:51', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('177', 'R08', '', '2017-10-19 11:09:16', '2017-10-19 11:09:16', '( 26 , 0 )', '0', '111', '', '', '1', '222', '2017-10-19 11:09:31', '[]');
INSERT INTO failure VALUES ('178', 'R20', '1111', '2017-10-21 10:54:52', '2017-10-21 10:54:52', '( 14 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('179', 'R09', '222', '2017-10-21 10:54:55', '2017-10-21 10:54:55', '( 25 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('180', 'R11', '333', '2017-10-21 10:54:58', '2017-10-21 10:54:58', '( 23 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('181', 'R08', '444', '2017-10-21 10:55:02', '2017-10-21 10:55:02', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('182', '??', '', '2017-10-21 13:19:23', '2017-10-21 13:19:23', '( 26 , 0 )', '2', '', '??????', '222', '1', '????', '2017-10-21 13:19:44', '[{\"type\":2,\"oldItem\":\"1\",\"newItem\":\"1\"}]');
INSERT INTO failure VALUES ('183', '??', '', '2017-10-21 13:21:26', '2017-10-21 13:21:26', '( 26 , 0 )', '3', '', '22', '33', '1', '333', '2017-10-21 13:21:39', '[{\"type\":2,\"oldItem\":\"1\",\"newItem\":\"1\"}]');
INSERT INTO failure VALUES ('184', '??', '1111', '2017-10-21 13:30:57', '2017-10-21 13:30:57', '( 25 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('185', '??', '', '2017-10-21 13:32:09', '2017-10-21 13:32:09', '( 26 , 0 )', '2', '', '33', '44', '1', 'asdfasfd', '2017-10-21 13:32:16', '[]');
INSERT INTO failure VALUES ('186', '??', '', '2017-10-21 13:32:53', '2017-10-21 13:32:53', '( 25 , 0 )', '2', '', '444', '55', '1', 'asfasfd', '2017-10-21 13:32:58', '[]');
INSERT INTO failure VALUES ('187', '??', '111', '2017-10-21 13:42:02', '2017-10-21 13:42:02', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('188', '??', '111', '2017-10-21 13:56:42', '2017-10-21 13:56:42', '( 26 , 0 )', null, '', '', '', '2', '', null, '[]');
INSERT INTO failure VALUES ('189', '??', '', '2017-10-21 14:13:10', '2017-10-21 14:13:10', '( 25 , 0 )', '3', '', '33', '22', '1', '222', '2017-10-21 14:13:20', '[]');

-- ----------------------------
-- Table structure for `sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(64) NOT NULL COMMENT '类别',
  `name` varchar(64) NOT NULL COMMENT '字典名',
  `value` varchar(64) NOT NULL COMMENT '字典值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO sys_dict VALUES ('1', '性别', '男', '男');
INSERT INTO sys_dict VALUES ('2', '性别', '女', '女');
INSERT INTO sys_dict VALUES ('3', '季度', '第一季度', '1');
INSERT INTO sys_dict VALUES ('4', '季度', '第二季度', '2');
INSERT INTO sys_dict VALUES ('5', '季度', '第三季度', '3');
INSERT INTO sys_dict VALUES ('6', '季度', '第四季度', '4');

-- ----------------------------
-- Table structure for `sys_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `privilege_name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `privilege_url` varchar(200) DEFAULT NULL COMMENT '权限URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO sys_privilege VALUES ('1', '用户管理', '/users');
INSERT INTO sys_privilege VALUES ('2', '角色管理', '/roles');
INSERT INTO sys_privilege VALUES ('3', '系统日志', '/logs');
INSERT INTO sys_privilege VALUES ('4', '人员维护', '/persons');
INSERT INTO sys_privilege VALUES ('5', '单位维护', '/companies');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `enabled` int(11) DEFAULT NULL COMMENT '有效标志',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO sys_role VALUES ('1', '管理员', '1', '1', '2016-04-01 17:02:14');
INSERT INTO sys_role VALUES ('2', '普通用户', '1', '1', '2016-04-01 17:02:34');

-- ----------------------------
-- Table structure for `sys_role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege`;
CREATE TABLE `sys_role_privilege` (
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `privilege_id` bigint(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------
INSERT INTO sys_role_privilege VALUES ('1', '1');
INSERT INTO sys_role_privilege VALUES ('1', '3');
INSERT INTO sys_role_privilege VALUES ('1', '2');
INSERT INTO sys_role_privilege VALUES ('2', '4');
INSERT INTO sys_role_privilege VALUES ('2', '5');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) DEFAULT NULL COMMENT '密码',
  `user_email` varchar(50) DEFAULT 'test@mybatis.tk' COMMENT '邮箱',
  `user_info` text COMMENT '简介',
  `head_img` blob COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1036 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO sys_user VALUES ('1', 'admin', '123456', 'admin@mybatis.tk', '管理员用户', 0x1231231230, '2016-06-07 01:11:12');
INSERT INTO sys_user VALUES ('1001', 'test', '123456', 'test@mybatis.tk', '测试用户', 0x1231231230, '2016-06-07 00:00:00');
INSERT INTO sys_user VALUES ('1035', 'test1', '123456', 'test@mybatis.tk', 'test info', 0x010203, '2019-03-15 15:06:19');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO sys_user_role VALUES ('1', '1');
INSERT INTO sys_user_role VALUES ('1', '2');
INSERT INTO sys_user_role VALUES ('1001', '2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `register_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('2', '张三', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-2', '1', '2019-03-13 16:36:19');
INSERT INTO user VALUES ('3', '李四', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-3', '1', '2019-03-13 16:36:25');
INSERT INTO user VALUES ('4', '4@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-4', '1', '2017-06-23 14:24:23');
INSERT INTO user VALUES ('5', '5@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-5', '1', '2017-06-23 14:24:23');
INSERT INTO user VALUES ('6', '6@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-6', '1', '2017-06-23 14:24:23');
INSERT INTO user VALUES ('7', '7@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-7', '1', '2017-06-23 14:24:23');
INSERT INTO user VALUES ('8', '8@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-8', '1', '2017-06-23 14:24:23');
INSERT INTO user VALUES ('9', '9@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-9', '1', '2017-06-23 14:24:23');
INSERT INTO user VALUES ('10', '10@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-10', '1', '2017-06-23 14:24:23');
INSERT INTO user VALUES ('11', '89921218@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆', '1', '2018-01-04 17:30:42');

-- ----------------------------
-- Table structure for `user info`
-- ----------------------------
DROP TABLE IF EXISTS `user info`;
CREATE TABLE `user info` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user info
-- ----------------------------
