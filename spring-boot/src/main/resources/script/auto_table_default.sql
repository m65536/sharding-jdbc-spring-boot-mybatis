
-- ----------------------------
-- 以下数据是导出的
-- ----------------------------
DROP TABLE IF EXISTS `tx_attachment`;
CREATE TABLE `tx_attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attachment_url` varchar(255) DEFAULT NULL COMMENT '附件地址',
  `attachment_type` int(11) DEFAULT NULL COMMENT '附件类型',
  `file_type` int(11) DEFAULT NULL COMMENT '文件类型',
  `customer_service_id` bigint(20) DEFAULT NULL COMMENT '售后表id',
  `return_info_id` bigint(20) DEFAULT NULL COMMENT '退货信息id',
  `attachment_size` bigint(20) DEFAULT NULL COMMENT '附件大小',
  `create_user_id` varchar(255) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_update_user_id` varchar(255) DEFAULT NULL COMMENT '更新人id',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `fk_attachment_to_custom_service` (`customer_service_id`),
  KEY `fk_attachment_to_return_info` (`return_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Table structure for tx_cancel_payment_log
-- ----------------------------
DROP TABLE IF EXISTS `tx_cancel_payment_log`;
CREATE TABLE `tx_cancel_payment_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `payment_id` bigint(20) NOT NULL COMMENT '支付的id',
  `order_id` bigint(20) NOT NULL COMMENT '对应订单id',
  `create_user_id` varchar(25) DEFAULT NULL COMMENT '操作人id',
  `create_user_name` varchar(25) DEFAULT NULL COMMENT '操作姓名',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='当日作废日志表';

-- ----------------------------
-- Table structure for tx_config
-- ----------------------------
DROP TABLE IF EXISTS `tx_config`;
CREATE TABLE `tx_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规则id',
  `config_name` varchar(100) NOT NULL COMMENT '规则名称',
  `config_description` varchar(200) DEFAULT NULL COMMENT '规则描述',
  `config_rank` int(11) DEFAULT NULL COMMENT '规则优先级',
  `auto_close_order_type` int(11) DEFAULT NULL COMMENT '自动关闭订单类型',
  `start_time` datetime DEFAULT NULL COMMENT '生效时间',
  `end_time` datetime DEFAULT NULL COMMENT '失效时间',
  `duration_time` bigint(20) DEFAULT NULL COMMENT '持续时间',
  `delete_flag` tinyint(4) DEFAULT NULL COMMENT '逻辑删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` datetime DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='规则配置表';

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
-- Table structure for tx_customer_service_status_version
-- ----------------------------
DROP TABLE IF EXISTS `tx_customer_service_status_version`;
CREATE TABLE `tx_customer_service_status_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `customer_service_id` bigint(20) NOT NULL COMMENT '外键，关联到tx_custom_service.id',
  `customer_service_status` int(11) NOT NULL COMMENT '售后表状态',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` varchar(255) DEFAULT NULL COMMENT '创建人id',
  `create_user_name` varchar(255) DEFAULT NULL COMMENT '创建人姓名',
  `delete_flag` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_customer_service_status_version_to_customer_service` (`customer_service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=211391 DEFAULT CHARSET=utf8 COMMENT='售后状态表';

-- ----------------------------
-- Table structure for tx_item_attributes
-- ----------------------------
DROP TABLE IF EXISTS `tx_item_attributes`;
CREATE TABLE `tx_item_attributes` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `order_item_id` bigint(20) DEFAULT NULL COMMENT '订单商品项id',
  `psg_id` varchar(50) DEFAULT NULL COMMENT '商品id',
  `attr_id` varchar(50) DEFAULT NULL COMMENT '属性id',
  `attr_name` varchar(200) DEFAULT NULL COMMENT '属性名称',
  `attr_value_id` varchar(50) DEFAULT NULL COMMENT '属性值id',
  `attr_value_name` varchar(200) DEFAULT NULL COMMENT '属性值名称',
  `is_shopping` tinyint(1) DEFAULT NULL COMMENT '是否购物属性',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_order_item_id` (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=778 DEFAULT CHARSET=utf8 COMMENT='订单商品自定义属性';

-- ----------------------------
-- Table structure for tx_item_commission
-- ----------------------------
DROP TABLE IF EXISTS `tx_item_commission`;
CREATE TABLE `tx_item_commission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `order_id` bigint(20) NOT NULL COMMENT '外键，关联到tx_order.id',
  `order_item_id` bigint(20) NOT NULL COMMENT '外键，关联到tx_order_item.id',
  `merchant_id` varchar(255) DEFAULT NULL COMMENT '商户唯一标示符，从商户系统中获取商户信息',
  `sku` varchar(100) DEFAULT NULL COMMENT '商品sku',
  `comm_rate` decimal(11,2) DEFAULT NULL COMMENT '佣金率',
  `comm_amt` decimal(11,4) DEFAULT NULL COMMENT '佣金金额',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=463 DEFAULT CHARSET=utf8 COMMENT='订单的佣金';

