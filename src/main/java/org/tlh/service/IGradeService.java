package org.tlh.service;

import org.tlh.domain.Grade;
import org.tlh.query.GradeQuery;
import org.tlh.until.PageList;

import java.util.List;


public interface IGradeService{
        List<Grade> selectAll();
        //根据id查询单条数据
        Grade selectById(Long id);
        //新增
        void add(Grade grade);

        //void getId(Grade grade);
        //编辑
        void update(Grade grade);
        //删除
        void deleteById(Long id);
        PageList<Grade>queryByPage(GradeQuery query);

        void batchDelete(List<Long> ids);

    List<Grade> queryTree();
}
