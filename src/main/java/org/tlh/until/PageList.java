package org.tlh.until;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageList<T> {
    //设置一个字段，来接受当前页查询的数据
    List<T>rows=new ArrayList<>();
    Long total;
}
