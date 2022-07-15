package com.xavier.demo01.bean;

public class Singleton {

    private volatile static Singleton SINGLETON_INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        if (SINGLETON_INSTANCE == null) {
            synchronized (Singleton.class) {
                if (SINGLETON_INSTANCE == null) {
                    SINGLETON_INSTANCE = new Singleton();
                }
            }
        }
        return SINGLETON_INSTANCE;
    }

}
