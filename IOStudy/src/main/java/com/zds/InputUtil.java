package com.zds;

import java.io.*;
import java.util.Scanner;

/**
 * Description: 输入流的几种实现方式
 * Author: zhongds
 * Date : 2019/8/29 19:32
 */
public class InputUtil {
    /**
     * description: 使用inputstream读取键盘输入内容
     * params []
     * return void
     */
    public static void readFun1() throws IOException{
        InputStream inputStream = System.in;
        System.out.println("输入一个数据：");
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println("输入的数据为："+new String(bytes,0,len));
        inputStream.close();
    }
    /**
     * description: 使用bufferreader读取键盘输入内容
     * params []
     * return void
     */
    public static void readFun2() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in,"utf-8"));
        //BufferedReader bufferedReader1 = new BufferedReader(new FileReader(new File("")));
        System.out.println("输入一个数据：");
        String line = bufferedReader.readLine();
        System.out.println("输入的数据为："+line);
        bufferedReader.close();
    }
    /**
     * description: 使用bufferreader读取文件内容
     * params []
     * return void
     */
    public static void readFun3() throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("D:\\projects\\Code\\IOStudy\\src\\main\\resources\\IOStudy.txt")));
        String line = null;
        System.out.println("输入一个数据：");
        while ((line = bufferedReader.readLine())!=null){
            System.out.println("输入的数据为："+line);
        }
        bufferedReader.close();
    }
    /**
     * description: 使用scanner读取键盘输入内容
     * params []
     * return void
     */
    public static void readFun4() throws IOException{
        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter("\n");
        System.out.println("输入一个数据：");
        String line = scanner.next();
        System.out.println("输入的数据为："+line);
        scanner.close();
    }
    /**
     * description: 使用scanner读取文件内容
     * params []
     * return void
     */
    public static void readFun5() throws IOException{
        Scanner scanner = new Scanner(new FileReader(new File("D:\\projects\\Code\\IOStudy\\src\\main\\resources\\IOStudy.txt")));
        scanner.useDelimiter("\r\n");
        while (scanner.hasNext()){
            String line = scanner.next();
            System.out.println(line);
        }
        scanner.close();
    }
    public static void main(String[] args) throws IOException {
//        readFun1();
//        readFun2();
//        readFun3();
        readFun4();
//        readFun5();
    }
}
