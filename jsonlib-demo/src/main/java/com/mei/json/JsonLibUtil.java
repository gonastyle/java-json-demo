package com.mei.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/17 11:17
 * @version:
 * @modified By:
 */
public class JsonLibUtil {

    /**
     * jsonlib全局配置
     */
    private static final JsonConfig jsonConfig = new JsonConfig();

    static {

        //Integer  数值处理: null -> 0
        jsonConfig.registerDefaultValueProcessor(Integer.class, new DefaultValueProcessor() {
            @Override
            public Object getDefaultValue(Class type) {
                return 0;
            }
        });

        jsonConfig.registerDefaultValueProcessor(Boolean.class, new DefaultValueProcessor() {
            @Override
            public Object getDefaultValue(Class type) {
                return false;
            }
        });

        //日期处理
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {

            @Override
            public Object processObjectValue(String paramString, Object paramObject, JsonConfig paramJsonConfig) {
                return process(paramObject);
            }

            @Override
            public Object processArrayValue(Object paramObject, JsonConfig paramJsonConfig) {
                return process(paramObject);
            }

            private Object process(Object value) {
                if (value instanceof Date) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                    return sdf.format(value);
                }
                return value == null ? "" : value.toString();
            }
        });

        //返回true的就是,不参与【序列化，反序列化】的字段
        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            @Override
            public boolean apply(Object source, String name, Object value) {

                if ("".equals(name)) {
                    return true;
                } else {
                    return false;
                }

            }
        });

        //指定在转换【序列化，反序列化】时不包含哪些属性
        jsonConfig.setExcludes(new String[]{""});

        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);

        //默认为false，即过滤默认的key，改为true则不忽略
        //生成json会多出：class
        jsonConfig.setIgnoreDefaultExcludes(false);

    }

    /**
     * JavaBean 生成 json 字符串
     *
     * @param obj
     * @return
     */
    public static String toJSONString(Object obj) {
        try {
            return parseObject(obj).toString();
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
            return (T) JSONObject.toBean(parseObject(json), clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * json 生成 JSONObject
     *
     * @param json
     * @return
     */
    public static JSONObject parseObject(Object json) {
        try {
            return JSONObject.fromObject(json, jsonConfig);
        } catch (Exception e) {
            e.printStackTrace();
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
            return JSONArray.fromObject(text, jsonConfig);
        } else {
            return null;
        }
    }


    public static void main(String[] args) {


    }
}
