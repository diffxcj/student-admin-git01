package org.tlh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tlh.domain.Grade;
import org.tlh.query.GradeQuery;

import java.util.List;

@Mapper
public interface IGradeMapper {
    //查询全部
    List<Grade> selectAll();
    //根据id查询单条数据
    Grade selectById(Long id);
    //新增
    void add(Grade grade);
    //编辑
    void update(Grade grade);

   // void getId(Grade grade);
    //删除
    void deleteById(Long id);
    List<Grade> selectByPage(GradeQuery query);
    Long count(GradeQuery query);

    void batchDelete(List<Long> ids);

}
