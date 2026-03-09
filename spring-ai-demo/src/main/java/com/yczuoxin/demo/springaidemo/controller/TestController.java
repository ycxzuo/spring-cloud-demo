package com.yczuoxin.demo.springaidemo.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.write.metadata.WriteTable;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        String fileName = "1234";
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        List<List<String>> dataList = new ArrayList<>();
        WriteTable table = new WriteTable();
        List<List<String>> heads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> headTitle = new ArrayList<>();
            headTitle.add("" + i);
            heads.add(headTitle);
        }
        table.setHead(heads);
        for (int i = 0; i < 40000; i++) {
            List<String> data = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                data.add("" + j);
            }
            dataList.add(data);
        }
        EasyExcelFactory.write(response.getOutputStream()).head(heads).sheet("清单列表sheet").doWrite(dataList);
    }

}