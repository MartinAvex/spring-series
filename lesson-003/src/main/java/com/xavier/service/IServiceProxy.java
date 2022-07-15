package com.xavier.service;

public class IServiceProxy implements IService{

    public IService target;

    public IServiceProxy(IService target) {
        this.target = target;
    }

    @Override
    public void method_1() {
        long start = System.nanoTime();
        target.method_1();
        long end = System.nanoTime();
        System.out.println("耗时：" + (end-start));
    }

    @Override
    public void method_2() {
        long start = System.nanoTime();
        target.method_2();
        long end = System.nanoTime();
        System.out.println("耗时：" + (end-start));
    }

    @Override
    public void method_3() {
        long start = System.nanoTime();
        target.method_3();
        long end = System.nanoTime();
        System.out.println("耗时：" + (end-start));
    }
}
