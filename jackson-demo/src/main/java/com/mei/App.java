package com.mei;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.mei.bean.DataDTO;
import com.mei.bean.TicketDTO;
import com.mei.bean.UserDTO;
import com.mei.file.FileUtil;
import com.mei.json.JacksonUtil;

import java.util.Date;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        test1();
    }

    public static void test() {
        String path = FileUtil.getFilePath("ticket.json");
        String data = FileUtil.readFileTXT(path);
        TicketDTO ticketDTO = JacksonUtil.parseObject(data, TicketDTO.class);
        System.out.println(ticketDTO.getData().getResult().get(0));
    }

    public static void test1() {

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
        System.out.println(JacksonUtil.toJSONString(ticketDTO));
    }

    public static void test2() {

        List<UserDTO> list = JacksonUtil.parseObject("[{\"id\": \"123\",\"name\": \"李四\"},{\"id\": \"6666\",\"name\": \"李五\"}]", new TypeReference<List<UserDTO>>() {
        });

        System.out.println(list.get(0));
    }

    public static void test3() {
        JsonNode jsonNode = JacksonUtil.parseObject("[{\"id\": \"123\",\"name\": \"李四\"},{\"id\": \"6666\",\"name\": \"李五\"}]");
        if (jsonNode.isArray()) {
            System.out.println(jsonNode.get(1).get("id").asText());
        }

    }


}
