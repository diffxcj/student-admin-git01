package org.tlh.service;

import org.tlh.domain.Students;
import org.tlh.query.StudentsQuery;
import org.tlh.until.PageList;

import java.util.List;

public interface IStudentsService {
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
    //分页查询+查询总条数
    PageList<Students>queryByPage(StudentsQuery query);

    void batchDelete(List<Long> ids);
}
