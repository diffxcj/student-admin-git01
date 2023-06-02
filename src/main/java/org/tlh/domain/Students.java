package org.tlh.domain;

import lombok.Data;

@Data
public class Students {
    private Long id;
    private String sid;//学号
    private String sname;//姓名
    private String sclass;//班级
    private  String sex;//性别
    private String major;//专业
    private String phone;//电话号码
    private String postbox;//邮箱
    private String home;//家庭住址
}
