package org.tlh.query;

import lombok.Data;

@Data
public class GradeQuery {
    private Integer currentPage = 2;
    private Integer pageSize = 5;

    public Integer getStart() {
        return (this.currentPage-1)*pageSize;
    }
    private String keyword;
}

