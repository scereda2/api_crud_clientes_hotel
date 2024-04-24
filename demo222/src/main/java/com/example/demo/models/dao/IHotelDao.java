package com.example.demo.models.dao;


import com.example.demo.models.entity.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface IHotelDao extends CrudRepository<Hotel, Long> {
}
