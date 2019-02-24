package pyk.codesample2.presenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import pyk.codesample2.presenter.fragment.MovieDetailFragmentPresenter;
import pyk.codesample2.support.StaticValues;
import pyk.model.MovieList;
import pyk.model.item.MovieItem;

public class MovieDetailFragmentPresenterTest {
  private MovieDetailFragmentPresenter mdfp;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mdfp = new MovieDetailFragmentPresenter();
  }
  
  @Test
  public void getMovie() {
    MovieList.getInstance().getMovies().addAll(StaticValues.movieList);
    mdfp.getMovie(1);
    MovieItem movieItem;
    movieItem = mdfp.getMovie(0);
    Assert.assertEquals("John Wick", movieItem.getTitle());
    movieItem = mdfp.getMovie(2);
    Assert.assertEquals("The Equalizer", movieItem.getTitle());
  }
}
