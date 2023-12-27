package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public ModelAndView showHello() {
        String name = "Tong tai De";
        ModelAndView modelAndView = new ModelAndView("hi");
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView showList() {
        List<String> list = new ArrayList<>();
        list.add("De");
        list.add("Dan");
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }
}