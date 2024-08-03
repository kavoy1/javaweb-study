package com.fxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import static java.time.LocalDateTime.now;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class student {
    private int id;
    private String name;
    private int age;
    private char gender = 'M';
    private java.sql.Date rsTime = null;
    private int cls;
}
