package com.xavier.entity;

import com.xavier.utils.IoUtils;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserModelTest {

    private static final String BEAN_XML = "classpath:/beans.xml";

    @Test
    public void beanWired() {
        ClassPathXmlApplicationContext context = IoUtils.context(BEAN_XML);
        String[] beanNameList = context.getBeanDefinitionNames();
        for (String beanName : beanNameList) {
            Object bean = context.getBean(beanName);
            if (bean instanceof PersonModel) {
                PersonModel personModel = (PersonModel) bean;
                System.out.println(personModel);
            }
        }


    }

    @Test
    public void isAssignableFrom() {
        /*Class.isAssignFrom()：判断两个类是否为父子关系*/
        boolean obj_str = Object.class.isAssignableFrom(String.class);
        System.out.println(obj_str);
    }


}