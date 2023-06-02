package org.tlh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tlh.domain.Sclass;
import org.tlh.query.SclassQuery;

import java.util.List;

public interface ISclassMapper {
    //查询全部
    @Mapper
    List<Sclass> selectAll();
    //根据id查询单条数据
    Sclass selectById(Long id);
    //新增
    void add(Sclass sclass);
    //编辑
    void update(Sclass sclass);
    //删除
    void deleteById(Long id);
    //分页+条件查询
    List<Sclass> selectByPage(SclassQuery query);
    //总条数
    Long count(SclassQuery query);

    void batchDelete(List<Long> ids);
}
