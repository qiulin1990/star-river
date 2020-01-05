package com.cloudwalk.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis工具类
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */
public class RedisPool {
    private static JedisPool pool;// jedis连接池
    // private static Integer maxTotal =
    // Integer.parseInt(PropertiesUtil.getProperty("redis.max.total","20"));
    // //最大连接数
    // private static Integer maxIdle =
    // Integer.parseInt(PropertiesUtil.getProperty("redis.max.idle","20"));//在jedispool中最大的idle状态(空闲的)的jedis实例的个数
    // private static Integer minIdle =
    // Integer.parseInt(PropertiesUtil.getProperty("redis.min.idle","20"));//在jedispool中最小的idle状态(空闲的)的jedis实例的个数
    //
    // private static Boolean testOnBorrow =
    // Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.borrow","true"));//在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值true。则得到的jedis实例肯定是可以用的。
    // private static Boolean testOnReturn =
    // Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.return","true"));//在return一个jedis实例的时候，是否要进行验证操作，如果赋值true。则放回jedispool的jedis实例肯定是可以用的。
    //
    // private static String redisIp = PropertiesUtil.getProperty("redis1.ip");
    // private static Integer redisPort =
    // Integer.parseInt(PropertiesUtil.getProperty("redis1.port"));
    private static String redisIp = ResourceUtil.getString("redis.ip");
    private static Integer redisPort = ResourceUtil.getInt("redis.port");
    private static String redisPassword = ResourceUtil.getString("redis.password");

    /**
     *
     */
    private static void initPool() {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setBlockWhenExhausted(true);// 连接耗尽的时候，是否阻塞，false会抛出异常，true阻塞直到超时。默认为true。

        pool = new JedisPool(config, redisIp, redisPort, 1000 * 2, redisPassword, 0);
    }

    static {
        initPool();
    }

    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void close(Jedis jedis) {
        try {
            if (jedis != null) {
                jedis.close();
            }
        } catch (Exception e) {

        }
    }
}
