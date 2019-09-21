package com.zds;


/**
 * Description: String类型与其他类型的转换
 * Author: zhongds
 * Date : 2019/9/14 16:36
 */
public class StringDemo {
    public static void main(String[] args) throws Exception {
        String str = "123456789";
        //String转换为整型
        int i = Integer.parseInt(str);
        //整型转化为字符串
        str = String.valueOf(i);
        System.out.println("转换为整型"+i);
        //String转换为浮点型
        double v = Double.parseDouble(str);
        System.out.println("转换为浮点型"+v);
        //转化为字符数组(拆分为字符)
        char[] chars = str.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            System.out.println(chars[j]);
        }
        //转化为字节数组(拆分为字节)
        byte[] bytes = str.getBytes();
        for (int j = 0; j < bytes.length; j++) {
            System.out.println(bytes[j]);
            System.out.println((char) bytes[j]);
        }

    }
}
