package com.normalUniversity.community.controller;

import com.normalUniversity.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

@Controller // 需要添加这个注解才会被container扫描
//@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Spring boot";
    }
    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }

    @RequestMapping("Http")
    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获得请求数据方法和路径
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());

        //请求行
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ' ' + value);
        }
        // 请求参数 code=...&name=...
        System.out.println(request.getParameter("code"));

        // 响应数据
        response.setContentType("text/html;charset=utf-8");
        // 获得输出流
        PrintWriter writer = response.getWriter();
        writer.write("<h1>asd</h1>");


    }

    // 分页显示
    // student?current=1&limit=20 跟下面保持一致 传过去的参数
    // 路径和请求方式为get
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    // 可以用RequestParam对current做出更详细的说明
    public String getStudents(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "20") int limit) {
        // 通过student?current=10&limit=10 这样就能够获取参数中的值
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }
    //  /student/123 参数变成路径的一部分
    @RequestMapping(path = "/students/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "Post success";
    }

    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    //获取的是html所以不用body
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "zhangsan");
        mav.addObject("age", "24");
        mav.setViewName("/demo/view");
        return mav;
    }
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    // 如果加了ReponseBody 的话就会返回真正的字符串，没加就是HTML
    public String school(Model model) {
        model.addAttribute("name", "Tqinghua" );
        model.addAttribute("age", "100");
        return "/demo/view";
    }
    // 响应JSON 也就是异步请求，在网页不刷新的情况下也能访问数据库
    // Java对象 -> JSON字符串 -> js对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    // ResponseBody加上返回的是Map对象，所以会自动转为JSON字符串
    public Map<String, Object> emp() {
        Map<String, Object> map = new HashMap();
        map.put("name", "lisi");
        map.put("age", "20");
        map.put("salary", "10000.00");
        return map;
    }
    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    // ResponseBody加上返回的是Map对象，所以会自动转为JSON字符串
    public List<Map<String, Object>> emps() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("name", "lisi");
        map.put("age", "20");
        map.put("salary", "10000.00");
        list.add(map);
        map.put("name", "xiaosan");
        map.put("age", "20");
        map.put("salary", "8000.00");
        list.add(map);
        map.put("name", "xiaowu");
        map.put("age", "20");
        map.put("salary", "12000.00");
        list.add(map);
        return list;
    }


}
