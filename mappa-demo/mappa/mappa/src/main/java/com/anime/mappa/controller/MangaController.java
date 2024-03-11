package com.anime.mappa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anime.mappa.entity.Manga;
import com.anime.mappa.entity.MyMangaList;
import com.anime.mappa.service.MangaService;
import com.anime.mappa.service.MyMangaListService;

@Controller
public class MangaController {
	
	@Autowired
	private MangaService mservice;
	
	@Autowired
	private MyMangaListService myMangaListService;

	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/anime_register")
	public String animeRegister()
	{
		//this animeRegister is  name of html page
		return "animeRegister";
	}
	
	
	/* this method is created for showing available manga  and after using save ethod
	 * we have to fetch data from db so we are difying it
	 * 
	 * after modification model and view is used to fetch and view the data i table that we have
	 * created on this page 
	 * 
	 * also public List<Manga> getAllManga(){
		return mrepository.findAll();
	}
	above method is creted in mangaservice class to get list of all manga
	this is explaination of getAllManga() */
	
	@GetMapping("/available_manga")
	public ModelAndView getAllManga()
	{
		List<Manga> list=mservice.getAllManga();
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("animeList");
//		mv.addObject("manga", list);
//		return mv;
		
		//or
		//this can be directly written like this
		return new ModelAndView("animeList","manga",list);
	}

	//this method is created for storing data in db & redirect is used to redirect on available manga page
	@PostMapping("/save")
	public String addManga(@ModelAttribute Manga m)
	{
		mservice.save(m);
		return "redirect:/available_manga";
	}
	
	
	//used to show db data in table format of myanga table
	//this is old method which shows table only
	
//	@GetMapping("/my_manga")
//	public String getMyAnime()
//	{
//		//this myAnime is  name of html page
//		return "myManga";
//	}
	
	//above methd is stored for future example/reference
	//now we will modify it to get data from db and to show 
	
	@GetMapping("/my_manga")
	public String getMyAnime(Model model)
	{
		//this myAnime is  name of html page
		//	class obj	listname	objofservice	methodfromservice
		List<MyMangaList> list= myMangaListService.getAllMyManga();
		model.addAttribute("manga",list);
		return "myManga";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id)
	{
		Manga m = mservice.getMangaById(id);
		MyMangaList mml = new MyMangaList(m.getId(),m.getName(),m.getCategory(),m.getPrice());
		myMangaListService.saveMyManga(mml);
		return "redirect:/my_manga";
	}
	
	
	//Model is used to send data from controller to view
	//@PathVariable("id") int id to get data by id
	@RequestMapping("/editbook/{id}")
	public String editManga(@PathVariable("id") int id, Model model)
	{
		Manga m=mservice.getMangaById(id);
		model.addAttribute("manga",m);
		return "mangaEdit";
	}
	
	
	@RequestMapping("/deletebook/{id}")
	public String deletemanga(@PathVariable ("id") int id) 
	{
		mservice.deleteById(id);
		return "redirect:/available_manga";
	}
}
