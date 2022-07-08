package com.xavier.demo01.factory;

import com.xavier.demo01.bean.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

import java.util.concurrent.atomic.AtomicInteger;

public class UserFactoryBean implements FactoryBean<User> {

    private static final AtomicInteger counter = new AtomicInteger();

    @Nullable
    @Override
    public User getObject() throws Exception {
        return User.builder().name("This is No." + counter.incrementAndGet() + " Object").build();
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

}
