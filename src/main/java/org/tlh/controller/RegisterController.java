package org.tlh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tlh.domain.Registerfo;
import org.tlh.service.IRegisterService;
import org.tlh.until.JsonResult;

@RestController
@RequestMapping
public class RegisterController {
    @Autowired
    private IRegisterService registerService;
    @PostMapping("/register")
    public JsonResult addD(@RequestBody Registerfo registerfo){
        String result=registerService.addd(registerfo);
            if(result.equals("账号已存在")){
                return new JsonResult(false,"操作失败");
            }
               else {
                registerService.addd(registerfo);
                return new JsonResult();
            }

    }
   

}
