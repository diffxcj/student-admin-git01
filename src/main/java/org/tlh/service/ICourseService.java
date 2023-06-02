package org.tlh.service;

import org.tlh.domain.Course;
import  org.tlh.query.CourseQuery;
import  org.tlh.until.PageList;

import java.util.List;

public interface ICourseService {
    List<Course> selcetAll();
    //根据id查询单条数据
    Course selectById(Long id);
    //新增
    void add(Course course);
    //编辑
    void update(Course course);
    //删除
    void deleteById(Long id);
    //分页查询+查询总条数
    PageList<Course>queryByPage(CourseQuery query);

    void batchDelete(List<Long> ids);
}
