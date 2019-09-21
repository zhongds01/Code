package com.service;

/**
 * Description: please add the description
 * Author: zhongds
 * Date : 2019/9/19 20:07
 */
class ComputerConsumer implements Runnable {
    private Computer computer;

    public ComputerConsumer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                this.computer.comsumer();
            }
        }

    }
}

class ComputerProducer implements Runnable {
    private Computer computer;
    public ComputerProducer(Computer computer){
        this.computer = computer;
    }
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                this.computer.make();
            }
        }
    }
    public synchronized int getMount(){
        return this.computer.getMount();
    }
}

class Computer {
    private int mount = 0;
    private boolean flag = true;
    //flag=true,只能生产,不能消费
    //flag=false,只能消费,不能生产

    public synchronized int getMount() {
        return mount;
    }


    /**
     * description: 电脑生产方法
     * params []
     * return int
     */
    public synchronized void make(){
        if (!this.flag){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"生产了一台电脑,电脑数量为:"+(++mount));

        this.flag = false;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.notify();
    }
    /**
     * description: 电脑消费方法
     * params []
     * return void
     */
    public synchronized void comsumer(){
        if (this.flag){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"取走了一台电脑");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.flag = true;
        super.notify();
    }
}

public class ThreadComputer {
    public static void main(String[] args) {
        Computer computer = new Computer();
        ComputerProducer computerProducer = new ComputerProducer(computer);
        ComputerConsumer computerConsumer = new ComputerConsumer(computer);
        Thread threadA = new Thread(computerProducer,"生产电脑线程A");
        Thread threadB = new Thread(computerProducer,"生产电脑线程B");
        Thread threadC = new Thread(computerConsumer,"生产电脑线程C");
        Thread threadD = new Thread(computerConsumer,"生产电脑线程D");
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        new Thread(computerProducer,"获取电脑数量线程").start();
        System.out.println("生产的电脑总数为:"+computerProducer.getMount());
    }
}
