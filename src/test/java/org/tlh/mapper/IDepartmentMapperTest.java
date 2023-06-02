package org.tlh.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tlh.App;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class IDepartmentMapperTest {
@Autowired

private IDepartmentMapper departmentMapper;
    @Test
    public void selectAll() {
        departmentMapper.selectAll().forEach(System.out::println);
    }
    @Test
    public void deleteById(){
        departmentMapper.deleteById(18l);
    }

}

