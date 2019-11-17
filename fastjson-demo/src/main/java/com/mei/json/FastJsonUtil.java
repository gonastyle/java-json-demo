package com.mei.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;


/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/16 13:04
 * @version:
 * @modified By:
 */
public class FastJsonUtil {

    static {
        //格式化日期
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        //是否输出值为null的字段,默认为false
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteMapNullValue.getMask();

        //数值字段如果为null,输出为0,而非null
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullNumberAsZero.getMask();
        //List字段如果为null,输出为[],而非null
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullListAsEmpty.getMask();
        //字符类型字段如果为null,输出为 "",而非null
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullStringAsEmpty.getMask();
        //Boolean字段如果为null,输出为false,而非null
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullBooleanAsFalse.getMask();

        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteBigDecimalAsPlain.getMask();
        //全局修改日期格式,默认为false
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteDateUseDateFormat.getMask();
        //消除循环引用
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
        //格式化输出
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.PrettyFormat.getMask();

    }

    /**
     * 将JavaBean序列化为JSON文本
     *
     * @param object
     * @return
     */
    public static final String toJSONString(Object object) {
        if (null != object) {
            return JSON.toJSONString(object);
        } else {
            return "";
        }
    }

    /**
     * 把JSON文本parse为JavaBean
     * 【可以过滤掉多余的json字段】
     *
     * @param text
     * @param clazz
     * @return
     */
    public static <T> T parseObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    /**
     * jsonArr 生成list
     *
     * @param text
     * @param javaType
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String text, TypeReference<T> javaType) {
        return JSON.parseObject(text, javaType);
    }


    /**
     * 把JSON文本parse成JSONObject
     * 【适用于没有类映射的情况】
     *
     * @param text
     * @return
     */
    public static JSONObject parseObject(String text) {

        if (null != text && text.length() != 0) {
            return JSON.parseObject(text);
        } else {
            return null;
        }
    }

    /**
     * 把JSON文本parse成JSONArray
     * 【适用于没有类映射的情况】
     *
     * @param text
     * @return
     */
    public static JSONArray parseArray(String text) {
        if (null != text && text.length() != 0) {
            return JSON.parseArray(text);
        } else {
            return null;
        }
    }


    public static void main(String[] args) {


    }


}
