package com.fxy.service;

import com.fxy.pojo.student;

import java.util.List;

public interface stuService {
    public List<student> selectAll();

    public void deleteById(int id);

    public void insert(student student);

    public student selectById(int id);
}
