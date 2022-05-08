package com.tencent.wxcloudrun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlController {

    @RequestMapping(value = "h5page")
    public ModelAndView h5page(@RequestParam Long id) {

        return new ModelAndView("index");
    }
}
