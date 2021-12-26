package com.example.demo.repo;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Movie;

public interface Repo extends JpaRepository<Movie,Integer> {
	
	// Filtrar por titulo
	@Query ("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
	List<Movie> findTitle(@Param("title") String title);

	//Filtrar por clasificación
	@Query ("SELECT m FROM Movie m WHERE m.classified LIKE %:classified%")
	List<Movie> findClass(@Param("classified") String classified);
	
	//Filtrar por los más populares
	@Query ("SELECT m FROM  Movie m ORDER BY m.rate DESC")
	List<Movie> findPopular(PageRequest pageRequest);
	

}
