package com.fxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class pageMsg {
    private int page;
    private int pageSize;
    private student stu;
}
