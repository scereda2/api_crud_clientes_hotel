package com.example.demo.controllers;

import com.example.demo.models.entity.Cliente;
import com.example.demo.models.entity.Hotel;

import com.example.demo.models.services.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelRestController {


    @Autowired
    private IHotelService hotelService;

    @GetMapping("/hoteles")
    public List<Hotel> index() {
        return hotelService.findAll();
    }
}
