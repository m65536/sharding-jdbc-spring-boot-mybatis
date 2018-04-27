package com.mo.test.controller;

import com.mo.test.entity.Order;
import com.mo.test.entity.OrderExample;
import com.mo.test.entity.OrderItem;
import com.mo.test.entity.OrderItemExample;
import com.mo.test.mapper.OrderItemMapper;
import com.mo.test.mapper.OrderMapper;
import com.mo.test.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by MoXingwang on 2017/6/14.
 */
@RestController
@RequestMapping(value = "")
public class TesController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
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


        return order.getId() + "";
    }

    @RequestMapping(value = "/select/order", method = RequestMethod.GET)
    public List<Order> selectOrder(@RequestParam(value = "id") Long id) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andIdEqualTo(id);
        return orderMapper.selectByExample(orderExample);
    }

    @RequestMapping(value = "/select/item", method = RequestMethod.GET)
    public List<OrderItem> selectOrderItem(@RequestParam(value = "id") Long id) {
        OrderItemExample orderItemExample = new OrderItemExample();
        orderItemExample.createCriteria().andIdEqualTo(id);
        return orderItemMapper.selectByExample(orderItemExample);
    }

    public String getCode(int length) {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }
}
