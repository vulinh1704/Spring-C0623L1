package com.codegym.service;

import com.codegym.model.CityBoy;
import com.codegym.repository.CityBoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityBoyService implements IManager<CityBoy> {
    @Autowired
    private CityBoyRepository<CityBoy> cityBoyRepository;

    @Override
    public void save(CityBoy cityBoy) {
        cityBoyRepository.save(cityBoy);
    }

    @Override
    public void delete(Long id) {
        cityBoyRepository.delete(id);
    }

    @Override
    public List<CityBoy> findAll() {
        return cityBoyRepository.findAll();
    }

    @Override
    public CityBoy findById(Long id) {
        return cityBoyRepository.findById(id);
    }
}
