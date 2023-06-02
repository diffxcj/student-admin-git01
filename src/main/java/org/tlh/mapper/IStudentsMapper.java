package org.tlh.mapper;

import org.tlh.domain.Students;
import org.tlh.query.StudentsQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface IStudentsMapper {
    //查询全部
    List<Students> selectAll();
    //根据id查询单条数据
    Students selectById(Long id);
    //新增
    void add(Students students);
    //编辑
    void update(Students students);
    //删除
    void deleteById(Long id);
    //分页+条件查询
    List<Students> selectByPage(StudentsQuery query);
    //总条数
    Long count(StudentsQuery query);

    void batchDelete(List<Long> ids);
}
