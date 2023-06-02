package org.tlh.service.impl;


import org.tlh.domain.Login;
import org.tlh.domain.Salary;
import org.tlh.mapper.ISalaryMapper;
import org.tlh.query.SalaryQuery;
import org.tlh.service.ISalaryService;
import org.tlh.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
 public class ISalaryServiceImpl implements ISalaryService {
    @Autowired
    private ISalaryMapper salaryMapper;
    @Override
    public List<Salary> selectAll() {

        return salaryMapper.selectAll();
    }

    @Override
    public Salary selectById(Long id) {

        return salaryMapper.selectById(id);
    }

    @Override
    public void add(Salary salary) {
        //携带dirpath
        salaryMapper.add(salary);

    }

    @Override
    public void update(Salary salary) {

        salaryMapper.update(salary);
    }

    @Override
    public void deleteById(Long id) {
        salaryMapper.deleteById(id);
    }

    @Override
    public PageList<Salary> queryByPage(SalaryQuery query) {
        //new一个pageList来接受对象
        PageList<Salary> pageList=new PageList<>();
        //查询当前数据
        List<Salary> rows = salaryMapper.selectByPage(query);
        pageList.setRows(rows);
        //统计条数
        Long total = salaryMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void bathDelete(List<Long> ids) {

    }

    @Override
    public String checkPassWord(Login login) {
        return null;
    }

}
