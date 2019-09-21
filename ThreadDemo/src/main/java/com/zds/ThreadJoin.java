package com.zds;

/**
 * Description: 线程的强制执行(join)
 * Author: zhongds
 * Date : 2019/9/18 15:34
 */
public class ThreadJoin {
    public static void main(String[] args) {
        Thread threadMain = Thread.currentThread();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                //执行到一半让主线程强制执行
                if (i == 50) {
                    try {
                        threadMain.join(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "执行，i=" + i);
            }
        }, "子线程A").start();
        for (int j = 0; j < 100; j++) {
            System.out.println(Thread.currentThread().getName() + "执行，j=" + j);
        }

    }
}
