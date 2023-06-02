package org.tlh.service.impl;

import org.tlh.domain.Course;
import  org.tlh.mapper.ICourseMapper;
import  org.tlh.query.CourseQuery;
import  org.tlh.service.ICourseService;
import  org.tlh.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ICourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseMapper courseMapper;
    @Override
    public List<Course> selcetAll() {

        return courseMapper.selcetAll();
    }

    @Override
    public Course selectById(Long id) {

        return courseMapper.selectById(id);
    }

    @Override
    public void add(Course course) {
        courseMapper.add(course);
    }

    @Override
    public void update(Course course) {
        courseMapper.update(course);
    }

    @Override
    public void deleteById(Long id) {
        courseMapper.deleteById(id);
    }

    @Override
    public PageList<Course> queryByPage(CourseQuery query) {
        //new一个pageList来接受对象
        PageList<Course> pageList=new PageList<>();
        //查询当前数据
        List<Course> rows= courseMapper.selectByPage(query);
        pageList.setRows(rows);
        //统计条数
        Long total = courseMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void batchDelete(List<Long> ids) {
        courseMapper.batchDelete(ids);
    }
}
