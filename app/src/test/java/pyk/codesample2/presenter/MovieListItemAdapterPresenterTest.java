package pyk.codesample2.presenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import pyk.codesample2.presenter.adapter.MovieListItemAdapterPresenter;
import pyk.model.item.MovieItem;

public class MovieListItemAdapterPresenterTest {
  private MovieListItemAdapterPresenter mliap;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mliap = new MovieListItemAdapterPresenter();
  }
  
  @Test
  public void getMovie() {
    MovieItem movieItem;
    movieItem = mliap.getMovie(2);
    Assert.assertEquals("Movie #2", movieItem.getTitle());
    movieItem = mliap.getMovie(197);
    Assert.assertEquals("Movie #197", movieItem.getTitle());
  }
  
  @Test
  public void getCount() {
    int count = mliap.getCount();
    Assert.assertEquals(200, count);
  }
}
