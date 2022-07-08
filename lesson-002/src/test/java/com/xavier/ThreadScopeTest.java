package com.xavier;

import com.xavier.scope.ThreadScope;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class ThreadScopeTest {

    public static void main(String[] args) throws InterruptedException {
        //创建容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext() {
            @Override
            protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
                beanFactory.registerScope(ThreadScope.THREAD_SCOPE, new ThreadScope());
                super.postProcessBeanFactory(beanFactory);
            }
        };
        //设置配置文件路径
        context.setConfigLocation("bean.xml");
        //启动容器
        context.refresh();

        //使用容器获取bean
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread() + "," + context.getBean("threadBean"));
                System.out.println(Thread.currentThread() + "," + context.getBean("threadBean"));
            }).start();
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
