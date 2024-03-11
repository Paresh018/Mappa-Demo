package com.anime.mappa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anime.mappa.service.MyMangaListService;

@Controller
public class MyMangaListController {
	
	//this obj of service class is created to use methods created in service class.
	//by using MyMangaListService obj we can access all methods that we have fetched using 
	//jparepository interface
	@Autowired
	private MyMangaListService mylistservice;

	///deleteMangaList/{id} this api is linked to delete button 
	//@pathvariable tag is used for retriving data by using id
	@RequestMapping("/deleteMangaList/{id}")
	public String deleteMyList(@PathVariable ("id") int id)
	{
		//call deletebyid method that we have created in MyMangaListService
		mylistservice.deleteById(id);
		return "redirect:/my_manga";
	}
}
