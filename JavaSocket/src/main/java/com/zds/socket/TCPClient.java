package com.zds.socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * description: 客户端类
 * author: ZDS
 * create_date : 2019/8/26
 * create_time : 21:14
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //三次握手发生在建立socket实例时候，如果服务器服务未启动，握手不成功，代码报错
        Socket socket = new Socket("127.0.0.1",8888);
        //向服务器发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好！服务器，我是客户端".getBytes());
        //接收服务器的反馈信息
        InputStream inputStream = socket.getInputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        socket.close();
    }
}
