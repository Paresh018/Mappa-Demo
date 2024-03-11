package com.anime.mappa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anime.mappa.entity.MyMangaList;
import com.anime.mappa.repository.MyMangaListRepository;

@Service
public class MyMangaListService {
	@Autowired
	private MyMangaListRepository mmrepository;

	//(MyMangaList mml) here MyMangaList is a class name and mml is objet name of that class
	public void saveMyManga(MyMangaList manga) {
		mmrepository.save(manga);
	}
	
	//this method is created to get all books from db so that we can show them on a screen as output
	//and now we will update getMyAnime() which is present in MangaController so that
	//gathered data from db will be shown on browser
	
	public List<MyMangaList> getAllMyManga(){
		return mmrepository.findAll();
	}
	
	
	//next method is created to delete record from mymangaist table
	public void deleteById(int id)
	{
		mmrepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
}
