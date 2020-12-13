package com.yc.bbnmd1.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class indexcroller {
    @RequestMapping("/index.html")
    public String indexhtml(){
        return  "index";
    }
    @RequestMapping("/404.html")
    public String indexhtm2l(){
        return  "404";
    }
    @RequestMapping("/detail.html")
    public String indexhtml3(){
        return  "detail";
    }
    @RequestMapping("/list.html")
    public String loginhtml(){
        return  "list";
    }
}
