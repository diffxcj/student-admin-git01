package org.tlh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tlh.domain.Students;
import org.tlh.query.StudentsQuery;
import org.tlh.service.IStudentsService;
import org.tlh.until.JsonResult;
import org.tlh.until.PageList;

import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentsController {
    @Autowired
    private IStudentsService studentsService;
    @GetMapping
    public List<Students> queryAll(){
        return  studentsService.selectAll();
    }
    @GetMapping("{id}")
    public Students queryById(@PathVariable("id")Long id){
        return studentsService.selectById(id);
    }
    @PostMapping
    public PageList<Students> queryByPage(@RequestBody StudentsQuery query){
        return studentsService.queryByPage(query);
    }
    //新增加修改
    @PutMapping
    public JsonResult add0rupdate(@RequestBody Students students){
        try {
            if (students.getId()==null){
                studentsService.add(students);
            }else {
                studentsService.update(students);
            }
            return new JsonResult();
        }catch(Exception e) {
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }

    @DeleteMapping("/{id}")
    public JsonResult deleteById(@PathVariable("id") Long id){
        try {
            studentsService.deleteById(id);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }
    //批量删除
    @PatchMapping
    public JsonResult bathDelete(@RequestBody List<Long>ids){
        try {
            studentsService.batchDelete(ids);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }

}
