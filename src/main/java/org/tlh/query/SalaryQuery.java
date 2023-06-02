package org.tlh.query;

import lombok.Data;

@Data
public class SalaryQuery {
    //分页查询应该封装“当前页”和“每页显示的条数”和“计算起始行”
    private Integer currentPage=1;//前端大小写
    private Integer pageSize=3;
    private Integer getStart(){//多线程所以最好加this
        return (this.currentPage-1)*pageSize;

    }
    //高级查询
    private String keyword;
}
