package com.zds;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description: some methods about fileinfo
 * author: ZDS
 * create_date : 2019/8/10
 * create_time : 13:34
 */
public class FileInfo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:"+File.separator+"upload"+File.separator+"build.jpg");
        System.out.println("【文件是否可读】："+file.canRead());
        System.out.println("【文件是否可写】："+file.canWrite());
        System.out.println("【文件是否可执行】："+file.canExecute());
        System.out.println("【文件的绝对路径】："+file.getAbsolutePath());
        System.out.println("【文件的相对路径】："+file.getCanonicalPath());
        System.out.println("【路径是否为目录】："+file.isDirectory());
        System.out.println("【路径是否为文件】："+file.isFile());
        System.out.println("【路径表示的文件或目录名称】："+file.getName());
        System.out.println("【路径】："+file.getPath());
        System.out.println("【文件的最后修改时间】："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));//最后修改时间
        System.out.println("【文件的大小】："+String.format("%5.3f",(double)file.length()/(1024*1024)));//文件大小，单位为B
    }
}
