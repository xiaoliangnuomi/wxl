package com.xl.utils;
import java.security.MessageDigest;
import java.util.Date;

/*
 * 负责给字符串数据进行加密
 */
public class MD5Utils<main> {

    public static String str2MD5(String strs) {
        /*
         * 加密需要使用JDK中提供的类
         */
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bs = digest.digest(strs.getBytes());
            /*
             * 加密后的数据是-128 到 127 之间的数字，这个数字也不安全。 
             * 取出每个数组的某些二进制位进行某些运算，得到一个新的加密结果
             * 
             *  0000 0011 0000 0100 0010 0000 0110 0001
             * &0000 0000 0000 0000 0000 0000 1111 1111
             * ---------------------------------------------
             *  0000 0000 0000 0000 0000 0000 0110 0001
             * 
             *  把取出的数据转成十六进制数
             */
            for (byte b : bs) {
                int x = b & 255;
                String s = Integer.toHexString(x);
                if (x < 16) {
                    sb.append("0");
                }
                sb.append(s);
            }

        } catch (Exception e) {
            System.out.println(strs+"----"+e);
            System.out.println("加密失败");
        }
        return sb.toString();
    }

    public final static String MD5(String pswd) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = pswd.getBytes();
            // 使用MD5创建MessageDigest对象
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte b = md[i];
                // System.out.println((int)b);
                // 将没个数(int)b进行双字节加密
                str[k++] = hexDigits[b >> 4 & 0xf];
                str[k++] = hexDigits[b & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "dft";
        }
    }
    public static void main(String[] args) {
        String pw = str2MD5("神州云动"+"shenzhouyundongA123"+new Date().toString());
//        String pw = str2MD5("scfx1234");
        System.out.println(pw);
        //60c09a2472b9879544a107d59eed0a5c
    }
}

