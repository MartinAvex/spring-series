package com.xavier.service;


import com.xavier.invocation.CostTimeInvocationHandler;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class IServiceTest{

    @Test
    public void IServiceTest() {
        IServiceImpl_1 iServiceImpl_1 = new IServiceImpl_1();
        IServiceImpl_2 iServiceImpl_2 = new IServiceImpl_2();
        iServiceImpl_1.method_1();
        iServiceImpl_1.method_2();
        iServiceImpl_1.method_3();

        iServiceImpl_2.method_1();
        iServiceImpl_2.method_2();
        iServiceImpl_2.method_3();
    }

    @Test
    public void JDKProxy() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1、获取接口代理类的class对象
        Class<IService> proxyClass = (Class<IService>) Proxy.getProxyClass(IService.class.getClassLoader(), IService.class);
        //2、创建代理类处理器
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("I am InvocationHandler and calling " + method.getName());
                return null;
            }
        };
        //3、创建代理实例
        IService proxyService = proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);
        proxyService.method_1();
        proxyService.method_2();
        proxyService.method_3();
    }

    @Test
    public void JDKProxySimple() {
        //1、创建代理类处理器
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("I am InvocationHandler and calling " + method.getName());
                return null;
            }
        };

        //2、创建代理实例
        IService proxyInstance = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class[]{IService.class}, invocationHandler);
        //3、调用代理方法
        proxyInstance.method_1();
        proxyInstance.method_2();
        proxyInstance.method_3();
    }

    @Test
    public void autoJDKProxy() {
        IService proxy = CostTimeInvocationHandler.createProxy(new IServiceImpl_1());
        proxy.method_1();
        proxy.method_2();
        proxy.method_3();
    }

}