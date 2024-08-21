package com.fxy.mapper;

import com.fxy.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface adminMapper {

    @Select("select * from db01.admin where username = #{username} and password = #{password}")
    public Admin login(Admin admin);

    @Select("select * from db01.admin")
    public Admin se();
}
