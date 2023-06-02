package org.tlh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tlh.domain.Educator;
import org.tlh.query.EducatorQuery;
import org.tlh.service.IEducatorService;
import org.tlh.until.JsonResult;
import org.tlh.until.PageList;

import java.util.List;

@RestController
@RequestMapping("/tesa")
public class EducatorController {
    @Autowired
    private IEducatorService educatorService;
    @GetMapping
    public List<Educator> queryAll(){
        return  educatorService.selectAll();
    }
    @GetMapping("{id}")
    public Educator queryById(@PathVariable("id")Long id){
        return educatorService.selectById(id);
    }
    @PostMapping
    public PageList<Educator> queryByPage(@RequestBody EducatorQuery query){
        return educatorService.queryByPage(query);
    }
    //新增加修改
    @PutMapping
    public JsonResult addOrupdate(@RequestBody Educator educator){
        try {
            if (educator.getId()==null){
                educatorService.add(educator);
            }else {
                educatorService.update(educator);
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
            educatorService.deleteById(id);
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
            educatorService.bathDelete(ids);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }
    @GetMapping("/tree")
    public List<Educator> getDeptTree(){
        return educatorService.queryTree();
    }
}
