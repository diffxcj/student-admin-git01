package org.tlh.service;

import org.tlh.domain.Sclass;
import org.tlh.query.SclassQuery;
import org.tlh.until.PageList;

import java.util.List;

public interface ISclassService {
    //查询全部
    List<Sclass> selectAll();
    //根据id查询单条数据
    Sclass selectById(Long id);
    //新增
    void add(Sclass sclass);
    //编辑
    void update(Sclass sclass);
    //删除
    void deleteById(Long id);
    //分页查询+查询总条数
    PageList<Sclass>queryByPage(SclassQuery query);

    void batchDelete(List<Long> ids);
}
