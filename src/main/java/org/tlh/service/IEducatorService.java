
package org.tlh.service;


import org.tlh.domain.Educator;
import org.tlh.query.EducatorQuery;
import org.tlh.until.PageList;

import java.util.List;

public interface IEducatorService {
    List<Educator> selectAll();
    //根据id查询单条数据
    Educator selectById(Long id);
    //新增
    void add(Educator educator);
    //编辑
    void update(Educator educator);
    //删除
    void deleteById(Long id);
    //分页查询+查询总tiao'shu
    PageList<Educator>queryByPage(EducatorQuery query);

    void bathDelete(List<Long> ids);

    List<Educator> queryTree();
}

