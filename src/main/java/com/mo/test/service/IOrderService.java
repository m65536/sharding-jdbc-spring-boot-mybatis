package com.mo.test.service;

import com.mo.test.entity.Order;
import com.mo.test.entity.OrderItem;

/**
 * @author MoXingwang on 2018-04-27.
 */
public interface IOrderService {

    void testTransactional();
    String getCode(int length);
}
