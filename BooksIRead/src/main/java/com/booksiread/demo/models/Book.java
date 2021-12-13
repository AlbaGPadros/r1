package com.booksiread.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name ="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@Column(name="number")
	private int number; 
	
	@Column(name="title")
	private String title; 
	
	@Column(name="author")
	private String author; 
	
	@Column (name="fiction")
	private boolean fiction; 
	
	
	//------------------------GETTERS I SETTERS---------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isFiction() {
		return fiction;
	}

	public void setFiction(boolean fiction) {
		this.fiction = fiction;
	}

}
