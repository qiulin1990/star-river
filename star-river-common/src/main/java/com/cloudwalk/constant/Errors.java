package com.cloudwalk.constant;

/**
 * 错误代码枚举
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */
public enum Errors {
    NO_ERROR(0, "接收成功"),
    JSON_REQUEST(1, "接收失败"),
    REQUEST_PARAS(2, "请求参数输入错误"),
    MYSQL_CONNECT(3, "mysql本地存储错误"),
    SERVICE_INNER(4, "启动mysql存储进程错误"),
    RETURN_ERROR(5, "kafka生产者存储错误"),
    REQUEST_ERROR(6, "启动kafka存储进程错误"),
    HBASE_STORE_ERROE(7, "kafka初始化失败"),
    KAFKA_PRO_ERROE(8, "kafka推送计算请求"),
    KAFKA_NO_MESSAGE(9, "kafka没消费到相应的数据"),
    KAFKA_NO_FILE(10, "kafka存储本地数据文件失败"),
    LOCAL_NO_FILE(11, "查询数据文件不存在"),
    HBASE_STORE_SUCCESS(12, "hbase存储数据成功"),
    MYSQL_PRIMARY(13, "MySQL主键冲突可忽略"),
    OTHER(9999, "服务器其他问题");
    public int id;
    public String name;

    Errors(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Errors fromId(int id) {
        for (Errors error : Errors.values()) {
            if (error.id == id)
                return error;
        }
        return null;
    }

    public static Errors fromName(String name) {
        for (Errors error : Errors.values()) {
            if (error.name.equals(name))
                return error;
        }
        return null;
    }


}
