package com.fxy.mapper;

import com.fxy.pojo.student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface stuMapper {

    @Select("select * from db01.stu")
    public List<student> slAll();
}
