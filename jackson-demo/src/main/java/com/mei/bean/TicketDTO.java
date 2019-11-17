package com.mei.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class TicketDTO {

    @JsonIgnore
    private String code;

    private int httpstatus;

    private String messages;
    private boolean status;

    private Boolean no = false;

    private DataDTO data;

}
