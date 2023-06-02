package org.tlh.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.tlh.domain.Educator;
import org.tlh.query.EducatorQuery;

import java.util.List;

@Mapper

public interface IEducatorMapper {
    //查询全部实体类，select All（）方法
    //list集合，
    //<Educator>泛型，只能是泛型类型只能在Educator里面的才能用
    List<Educator> selectAll();
    //根据id查询单条数据，接收一条数据
    Educator selectById(long id);
    //新增，没有返回值
    void add(Educator educator);
    //编辑
    void update(Educator educator);
    //删除
    void deleteById(Long id);
    //分页+条件查询
    List<Educator> selectByPage(EducatorQuery query);
    //总条数
    Long count(EducatorQuery query);//参数query

    void batchDelete(List<Long> ids);
}
