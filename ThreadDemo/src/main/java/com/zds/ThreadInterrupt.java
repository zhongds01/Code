package com.zds;

/**
 * Description: please add the description
 * Author: zhongds
 * Date : 2019/9/18 14:58
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"线程执行。。。,准备休息10s");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName()+"线程执行。。。,休眠完毕");
            } catch (InterruptedException e) {
                System.out.println("休息被中断。。。");
            }
        });
        thread.start();
        System.out.println(thread.getName()+"线程是否被中断："+thread.isInterrupted());
        //Thread.sleep(5000);
        thread.interrupt();
        System.out.println(thread.getName()+"线程是否被中断："+thread.isInterrupted());
    }
}

