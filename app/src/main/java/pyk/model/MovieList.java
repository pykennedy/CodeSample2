package pyk.model;

import java.util.ArrayList;
import java.util.List;

import pyk.model.item.MovieItem;

public class MovieList {
  private static final MovieList       instance = new MovieList();
  private              List<MovieItem> movies;
  
  private MovieList() {
    movies = new ArrayList<>();
    for (int i = 0; i < 200; i++) {
      movies.add(new MovieItem(
          "Movie #" + i
          , null
          , null
          , 0
          , null
          , null));
    }
  }
  
  public List<MovieItem> getMovies() {
    return movies;
  }
  
  public int getCount() {
    return movies.size();
  }
  
  public static MovieList getInstance() {
    return instance;
  }
}