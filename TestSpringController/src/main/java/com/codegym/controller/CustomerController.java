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
    public ModelAndView modelAndView() {
        List<Customer> customerList = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("customer/home");
        modelAndView.addObject("list" , customerList);
        return modelAndView;
    }


    @GetMapping("/hello")
    public ModelAndView showHello() {
        String name = "Vu Linh";
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("name", name);
        return modelAndView;
    }


    @GetMapping("/show/{name}")
    public ModelAndView showPathVariable(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView("pathVariable");
        modelAndView.addObject("pathVariable", name);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView showParam(@RequestParam String q) {
        ModelAndView modelAndView = new ModelAndView("param");
        modelAndView.addObject("parameter", q);
        return modelAndView;
    }

    @GetMapping("/showFormCreate")
    public ModelAndView showFormCreate() {
        Customer customer = new Customer();
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject(customer);
        return modelAndView;
    }


    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer) {
        customerService.add(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        Customer customerEdit = customerService.findCustomerById(id);
        modelAndView.addObject("customerEdit", customerEdit);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute Customer customer) {
        customerService.edit(id, customer);
        return "redirect:/customers/list";
    }
}






















