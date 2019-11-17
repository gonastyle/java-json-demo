package com.mei;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.mei.bean.DataDTO;
import com.mei.bean.TicketDTO;
import com.mei.bean.UserDTO;
import com.mei.file.FileUtil;
import com.mei.json.GsonUtil;

import java.util.Date;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {

        test1();
    }


    /**
     * 反序列化已经定义好的对象
     */
    public static void test() {

        String path = FileUtil.getFilePath("ticket.json");
        String data = FileUtil.readFileTXT(path);
        TicketDTO ticketDTO = GsonUtil.parseObject(data, TicketDTO.class);
        System.out.println(ticketDTO.getData().getResult().get(1));

    }

    public static void test1() {

        TicketDTO ticketDTO = new TicketDTO().builder().data(new DataDTO().builder().create_time(new Date()).build()).build();
        System.out.println(GsonUtil.toJSONString(ticketDTO));

        /**
         * Gson不支持匿名内部类
         */
/*
        System.out.println(new Gson().toJson(new TicketDTO() {
        }));


        System.out.println(new Gson().toJson(new TicketDTO()));
        System.out.println((GsonUtil.toJSONString(new TicketDTO())));

*/

    }


    public static void test4() {

/*        UserDTO userDTO = new UserDTO().builder().id("32").name("jkdj").build();
        String result = GsonUtil.toJSONString(userDTO);
        System.out.println(new Gson().toJson(userDTO));
        System.out.println(result);*/

//        System.out.println(GsonUtil.toJSONString(new UserDTO()));
    }

    /**
     * json数组转list对象
     */
    public static void test2() {

        List<UserDTO> list = GsonUtil.parseObject("[{\"id\": \"123\",\"name\": \"李四\"},{\"id\": \"6666\",\"name\": \"李五\"}]", new TypeToken<List<UserDTO>>() {
        });

        System.out.println(list.get(0));
    }

    /**
     * json数组测试
     */
    public static void test3() {
        JsonElement jsonElement = GsonUtil.parseArray("[{\"id\": \"123\",\"name\": \"李四\"},{\"id\": \"6666\",\"name\": \"李五\"}]");
        System.out.println(jsonElement.getAsJsonArray().get(1).getAsJsonObject().get("name").getAsString());

    }


}
