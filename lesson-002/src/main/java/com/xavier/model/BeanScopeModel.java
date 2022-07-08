package com.xavier.model;

public class BeanScopeModel {

    public BeanScopeModel(String beanScope) {
        System.out.println(String.format("Thread: %s, create beanScopeModel -- {scope = %s} , {this = %s}", Thread.currentThread(), beanScope, this));
    }
}
