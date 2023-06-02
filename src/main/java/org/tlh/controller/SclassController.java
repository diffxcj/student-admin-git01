package org.tlh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tlh.domain.Sclass;
import org.tlh.query.SclassQuery;
import org.tlh.service.ISclassService;
import org.tlh.until.JsonResult;
import org.tlh.until.PageList;

import java.util.List;

@RestController
@RequestMapping("/class")
public class SclassController {
    @Autowired
    private ISclassService sclassService;
    @GetMapping
    public List<Sclass> queryAll(){
        return  sclassService.selectAll();
    }
    @GetMapping("{id}")
    public Sclass queryById(@PathVariable("id")Long id){
        return sclassService.selectById(id);
    }
    @PostMapping
    public PageList<Sclass> queryByPage(@RequestBody SclassQuery query){
        return sclassService.queryByPage(query);
    }
    //新增加修改
    @PutMapping
    public JsonResult addOrupdate(@RequestBody Sclass sclass){
        try {
            if (sclass.getId()==null){
                sclassService.add(sclass);
            }else {
                sclassService.update(sclass);
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
            sclassService.deleteById(id);
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
            sclassService.batchDelete(ids);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }
}
