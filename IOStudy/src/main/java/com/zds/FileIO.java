package com.zds;

import java.io.*;

/**
 * description: 字节流与字符流区别在于字符流需要将缓冲区清楚以后，才能将数据真正的写进文件中。
 * author: ZDS
 * create_date : 2019/8/20
 * create_time : 22:12
 */
public class FileIO {
    public static void main(String[] args) throws IOException {
//        fileWriter();
//        fileOutputStream();
        fileInputStream();
//        fileReader();
    }

    /**
     * 文件字节输出流方法
     * @throws IOException
     */
    public static void fileOutputStream() throws IOException {
        File file = new File("./src/main/resources/info.txt");
        //true表示不覆盖文件内容
        OutputStream outputStream = new FileOutputStream(file,true);
        outputStream.write("this is hello\n小哥哥!".getBytes());
        outputStream.close();
    }

    /**
     * 文件字节输入流
     * read()方法逐个读取流中的字节，读到最后返回-1
     * @throws IOException
     */
    public static void fileInputStream() throws IOException {
        File file = new File("./src/main/resources/info.txt");
        InputStream inputStream = new FileInputStream(file);
        byte info[] = new byte[1024];
        //输出输入字节流可用的大小
        //System.out.println(inputStream.available());
        //read(info)返回值为输入流读取到的字节个数,如果输入流读取完毕，返回-1
        int num = inputStream.read(info);
        System.out.println(num);
        //测试读取完毕是否返回-1
        num = inputStream.read(info);
        System.out.println(num);
        //System.out.println(new String(info,0,num));
        inputStream.close();
    }

    /**
     * 文件字符输出流
     * writer与append方法区别在于append参数可以为空。
     * @throws IOException
     */
    public static void fileWriter() throws IOException {
        File file = new File("./src/main/resources/info.txt");
        Writer writer = new FileWriter(file);
        writer.write("hello,characters\n");
        //writer.append("");
        //此处必须使用flush()或者close()
        //writer.flush();
        writer.close();
    }

    /**
     * 文件字符输入流
     * @throws IOException
     */
    public static void fileReader() throws IOException {
        File file = new File("./src/main/resources/info.txt");
        Reader reader = new FileReader(file);
//        逐一读取(不推荐)
//        while (!(reader.read()==-1)){
//            System.out.println((char)reader.read());
//        }
        char[] data = new char[1024];
        int len = reader.read(data);
        System.out.println(new String (data,0,len));
        reader.close();
    }
}
