package com.mo.test.controller;

import com.mo.test.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MoXingwang on 2017/6/14.
 */
@RestController
@RequestMapping(value = "test")
public class TesController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String test(){

        return "";
    }
}
