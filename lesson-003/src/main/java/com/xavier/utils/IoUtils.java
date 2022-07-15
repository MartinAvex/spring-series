package com.xavier.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoUtils {

    public static ClassPathXmlApplicationContext context(String beanXml) {
        return new ClassPathXmlApplicationContext(beanXml);
    }

}
