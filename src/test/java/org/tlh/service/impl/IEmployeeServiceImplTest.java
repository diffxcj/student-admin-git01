package org.tlh.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tlh.App;
import org.tlh.service.IEmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class IEmployeeServiceImplTest {
  @Autowired
  private IEmployeeService employeeService;
    @Test
    public void selectByUsername() {
        employeeService.selectAll().forEach(System.out::println);
    }
}