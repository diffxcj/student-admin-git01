package org.tlh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tlh.domain.Salary;
import org.tlh.query.SalaryQuery;

import java.util.List;

@Mapper

public interface ISalaryMapper {
    //查询全部 ;泛型<>只能接收类型
    List<Salary> selectAll();
    //根据ID查询单条数据
    Salary selectById(Long id);
    //新增
    void add(Salary salary);
    //编辑
    void update(Salary salary);
    //删除
    void deleteById(Long id);
    //分页加条件查询
    List<Salary> selectByPage(SalaryQuery query);
    //计算总tiao数;long比较保险，条数比较多
    Long count(SalaryQuery query);
    void batchDelete(SalaryQuery query);

    Salary selectByGrade(String grade);
}

