package com.anime.mappa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyManga")
public class MyMangaList {
	
	@Id
	private int id;
	private String name;
	private String Category;
	private String price;
	public MyMangaList(int id, String name, String category, String price) {
		super();
		this.id = id;
		this.name = name;
		Category = category;
		this.price = price;
	}
	public MyMangaList() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
}
