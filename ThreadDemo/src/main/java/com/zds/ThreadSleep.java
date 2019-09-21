package com.zds;

/**
 * Description: please add the description
 * Author: zhongds
 * Date : 2019/9/17 17:14
 */
public class ThreadSleep {
    public static void main(String[] args) {
        ThreadDemo4 threadBody = new ThreadDemo4();
        new Thread(threadBody,"线程A").start();
        threadBody.run();
    }
}

class ThreadDemo4 implements Runnable{
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行...");
        }
    }
}
