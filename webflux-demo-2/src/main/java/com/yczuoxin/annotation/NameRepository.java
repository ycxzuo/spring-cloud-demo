package com.yczuoxin.annotation;

import java.util.Arrays;
import java.util.List;

@StringRepository(value = "chineseNameRepository")
public class NameRepository {

    public List<String> findAll() {
        return Arrays.asList("张三", "李四");

    }

}
