package com.fxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student {
    private int id;
    private String name;
    private int age;
    private char gender;
    private java.sql.Date rsTime;
    private int cls;
}
