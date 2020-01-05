package com.cloudwalk.util;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 字符串工具类
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */
public final class StringUtil {

    private static final String EMPTY = "";
    private static String reg = "^(\\-|\\+)?\\d+(\\.\\d+)?$";

    /**
     * Returns the first sub string after target and exclude target.
     *
     * @param str
     * @param target
     * @return String
     */
    public static String afterString(String str, String target) {
        //
        if (str == null || target == null) {
            return str;
        }
        //
        int begin = str.indexOf(target);
        if (begin < 0) {
            return str;
        }
        //
        return str.substring(begin + target.length());
    }

    /**
     * Returns the first sub string before target and exclude target.
     *
     * @param str
     * @param target
     * @return String
     */
    public static String beforeString(String str, String target) {
        //
        if (str == null || target == null) {
            return str;
        }
        //
        int begin = str.indexOf(target);
        if (begin < 0) {
            return str;
        }
        //
        return str.substring(0, begin);
    }

    public static String toString(Object obj) {
        if (obj == null)
            return null;
        return obj.toString();
    }

    /**
     * Returns if a string is real blank.
     *
     * @param target
     * @return boolean
     */
    public static boolean isBlank(Object target) {
        return (target == null || "".equals(target.toString().trim()));
    }

    public static boolean isBlankStr(String target) {
        return (target == null || "".equals(target.trim()))
                || "NULL".equals(target.trim().toUpperCase());
    }

    /**
     * @param target
     * @return
     */
    public static boolean isPureDigital(String target) {

        if (target != null) {
            return target.matches(reg) ? true : false;
        } else {
            return false;
        }
    }

    /*
     * public static void main(String[] args) { String regs = "^[A-Za-z0-9]{5}";
     * String s =
     * "01090_700000000114734498 column=f:riskExplain_list, timestamp=1490860284808, value=\\xE9\\x80\\xBE\\xE6\\x9C\\x9F 1 \\xE6\\x9C\\x9F"
     * ; System.out.println(s.matches(regs)); }
     */

    /**
     * Returns string compare result.
     *
     * @param str1
     * @param str2
     * @return boolean
     */
    public static boolean compare(String str1, String str2) {
        //
        return (str1 != null ? str1.equals(str2) : (str2 == null));
    }

    public static String join(Object[] array) {
        return join(array, null);
    }

    public static String join(Object[] array, String separator) {
        if (array == null) {
            return null;
        }
        return join(array, separator, 0, array.length);
    }

    public static String join(Object[] array, String separator, int startIndex,
                              int endIndex) {
        if (array == null) {
            return null;
        }
        if (separator == null) {
            separator = EMPTY;
        }

        int bufSize = (endIndex - startIndex);
        if (bufSize <= 0) {
            return EMPTY;
        }

        bufSize *= ((array[startIndex] == null ? 16 : array[startIndex]
                .toString().length()) + separator.length());

        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = startIndex; i < endIndex; i++) {
            if (i > startIndex) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }

    public static String nullWithDefault(Object value, String defaultStr) {
        return value == null ? defaultStr : String.valueOf(value);
    }

    public static String toUtf8String(HttpServletRequest request, String s) {
        String agent = request.getHeader("User-Agent");
        try {
            boolean isFireFox = (agent != null && agent.toLowerCase().indexOf(
                    "firefox") != -1);
            if (isFireFox) {
                s = new String(s.getBytes("UTF-8"), "ISO8859-1");
            } else {
                s = toUtf8String(s);
                if ((agent != null && agent.indexOf("MSIE") != -1)) {
                    // see http://support.microsoft.com/default.aspx?kbid=816868
                    if (s.length() > 150) {
                        // 根据request的locale 得出可能的编码
                        s = new String(s.getBytes("UTF-8"), "ISO8859-1");
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    // "将文件名中的汉字转为UTF8编码的串时错误，输入的字符串为：" + s);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0)
                        k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }

    /**
     * 如果为空则返回零
     *
     * @param str
     * @return
     */
    public static String turnNull2Zero(String str) {
        return StringUtil.isBlankStr(str) ? "0" : str;
    }

    /**
     * @param str
     * @return
     */
    public static String upperFirstLetter(String str) {
        if (str == null)
            return null;
        StringBuffer result = new StringBuffer();
        result.append(str.substring(0, 1).toUpperCase()).append(
                str.substring(1));
        return result.toString();
    }

    public static List<String> toList(String str, String splitStr) {
        if (str == null)
            return null;
        List<String> list = new ArrayList<>();
        String[] strs = str.split(splitStr);

        for (int i = 0, len = strs.length; i < len; i++) {
            list.add(strs[i]);
        }
        return list;

    }

    public static String featuresAttributeStr(String srcStr) {
        String newString = "";
        int first = 0;
        while (srcStr.indexOf("_") != -1) {
            first = srcStr.indexOf("_");
            if (first != srcStr.length()) {
                newString = newString + srcStr.substring(0, first) + "";
                srcStr = srcStr
                        .substring(first + "_".length(), srcStr.length());
                srcStr = srcStr.substring(0, 1).toUpperCase()
                        + srcStr.substring(1);
            }
        }
        newString = newString + srcStr;
        return newString;
    }
}