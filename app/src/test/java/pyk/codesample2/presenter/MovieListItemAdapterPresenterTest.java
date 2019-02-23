package pyk.codesample2.presenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pyk.codesample2.contract.callback.Callback;
import pyk.codesample2.helper.TMDBHelper;
import pyk.codesample2.presenter.adapter.MovieListItemAdapterPresenter;
import pyk.model.item.MovieItem;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class MovieListItemAdapterPresenterTest {
  private MovieListItemAdapterPresenter mliap;
  
  @Mock
  TMDBHelper tmdbHelper;
  
  @Captor
  private ArgumentCaptor<Callback> captor;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mliap = new MovieListItemAdapterPresenter(tmdbHelper);
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
  
  @Test
  public void pullData_CallsTMDBHelper() {
    mliap.pullData(0);
    verify(tmdbHelper).getMovies(eq(0), captor.capture());
  }
}
