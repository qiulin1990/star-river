package com.cloudwalk.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * json工具类
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */

public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toString(Object obj)
            throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public static <T> T fromString(String json, Class<T> valueType)
            throws IOException {
        return objectMapper.readValue(json, valueType);
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromString(String json, TypeReference<T> typeReference)
            throws IOException {
        return (T) objectMapper.readValue(json, typeReference);
    }
}
