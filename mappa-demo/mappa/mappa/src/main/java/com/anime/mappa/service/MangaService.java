package com.anime.mappa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anime.mappa.entity.Manga;
import com.anime.mappa.repository.MangaRepository;

/* MangaRepository is an interface created by us which extends jparepository and
 * main use of this is to use all mehods availble in jparepository
 * 
 *  now we have created a service class which will be used to give implementation to 
 *  methods which we are extending from jparepository or mangarepository 
 *  
 *  here we will make object of manga repository first and then by using that object we can 
 *  assign object of class and then to manipulate that data*/

@Service
public class MangaService {
	@Autowired
	private MangaRepository mrepository;

	public void save(Manga m) {
		mrepository.save(m);
	}
	
	public List<Manga> getAllManga(){
		return mrepository.findAll();
	}
	
	public Manga getMangaById(int id)
	{
		return mrepository.findById(id).get();
	}
	
	public void deleteById(int id)
	{
		mrepository.deleteById(id);
	}
}
