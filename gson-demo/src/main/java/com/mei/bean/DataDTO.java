package com.mei.bean;

import lombok.*;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataDTO {
    /**
     * 参与序列化/反序列化
     */
//    @Expose()
    private String flag;
    /**
     * 不参与序列化，也不参与反序列化
     */
//    @Expose(serialize = false, deserialize = false)
    private List<String> result;

    private Date create_time;
}
