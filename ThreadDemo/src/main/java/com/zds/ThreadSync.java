package com.zds;

/**
 * Description: 线程同步 synchronized修饰的代码块某一时间只能被一个线程访问
 * 通过与在run()前加上synchronized关键字作比较
 * Author: zhongds
 * Date : 2019/9/18 16:52
 */
public class ThreadSync implements Runnable {
    private int ticket = 200000;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            synchronized (this) {
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在售票,当前票数还剩" + ticket--);
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadSync threadBody = new ThreadSync();
        Thread threadA = new Thread(threadBody, "卖票窗口1");
        Thread threadB = new Thread(threadBody, "卖票窗口2");
        Thread threadC = new Thread(threadBody, "卖票窗口3");
        threadA.start();
        threadB.start();
        threadC.start();
    }

}
