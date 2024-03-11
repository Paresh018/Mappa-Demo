package com.anime.mappa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anime.mappa.entity.MyMangaList;

@Repository
public interface MyMangaListRepository extends JpaRepository<MyMangaList, Integer>{
//MyMangaList is a class name where we have written attributes required for mangalist
	
}
