package com.easy.action;

import com.easy.annotation.EAutowired;
import com.easy.annotation.EController;
import com.easy.annotation.ERequestMapping;
import com.easy.service.ITestService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EController
@ERequestMapping("/test")
public class TestController {
    @EAutowired
    private ITestService testService;

    @ERequestMapping("/getContent")
    public void getContent(HttpServletRequest request, HttpServletResponse response,String name) {
        testService.test();
        System.out.println("执行了");
        try {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write("您输入的名字是"+name);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
