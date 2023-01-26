package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
         movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public void addMovieDirectorPair(String movieName, String directorName) {
         movieRepository.addMovieDirectorPair(movieName,directorName);
    }

    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }
    public Director getDirectorByName(String name){
        return movieRepository.getDirectorByName(name);
    }
    public List<String> getMoviesByDirectorName(String director){
        return movieRepository.findMoviesFromDirector(director);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirector();
    }

}
