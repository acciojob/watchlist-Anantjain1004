package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
       movieService.addMovie(movie);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director) {
        movieService.addDirector(director);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("mName") String movieName ,@RequestParam("dName") String directorName) {
        movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name) {
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("director") String name) {
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director, HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> movies = movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }


    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String directorName) {
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

}
