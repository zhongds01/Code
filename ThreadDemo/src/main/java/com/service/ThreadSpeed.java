package com.service;

/**
 * Description: please add the description
 * Author: zhongds
 * Date : 2019/9/21 11:43
 */

public class ThreadSpeed {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(() -> {
            resource.create();
        }, "生产电脑线程").start();
        new Thread(() -> {
            resource.get();
        }, "取走电脑线程").start();
    }
}

class ComputerInfo {
    private String brand;
    private double price;

    public ComputerInfo(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ComputerInfo{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}

class Resource {
    private int num = 0;
    ComputerInfo computerInfo = null;

    public synchronized void create() {
        for (int i = 0; i < 10; i++) {
            if (computerInfo != null) {
                try {
                    super.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 2 == 0) {
                computerInfo = new ComputerInfo("Dell", 4999);
            } else {
                computerInfo = new ComputerInfo("Lenovo", 6333);
            }
            System.out.println("+++++++++" + Thread.currentThread().getName() + "线程生产电脑" + computerInfo);
            super.notify();
        }

    }

    public synchronized void get() {
        for (int i = 0; i < 10; i++) {
            if (computerInfo == null) {
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
            System.out.println("---------" + Thread.currentThread().getName() + "取走电脑" + computerInfo);
            computerInfo = null;
            super.notify();
        }
    }
}
