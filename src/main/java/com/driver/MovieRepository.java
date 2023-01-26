package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieDb;
    private HashMap<String, Director> directorDb;
    private HashMap<String, List<String>> movieDirectorDb = new HashMap<>();

    public MovieRepository() {
        this.movieDb = new HashMap<String, Movie>();
        this.directorDb = new HashMap<String, Director>();
        this.movieDirectorDb = new HashMap<String, List<String>>();
    }

    //adding Movie
    public void addMovie(Movie movie) {
        String name = movie.getName();
        movieDb.put(name, movie);
    }

    public void addDirector(Director director) {
        String name = director.getName();
        directorDb.put(name, director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if(movieDb.containsKey(movieName) && directorDb.containsKey(directorName)){
//            movieMap.put(movie, movieMap.get(movie));
//            directorMap.put(director, directorMap.get(director));
            List<String> currentMovies = new ArrayList<String>();
            if(movieDirectorDb.containsKey(directorName))
                currentMovies = movieDirectorDb.get(directorName);
            currentMovies.add(movieName);
            movieDirectorDb.put(directorName, currentMovies);
        }
    }
    public Movie getMovieByName(String name) {
       return movieDb.get(name);
    }

    public Director getDirectorByName(String name) {
       return directorDb.get(name);
    }

    public List<String> findMoviesFromDirector(String director){
        List<String> moviesList = new ArrayList<String>();
        if(movieDirectorDb.containsKey(director))
            moviesList = movieDirectorDb.get(director);
        return moviesList;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieDb.keySet());
    }

    public void deleteDirector(String directorName) {
        List<String> movies = new ArrayList<String>();
        if(movieDirectorDb.containsKey(directorName)){
            movies = movieDirectorDb.get(directorName);
            for(String movie: movies){
                if(movieDb.containsKey(movie)){
                    movieDb.remove(movie);
                }
            }

            movieDirectorDb.remove(directorName);
        }
        if(directorDb.containsKey(directorName)){
            directorDb.remove(directorName);
        }
    }

    public void deleteAllDirector(){
        HashSet<String> moviesSet = new HashSet<String>();

        for(String director: movieDirectorDb.keySet()){
            for(String movie: movieDirectorDb.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieDb.containsKey(movie)){
                movieDb.remove(movie);
            }
        }
    }
}

