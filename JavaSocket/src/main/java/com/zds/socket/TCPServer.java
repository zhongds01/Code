package com.zds.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * description: socket编程服务器端
 * author: ZDS
 * create_date : 2019/8/26
 * create_time : 21:14
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //实例化一个服务器端对象，主要指定服务器开放的端口
        ServerSocket serverSocket = new ServerSocket(8888);
        //accept()方法用于接收客户端的socket对象实例，通过这个实例进行IO操作
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        len = inputStream.read(bytes);
        //输出从客户端获取的信息
        System.out.println(new String(bytes,0,len));
        //回复客户端，已收到信息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我已收到你的问候，谢谢！".getBytes());
        socket.close();
        serverSocket.close();
    }
}
