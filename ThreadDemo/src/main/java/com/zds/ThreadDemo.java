package com.zds;


import java.util.concurrent.Callable;

/**
 * Description: 多线程
 * Author: zhongds
 * Date : 2019/9/16 15:23
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //继承Thread类的线程启动
//        ThreadDemo1 threadA = new ThreadDemo1("通过继承Thread类的线程A");
//        ThreadDemo1 threadB = new ThreadDemo1("通过继承Thread类的线程B");
//        threadA.start();
//        threadB.start();
        //实现Runnable接口的线程启动
        ThreadDemo2 threadBody = new ThreadDemo2();
        new Thread(threadBody, "进程A").start();
        new Thread(threadBody, "进程B").start();



        //实现Runnable接口的线程启动改进Lambda
//        String[] thread_names = new String[]{"通过Lambda表达式改进线程A","通过Lambda表达式改进线程B"};
//        for (String thread_name : thread_names) {
//            new Thread(()->{
//                for (int j=0;j<10;j++){
//                    System.out.println(thread_name+"运行，j="+j);
//                }
//            }).start();
//        }
//        String[] thread_namess = new String[]{"未改进线程C","未改进线程D"};
//        for (String thread_name : thread_namess) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int j=0;j<10;j++){
//                        System.out.println(thread_name+"运行，j="+j);
//                    }
//                }
//            }).start();
//        }
    }


}

/**
 * description: 通过继承Thread类实现多线程
 */
class ThreadDemo1 extends Thread{
    private String thread_name;

    public ThreadDemo1(String thread_name) {
        this.thread_name = thread_name;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(thread_name+"运行，i="+i);
        }
    }
}
/**
 * description: 通过实现Runnable接口实现多线程
 */
class ThreadDemo2 implements Runnable{
    private int ticket = 20;
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+"正在卖票，ticket="+ticket--);
            }
        }
    }
}
/**
 * description: 通过实现Callable接口实现多线程
 */
class ThreadDemo3 implements Callable<ThreadDemo2> {
    public ThreadDemo2 call() throws Exception {
        return null;
    }
}
