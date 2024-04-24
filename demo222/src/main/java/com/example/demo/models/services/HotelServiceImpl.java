package com.example.demo.models.services;

import com.example.demo.models.dao.IHotelDao;
import com.example.demo.models.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private IHotelDao hotelDao;

    @Override
    public List<Hotel> findAll() {
        return (List<Hotel>) hotelDao.findAll();
    }
}
