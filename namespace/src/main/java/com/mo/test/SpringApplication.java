package com.mo.test;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    private static Logger logger = Logger.getLogger(SpringApplication.class);


    public static void main(final String[] args) {
        // CHECKSTYLE:ON
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/*.xml");
    }

}
