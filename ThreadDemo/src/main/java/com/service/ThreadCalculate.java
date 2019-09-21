package com.service;

/**
 * Description: 完成加减法
 * Author: zhongds
 * Date : 2019/9/19 19:54
 */
class Number{
    private int num = 0;
    private boolean flag = true;
    public synchronized void add(){
        for (int i = 0; i < 5; i++) {
            if (!flag){
                try {
                    super.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"线程执行加法操作,num="+(++num));
            this.flag = false;
            super.notify();
        }
    }
    public synchronized void sub(){
        for (int i = 0; i < 5; i++) {
            if (flag){
                try {
                    super.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"线程执行减法操作,num="+(--num));
            this.flag = true;
            super.notify();
        }
    }

}
class Addition implements Runnable{
    private Number number;
    public Addition(Number number){
        this.number = number;
    }
    @Override
    public void run() {
        synchronized (this){
            number.add();
        }
    }
}
class Substruction implements Runnable{
    private Number number;
    public Substruction(Number number){
        this.number = number;
    }
    @Override
    public void run() {
        synchronized (this){
            number.sub();
        }

    }
}
public class ThreadCalculate {
    public static void main(String[] args) {
        Number number = new Number();
        Addition addition = new Addition(number);
        Substruction substruction = new Substruction(number);
        Thread threadA = new Thread(addition,"加法线程A");
        Thread threadB = new Thread(addition,"加法线程B");
        Thread threadC = new Thread(substruction,"减法线程C");
        Thread threadD = new Thread(substruction,"减法线程D");
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
