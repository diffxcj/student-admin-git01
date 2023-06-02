package org.tlh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tlh.domain.Grade;
import org.tlh.mapper.IGradeMapper;
import org.tlh.query.GradeQuery;
import org.tlh.service.IGradeService;
import org.tlh.until.PageList;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class IGradeServiceImpl implements IGradeService {
    @Autowired
    private IGradeMapper gradeMapper;
    @Override
    public List<Grade> selectAll() {

        return gradeMapper.selectAll();
    }

    @Override
    public Grade selectById(Long id) {

        return gradeMapper.selectById(id);
    }

    @Override
    public void add(Grade grade) {

        gradeMapper.add(grade);
    }

    @Override
    public void update(Grade grade) {

        gradeMapper.update(grade);
    }

    @Override
    public void deleteById(Long id) {
          gradeMapper.deleteById(id);
    }

    @Override
    public PageList<Grade> queryByPage(GradeQuery query) {
        PageList<Grade> pageList=new PageList<>();
       List<Grade> rows=gradeMapper.selectByPage(query);
       pageList.setRows(rows);
       Long total=gradeMapper.count(query);
       pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void batchDelete(List<Long> ids) {
        gradeMapper.batchDelete(ids);
    }

    @Override
    public List<Grade> queryTree() {
        //查询所有的姓名
        List<Grade> grades = gradeMapper.selectAll();
        //查询所有的班长
        List<Grade>levell=new ArrayList<>();
        //循环所有的，找到名为managerid为null的姓名，把他们设置到levell的集合里面
        for (Grade grade:grades){
            if (grade.getManager_id()==null){
                levell.add(grade);
            }else {
                //找到有父类（managerid不为null）,然后把自己当作children设置到父类部门里面
                for (Grade grade2:grades){
                    if(grade.getManager_id()==grade2.getId()){
                        grade2.getChildren().add(grade);
                    }
                }
            }
        }
        return levell;
    }


}
