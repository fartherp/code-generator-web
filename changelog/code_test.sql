CREATE DATABASE `code_test` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `code_test`;

DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(255) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `menu_remark` varchar(255) NOT NULL DEFAULT '' COMMENT '菜单备注',
  `menu_parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父菜单ID',
  `menu_url` varchar(255) NOT NULL DEFAULT '' COMMENT '菜单URL',
  `create_user` int(11) NOT NULL DEFAULT '0' COMMENT '创建人ID',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_user` int(11) NOT NULL DEFAULT '0' COMMENT '修改人ID',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '修改时间',
  `is_delete` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标志，0:未删除，1:已删除',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';