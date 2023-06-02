package org.tlh.query;

import lombok.Data;

@Data
public class EducatorQuery {
    //当前页
    private Integer currentPage=1;
    //每页显示的条数
    private Integer pageSize=5;
    //计算起始行
    public Integer getStart(){
        return (this.currentPage-1)*pageSize;
    }
    private String keyword;
}
