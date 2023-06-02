package org.tlh.service.impl;

import org.tlh.domain.Educator;
import org.tlh.mapper.IEducatorMapper;
import org.tlh.query.EducatorQuery;
import org.tlh.service.IEducatorService;
import org.tlh.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class IEducatorServiceImpl implements IEducatorService {
    @Autowired
    private IEducatorMapper educatorMapper;
    @Override
    public List<Educator> selectAll() {

        return educatorMapper.selectAll();
    }

    @Override
    public Educator selectById(Long id) {

        return educatorMapper.selectById(id);
    }

    @Override
    public void add(Educator educator) {
        //携带dirpath
        educatorMapper.add(educator);
    }

    @Override
    public void update(Educator educator) {
        educatorMapper.update(educator);
    }

    @Override
    public void deleteById(Long id) {
        educatorMapper.deleteById(id);
    }

    @Override
    public PageList<Educator> queryByPage(EducatorQuery query) {
        //new一个pageList来接受对象
        PageList<Educator> pageList=new PageList<>();
        //查询当前数据
        List<Educator> rows = educatorMapper.selectByPage(query);
        pageList.setRows(rows);
        //统计条数
        Long total = educatorMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void bathDelete(List<Long> ids) {
        educatorMapper.batchDelete(ids);
    }

    @Override
    public List<Educator> queryTree() {
        //首先查询所有的部门
        List<Educator> educators=educatorMapper.selectAll();
        //顶级部门
        List<Educator>level1=new ArrayList<>();
        //循环遍历，找到上级部门为null的
        for(Educator dept:educators) {
            if (dept.getParent_id() == null) {
                level1.add(dept);
            } else {
                //找到有父类的，不为空，children
                for(Educator dept2:educators){
                    if(dept.getParent_id()==dept2.getId()){
                        dept2.getChildren().add(dept);
                    }
                }
            }
        }
        return level1;
    }
}
