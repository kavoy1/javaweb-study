package com.fxy.service.impService;

import com.fxy.mapper.stuMapper;
import com.fxy.pojo.pageMsg;
import com.fxy.pojo.student;
import com.fxy.service.stuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class impStuService implements stuService {
    @Autowired
    private stuMapper stuMapper;

    public List<student> selectAll() {
        return stuMapper.slAll();
    }

    @Override
    public void deleteById(int id) {
        stuMapper.dlt(id);
    }

    @Override
    public void insert(student student) {
        stuMapper.inst(student);
    }

    @Override
    public student selectById(int id) {
        return stuMapper.sltById(id);
    }

    @Override
    public void update(student student) {
        stuMapper.upById(student);
    }

    @Override
    public List<student> pageSrc(pageMsg pageMsg) {
        int realPage = (pageMsg.getPage()-1)*pageMsg.getPageSize();
        int pageSize = pageMsg.getPageSize();
        return stuMapper.pageSearch(realPage, pageSize, pageMsg.getStu());
    }
}
