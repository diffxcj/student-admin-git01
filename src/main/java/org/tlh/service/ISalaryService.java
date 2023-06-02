package org.tlh.service;

import org.tlh.domain.Salary;
import org.tlh.domain.Login;
import org.tlh.query.SalaryQuery;
import org.tlh.until.PageList;

import java.util.List;


public interface ISalaryService {
    //查询全部 ;泛型<>只能接收Department类型
    List<Salary> selectAll();
    //根据ID查询单条数据
    Salary selectById(Long id);
    //新增
    void add(Salary salary);
    //编辑
    void update(Salary salary);
    //删除
    void deleteById(Long id);
    //两个方法分页的，合成在一起；带分页的所有数据和总条数
    PageList<Salary>queryByPage(SalaryQuery query);

    void bathDelete(List<Long> ids);
    String checkPassWord(Login login);
}

