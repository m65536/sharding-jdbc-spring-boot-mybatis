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
     * 事务测试
     */
    @Override
    @Transactional
    @ShardingHint
    public void testTransactional() {


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
