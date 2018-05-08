package com.mo.test.controller;

import com.mo.test.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MoXingwang on 2017/6/14.
 */
@RestController
@RequestMapping(value = "")
public class TesController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public Long insert() {
        return orderService.insertOrder();
    }

    @RequestMapping(value = "/tc", method = RequestMethod.GET)
    public String testTransactional() {
        orderService.testTransactional();
        return "OK";
    }

}
