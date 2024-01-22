package com.codegym.controller;

import com.codegym.model.CityBoy;
import com.codegym.service.ICityBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cityBoys")
public class CityBoyController {

    @Autowired
    private ICityBoyService<CityBoy> cityBoyService;


    @GetMapping("")
    public ResponseEntity<List<CityBoy>> getAll() {
        List<CityBoy> cityBoyList = cityBoyService.findAll();
        return new ResponseEntity<>(cityBoyList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody CityBoy cityBoy) {
        cityBoyService.save(cityBoy);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody CityBoy cityBoy) {
        cityBoy.setId(id);
        cityBoyService.save(cityBoy);
        return new ResponseEntity<>("Sưa thành công", HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        cityBoyService.delete(id);
        return new ResponseEntity<>("Xóa  thành công", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CityBoy>> getByName(@RequestParam String q) {
        List<CityBoy> cityBoyList = cityBoyService.findByNameContaining(q);
        return new ResponseEntity<>(cityBoyList, HttpStatus.OK);
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<List<CityBoy>> getByTeamsId(@PathVariable Long id) {
        List<CityBoy> cityBoyList = cityBoyService.findByTeamsId(id);
        return new ResponseEntity<>(cityBoyList, HttpStatus.OK);
    }

}

