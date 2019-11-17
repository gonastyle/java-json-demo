package com.mei.bean;

import lombok.*;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/11/16 21:54
 * @version:
 * @modified By:
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String id;
    private String name;
    private Double no;
}