-- ----------------------------
-- Table structure for tx_item_payment
-- ----------------------------
DROP TABLE IF EXISTS `tx_item_payment`;
CREATE TABLE `tx_item_payment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `order_id` bigint(20) NOT NULL COMMENT '外键，关联到tx_order.id',
  `order_item_id` bigint(20) NOT NULL COMMENT '订单商品id',
  `payment_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '支付id',
  `payable_amount` decimal(19,2) NOT NULL COMMENT '本次付款金额',
  `promotion_amount` decimal(19,2) DEFAULT NULL COMMENT '本次促销金额',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `delete_flag` tinyint(2) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=305253 DEFAULT CHARSET=utf8 COMMENT='商品费用明细表';

-- ----------------------------
-- Table structure for tx_item_promotion
-- ----------------------------
DROP TABLE IF EXISTS `tx_item_promotion`;
CREATE TABLE `tx_item_promotion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id（主键，自增长，步长＝1）',
  `promotion_id` varchar(50) DEFAULT NULL COMMENT '促销代码，由促销中心系统提供',
  `promotion_amount` decimal(19,2) DEFAULT NULL COMMENT '促销优惠金额',
  `order_id` bigint(20) NOT NULL COMMENT '对应订单id',
  `sku` varchar(255) DEFAULT NULL COMMENT '商品sku',
  `item_id` bigint(20) NOT NULL COMMENT '商品id',
  `promotion_type` int(11) DEFAULT NULL COMMENT '促销类型',
  `item_amount` decimal(19,2) DEFAULT NULL COMMENT '商品金额（减促销）',
  `item_quantity` decimal(19,2) DEFAULT NULL COMMENT '商品数量',
  `voucher_no` varchar(20) DEFAULT NULL COMMENT '券码',
  `voucher_sku` varchar(20) DEFAULT NULL COMMENT '券对应sku',
  PRIMARY KEY (`id`),
  KEY `FK_item_promotion_to_order_idx` (`order_id`) USING BTREE,
  KEY `tx_item_promotion_ibfk_2` (`item_id`),
  KEY `idx_voucher_no` (`voucher_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1550083 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tx_operation_history
-- ----------------------------
DROP TABLE IF EXISTS `tx_operation_history`;
CREATE TABLE `tx_operation_history` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `operation_type` tinyint(1) NOT NULL COMMENT '操作类型，1 订单改单 2. B端订单跟单',
  `order_id` bigint(20) NOT NULL COMMENT '外键，关联到tx_order.id',
  `remark` varchar(200) NOT NULL COMMENT '日志',
  `create_user_id` varchar(50) NOT NULL COMMENT '创建用户id',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=711094 DEFAULT CHARSET=utf8 COMMENT='订单操作记录';

