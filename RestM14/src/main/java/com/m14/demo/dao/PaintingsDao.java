package com.m14.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m14.demo.models.Painting;


public interface PaintingsDao extends JpaRepository<Painting,Integer> {
	//List<Producto> findProductoByshopid(Long shopid);
	List<Painting> findAllByShopid(int shopid);
	void deleteAllByShopid(int shopid);
	
}