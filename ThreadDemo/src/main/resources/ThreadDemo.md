###多线程
多线程编程主要就是资源的共享，一个进程中的多个线程可以共享一块资源    
1.  生命周期  
-   正常情况下  
新建（运行start()方法，状态变为就绪）-->就绪（运行run()方法，此时状态变为运行状态）-->运行-->结束
-  非正常情况下  
新建（运行start()方法，状态变为就绪）-->就绪（运行run()方法，获取CPU资源，此时状态变为运行状态）-->运行（时间片用完或者cpu强行终止，状态变为阻塞）-->阻塞（资源就绪，重新回到就绪状态）-->就绪（获取CPU资源）-->运行-->终止（结束）
2. 线程控制
-   一般情况下，Thread用于线程的控制，Runnable用于线程的实现。简单来说，Thread用于启动线程，Runnable接口的run方法中完成业务功能实现
3. start()与run()
-   线程的启动只能通过Thread.start(),调用完start()方法以后，会调用Thread.run()方法（具体原因由系统底层实现native start0()）。run()方法中会判断Thread实例属性中是否有Runnable接口的实例，如果有，执行Runnable接口的run()方法，如果没有，执行用户覆盖的Thread类中的run()方法

        public void run() {
            if (target != null) {
                target.run();
            }
        }
4. 资源共享
-   一般使用Runnable接口的方式实现资源共享。

        ThreadDemo2 threadA = new ThreadDemo2("通过实现Runnable接口的线程A")；
        new Thread(threadA).start();
        new Thread(threadA).start();

5. 进程与线程
-   每一个java程序的执行，都会生成一个java进程，这个进程中会产生一个主线程（main方法线程），主线程创建若干个子线程，所有的线程并行执行
6. 线程休眠
-   Thread.sleep()