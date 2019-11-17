package com.mei.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/17 14:32
 * @version:
 * @modified By:
 */
public class GsonUtil {

    private static final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")  //时间格式
            .enableComplexMapKeySerialization()//支持Map的key为复杂对象的形式
            .serializeNulls() //智能null
            .setPrettyPrinting()// 调教格式
            .disableHtmlEscaping() //默认是GSON把HTML 转义的
            /* .excludeFieldsWithoutExposeAnnotation()  //使用 @Expose这个注解来控制序列化/反序列化*/
            .registerTypeAdapter(String.class, new TypeAdapter<String>() {
                @Override
                public void write(JsonWriter out, String value) throws IOException {
                    if (value == null) {
                        out.value("");
                        return;
                    }
                    out.value(value);
                    return;
                }

                @Override
                public String read(JsonReader in) throws IOException {
                    if (in.peek() == JsonToken.NULL) {
                        in.nextNull();
                        return null;
                    }
                    return in.nextString();
                }
            })
            .registerTypeAdapter(Integer.class, new TypeAdapter<Integer>() {
                @Override
                public void write(JsonWriter out, Integer value) throws IOException {
                    if (value == null) {
                        out.value(0L);
                        return;
                    }
                    out.value(value);
                    return;
                }

                @Override
                public Integer read(JsonReader in) throws IOException {
                    if (in.peek() == JsonToken.NULL) {
                        in.nextNull();
                        return null;
                    }
                    return in.nextInt();
                }
            })
            .registerTypeAdapter(Boolean.class, new TypeAdapter<Boolean>() {
                @Override
                public void write(JsonWriter out, Boolean value) throws IOException {
                    if (value == null) {
                        out.value(false);
                        return;
                    }
                    out.value(value);
                    return;
                }

                @Override
                public Boolean read(JsonReader in) throws IOException {
                    if (in.peek() == JsonToken.NULL) {
                        in.nextNull();
                        return null;
                    }
                    return in.nextBoolean();
                }
            })
            .registerTypeAdapter(Double.class, new TypeAdapter<Double>() {
                @Override
                public void write(JsonWriter out, Double value) throws IOException {
                    if (value == null) {
                        out.value(0.00d);
                        return;
                    }

                    out.value(value);
                    return;
                }

                @Override
                public Double read(JsonReader in) throws IOException {
                    if (in.peek() == JsonToken.NULL) {
                        in.nextNull();
                        return null;
                    }
                    return in.nextDouble();
                }
            })
            .create();


    /**
     * JavaBean 生成 json 字符串
     * 对象需要有参构造函数
     *
     * @param obj
     * @return
     */
    public static String toJSONString(Object obj) {
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * json 字符串 生成 JavaBean
     * String[].class
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        try {
            return gson.fromJson(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * jsonArr 生成 list
     * new TypeToken<List<String>>(){}.getType()
     *
     * @param jsonArr
     * @param javaType
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String jsonArr, TypeToken<T> javaType) {
        try {
            return gson.fromJson(jsonArr, javaType.getType());
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
    public static JsonElement parseObject(String text) {
        try {
            return gson.toJsonTree(text);
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
    public static JsonElement parseArray(String text) {
        if (null != text && text.length() != 0) {
            JsonParser jsonParser = new JsonParser();
            return jsonParser.parse(text);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

    }


}
