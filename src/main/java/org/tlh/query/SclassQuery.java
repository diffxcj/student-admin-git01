package org.tlh.query;

import lombok.Data;

@Data
public class SclassQuery {
    //当前页面
    private Integer currentPage=2;
    //每页显示条数
    private Integer pageSize=5;
    //计算起始行
    public Integer getStart(){
        return (this.currentPage-1)*pageSize;
    }
    //条件查询
    private String keyword;
}
