package com.zds;

import java.io.File;
import java.io.IOException;

/**
 * description: File操作基础之文件的创建
 * author: ZDS
 * create_date : 2019/8/9
 * create_time : 18:45
 */
public class FileDemo {
    private static File file = new File("d:"+File.separator+"FileDemo"+File.separator+"demo.txt");//定义一个要操作的文件路径，该路径可以不存在
    //private static File file = new File("d:"+File.separator+"demo.txt");
    static {
        if (!file.getParentFile().exists()){//判断父目录是否存在
            file.getParentFile().mkdirs();//创建父目录
        }
    }
    public static void main(String[] args) throws IOException {
        if (file.exists()){
            System.out.println("文件存在，执行删除操作。。。"+file.delete());//delete不仅可以删除文件，还可以删除文件夹
        }else {
            System.out.println("文件不存在，执行创建操作。。。"+file.createNewFile());
        }
    }
}
