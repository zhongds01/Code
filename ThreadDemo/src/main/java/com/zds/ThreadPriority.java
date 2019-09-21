package com.zds;

/**
 * Description: 线程优先级(Thread.MAX_PRIORITY:10、Thread.MIN_PRIORITY：1、Thread.NORM_PRIORITY:5)默认5，高优先级不一定先执行
 * Author: zhongds
 * Date : 2019/9/18 16:10
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Runnable run = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行，i=" + i);
            }
        };
        Thread threadA = new Thread(run,"线程A");
        Thread threadB = new Thread(run,"线程B");
        Thread threadC = new Thread(run,"线程C");
        threadA.setPriority(Thread.MAX_PRIORITY);
        threadB.setPriority(Thread.MIN_PRIORITY);
        threadC.setPriority(Thread.MIN_PRIORITY);
        threadA.start();
        threadB.start();
        threadC.start();
        //主线程的优先级
        System.out.println(Thread.currentThread().getPriority());
    }
}
