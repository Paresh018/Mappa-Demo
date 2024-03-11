package com.anime.mappa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anime.mappa.entity.Manga;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Integer>{

}
