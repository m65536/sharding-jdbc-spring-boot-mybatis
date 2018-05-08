package com.mo.test.controller;

import com.mo.test.entity.Order;
import com.mo.test.entity.OrderExample;
import com.mo.test.entity.OrderItem;
import com.mo.test.entity.OrderItemExample;
import com.mo.test.mapper.OrderItemMapper;
import com.mo.test.mapper.OrderMapper;
import com.mo.test.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MoXingwang on 2017/6/14.
 */
@RestController
@RequestMapping(value = "")
public class TesController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        Order order = new Order();


        return "";
    }


    @RequestMapping(value = "/tc", method = RequestMethod.GET)
    public String testTransactional() {

        orderService.testTransactional();

        return "OK";
    }


    @RequestMapping(value = "/select/order/all", method = RequestMethod.GET)
    public List<Order> selectOrderAll() {
        OrderExample orderExample = new OrderExample();
        return orderMapper.selectByExample(orderExample);
    }

    @RequestMapping(value = "/select/order", method = RequestMethod.GET)
    public List<Order> selectOrder(@RequestParam(value = "id") Long id) {
        OrderExample orderExample = new OrderExample();

        return orderMapper.selectByExample(orderExample);
    }


    @RequestMapping(value = "/select/order/shardingKey", method = RequestMethod.GET)
    public List<Order> selectOrderByShardingKey(@RequestParam(value = "shardingKey") String shardingKey) {
        OrderExample orderExample = new OrderExample();

        return orderMapper.selectByExample(orderExample);
    }

    @RequestMapping(value = "/select/item", method = RequestMethod.GET)
    public List<OrderItem> selectOrderItem(@RequestParam(value = "id") Long id) {
        OrderItemExample orderItemExample = new OrderItemExample();

        return orderItemMapper.selectByExample(orderItemExample);
    }


}
