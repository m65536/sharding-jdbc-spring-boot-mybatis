package com.mo.test.service;

/**
 * @author MoXingwang on 2018-04-27.
 */
public interface IOrderService {

    void testTransactional();

    Long insertOrder();

    int updateOrder();

    int deleteOrder();

    void testHintManager();

    String getCode(int length);
}
