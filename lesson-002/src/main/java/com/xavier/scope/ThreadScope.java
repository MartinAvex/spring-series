package com.xavier.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 需求中要求bean在线程中是贡献的，所以我们可以通过ThreadLocal来实现，ThreadLocal可以实现线程中数据的共享。
 */
public class ThreadScope implements Scope {

    private static final Logger log = LoggerFactory.getLogger(ThreadScope.class);

    public static final String THREAD_SCOPE = "thread";

    private ThreadLocal<Map<String, Object>> beanMap = new ThreadLocal() {
        @Override
        protected Map<String, Integer> initialValue() {
            return new HashMap<>();
        }
    };

    @Override
    public Object get(String beanName, ObjectFactory<?> objectFactory) {
        Object bean = beanMap.get().get(beanName);
        if (Objects.isNull(bean)) {
            bean = objectFactory.getObject();
            beanMap.get().put(beanName, bean);
        }
        return bean;
    }

    @Nullable
    @Override
    public Object remove(String beanName) {
        return beanMap.get().remove(beanName);
    }

    @Override
    public void registerDestructionCallback(String beanName, Runnable runnable) {
        //bean作用域范围结束的时候调用的方法，用于bean清理
        log.info(beanName);
    }

    @Nullable
    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Nullable
    @Override
    public String getConversationId() {
        return Thread.currentThread().getName();
    }

}
