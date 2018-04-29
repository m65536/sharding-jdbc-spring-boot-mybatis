package com.mo.test.service.impl;

import com.mo.test.annotation.ShardingHint;
import com.mo.test.mapper.OrderMapper;
import com.mo.test.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * Created by MoXingwang on 2017/6/14.
 */
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 保证所有相关业务update进入一个库
     */
    @Override
    @Transactional
    @ShardingHint//自定义强制路由到主库
    public void testTransactional() {

        System.out.println("第一查询" + orderMapper.selectSlaveTest());

        String test = "INSERT INTO tx_customer_service (sharding_key,order_id, refund_order_id, refund_reason, refund_reason_detail, refund_amount, customer_service_status, merchant_confirm_time, last_merchant_confirm_time, user_confirm_time, last_user_confirm_time, apply_count, customer_service_type, create_time, create_user_id, last_update_time, last_update_user_id, delete_flag, return_goods_type, return_goods_way, merchant_audit_reason, return_deliver_status) VALUES ('1-1',9, 10, '7天无理由退换货', '退货退款不想买了测试', 0.01, 6, '2017-09-06 15:41:33', '2016-12-01 20:25:01', '2017-09-06 15:41:33', '2016-12-01 20:25:01', 2, 1, '2016-10-20 17:27:14', null, '2017-09-06 15:41:33', '1163fc18-f050-4d34-b18b-a0fd64b047a6', 0, 2, 3, null, 0);";

        orderMapper.insertSql("INSERT INTO tx_order_reviewed (sharding_key,order_id, reviewed_status, reviewed_star, reviewed_content, remark, create_date) VALUES ('1', 1062429, 1, 5, '导购很专业,用材绿色环保,售后放心,导购非常热情,设计新颖,促销很优惠', '5b6I5qOS77yB54m55Yir5Zac5qyi77yB5YC85b6X6LSt5Lmw', '2018-04-03 20:15:02');");

        int rs = orderMapper.insertSql(test);

        if (1 == rs) {
//            throw new IllegalArgumentException("11111");
        }

        System.out.println("第二查询" + orderMapper.selectSlaveTest());

    }

    @Override
    public String getCode(int length) {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }
}
