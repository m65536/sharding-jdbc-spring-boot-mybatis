package com.mo.test.service.impl;

import com.mo.test.entity.Order;
import com.mo.test.entity.OrderItem;
import com.mo.test.mapper.OrderItemMapper;
import com.mo.test.mapper.OrderMapper;
import com.mo.test.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by MoXingwang on 2017/6/14.
 */
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    /**
     * 保证所有相关业务update进入一个库
     */
    @Override
    @Transactional
    public void testTransactional() {
        Order order = new Order();
        order.setCreateDate(new Date());
        order.setSerialNumber(UUID.randomUUID().toString());
        order.setMarketId(getCode(6));
        order.setShopId(getCode(6));
        order.setShardingKey(order.getMarketId() + "-" + order.getShopId());
        orderMapper.insert(order);


        OrderItem orderItem = new OrderItem();
        orderItem.setShardingKey(order.getShardingKey());
        orderItem.setOrderId(order.getId());
        orderItem.setProductName(UUID.randomUUID().toString());
        orderItemMapper.insert(orderItem);

        if (order.getId() > 0) {
            throw new IllegalArgumentException("测试插入事务操");
        }
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
