package org.tlh.controller;

import org.tlh.domain.Course;
import org.tlh.query.CourseQuery;
import org.tlh.service.ICourseService;
import org.tlh.until.JsonResult;
import org.tlh.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;
    //查询所有
    @GetMapping
    public List<Course> queryAll(){
        return courseService.selcetAll();
    }
    //根据id查询
    @GetMapping("{id}")
    public Course queryById(@PathVariable("id") Long id){
        return courseService.selectById(id);
    }
    //分页查询+条件查询+统计条数
    @PostMapping
    public PageList<Course> queryPage(@RequestBody CourseQuery query){
        return courseService.queryByPage(query);
    }
    //新增、修改
    @PutMapping
    public JsonResult addOrupdate(@RequestBody Course course){
        try{
            if(course.getId()==null){
                courseService.add(course);
            }else {
                courseService.update(course);
            }
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }
    //根据id删除
    @DeleteMapping("{id}")
    public JsonResult deleteById(@PathVariable("id")Long id) {
        try {
            courseService.deleteById(id);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }
    //批量删除
    @PatchMapping
    public JsonResult bathDelete(@RequestBody List<Long>ids){
        try{
            courseService.batchDelete(ids);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }

}
