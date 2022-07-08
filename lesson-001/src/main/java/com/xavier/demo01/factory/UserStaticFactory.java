package com.xavier.demo01.factory;

import com.xavier.demo01.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserStaticFactory {

    public static final Logger logger = LoggerFactory.getLogger(UserStaticFactory.class);

    public static User userBuilder_1() {
        logger.info(UserStaticFactory.class + ".userBuilder_1()");
        return User.builder().name("No Arguments Constructor Method!").build();
    }

    public static User userBuilder_2(String name, Integer age) {
        logger.info(UserStaticFactory.class + ".builder_2()");
        return User.builder().name(name).age(age).build();
    }

}
