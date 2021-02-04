package com.zhang.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: haiqing.zhang
 * @date: 2021/1/24
 * @description:
 */
@Controller
@RequestMapping("/transPage")
public class TransParamToWebApi {

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("indexName","首页展示");
        return modelAndView;
    }
}
