package org.tlh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tlh.domain.Login;
import org.tlh.service.ILoginfoService;
import org.tlh.until.JsonResult;

@RestController
@RequestMapping
public class LoginfoController {
    @Autowired
   private ILoginfoService loginfoService;
    @PostMapping("/login")
    public JsonResult checkPassword(@RequestBody Login login){
                   String result=loginfoService.checkPassWord(login);
                   if (result.equals("密码正确")){
                       return new JsonResult();
                   }else {
                       return new JsonResult(false,"登陆失败");
                   }
    }
}
