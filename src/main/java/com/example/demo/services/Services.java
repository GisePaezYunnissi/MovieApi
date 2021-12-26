package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repo.Repo;

@Service
public class Services {

    private final Repo movieRepository;

    @Autowired
    public Services(Repo movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    //al inicio de la API aparece lo siguiente
  	public String init() {
  		return "<h1>Bienvenido a mi API de Películas<h1>";
  	};
    
    //Para leer el listado de películas
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    //Para agregar una película a la BD
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    
    //Para eliminar una película
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }
    
    //Para actualizar una película
    public Movie updateMovie(Movie movie, Integer id) {
    	
    	Optional<Movie> movieupdate = movieRepository.findById(id);
        
        if (!movieupdate.isEmpty()) {
			return movieRepository.save(movie);
		}else {
			throw new RuntimeException("Movie not found");
		}
    }
    
    //Buscar por id
  	public Optional < Movie> findId(Integer id) {
  		return movieRepository.findById(id);
  	}
  		
  	//Buscar por titulo
  	public List<Movie> findTitle(String title) {
  		return movieRepository.findTitle(title);
  	}
  		
  	//Buscar por popular
  	public List<Movie> findPopular() {
  		return movieRepository.findPopular(PageRequest.of(0,3));
  	}
  		
  	//Buscar por clasificación de pelicula
  	public List<Movie> findClass(String classified) {
  		return movieRepository.findClass(classified);
  	}
}