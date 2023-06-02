package org.tlh.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tlh.App;
import org.tlh.domain.Department;
import org.tlh.query.DepartmentQuery;
import org.tlh.service.IDepartmentService;
import org.tlh.until.PageList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class IDeparentServiceImplTest {
@Autowired
private IDepartmentService departmentService;
    @Test
    public void queryByPage() {
        DepartmentQuery query=new DepartmentQuery();
        query.setCurrentPage(2);
        query.setPageSize(5);
        PageList<Department> pageList=departmentService.queryByPage(query);
        System.out.println(pageList);
    }
}