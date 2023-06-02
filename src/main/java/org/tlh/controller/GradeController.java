package org.tlh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tlh.domain.Grade;
import org.tlh.query.GradeQuery;
import org.tlh.service.IGradeService;
import org.tlh.until.JsonResult;
import org.tlh.until.PageList;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private IGradeService gradeService;
    @GetMapping
    public List<Grade> queryAll(){
        return  gradeService.selectAll();
    }
    @GetMapping("{id}")
    public Grade queryById(@PathVariable("id")Long id){
        return gradeService.selectById(id);
    }
    @PostMapping
    public PageList<Grade> queryByPage(@RequestBody GradeQuery query){
        return gradeService.queryByPage(query);
    }
    //新增加修改
    @PutMapping
    public JsonResult add0rupdate(@RequestBody Grade grade){
        try {
            if (grade.getId()==null){
                gradeService.add(grade);
            }else {
                gradeService.update(grade);
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
            gradeService.deleteById(id);
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
            gradeService.batchDelete(ids);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }
    @GetMapping("/tree")
    public List<Grade> getGradeTree(){
        return  gradeService.queryTree();
    }
}
