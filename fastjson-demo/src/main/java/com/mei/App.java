package com.mei;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.mei.bean.DataDTO;
import com.mei.bean.TicketDTO;
import com.mei.file.FileUtil;
import com.mei.json.FastJsonUtil;

import java.util.Date;
import java.util.List;

/**
 * @date: 2019-11-16
 */
public class App {
    /***
     *
     * @param args
     */
    public static void main(String[] args) {

        test1();
    }


    public static void test() {
        String path = FileUtil.getFilePath("ticket.json");
        String data = FileUtil.readFileTXT(path);
        TicketDTO ticketDTO = FastJsonUtil.parseObject(data, TicketDTO.class);
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
        System.out.println(FastJsonUtil.toJSONString(ticketDTO));
    }

    public static void test2() {
        String path = FileUtil.getFilePath("ticket.json");
        String data = FileUtil.readFileTXT(path);
        JSONObject ticket = FastJsonUtil.parseObject(data);
        System.out.println(ticket.getJSONObject("data").getJSONArray("result").getString(0));

        JSONArray array = FastJsonUtil.parseArray("[1,2,3,5]");
        System.out.println(array.getInteger(3));

    }

    public static void test3() {

        List<Integer> list = FastJsonUtil.parseObject("[6,2,3,5]", new TypeReference<List<Integer>>() {
        });
        System.out.println(list.get(0));
    }

}
