package com.xavier.service;


import org.junit.Test;

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

}