package com.zds;

/**
 * Description: 线程礼让
 * Author: zhongds
 * Date : 2019/9/18 15:56
 */
public class ThreadYield {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 3 == 0) {
                    Thread.yield();
                    System.out.println(Thread.currentThread().getName() + "开始礼让。。。");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行,i=" + i);
            }
        }, "礼让线程").start();
        for (int j = 0; j < 100; j++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "线程执行,j=" + j);
        }
    }
}
