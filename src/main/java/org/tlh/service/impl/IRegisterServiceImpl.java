package org.tlh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tlh.config.MD5Utils;
import org.tlh.domain.Register;
import org.tlh.domain.Registerfo;
import org.tlh.mapper.IRegisterMapper;
import org.tlh.service.IRegisterService;

@Service
public class IRegisterServiceImpl implements IRegisterService {
    @Autowired
    private IRegisterMapper registerMapper;

    @Override



    public String addd(Registerfo registerfo) {
        Register register=registerMapper.selectByUsername(registerfo.getUsername());
        System.out.println(registerfo.getUsername());
        if (register==null){
            registerfo.setPassword(MD5Utils.string2MD5(registerfo.getPassword()));
            registerMapper.add(registerfo);
        }
        if (register!=null){
            return "账号已存在";
        }
        return "非法请求";
    }


}
