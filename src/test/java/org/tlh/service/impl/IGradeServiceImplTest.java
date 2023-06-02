package org.tlh.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tlh.App;
import org.tlh.domain.Grade;
import org.tlh.query.GradeQuery;
import org.tlh.service.IGradeService;
import org.tlh.until.PageList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class IGradeServiceImplTest {
    @Autowired
    private IGradeService gradeService;
    @Test
    public void queryByPage() {
        GradeQuery query=new GradeQuery();
        query.setCurrentPage(2);
        query.setPageSize(5);
        PageList<Grade> pageList=gradeService.queryByPage(query);
        System.out.println(pageList);
    }
}