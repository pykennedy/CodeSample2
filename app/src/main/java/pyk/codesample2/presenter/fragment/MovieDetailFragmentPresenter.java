package pyk.codesample2.presenter.fragment;

import pyk.codesample2.contract.fragment.MovieDetailFragmentContract;
import pyk.model.MovieList;
import pyk.model.item.MovieItem;

public class MovieDetailFragmentPresenter implements MovieDetailFragmentContract.MovieDetailFragmentPresenter {
  MovieList movieList;
  
  public MovieDetailFragmentPresenter() {
    movieList = MovieList.getInstance();
  }
  
  @Override public MovieItem getMovie(int i) {
    return movieList.getMovies().get(i);
  }
  
  /****************************************************************************************
   dependency injection for testing, no production code allowed beyond this point
   ***************************************************************************************/

  public MovieDetailFragmentPresenter(MovieList movieList) {
    this.movieList = movieList;
  }
}
