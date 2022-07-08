package com.xavier.demo01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class HelloWorldTest {

    public static final String beanXml = "classpath:/com/xavier/demo01/beans.xml";
    public static final ApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

    @Test
    public void getBean() {
        List<String> beanNameList = Arrays.asList("hello1", "hello2", "hello3", "hello4", "hello5");
        beanNameList.forEach(beanName -> {
            String[] aliases = context.getAliases(beanName);
            System.out.println(String.format("beanName: %s, Aliases: %s", beanName, String.join(",", aliases)));
        });

    }

    @Test
    public void getBean1() {
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.asList(beanNames).forEach(beanName -> {
            String[] aliases = context.getAliases(beanName);
            System.out.println(String.format("beanName: %s, Aliases: %s", beanName, String.join(",", aliases)));
        });

    }

    //通过反射调用构造方法创建bean对象
    @Test
    public void constructBean_1() {
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s : %s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void factoryBean() {
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s : %s", beanName, context.getBean(beanName)));
        }
        System.out.println();
        System.out.println("createBeanByFactoryBean : " + context.getBean("createBeanByFactoryBean"));
        System.out.println("createBeanByFactoryBean : " + context.getBean("createBeanByFactoryBean"));
    }


}