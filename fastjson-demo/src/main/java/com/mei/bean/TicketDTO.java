package com.mei.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/16 13:32
 * @version:
 * @modified By:
 */
@Getter
@Setter
@ToString
public class TicketDTO {
    private int httpstatus;
    private String messages;
    private boolean status;
    private DataDTO data;

    private Boolean no;

}
