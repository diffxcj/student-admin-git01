package org.tlh.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tlh.domain.Salary;
import org.tlh.query.SalaryQuery;
import org.tlh.service.ISalaryService;
import org.tlh.until.JsonResult;
import org.tlh.until.PageList;

import java.util.List;

@RestController
@RequestMapping("/sala")
public class SalaryController {
    @Autowired
    private ISalaryService salaryService;
    @GetMapping
    public List<Salary> queryAll(){
        return  salaryService.selectAll();
    }
    @GetMapping("{id}")
    public Salary queryById(@PathVariable("id")Long id){
        return salaryService.selectById(id);
    }
    @PostMapping
    public PageList<Salary> queryByPage(@RequestBody SalaryQuery query){
        return salaryService.queryByPage(query);
    }

    @ApiOperation("新增加修改")
    //新增加修改
    @PutMapping
    public JsonResult addOrupdate(@RequestBody Salary salary){
        try {
            if (salary.getId()==null){
                salaryService.add(salary);
            }else {
                salaryService.update(salary);
            }
            return new JsonResult();
        }catch(Exception e) {
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }
    @ApiOperation("按id删除")
    @DeleteMapping("/{id}")
    public JsonResult deleteById(@PathVariable("id") Long id){
        try {
            salaryService.deleteById(id);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }
    @ApiOperation("批量删除")
    //批量删除
    @PatchMapping
    public JsonResult bathDelete(@RequestBody List<Long>ids){
        try {
            salaryService.bathDelete(ids);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }

}
