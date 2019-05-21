/*
Navicat MySQL Data Transfer

Source Server         : sms
Source Server Version : 50725
Source Host           : 134.175.100.63:3306
Source Database       : sms

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-17 15:22:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for kfc_order
-- ----------------------------
DROP TABLE IF EXISTS `kfc_order`;
CREATE TABLE `kfc_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_time` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_user_id` (`user_id`),
  CONSTRAINT `fk_order_user_id` FOREIGN KEY (`user_id`) REFERENCES `kfc_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kfc_order
-- ----------------------------
INSERT INTO `kfc_order` VALUES ('1', '2019', '未支付', '1');
INSERT INTO `kfc_order` VALUES ('2', '2019', '已支付', '3');
INSERT INTO `kfc_order` VALUES ('3', '2019', '未支付', '2');

-- ----------------------------
-- Table structure for kfc_orderline
-- ----------------------------
DROP TABLE IF EXISTS `kfc_orderline`;
CREATE TABLE `kfc_orderline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ol_pro_id` (`product_id`),
  KEY `fk_ol_or_id` (`order_id`),
  CONSTRAINT `fk_ol_or_id` FOREIGN KEY (`order_id`) REFERENCES `kfc_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ol_pro_id` FOREIGN KEY (`product_id`) REFERENCES `kfc_product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kfc_orderline
-- ----------------------------
INSERT INTO `kfc_orderline` VALUES ('1', '2', '1', '3');
INSERT INTO `kfc_orderline` VALUES ('2', '1', '3', '1');

-- ----------------------------
-- Table structure for kfc_product
-- ----------------------------
DROP TABLE IF EXISTS `kfc_product`;
CREATE TABLE `kfc_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` decimal(30,0) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `xiaoliang` bigint(255) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ca_pro_id` (`category_id`),
  CONSTRAINT `fk_ca_pro_id` FOREIGN KEY (`category_id`) REFERENCES `kfc_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kfc_product
-- ----------------------------
INSERT INTO `kfc_product` VALUES ('1', '辣子鸡', '非常好吃的炸鸡', '26', null, '有余', '1500', '4');
INSERT INTO `kfc_product` VALUES ('2', '炸鸡翅', '酥软的炸鸡翅', '26', '', '有余', '1500', '4');
INSERT INTO `kfc_product` VALUES ('3', '馒头', '又白又大', '24', null, '有余', '3000', '5');

-- ----------------------------
-- Table structure for kfc_role
-- ----------------------------
DROP TABLE IF EXISTS `kfc_role`;
CREATE TABLE `kfc_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kfc_role
-- ----------------------------
INSERT INTO `kfc_role` VALUES ('1', '用户');
INSERT INTO `kfc_role` VALUES ('2', '管理员');
INSERT INTO `kfc_role` VALUES ('3', 'boss');
INSERT INTO `kfc_role` VALUES ('4', '服务员');

-- ----------------------------
-- Table structure for kfc_user
-- ----------------------------
DROP TABLE IF EXISTS `kfc_user`;
CREATE TABLE `kfc_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kfc_user
-- ----------------------------
INSERT INTO `kfc_user` VALUES ('1', '张一', '110', '123456', null);
INSERT INTO `kfc_user` VALUES ('2', '张二', '150', '123456', '');
INSERT INTO `kfc_user` VALUES ('3', '张三', '120', '123456', '');

-- ----------------------------
-- Table structure for kfc_user_role
-- ----------------------------
DROP TABLE IF EXISTS `kfc_user_role`;
CREATE TABLE `kfc_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kfc_role_id` (`role_id`),
  KEY `fk_kfc_user_id` (`user_id`),
  CONSTRAINT `fk_kfc_role_id` FOREIGN KEY (`role_id`) REFERENCES `kfc_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_kfc_user_id` FOREIGN KEY (`user_id`) REFERENCES `kfc_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kfc_user_role
-- ----------------------------
INSERT INTO `kfc_user_role` VALUES ('1', '1', '1');
INSERT INTO `kfc_user_role` VALUES ('2', '2', '1');
INSERT INTO `kfc_user_role` VALUES ('3', '3', '1');
