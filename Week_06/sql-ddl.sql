CREATE TABLE `user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '�ǳ�',
  `mobile` varchar(11) NOT NULL COMMENT '�ֻ���',
  `create_time` int NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='�û���';

CREATE TABLE `goods` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '��Ʒ����',
  `price` int NOT NULL DEFAULT '0' COMMENT '��Ʒ�۸񣺷�',
  `create_time` int NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='��Ʒ��';

CREATE TABLE `order` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `order_no` varchar(40) NOT NULL COMMENT '������',
  `user_id` int NOT NULL COMMENT '�û�id',
  `good_id` int NOT NULL COMMENT '��Ʒid',
  `good_price` int NOT NULL COMMENT '��Ʒ�۸񣺷�',
  `count` int NOT NULL COMMENT '��Ʒ����',
  `amount` int NOT NULL DEFAULT '0' COMMENT '��������',
  `order_status` int NOT NULL DEFAULT '0' COMMENT '����״̬',
  `create_time` int NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='������';