package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private IService<Customer> customerService;

    @GetMapping("/list")
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView("customers/home");
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("list", customerList);
        return modelAndView;
    }

    @GetMapping("/showFormCreate")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("customers/create");
        Customer customer = new Customer();
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer) {
        customerService.add(customer);
        return "redirect:/customers/list";
    }


    @GetMapping("/showFormEdit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("customers/edit");
        Customer customer = customerService.findElementById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }


    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @ModelAttribute Customer customer) {
        customerService.edit(id, customer);
        return "redirect:/customers/list";
    }


//    @GetMapping("/hello")
////    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public ModelAndView showHello() {
//        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("hello", "Hello C0623L1");
//        return modelAndView;
//    }
//
//    @GetMapping("/show/{name}")
//    public ModelAndView showPathVariable(@PathVariable String name) {
//        ModelAndView modelAndView = new ModelAndView("path");
//        modelAndView.addObject("pathVariable", name);
//        return modelAndView;
//    }
//
//    @GetMapping("/showParam")
//    public ModelAndView showParam(@RequestParam String q) {
//        ModelAndView modelAndView = new ModelAndView("param");
//        modelAndView.addObject("query", q);
//        return modelAndView;
//    }


}
