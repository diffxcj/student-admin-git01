package org.tlh.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tlh.App;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class IEmployeeMapperTest {
  @Autowired
  private IEmployeeMapper employeeMapper;
    @Test
    public void selectAll() {
        employeeMapper.selectAll().forEach(System.out::println);
        
    }
}