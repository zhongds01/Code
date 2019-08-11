package com.zds;

import java.io.File;

/**
 * description: 目录以及子目录的遍历
 * author: ZDS
 * create_date : 2019/8/11
 * create_time : 14:48
 */
public class DirInfo {
    public static void main(String[] args) {
        File file = new File("d:" + File.separator + "upload");
        //getDirAndFileOne(file);
        getDirAndFileTwo(file);
        /*File file1 = new File("d:" + File.separator + "upload" + File.separator + "test");
        deleteFloderAndFile(file1);*/
    }

    public static void getDirAndFileOne(File file){
        if (file.isDirectory()){
            String[] list = file.list();
            for (String s : list) {
                System.out.println(s);
            }
        }else {
            System.out.println(file.getPath()+"不是一个目录，无法遍历");
        }
    }

    public static void getDirAndFileTwo(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files!=null){
                for (int i = 0; i < files.length; i++) {
                    getDirAndFileTwo(files[i]);
                }
            }
        }else {
            System.out.println(file);
        }

    }

    /**
     * 删除文件夹下所有内容
     * @param file
     */
    private static void deleteFloderAndFile(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files!=null){
                for (File file1 : files) {
                    deleteFloderAndFile(file1);
                }
            }
        }
        System.out.println("即将删除"+file.getName());
        file.delete();
    }
}
