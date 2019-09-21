package com.zds;


/**
 * Description: please add the description
 * Author: zhongds
 * Date : 2019/9/18 17:54
 */

public class ThreadModel {
    public static void main(String[] args) {
        Message message = new Message();
        ThreadConsumer threadConsumer = new ThreadConsumer(message);
        ThreadProducer threadProducer = new ThreadProducer(message);
        new Thread(threadConsumer, "消费线程").start();
        new Thread(threadProducer, "生产线程").start();
    }
}
/**
 * description: 生产者线程模型
 * params
 * return
 */
class ThreadProducer implements Runnable {
    private Message message;
    public ThreadProducer(Message message) {
        this.message = message;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 2 == 0) {
                this.message.set("周杰伦", "男");
            } else {
                this.message.set("王祖贤", "女");
            }
//            System.out.println(message);
        }
    }
}
/**
 * description: 消费者线程模型
 * params
 * return
 */
class ThreadConsumer implements Runnable {
    private Message message;

    public ThreadConsumer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.message.get();
        }
    }
}
/**
 * description: 共享资源类
 * params
 * return
 */
class Message {
    private boolean flag = true;
    private String name;
    private String sex;

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }


    public synchronized void set(String name, String sex) {
        if (!flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.sex = sex;
        this.flag = false;
        super.notify();
    }

    public synchronized void get() {
        if (flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "-" + this.sex);
        this.flag = true;
        super.notify();


    }


//    public synchronized void set(String name, String sex) {
//        if (flag) {
//            this.name = name;
//            this.sex = sex;
//            this.flag = false;
//            super.notify();
//        }
//        try {
//            super.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public synchronized void get() {
//        if (!flag) {
//            System.out.println(this.name + "-" + this.sex);
//            this.flag = true;
//            super.notify();
//        }
//        try {
//            super.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}

