package com.mo.test.service.impl;

import com.mo.test.entity.Order;
import com.mo.test.entity.OrderItem;
import com.mo.test.mapper.OrderItemMapper;
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
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    @Transactional
    public void testTransactional() {

    }

    @Override
    public Long insertOrder() {
        Order order = new Order();
        order.setStatus("1");
        order.setUserId(Integer.valueOf(getCode(4)));
        orderMapper.insert(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(order.getOrderId());
        orderItem.setUserId(order.getUserId());

        orderItemMapper.insert(orderItem);

        return order.getOrderId();
    }

    @Override
    public int updateOrder() {
        return 0;
    }

    @Override
    public int deleteOrder() {
        return 0;
    }

    @Override
    public void testHintManager() {

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
