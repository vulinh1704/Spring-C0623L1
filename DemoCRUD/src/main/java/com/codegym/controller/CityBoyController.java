package com.codegym.controller;

import com.codegym.model.CityBoy;
import com.codegym.service.ICityBoyService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cityBoy")
public class CityBoyController {

    @Autowired
    private ICityBoyService<CityBoy> cityBoyService;

    @GetMapping("/list")
    public ModelAndView showList() {
        List<CityBoy> cityBoyList = cityBoyService.findAll();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list", cityBoyList);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showFormAdd() {
        ModelAndView modelAndView = new ModelAndView("add");
        CityBoy cityBoy = new CityBoy();
        modelAndView.addObject("cityBoy", cityBoy);
        return modelAndView;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute CityBoy cityBoy) {
        cityBoyService.save(cityBoy);
        return "redirect:/cityBoy/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        CityBoy cityBoy = cityBoyService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("cityBoy", cityBoy);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute CityBoy cityBoy) {
        cityBoyService.save(cityBoy);
        return "redirect:/cityBoy/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        cityBoyService.delete(id);
        return "redirect:/cityBoy/list";
    }

    @GetMapping("/findByAge")
    public String getListByAge() {
        List<CityBoy> list = cityBoyService.findByAgeCityBoy(22);
        return "";
    }

    @GetMapping("/findByName")
    public String findByName() {
        List<CityBoy> list = cityBoyService.findByNameContaining("Đ");
        return "";
    }


    @GetMapping("/findCustom")
    public String findCustom(@RequestParam("name") String name,@RequestParam("age") int age) {
        CityBoy cityBoy = cityBoyService.findCustom(name, age);
        return "";
    }
}
