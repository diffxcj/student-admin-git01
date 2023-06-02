package org.tlh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tlh.config.MD5Utils;
import org.tlh.domain.Login;
import org.tlh.domain.Loginfo;
import org.tlh.mapper.ILoginfoMapper;
import org.tlh.service.ILoginfoService;

@Service
public class ILoginfoServiceImpl implements ILoginfoService {
    @Autowired
    private ILoginfoMapper loginfoMapper;
    @Override
    public String checkPassWord(Login login) {
          Loginfo loginfo=loginfoMapper                                                                                                                                             .selectByUsername(login.getUsername());
          System.out.println(login.getPassword());
          if (loginfo==null){
              return "账号不存在";
          }
          if(loginfo.getPassword().equals(MD5Utils.string2MD5(login.getPassword()))){
              return "密码正确";
          }
          return "非法请求";

    }
}
