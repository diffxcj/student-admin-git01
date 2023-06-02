package org.tlh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tlh.domain.Register;
import org.tlh.domain.Registerfo;

@Mapper
public interface IRegisterMapper {
    void add(Registerfo register);
   Register selectByUsername(String username);
}
