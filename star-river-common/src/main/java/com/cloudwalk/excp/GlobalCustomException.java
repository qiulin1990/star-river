package com.cloudwalk.excp;

import com.cloudwalk.excp.GlobalConf;

/**
 * 全域客户端异常
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */
public class GlobalCustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * @param type
     */
    public GlobalCustomException(com.cloudwalk.excp.GlobalConf.ErrorType type) {
        this(type, null);
    }

    /**
     * @param type
     * @param cause
     */
    public GlobalCustomException(GlobalConf.ErrorType type, Throwable cause) {
        super(type.name() + ":" + type.getDesc(), cause);
    }
}