-- ----------------------------
-- Table structure for tx_order
-- ----------------------------
DROP TABLE IF EXISTS `tx_order`;
CREATE TABLE `tx_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `channel` bigint(20) DEFAULT NULL COMMENT '渠道号标识（线上或者线下）',
  `plantform` bigint(20) DEFAULT NULL COMMENT '平台标识 1：B端PC，2：B端App，3：C端App',
  `client` bigint(20) DEFAULT NULL COMMENT '客户端标示 1：商户开单pc客户端，2：商户开单app客户端，',
  `serial_number` varchar(255) NOT NULL COMMENT '订单序列号',
  `order_status` int(11) DEFAULT NULL COMMENT '订单状态',
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型',
  `market_id` varchar(10) DEFAULT NULL COMMENT '商场id',
  `market_name` varchar(255) DEFAULT NULL COMMENT '商场名称',
  `shop_id` varchar(50) DEFAULT NULL COMMENT '店铺id',
  `shop_name` varchar(100) DEFAULT NULL COMMENT '店铺名称',
  `total_amount` decimal(19,2) DEFAULT NULL COMMENT '订单总金额',
  `promotion_total_amount` decimal(19,2) DEFAULT NULL COMMENT '促销总金额',
  `excepted_change_amount` decimal(19,2) DEFAULT NULL COMMENT '抹零金额',
  `payable_amount` decimal(19,2) DEFAULT NULL COMMENT '订单应付金额',
  `service_amount` decimal(19,2) DEFAULT '0.00' COMMENT '服务费',
  `paid_amount` decimal(19,2) DEFAULT '0.00' COMMENT '订单已付金额',
  `refunded_amount` decimal(19,2) DEFAULT '0.00' COMMENT '订单已退金额',
  `create_user_id` varchar(255) DEFAULT NULL COMMENT '创建人id，可以从用户系统获取创建人id',
  `create_user_name` varchar(255) DEFAULT NULL COMMENT '创建人名称，从用户系统获取',
  `create_date` datetime DEFAULT NULL COMMENT '订单创建时间yyyy-mm-dd hh24:mi:ss',
  `last_update_user_id` varchar(255) DEFAULT NULL COMMENT '最后更新人信息，可从用户系统获取最后更新人',
  `last_update_user_name` varchar(255) DEFAULT NULL COMMENT '最后更新人名称，从用户系统获取',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新日期',
  `area_id` bigint(20) DEFAULT NULL COMMENT '区域id',
  `area_name` varchar(255) DEFAULT NULL COMMENT '区域名称',
  `purchaser_id` varchar(255) DEFAULT NULL COMMENT '购买人id',
  `purchaser_name` varchar(255) DEFAULT NULL COMMENT '购买人名称',
  `receiver_id` varchar(255) DEFAULT NULL COMMENT '收货人id',
  `receiver_name` varchar(255) DEFAULT NULL COMMENT '收货人名称',
  `receiver_mobile` varchar(255) DEFAULT NULL COMMENT '收货人手机号',
  `mobile` varchar(255) DEFAULT NULL COMMENT '移动电话',
  `address` varchar(255) DEFAULT NULL COMMENT '送货地址',
  `carriage` decimal(19,2) DEFAULT '0.00' COMMENT '运费',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `delete_flag` tinyint(1) DEFAULT '0',
  `reference_id` bigint(20) DEFAULT NULL COMMENT '订金订单对应订单id',
  `deliver_type` int(11) DEFAULT NULL COMMENT '物流类型',
  `deliver_status` int(11) DEFAULT NULL COMMENT '物流状态',
  `refund_reason` varchar(500) DEFAULT NULL COMMENT '退单原因',
  `can_refund` tinyint(1) DEFAULT '1' COMMENT '是否可以退款',
  `contract_number` varchar(255) DEFAULT NULL COMMENT '合同号，龙果提供',
  `serial_code` varchar(255) DEFAULT NULL COMMENT '系列编码，龙果提供',
  `serial_name` varchar(255) DEFAULT NULL COMMENT '系列名称，龙果提供',
  `first_payment` decimal(19,2) DEFAULT NULL COMMENT '首付金额',
  `agreed_delivery_date` datetime DEFAULT NULL COMMENT '约定送货日期yyyy-mm-dd',
  `dealer_id` varchar(255) DEFAULT NULL COMMENT '经销商id',
  `dealer_name` varchar(100) DEFAULT NULL COMMENT '商户名称',
  `real_deliver_date` datetime DEFAULT NULL COMMENT '实际送货日期',
  `real_received_date` datetime DEFAULT NULL COMMENT '确认收货日期',
  `province_id` varchar(255) DEFAULT NULL COMMENT '省id',
  `province_name` varchar(255) DEFAULT NULL COMMENT '省名称',
  `city_id` varchar(255) DEFAULT NULL COMMENT '市id',
  `city_name` varchar(255) DEFAULT NULL COMMENT '市名称',
  `district_id` varchar(255) DEFAULT NULL COMMENT '区id',
  `district_name` varchar(255) DEFAULT NULL COMMENT '区名称',
  `is_stage` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否阶段订单',
  `settlement_status` int(11) DEFAULT NULL COMMENT '结算状态',
  `settlement_date` datetime DEFAULT NULL COMMENT '结算时间',
  `settlement_amount` decimal(19,2) DEFAULT NULL COMMENT '结算金额',
  `planed_settlement_date` datetime DEFAULT NULL COMMENT '计划结算时间',
  `refund_status` int(11) DEFAULT NULL COMMENT '退款状态',
  `after_sale_status` int(11) DEFAULT NULL COMMENT '售后状态',
  `review_status` int(11) DEFAULT NULL COMMENT '评论状态',
  `oms_uuid` varchar(30) DEFAULT NULL COMMENT 'oms商场uuid',
  `review_date` datetime DEFAULT NULL COMMENT '评价时间',
  `review_id` varchar(50) DEFAULT NULL COMMENT '对应评价系统的评价id',
  `return_visit_status` varchar(64) DEFAULT '0000000000' COMMENT '按位存储状体,从左自右，高金额回访，撤场回访，真实性回访',
  `extend_status` tinyint(1) DEFAULT NULL COMMENT '扩展订单类型状态：0未付费，1已付订金，2 已付尾款，3 未使用，4 已使用，5 已退款，6 未成团，7 已成团',
  `extend_type` tinyint(1) DEFAULT '0' COMMENT '扩展订单类型：0 默认，1 预付费类型订单，2 付费券订单，3 停车费订单，4 拼团购订单',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_serial_number` (`serial_number`),
  KEY `i_tx_order_mobile` (`mobile`) USING BTREE,
  KEY `i_tx_order_purchaser_name` (`purchaser_name`) USING BTREE,
  KEY `i_tx_order_reference_id` (`reference_id`) USING BTREE,
  KEY `real_received_date` (`real_received_date`) USING BTREE,
  KEY `idx_purchaser_id` (`purchaser_id`),
  KEY `idx_shop_id` (`shop_id`),
  KEY `idx_market_id` (`market_id`,`order_status`,`create_date`),
  KEY `idx_market_id_type` (`market_id`,`order_type`,`create_date`),
  KEY `idx_shop_create_date` (`shop_id`,`order_type`,`create_date`),
  KEY `idx_agreed_delivery_date` (`agreed_delivery_date`),
  KEY `idx_type_create_date` (`create_date`,`order_type`,`extend_type`)
) ENGINE=InnoDB AUTO_INCREMENT=1606129 DEFAULT CHARSET=utf8 COMMENT='订单主表';

