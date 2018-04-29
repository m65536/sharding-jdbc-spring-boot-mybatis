
-- ----------------------------
-- Table structure for tx_customer_service
-- ----------------------------
DROP TABLE IF EXISTS `tx_customer_service`;
CREATE TABLE `tx_customer_service` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `refund_order_id` bigint(20) DEFAULT NULL COMMENT '退款单id',
  `refund_reason` varchar(255) DEFAULT NULL COMMENT '售后原因',
  `refund_reason_detail` varchar(500) DEFAULT NULL COMMENT '售后详细原因',
  `refund_amount` decimal(19,2) DEFAULT NULL COMMENT '退款金额',
  `customer_service_status` int(11) DEFAULT NULL COMMENT '售后状态',
  `merchant_confirm_time` datetime DEFAULT NULL COMMENT '商家实际确认价格时间',
  `last_merchant_confirm_time` datetime DEFAULT NULL COMMENT '商户最晚确认价格时间',
  `user_confirm_time` datetime DEFAULT NULL COMMENT '用户确认价格时间',
  `last_user_confirm_time` datetime DEFAULT NULL COMMENT '用户最晚确认价格时间',
  `apply_count` int(11) DEFAULT NULL COMMENT '申请次数',
  `customer_service_type` int(11) DEFAULT NULL COMMENT '服务类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(255) DEFAULT NULL COMMENT '创建人id',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_update_user_id` varchar(255) DEFAULT NULL COMMENT '更新者id',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  `return_goods_type` tinyint(2) DEFAULT '2' COMMENT '退货类型：1：15分钟快速退货，2：30天无理由退货 3：补偿退单 4：投诉问题 5 ： 其他',
  `return_goods_way` tinyint(2) DEFAULT '3' COMMENT '退货方式; 1: 上门取件,2: 用户寄回，3：无需退货',
  `merchant_audit_reason` varchar(255) DEFAULT NULL COMMENT '商户审核理由',
  `return_deliver_status` tinyint(2) DEFAULT '0' COMMENT '退货物流状态；0:默认 1 ： 等待寄回，2 确认收到退货',
  PRIMARY KEY (`id`),
  KEY `fk_customer_service_to_order` (`order_id`),
  KEY `fk_customer_service_to_order_refund` (`refund_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15439 DEFAULT CHARSET=utf8 COMMENT='售后服务表';


-- ----------------------------
-- Table structure for tx_order_reviewed
-- ----------------------------
DROP TABLE IF EXISTS `tx_order_reviewed`;
CREATE TABLE `tx_order_reviewed` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id（非自增，随tx_order表id）',
  `order_id` bigint(20) NOT NULL COMMENT '外键，关联到tx_order.id',
  `reviewed_status` tinyint(1) DEFAULT '2' COMMENT '评价状态 0 未评价 1 已评价',
  `reviewed_star` tinyint(1) DEFAULT '2' COMMENT '评价星级',
  `reviewed_content` varchar(100) DEFAULT NULL COMMENT '评价内容',
  `remark` varchar(1024) DEFAULT NULL COMMENT '评价备注',
  `create_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10816 DEFAULT CHARSET=utf8 COMMENT='订单匿名评价';



