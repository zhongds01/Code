package com.zds.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * description: 浏览器访问服务器的图片时，会发多次请求
 * author: ZDS
 * create_date : 2019/8/27
 * create_time : 20:57
 */
public class TCPServerThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        OutputStream outputStream = socket.getOutputStream();
                        //System.out.println(inputStream.available());
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        String s = bufferedReader.readLine();
                        System.out.println(s);
                        String[] split = s.split(" ");
                        String htmlpath = split[1].substring(1);
                        System.out.println(htmlpath);

                        // File file = new File(htmlpath);
                        InputStream is = new FileInputStream("D:\\projects\\Code\\JavaSocket\\web\\index.html");
                        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                        outputStream.write("Content-Type:text/html\r\n".getBytes());
                        outputStream.write("\r\n".getBytes());
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = is.read(bytes))!=-1){
                            outputStream.write(bytes,0,len);
                        }
                        is.close();
                        socket.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();

        }

    }
}
