package com.mei.json;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.text.SimpleDateFormat;


/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/16 20:47
 * @version:
 * @modified By:
 */

public class JacksonUtil {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    /**
     *
     *   序列化时,空属性字段删除
     *   objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
     *   使用注解的方法进行设置
     *   @JsonIgnore 定义属性不转换为json
     *   @JsonInclude(value = Include.NON_NULL)   为null 不转换
     **/
    static {

        //美化json
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //json多余的字段忽略
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //日期格式化
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        // null 转 ""
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
                arg1.writeString("");
            }
        });


    }

    /**
     * JavaBean 生成 json 字符串
     *
     * @param obj
     * @return
     */
    public static String toJSONString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * json 字符串 生成 JavaBean
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * jsonArr 生成list
     *
     * @param jsonArr
     * @param javaType
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String jsonArr, TypeReference<T> javaType) {
        try {
            return objectMapper.readValue(jsonArr, javaType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * json 生成 JsonNode
     *
     * @param text
     * @return
     */
    public static JsonNode parseObject(String text) {
        try {
            return objectMapper.readTree(text);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public static void main(String[] args) {


    }

}
