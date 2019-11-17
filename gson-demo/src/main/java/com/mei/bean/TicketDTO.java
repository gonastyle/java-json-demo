package com.mei.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

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
@AllArgsConstructor
@Builder
public class TicketDTO {
    /**
     * 取别名
     */
    @SerializedName("email_address")
    private String code;
    /**
     * 忽略字段【需要开启配置】
     */
    @Expose(deserialize = true,serialize = true)
    private Integer httpstatus;
    private String messages;
    private Boolean status;
    private DataDTO data;

}
