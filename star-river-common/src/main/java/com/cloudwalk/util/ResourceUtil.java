package com.cloudwalk.util;

import com.cloudwalk.util.ExceptionUtil;
import com.cloudwalk.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 文件加载工具类
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */
public class ResourceUtil {

	private final static Logger logger = LoggerFactory
			.getLogger(ResourceUtil.class);
    //private final static String localPath ="D:/pro/workspace/risk_decision/src/main/resources/";
	private final static String localPath = "/app/opt/appuser/pro/risk_decision/config/";

	private static Properties props;

	public static void init() {

		logger.info("Loading properties started...");
		loadProperties("config.properties");
		logger.info("Loading properties ended...");
	}

	public static void reLoadProperties() {

	}

	private static void loadProperties(String path) {
		if (props == null) {
			props = new Properties();
		}
		if (!com.cloudwalk.util.StringUtil.isBlank(path)) {
			Reader reader = null;
			try {
				reader = new InputStreamReader(new FileInputStream(localPath
						+ path), "UTF-8");
				props.load(reader);
			} catch (IOException e) {
				logger.error("Load properties error...\n{}",
						ExceptionUtil.get(e));
			} finally {
				try {
					if (reader != null) {
						reader.close();
					}
				} catch (IOException e) {
					logger.error("close file error...\n{}",
							ExceptionUtil.get(e));
				}
			}
		} else {
			throw new RuntimeException("Properties path is null");
		}
	}

	private static Properties getProperties() {
		if (props == null) {
			init();
			// throw new RuntimeException("Properties not initialized...");
		}
		return props;
	}

	public static int getInt(String name) {
		return Integer.parseInt(getProperties().getProperty(name));
	}

	public static long getLong(String name) {
		return Long.parseLong(getProperties().getProperty(name));
	}

	public static String getString(String name) {
		return getProperties().getProperty(name);
	}

	public static String getString(String name, String defaultValue) {
		return getProperties().getProperty(name, defaultValue);
	}

	public static Map<String, Object> loadPropertiesToMap(String path) {
		if (!StringUtil.isBlank(path)) {
			Reader reader = null;
			try {
				Properties properties = new Properties();
				reader = new InputStreamReader(new FileInputStream(localPath
						+ path), "UTF-8");
				properties.load(reader);
				Map<String, Object> map = new HashMap<>();
				for (String key : properties.stringPropertyNames()) {
					Object value = properties.getProperty(key).trim();
					map.put(key, value);
				}
				return map;
			} catch (IOException e) {
				logger.error("Load properties error...\n{}",
						ExceptionUtil.get(e));
				throw new RuntimeException(e);
			} finally {

				try {
					if (reader != null) {
						reader.close();
					}
				} catch (IOException e) {
					logger.error("close file error...\n{}",
							ExceptionUtil.get(e));
				}
			}
		} else {
			logger.error("Properties path should not be empty.", path);
			throw new RuntimeException();
		}
		// return null;
	}
}
