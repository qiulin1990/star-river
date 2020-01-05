package com.cloudwalk.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * md5工具类
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */

public class Md5Util {
    private static Logger logger = LoggerFactory.getLogger(Md5Util.class);
    public static MessageDigest digest = null;
    public static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static {
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static String md5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (str == null) return null;
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] btInput = str.getBytes();
        digest.reset();
        digest.update(btInput);
        byte[] md = digest.digest();
        // 把密文转换成十六进制的字符串形式
        int j = md.length;
        char strChar[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            strChar[k++] = hexDigits[byte0 >>> 4 & 0xf];
            strChar[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(strChar);
    }

    /**
     * @param args
     * @return
     */
    public static String getRowKey(String[] args) {
        String passMd5 = null;
        String rowKey = null;
        StringBuilder str = new StringBuilder();

        try {
            int length = args.length;
            for (int i = 0; i < length; i++) {
                str.append(args[i]);
                if (i < length - 1) {
                    str.append("_");
                }
            }

            String strNew = str.toString();
            passMd5 = Md5Util.md5(strNew);
            rowKey = passMd5.substring(0, 5) + "_" + strNew;
        } catch (UnsupportedEncodingException e) {
            logger.error("getRowKey error", e);
        } catch (NoSuchAlgorithmException e) {
            logger.error("getRowKey error", e);
        }

        return rowKey;

    }
    
    /*	public static void main(String[] args) {
            String passMd5 = null;
            try {
                passMd5 = Md5Util.md5("700000000114733689");
               // System.out.println(IDGenerate.generate("万卡系统","990639072"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            System.out.println(passMd5);
            System.out.println("29.00000000000000040");
            System.out.println(Integer.valueOf("29.00000000000000040"));
		}*/
}
