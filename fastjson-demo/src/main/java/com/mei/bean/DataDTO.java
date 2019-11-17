package com.mei.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/16 13:34
 * @version:
 * @modified By:
 */
@Getter
@Setter
@ToString
public class DataDTO {
    private String flag;
    private List<String> result;
    private Date create_time;
}
