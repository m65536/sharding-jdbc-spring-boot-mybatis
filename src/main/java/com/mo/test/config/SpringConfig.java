package com.mo.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author MoXingwang on 2018-04-26.
 */
@Configuration
@ImportResource(locations={"classpath:application-bean.xml"})
public class SpringConfig {
}
