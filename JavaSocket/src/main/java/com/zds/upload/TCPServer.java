package com.zds.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * description: 文件上传服务器端
 * author: ZDS
 * create_date : 2019/8/26
 * create_time : 21:43
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        //读取文件流并写入服务器本地的磁盘中
        File file = new File("D:"+ File.separator+"upload");
        if (!file.exists()){
            file.mkdirs();
        }

        byte[] bytes = new byte[1024];
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        int len = 0;
                        //获取客户端上传的文件流
                        InputStream inputStream = socket.getInputStream();
                        //System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                        OutputStream outputStream = new FileOutputStream(file+File.separator+ UUID.randomUUID()+".jpg");
                        while ((len = inputStream.read(bytes))!=-1){
                            outputStream.write(bytes);
                        }
                        //回复客户端
                        OutputStream socketOutputStream = socket.getOutputStream();
                        socketOutputStream.write("文件上传成功！".getBytes("utf-8"));
                        //关闭流
                        outputStream.close();
                        socket.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                }
            }).start();

            //serverSocket.close();
        }

    }
}
