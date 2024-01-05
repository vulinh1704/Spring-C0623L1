package com.codegym.service;

import com.codegym.model.CityBoy;

import java.util.ArrayList;
import java.util.List;

public class CityBoyService implements IManager<CityBoy> {
    private List<CityBoy> cityBoyList = new ArrayList<>();

    public CityBoyService() {
        this.cityBoyList.add(new CityBoy(1, "Đề", 23));
        this.cityBoyList.add(new CityBoy(2, "Dân", 17));
    }

    @Override
    public void add(CityBoy cityBoy) {
        cityBoyList.add(cityBoy);
    }

    @Override
    public void edit(int id, CityBoy cityBoy) {
        int index = findById(id);
        cityBoyList.set(index, cityBoy);
    }

    @Override
    public void delete(int id) {
        int index = findById(id);
        cityBoyList.remove(index);
    }

    @Override
    public List<CityBoy> findAll() {
        return cityBoyList;
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < cityBoyList.size(); i++) {
            if(id == cityBoyList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public CityBoy findElementById(int id) {
        for (CityBoy c: cityBoyList) {
            if(c.getId() == id) return c;
        }
        return null;
    }
}
