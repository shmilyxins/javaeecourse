package com.hnucm.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsController {
    @RequestMapping("/news/{newsid}")
    public String news(@PathVariable String newsid, Model model){
        model.addAttribute("newsid", "新闻id:"+newsid);
        return "news.html";
    }
}
