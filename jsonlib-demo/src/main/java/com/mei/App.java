package com.mei;

import com.mei.bean.DataDTO;
import com.mei.bean.TicketDTO;
import com.mei.file.FileUtil;
import com.mei.json.JsonLibUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        TicketDTO ticketDTO = new TicketDTO() {

            DataDTO dataDTO = new DataDTO() {
                {
                    this.setCreate_time(new Date());
                }
            };

            {
                this.setData(dataDTO);
            }
        };
        System.out.println(JsonLibUtil.toJSONString(ticketDTO));
    }


    public static void test1() {
        String path = FileUtil.getFilePath("ticket.json");
        String data = FileUtil.readFileTXT(path);
        TicketDTO ticketDTO = JsonLibUtil.parseObject(data, TicketDTO.class);
        System.out.println(ticketDTO);
        System.out.println(ticketDTO.getData().getResult().get(0));
    }


    public static void test2() {
        JSONArray jsonArray = JsonLibUtil.parseArray("[{\"id\": \"123\",\"name\": \"李四\"},{\"id\": \"6666\",\"name\": \"李五\"}]");
        System.out.println(jsonArray.getJSONObject(0).getString("id"));

    }

    public static void test3() {

        String path = FileUtil.getFilePath("ticket.json");
        String data = FileUtil.readFileTXT(path);

        /**
         * 使用jsonconfig
         */
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"map"});//map字段不参与
        JSONObject jsonObject = JSONObject.fromObject(data, jsonConfig);

        TicketDTO ticketDTO = (TicketDTO) JSONObject.toBean(jsonObject, TicketDTO.class);
        System.out.println(ticketDTO);

    }






}
