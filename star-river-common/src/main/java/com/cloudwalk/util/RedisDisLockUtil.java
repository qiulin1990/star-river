package com.cloudwalk.util;

import com.cloudwalk.util.RedisPoolUtil;

/**
 * redis分布式锁工具类
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */
public class RedisDisLockUtil {

    private RedisDisLockUtil() {
    }

    /**
     * @param lockName
     * @return
     */
    public static boolean lock(String lockName) {
        // lockName可以为共享变量名，也可以为方法名，主要是用于模拟锁信息
        System.out.println(Thread.currentThread() + "开始尝试加锁！");
        Long result = com.cloudwalk.util.RedisPoolUtil.setnx(lockName,
                String.valueOf(System.currentTimeMillis() + 5000));
        if (result != null && result.intValue() == 1) {
            System.out.println(Thread.currentThread() + "加锁成功！");
            com.cloudwalk.util.RedisPoolUtil.expire(lockName, 5);
            System.out.println(Thread.currentThread() + "执行业务逻辑！");
            com.cloudwalk.util.RedisPoolUtil.del(lockName);
            return true;
        } else {
            String lockValueA = com.cloudwalk.util.RedisPoolUtil.get(lockName);
            if (lockValueA != null
                    && Long.parseLong(lockValueA) >= System.currentTimeMillis()) {
                String lockValueB = com.cloudwalk.util.RedisPoolUtil.getSet(lockName,
                        String.valueOf(System.currentTimeMillis() + 5000));
                if (lockValueB == null || lockValueB.equals(lockValueA)) {
                    System.out.println(Thread.currentThread() + "加锁成功！");
                    com.cloudwalk.util.RedisPoolUtil.expire(lockName, 5);
                    System.out.println(Thread.currentThread() + "执行业务逻辑！");
                    RedisPoolUtil.del(lockName);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
/*	public static void main(String[] args) {
		boolean aa=RedisDisLockUtil.lock("liuzhonghua00");
		System.out.println(aa);
	}*/
}
