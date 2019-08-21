package com.zds;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/8/9
 * create_time : 17:40
 */
public class IOTest {
    public static void main(String[] args) throws IOException {
        test();
    }
    public static void test() throws IOException {
        File file = new File("a.txt");
        byte[]  bytes= new byte[10];
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(65);
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        int len = fileInputStream.read(bytes);
        System.out.println(new String(bytes,0, len));
        fileInputStream.close();

    }
}
