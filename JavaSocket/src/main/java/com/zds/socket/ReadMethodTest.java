package com.zds.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * description: 关于read的返回值问题，当读取到文件末尾（流末尾），返回-1
 * author: ZDS
 * create_date : 2019/8/26
 * create_time : 22:23
 */
public class ReadMethodTest {
        public static void main(String[] args) throws IOException {
        File file = new File("D:"+File.separator+"Sql脚本"+File.separator+"根据操作ID对比配置.sql");

        InputStream inputStream = new FileInputStream(file);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1){
            System.out.println(len);
        }
        System.out.println(len);
        inputStream.close();
    }
}
