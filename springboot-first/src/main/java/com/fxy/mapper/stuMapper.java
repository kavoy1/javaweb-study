package com.fxy.mapper;

import com.fxy.pojo.student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface stuMapper {

    @Select("select * from db01.stu")
    public List<student> slAll();

    @Delete("delete from stu where id = #{id}")
    public void dlt(int id);

    @Insert("INSERT into db01.stu (db01.stu.name, db01.stu.age, db01.stu.gender, db01.stu.rsTime, db01.stu.class) values (#{name},#{age},#{gender},now(),#{cls})")
    public void inst(student stu);

    //@Select("select * from stu where id = #{id}")
    public student sltById(int id);


    public int upById(student stu);

    public List<student> pageSearch(@Param("realPage") int realPage,@Param("pageSize") int pageSize,@Param("stu") student stu);
}
