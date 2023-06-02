package org.tlh.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
//实体类字母大写
public class Educator {

    private Long id;
    private String un;
    private String name;
    private  Integer sex;
    private String age;
    private String course;
    private String phone;
    private String dirPath;//专门用来回显上级领导的
    private  Integer state;
    private Salary rank;//管理员
    private Long rank_id;//与上面的表连接
    private Long parent_id;
    private Educator parent;//以对象的形式，上级部门

    //当前设置一个children
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    List<Educator>children=new ArrayList<>();
}
