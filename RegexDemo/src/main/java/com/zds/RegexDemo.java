package com.zds;

/**
 * Description: 正则
 * Author: zhongds
 * Date : 2019/9/14 16:08
 */
public class RegexDemo {
    public static void main(String[] args) {
        //用户名正则，4到16位（字母，数字，下划线，减号）
        String regex_name = "[a-zA-Z0-9_-]{4,16}";
        String user_name = "ds1_-";
        System.out.println(user_name.matches(regex_name));
        //密码强度正则，最少6位，包括至少2个大写字母，2个小写字母，1个数字，1个特殊字符
        String regex_pwd = ".*(?=.{6,16})(?=.*\\d)(?=.*[A-Z]{2,})(?=.*[a-z]{2,})(?=.*[!@#$%^&*?\\(\\)]).*";
        String user_pwd = "aAV1dasd#";
        System.out.println(user_pwd.matches(regex_pwd));
        //手机号判断(131，132，159，187，188，177开头等，11位)
        //String regex_phone = "1(3[0-9]|4[5|7|9]|5[0-3|5-9]|7[1-3|5-8]|8[0-9]|9[8-9])[\\d]{8}";
        //改进
        String regex_phone = "1([38][0-9]|4[579]|5[0-35-9]|7[1-35-8]|9[8-9])[\\d]{8}";
        String user_phone = "15560906621";
        System.out.println(user_phone.matches(regex_phone));
        //邮箱判断
        String regex_email = "\\w+@\\w+(\\.\\w+)*\\.\\w+(\\.\\w+)*";
        String user_email = "zhongds01@163.com.cn";
        System.out.println(user_email.matches(regex_email));
    }
}
