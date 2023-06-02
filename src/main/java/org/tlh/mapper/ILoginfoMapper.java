package org.tlh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tlh.domain.Loginfo;

@Mapper
public interface ILoginfoMapper {
    Loginfo selectByUsername(String username);
}
