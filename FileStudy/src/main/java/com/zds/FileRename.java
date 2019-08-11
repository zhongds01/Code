package com.zds;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * description: 大量文件的重命名
 * author: ZDS
 * create_date : 2019/8/11
 * create_time : 16:00
 */
public class FileRename {
    public static int maxLength = 0;
    public static int length = 0;
    public static StringBuffer newName = null;
    public static String substring = null;
    public static String baoliuString = null;
    public static String maxLengthFileName = null;
    public static String parentFileName = null;
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "logs");
        //createFile(file);
        fileInit(file);
        fileRename(file);
    }
    private static String getDate(){
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }
    private static void fileInit(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();//列出所有的子目录
            if (files!=null){
                for (int i = 0; i < files.length; i++) {
                    fileInit(files[i]);
                }
            }
        }else{
            if (file.isFile()){//进行对文件名称的修改
                if (file.getName().matches("\\d{14}_\\d{1,}\\.log")){
                    //System.out.println(file.getName());
                    //取最大长度
                    if (file.getName().length()>maxLength){
                        maxLength = file.getName().length();
                        //System.out.println(maxLength);
                        //记录最长文件名称
                        maxLengthFileName = file.getName();
                        //截取每个文件不一样的地方(截去文件相同的地方)
                        substring = maxLengthFileName.substring(maxLengthFileName.lastIndexOf("_")+1, maxLengthFileName.lastIndexOf("."));
                        //System.out.println("****"+substring);
                        baoliuString = maxLengthFileName.substring(0,15);
                        //System.out.println(baoliuString);
                        length = substring.length();
                        //System.out.println("最大文件长度"+length);
                    }
                }
            }
        }

        //System.out.println(file.getName());
    }
    private static void fileRename(File file){
       /* System.out.println("需要修改的地方"+substring);
        System.out.println("保留字符串"+baoliuString);
        System.out.println("修改的位数"+length);
        System.out.println("最长文件名称"+maxLengthFileName);
        System.out.println("最大文件长度"+maxLength);*/

        if (file.isDirectory()){
            File[] files = file.listFiles();//列出所有的子目录
            if (files!=null){
                for (int i = 0; i < files.length; i++) {
                    fileRename(files[i]);
                }
            }
        }else {
            if (file.isFile()) {
                if (file.getName().matches("\\d{14}_\\d{1,}\\.log")) {
                    //此处修改名称
                    parentFileName = file.getParentFile().toString();
                    //System.out.println(file.getName().substring(file.getName().lastIndexOf("_")+1, file.getName().lastIndexOf(".")));
                    StringBuffer stringBuffer = new StringBuffer(file.getName().substring(file.getName().lastIndexOf("_")+1, file.getName().lastIndexOf(".")));
                    //System.out.println(stringBuffer.insert(0, "0"));
                    int tempLength = file.getName().length();
                    //System.out.println(tempLength);
                    while (tempLength<maxLength){
                        stringBuffer.insert(0, "0");
                        tempLength++;
                    }
                    newName = new StringBuffer(parentFileName).append(File.separator).append(baoliuString).append(stringBuffer).append(".log");
                    //System.out.println(newName);
                    file.renameTo(new File(newName.toString()));
                }
            }
        }

    }
    private static void createFile(File file) throws IOException {
        for (int i = 1; i < 5; i++) {
            new File(file,getDate()+"_"+i+".log").createNewFile();
        }
    }
}