-- ----------------------------
-- Table structure for tx_order_addition
-- ----------------------------
DROP TABLE IF EXISTS `tx_order_addition`;
CREATE TABLE `tx_order_addition` (
  `id` bigint(20) NOT NULL COMMENT 'id（非自增，随tx_order表id）',
  `large_region_id` varchar(50) DEFAULT NULL COMMENT '大区id',
  `large_region_name` varchar(255) DEFAULT NULL COMMENT '大区名称',
  `small_region_id` varchar(50) DEFAULT NULL COMMENT '小区id',
  `small_region_name` varchar(50) DEFAULT NULL COMMENT '小区名称',
  `floor_id` varchar(50) DEFAULT NULL COMMENT '楼层id',
  `floor_name` varchar(50) DEFAULT NULL COMMENT '楼层名称',
  `building_id` varchar(50) DEFAULT NULL COMMENT '楼栋id',
  `building_name` varchar(50) DEFAULT NULL COMMENT '楼栋名称',
  `get_invoice` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否开发票',
  `invoice_type` tinyint(1) DEFAULT NULL COMMENT '发票类型：1 公司 2个人',
  `invoice_head` varchar(255) DEFAULT NULL COMMENT '发票抬头',
  `taxpayer_number` varchar(50) DEFAULT NULL COMMENT '纳税人识别号',
  `market_booth_number` varchar(50) DEFAULT NULL COMMENT '卖场门牌号',
  `shop_type` tinyint(1) DEFAULT NULL COMMENT '店铺类型 0 :纯线下,1:纯线上 , 2:线上+线下',
  `payment_lock` tinyint(1) DEFAULT '0' COMMENT '整笔未完成支付lock: 0 未锁定，1已锁定，2 锁定过',
  `comm_status` tinyint(1) DEFAULT '0' COMMENT '是否计算佣金：0 未计算，1已计算',
  `service_audit_status` tinyint(1) DEFAULT '0' COMMENT '客诉审核状态：0 默认， 1 成功 2 失败 3审核中',
  `service_audit_reason` varchar(255) DEFAULT NULL COMMENT '客诉审核理由',
  `service_audit_datetime` datetime DEFAULT NULL COMMENT '客诉审核时间',
  `shop_brand_id` varchar(50) DEFAULT NULL COMMENT '店铺主营品牌id',
  `shop_brand_name` varchar(100) DEFAULT NULL COMMENT '店铺主营品牌名称',
  `return_goods_type` tinyint(1) DEFAULT NULL COMMENT '退货类型：1 15分钟快速退货，2.30天无理由退货 3.其它',
  `community_id` varchar(30) DEFAULT NULL COMMENT '小区id',
  `final_pay_remark` varchar(20) DEFAULT NULL COMMENT '尾款付款备注，打印单据',
  `other_print_amount` decimal(11,2) DEFAULT NULL COMMENT '其他费用，打印单据',
  `dist_shop_id` varchar(50) DEFAULT NULL COMMENT '分单店铺id',
  `dist_shop_name` varchar(50) DEFAULT NULL COMMENT '分单店铺名称',
  `dist_market_id` varchar(50) DEFAULT NULL COMMENT '分单商场id',
  `dist_market_name` varchar(50) DEFAULT NULL COMMENT '分单商场名称',
  `dist_status` tinyint(1) DEFAULT '0' COMMENT '0 未分配 1 已分单 2 已接单 3 已拒绝',
  `first_payment_date` datetime DEFAULT NULL COMMENT '第一次付款时间',
  `last_payment_date` datetime DEFAULT NULL COMMENT '最后一次付款时间',
  `service_remark` varchar(250) DEFAULT NULL COMMENT '服务费备注',
  PRIMARY KEY (`id`),
  KEY `idx_floor_id` (`floor_id`) USING BTREE,
  KEY `idx_building_id` (`building_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for tx_order_extend
-- ----------------------------
DROP TABLE IF EXISTS `tx_order_extend`;
CREATE TABLE `tx_order_extend` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'id（非自增，随tx_order表id）',
  `confirm_deliver_status` tinyint(2) DEFAULT '0' COMMENT '确认物流发送时间：0 未确认，1 已确认',
  `worker_status` tinyint(2) DEFAULT '0' COMMENT '三工维护状态，0：默认未维护,1:已维护',
  `jbd_number` varchar(20) DEFAULT NULL COMMENT '家倍得客户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外围属性表';

-- ----------------------------
-- Table structure for tx_order_item
-- ----------------------------
DROP TABLE IF EXISTS `tx_order_item`;
CREATE TABLE `tx_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `order_id` bigint(20) NOT NULL COMMENT '外键，关联到tx_order.id',
  `merchant_id` varchar(255) DEFAULT NULL COMMENT '商户唯一标示符，从商户系统中获取商户信息',
  `merchant_name` varchar(255) DEFAULT NULL COMMENT '商户名称，从商户系统获取',
  `product_id` varchar(255) DEFAULT NULL COMMENT '产品id，从产品系统中获取产品信息',
  `product_name` varchar(255) NOT NULL COMMENT '产品名称，从产品系统中获取',
  `brand_id` varchar(255) DEFAULT NULL COMMENT '品牌id，从商品库获取',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '名牌名称，从商品库获取',
  `img_url` varchar(500) DEFAULT NULL COMMENT '商品圖片路徑',
  `order_item_type` int(11) DEFAULT NULL COMMENT '商品类型，从商品库获取，（买券类型：3.购买券，4.抵用券）',
  `unit_id` varchar(255) DEFAULT NULL COMMENT '商品单位id，从商品库获取',
  `unit_name` varchar(255) DEFAULT NULL COMMENT '商品单位名称，从商品库获取',
  `unit_price` decimal(19,2) NOT NULL COMMENT '商品单价，从定价库获取',
  `sale_price` decimal(19,2) NOT NULL COMMENT '商品销售价格，从定价系统获取',
  `paid_amount` decimal(19,2) DEFAULT '0.00' COMMENT '分摊到商品已付金额',
  `share_rate` decimal(19,8) DEFAULT '0.00000000' COMMENT '(真实售价*数量-此商品b端总促销)/（订单总商品售价-b端订单总促销金额）',
  `total_amount` decimal(19,2) NOT NULL COMMENT '单项商品购买总价',
  `inventory_id` varchar(255) DEFAULT NULL COMMENT '库存id，从商品库获取',
  `quantity` decimal(19,2) NOT NULL COMMENT '购买数量',
  `real_quantity` decimal(19,2) DEFAULT NULL COMMENT '真实数量（= 总数量 - 已退数量）',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `delete_flag` tinyint(1) NOT NULL,
  `signed_code` varchar(255) DEFAULT NULL COMMENT '价签码(龙果提供)sku_id',
  `model` varchar(255) DEFAULT NULL COMMENT '型号（龙果）',
  `size` varchar(255) DEFAULT NULL COMMENT '规格（龙果）没有就反斜杠',
  `size_unit` varchar(255) DEFAULT NULL COMMENT '规格单位（龙果）',
  `discount_rate` decimal(5,2) DEFAULT NULL COMMENT '折扣率',
  `is_blatantly` tinyint(1) DEFAULT NULL COMMENT '1：明码实价，2：明码议价',
  `serial_code` varchar(255) DEFAULT NULL COMMENT '系列编码，龙果提供',
  `serial_name` varchar(255) DEFAULT NULL COMMENT '系列名称，龙果提供',
  `description` varchar(500) DEFAULT NULL COMMENT '商品描述说明',
  `can_refund` tinyint(1) DEFAULT NULL COMMENT '是否可退',
  `color` varchar(255) DEFAULT NULL COMMENT '颜色',
  `color_rgb` varchar(255) DEFAULT NULL COMMENT '颜色编码',
  `oms_price_tag_code` varchar(255) DEFAULT NULL COMMENT 'oms价签码',
  `sku` varchar(255) DEFAULT NULL COMMENT '商品sku',
  `reject_count` int(11) DEFAULT NULL,
  `is_service` tinyint(1) DEFAULT '0' COMMENT '是否是服务费 0：不是，1：是',
  `reference_item_id` bigint(20) DEFAULT NULL COMMENT '原单商品id',
  `review_status` int(11) DEFAULT NULL COMMENT '评价状态',
  `review_date` datetime DEFAULT NULL COMMENT '评价时间',
  `review_id` varchar(50) DEFAULT NULL COMMENT '对应评价系统的评价id',
  `goods_type` tinyint(1) DEFAULT '0' COMMENT '商品类型：0店铺商品；1：自采商品',
  `sale_channel` tinyint(1) DEFAULT '0' COMMENT '纯线上销售：0否；1：是',
  `unit_is_show` tinyint(1) DEFAULT '0' COMMENT '计价单位是否显示：0否；1：是',
  PRIMARY KEY (`id`),
  KEY `i_tx_order_item_order_id` (`order_id`) USING BTREE,
  KEY `idx_sku` (`sku`)
) ENGINE=InnoDB AUTO_INCREMENT=2753612 DEFAULT CHARSET=utf8;

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

-- ----------------------------
-- Table structure for tx_order_status_version
-- ----------------------------
DROP TABLE IF EXISTS `tx_order_status_version`;
CREATE TABLE `tx_order_status_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `order_id` bigint(20) NOT NULL COMMENT '外键，关联到tx_order.id',
  `order_status` int(11) NOT NULL COMMENT '订单状态',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` varchar(255) DEFAULT NULL COMMENT '创建人id',
  `create_user_name` varchar(255) DEFAULT NULL COMMENT '创建人姓名',
  `delete_flag` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `i_tx_order_status_version_order_id` (`order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=379251 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tx_order_worker
-- ----------------------------
DROP TABLE IF EXISTS `tx_order_worker`;
CREATE TABLE `tx_order_worker` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) unsigned NOT NULL COMMENT '外键，对应订单id',
  `worker_id` varchar(20) DEFAULT NULL COMMENT '三工人员id',
  `worker_name` varchar(30) DEFAULT NULL COMMENT '三工人员姓名',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `delete_flag` tinyint(1) NOT NULL COMMENT '删除标志',
  PRIMARY KEY (`id`),
  KEY `idx_workder_id` (`worker_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=333 DEFAULT CHARSET=utf8 COMMENT='订单的三工人员表';


-- ----------------------------
-- Table structure for tx_payment_line
-- ----------------------------
DROP TABLE IF EXISTS `tx_payment_line`;
CREATE TABLE `tx_payment_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `payment_line_amount` decimal(19,2) NOT NULL COMMENT '付款金额',
  `order_id` bigint(20) NOT NULL COMMENT '外键，对应订单id',
  `delete_flag` tinyint(1) NOT NULL,
  `payment_status` int(4) NOT NULL DEFAULT '1' COMMENT '支付状态',
  `transaction_serial_number` varchar(60) DEFAULT NULL COMMENT '交易流水号',
  `create_date` datetime NOT NULL,
  `payment_date` datetime DEFAULT NULL COMMENT '付款时间',
  `real_payment_date` datetime DEFAULT NULL COMMENT '实际付款时间',
  `payment_type` int(4) DEFAULT NULL COMMENT '支付类型，线上或者线下',
  `pay_type_code` varchar(20) DEFAULT NULL COMMENT '收付类型编码',
  `pay_type_name` varchar(64) DEFAULT NULL COMMENT '收付类型名称',
  `remark` varchar(255) DEFAULT NULL,
  `seq_num` int(4) DEFAULT NULL COMMENT '分期次数',
  PRIMARY KEY (`id`),
  KEY `i_tx_order_payment_line_order_id` (`order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1625488 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tx_payment_line_detail
-- ----------------------------
DROP TABLE IF EXISTS `tx_payment_line_detail`;
CREATE TABLE `tx_payment_line_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `payment_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '支付id',
  `pay_way_code` varchar(50) DEFAULT '0' COMMENT '收付代码（支付类型代码）',
  `pay_way_name` varchar(50) DEFAULT '0' COMMENT '收付名称（支付类型名称）',
  `pay_type_code` varchar(50) DEFAULT '0' COMMENT '收付类型编码',
  `pay_type_name` varchar(50) DEFAULT '0' COMMENT '收付类型名称',
  `has_invoice` tinyint(1) DEFAULT '0' COMMENT '是否有发票',
  `poundage` decimal(19,2) DEFAULT '0.00' COMMENT '手续费',
  `pay_detail` decimal(19,2) NOT NULL DEFAULT '0.00' COMMENT '明细',
  PRIMARY KEY (`id`),
  KEY `i_tx_payment_line_detail_payment_id` (`payment_id`) USING BTREE,
  KEY `fk_payment_line_detail_to_payment_line_idx` (`payment_id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for tx_promotion
-- ----------------------------
DROP TABLE IF EXISTS `tx_promotion`;
CREATE TABLE `tx_promotion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `order_id` bigint(20) DEFAULT NULL COMMENT '外键，关联到tx_order.id',
  `promotion_id` varchar(255) DEFAULT NULL COMMENT '促销代码，由促销中心系统提供',
  `promotion_type` int(11) DEFAULT NULL COMMENT '促销类型',
  `promotion_name` varchar(255) DEFAULT NULL COMMENT '促销名称，由促销中心系统提供',
  `promotion_discount_amount` decimal(19,2) DEFAULT NULL COMMENT '促销优惠金额',
  `description` varchar(255) DEFAULT NULL COMMENT '促销描述信息',
  `create_date` datetime DEFAULT NULL COMMENT '促销记录创建时间',
  `channel` int(255) DEFAULT NULL COMMENT '渠道代码',
  `plantform` int(11) DEFAULT NULL COMMENT '平台代码',
  `client` int(11) DEFAULT NULL COMMENT '客户端代码',
  `market_id` varchar(255) DEFAULT NULL COMMENT '商场代码，从龙果系统获取',
  `market_name` varchar(255) DEFAULT NULL COMMENT '商场名称，从龙果系统获取',
  `merchant_id` varchar(255) DEFAULT NULL COMMENT '商铺id，从龙果系统获取',
  `merchant_name` varchar(255) DEFAULT NULL COMMENT '商铺名称，从龙果系统获取',
  `product_id` varchar(255) DEFAULT NULL COMMENT '产品id，从龙果系统获取 order_item_id',
  `product_name` varchar(255) DEFAULT NULL COMMENT '产品名称，从龙果系统获取',
  `brand_id` varchar(255) DEFAULT NULL COMMENT '品牌id，从龙果系统获取',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称，从龙果系统获取',
  `serial_number` varchar(255) DEFAULT NULL COMMENT '促销序列号',
  `delete_flag` tinyint(1) NOT NULL,
  `oms_promotion` int(11) DEFAULT NULL COMMENT '0 新促销 1 OMS促销 2 OMS微信券',
  `is_sharable` int(1) DEFAULT NULL COMMENT '新促销1 可与其它共享，0不可与其它共享',
  `voucher_no` varchar(255) DEFAULT NULL COMMENT 'OMS微信券码',
  `oms_promotion_priority` int(11) DEFAULT NULL COMMENT 'OMS促销活动优先级，1最高',
  `is_shared_subpromotion` tinyint(1) DEFAULT NULL COMMENT '是否可以与促销叠加',
  `is_shared_coupon` tinyint(1) DEFAULT NULL COMMENT '是否可以与优惠券叠加',
  `gift_name` varchar(64) DEFAULT NULL COMMENT '赠品名称',
  `promotion_big_type` tinyint(1) DEFAULT NULL COMMENT '1 商品促销  2 订单促销 3 券',
  `payment_id` bigint(20) DEFAULT '0' COMMENT '支付id',
  PRIMARY KEY (`id`),
  KEY `i_tx_order_promotion_order_id` (`order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=430914 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tx_promotion_job
-- ----------------------------
DROP TABLE IF EXISTS `tx_promotion_job`;
CREATE TABLE `tx_promotion_job` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
  `promotion_type` int(4) DEFAULT NULL COMMENT '促销类型',
  `promotion_id` varchar(50) DEFAULT NULL COMMENT '促销代码，由促销中心系统提供',
  `task_type` int(1) DEFAULT NULL COMMENT '类型 1 付费预定 2 买劵 3 拼团购',
  `prom_value` varchar(50) DEFAULT NULL COMMENT '值',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态 0 未执行 1成功',
  `execute_date` datetime DEFAULT NULL COMMENT '执行时间',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3325 DEFAULT CHARSET=utf8 COMMENT='外部job数据处理表';


-- ----------------------------
-- Table structure for tx_refund_bill
-- ----------------------------
DROP TABLE IF EXISTS `tx_refund_bill`;
CREATE TABLE `tx_refund_bill` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `bill_type` tinyint(4) NOT NULL COMMENT '费用类型; 1:运费，2：服务费；3：仓储费；4：上楼费；5：安装费；6：设计费；7：测量法；8：重新包装费；9：其它',
  `bill_amount` decimal(19,2) NOT NULL COMMENT '费用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=185 DEFAULT CHARSET=utf8 COMMENT='退款费用明细';

-- ----------------------------
-- Table structure for tx_return_detail
-- ----------------------------
DROP TABLE IF EXISTS `tx_return_detail`;
CREATE TABLE `tx_return_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `return_info_id` bigint(20) DEFAULT NULL COMMENT '退货表id',
  `item_quantity` decimal(19,2) DEFAULT NULL COMMENT '商品数量',
  `order_item_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(255) DEFAULT NULL COMMENT '创建人id',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_update_user_id` varchar(255) DEFAULT NULL COMMENT '更新者id',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `fk_return_detail_to_return_info` (`return_info_id`),
  KEY `fk_return_detail_to_order_item` (`order_item_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='退货详情表';

-- ----------------------------
-- Table structure for tx_return_info
-- ----------------------------
DROP TABLE IF EXISTS `tx_return_info`;
CREATE TABLE `tx_return_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_service_id` bigint(20) DEFAULT NULL COMMENT '售后表id',
  `return_type` int(11) DEFAULT NULL COMMENT '退货方式',
  `return_time` bigint(20) DEFAULT NULL COMMENT '退货耗时',
  `create_user_id` varchar(255) DEFAULT NULL COMMENT '创建者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL,
  `last_update_user_id` varchar(255) DEFAULT NULL COMMENT '更新人id',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  `deliver_company` varchar(255) DEFAULT NULL COMMENT '快递公司',
  `deliver_number` varchar(255) DEFAULT NULL COMMENT '快递单号',
  `deliver_desc` varchar(255) DEFAULT NULL COMMENT '快递凭证说明',
  PRIMARY KEY (`id`),
  KEY `fk_return_info_to_customer_service` (`customer_service_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='退货信息表';




alter table        tx_customer_service               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_item_payment               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_item_promotion               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_operation_history               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_order               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_order_addition               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_order_extend               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_order_item               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_order_reviewed               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_order_status_version               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_order_worker               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_payment_line               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_payment_line_detail               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_promotion               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_promotion_job               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_refund_bill               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;
alter table        tx_attachment               add  `sharding_key` varchar(64) not null COMMENT 'sharding_key' after id;







