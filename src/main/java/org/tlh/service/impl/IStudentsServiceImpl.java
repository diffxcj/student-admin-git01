package org.tlh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tlh.domain.Students;
import org.tlh.mapper.IStudentsMapper;
import org.tlh.query.StudentsQuery;
import org.tlh.service.IStudentsService;
import org.tlh.until.PageList;

import java.util.List;

@Service
public class IStudentsServiceImpl implements IStudentsService {
    @Autowired
    private IStudentsMapper studentMapper;
    @Override
    public List<Students> selectAll() {

        return studentMapper.selectAll();
    }

    @Override
    public Students selectById(Long id) {

        return studentMapper.selectById(id);
    }

    @Override
    public void add(Students student) {
        studentMapper.add(student);
    }

    @Override
    public void update(Students student) {
        studentMapper.update(student);
    }

    @Override
    public void deleteById(Long id) {
        studentMapper.deleteById(id);
    }

    @Override
    public PageList<Students> queryByPage(StudentsQuery query) {
        //new一个pagelist对象来接收参数
        PageList<Students> pageList=new PageList<>();
        //查询当前页的数据
        List<Students> rows = studentMapper.selectByPage(query);
        pageList.setRows(rows);
        //统计条数
        Long total = studentMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void batchDelete(List<Long> ids) {
        studentMapper.batchDelete(ids);
    }
}
