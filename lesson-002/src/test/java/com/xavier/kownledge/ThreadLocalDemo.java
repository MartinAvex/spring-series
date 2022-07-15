package com.xavier.kownledge;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    static class LocalVariable {
        private Long[] a = new Long[1024 * 1024];
    }

    // (1)
    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
    // (2)
    final static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<LocalVariable>();

    public static void main(String[] args) throws InterruptedException {

        // (3)
        Thread.sleep(500);
        for (int i = 0; i < 5; ++i) {
            poolExecutor.execute(new Thread(() -> {

                //final ThreadLocal<LocalVariable> localVariable = new ThreadLocal<LocalVariable>();
                // (4)
                localVariable.set(new LocalVariable());
                // (5)
                System.out.println("use local varaible" + localVariable.get());
                localVariable.remove();
            }));
        }
        // (6)
        System.out.println("pool execute over");
    }
}