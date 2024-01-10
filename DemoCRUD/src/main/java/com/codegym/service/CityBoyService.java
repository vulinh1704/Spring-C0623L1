package com.codegym.service;

import com.codegym.model.CityBoy;
import com.codegym.repository.CityBoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityBoyService implements ICityBoyService<CityBoy> {
    @Autowired
    private CityBoyRepository cityBoyRepository;

    @Override
    public void save(CityBoy cityBoy) {
        cityBoyRepository.save(cityBoy);
    }

    @Override
    public void delete(Long id) {
        cityBoyRepository.deleteById(id);
    }

    @Override
    public List<CityBoy> findAll() {
        return cityBoyRepository.findAll();
    }

    @Override
    public Optional<CityBoy> findById(Long id) {
        return cityBoyRepository.findById(id);
    }

    @Override
    public List<CityBoy> findByAgeCityBoy(int age) {
        return cityBoyRepository.findByAge(age);
    }

    @Override
    public List<CityBoy> findByNameContaining(String name) {
        return cityBoyRepository.findByNameContaining(name);
    }

    @Override
    public CityBoy findCustom(String name, int age) {
        return cityBoyRepository.findCustom(name, age);
    }
}
