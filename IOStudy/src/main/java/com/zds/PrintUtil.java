package com.zds;

import java.io.*;

/**
 * description: 打印流案例
 * PrintWriter: 字符输出流，不需要手动清除缓存区（遇到换行就会自动刷新）,一般用于二进制数据操作
 * PrintStream: 字节输出流，必须手动清除缓存区（flush、close）才能完成输出操作。一般用于文本操作
 * author: ZDS
 * create_date : 2019/8/29
 * create_time : 18:19
 */
public class PrintUtil {
    /**
     * description: fileWriter
     * params []
     * return void
     */
    public static void fileWriter() {
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("D:"+File.separator+"demo.txt")));
            printWriter.print(1);
            printWriter.print("、你好\r\n");
            printWriter.print(2);
            printWriter.println("、中国");
            printWriter.print(3);
            printWriter.println("、世界");
            printWriter.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    /**
     * description: consoleWriter
     * params []
     * return void
     */
    public static void consoleWriter() {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print(1);
        printWriter.print("、你好\r\n");
        printWriter.print(2);
        printWriter.println("、中国");
        printWriter.print(3);
        printWriter.println("、世界");
        printWriter.printf("%d、%s π=%3.2f",4,"高尔夫",3.1415926);
        printWriter.close();

    }
    /**
     * description: fileStream
     * params []
     * return void
     */
    public static void fileStream() {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(new File("D:"+File.separator+"demo.txt")));
            printStream.print(1);
            printStream.print("、你好\r\n");
            printStream.print(2);
            printStream.println("、中国");
            printStream.print(3);
            printStream.println("、世界");
            printStream.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    /**
     * description: consoleStream
     * params []
     * return void
     */
    public static void consoleStream() {
        PrintStream printStream = new PrintStream(System.out);
        printStream.write(1);
        printStream.print(1);
        printStream.print("、你好\r\n");
        printStream.print(2);
        printStream.println("、中国");
        printStream.print(3);
        printStream.println("、世界");
        printStream.close();

    }
    public static void main(String[] args) {
        fileWriter();
        consoleWriter();
        fileStream();
        consoleStream();
    }
}
