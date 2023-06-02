package org.tlh.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Grade {
    private Long id;
    private Integer sid;
    private String gname;
    private String sex;
    private String sclass;
    private Course scourse;
    private Long scourse_id;
    private Integer grade;
    private Long manager_id;
    private Grade manager;
    //设置一个当前部门儿子的集合
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    List<Grade> children=new ArrayList<>();
}
