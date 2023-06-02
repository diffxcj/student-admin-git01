package org.tlh.mapper;

import org.tlh.domain.Course;
import org.tlh.query.CourseQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface ICourseMapper {
    //查询全部
    List<Course> selcetAll();
    //根据id查询单条数据
    Course selectById(long id);
    //新增
    void add(Course course);
    //编辑
    void update(Course course);
    //删除
    void deleteById(Long id);
    //分页+条件查询
    List<Course> selectByPage(CourseQuery query);
    //总条数
    Long count(CourseQuery query);

    void batchDelete(List<Long> ids);

}
