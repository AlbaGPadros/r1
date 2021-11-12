package com.m14.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paintings")
public class Painting {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(name="name", nullable=false, length=30)
	private String name;
	
	@Column(name="shopid", nullable=false, length=30)
	private int shopid;
	
	
	//GETTERS I SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getShopId() {
		return shopid;
	}
	public void setShopId(int shopid) {
		this.shopid = shopid;
	}
}
