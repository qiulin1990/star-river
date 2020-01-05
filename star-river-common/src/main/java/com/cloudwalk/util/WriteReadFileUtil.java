package com.cloudwalk.util;

import java.io.*;

/**
 * 读写文件工具类
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */
public class WriteReadFileUtil {
    private String pathName;
    private String data;

    /**
     * @param pathName
     * @return
     */
    public String readFile(String pathName) {
        this.pathName = pathName;
        StringBuffer stringBuffer = new StringBuffer();
        try (FileReader reader = new FileReader(pathName);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                stringBuffer.append(line + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /**
     * @param pathName
     * @param data
     */
    public void writeFile(String pathName, String data) {
        this.pathName = pathName;
        this.data = data;
        try {
            File writeName = new File(pathName);
            writeName.createNewFile();
            try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(writeName, true)))
            ) {
                out.write(data + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


