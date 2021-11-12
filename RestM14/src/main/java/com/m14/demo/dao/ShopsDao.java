package com.m14.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.m14.demo.models.Shop;



public interface ShopsDao extends JpaRepository<Shop,Integer> {


}
