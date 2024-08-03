package com.fxy.service.impService;

import com.fxy.mapper.stuMapper;
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
}
