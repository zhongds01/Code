package com.zds.upload;

import java.io.*;
import java.net.Socket;

/**
 * description: 文件上传客户端
 * author: ZDS
 * create_date : 2019/8/26
 * create_time : 21:43
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        //读取本地磁盘的文件，通过socket获取的输出流上传到服务器
        File file = new File("D:"+File.separator+"upload"+File.separator+"build.jpg");
        InputStream inputStream = new FileInputStream(file);
        //System.out.println(inputStream.available());
        OutputStream outputStream = socket.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1){
            outputStream.write(bytes);
        }
        /*
        *很重要，因为在while循环中，当len=-1时，不会执行循环体中的语句，
        *也就是-1（文件读取结束标志）不会被上传到服务器，所以需要手动告知服务器已读取完毕
         */
        socket.shutdownOutput();
        InputStream socketInputStream = socket.getInputStream();
        len = socketInputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        inputStream.close();
        socket.close();
    }
}
