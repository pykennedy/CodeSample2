package pyk.codesample2.presenter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pyk.codesample2.contract.adapter.MovieListItemAdapterContract;
import pyk.codesample2.contract.callback.Callback;
import pyk.codesample2.helper.TMDBHelper;
import pyk.codesample2.presenter.adapter.MovieListItemAdapterPresenter;
import pyk.codesample2.support.StaticValues;
import pyk.model.MovieList;
import pyk.model.item.MovieItem;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class MovieListItemAdapterPresenterTest {
  private MovieListItemAdapterPresenter mliap;
  private MovieList movieList;
  
  @Mock
  private TMDBHelper tmdbHelper;
  @Mock
  private MovieListItemAdapterContract.MovieListItemAdapterView mliav;
  
  @Captor
  private ArgumentCaptor<Callback> captor;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    movieList = MovieList.getInstance();
    mliap = new MovieListItemAdapterPresenter(tmdbHelper, movieList, mliav);
  }
  
  @After
  public void cleanup() {
    movieList.getMovies().clear();
  }
  
  @Test
  public void getMovie() {
    mliap = new MovieListItemAdapterPresenter(mliav);
    mliap.pullData(1);
    MovieItem movieItem;
    movieItem = mliap.getMovie(0);
    Assert.assertEquals("John Wick", movieItem.getTitle());
    movieItem = mliap.getMovie(2);
    Assert.assertEquals("The Equalizer", movieItem.getTitle());
  }
  
  @Test
  public void getCount() {
    mliap = new MovieListItemAdapterPresenter(mliav);
    mliap.pullData(1);
    int count = mliap.getCount();
    Assert.assertEquals(3, count);
  }
  
  @Test
  public void pullData_CallsTMDBHelper() {
    mliap.pullData(1);
    verify(tmdbHelper).getMovies(eq(1), captor.capture());
  }
  
  @Test
  public void pullData_CallbackSucceeded() {
    mliap.pullData(1);
    verify(tmdbHelper).getMovies(eq(1), captor.capture());
    captor.getValue().onResponse(StaticValues.volleyResponse, true);
  }
  
  @Test
  public void pullData_CallbackFailed() {
    mliap.pullData(3);
    verify(tmdbHelper).getMovies(eq(3), captor.capture());
    captor.getValue().onResponse("failed", false);
  }
  
  @Test
  public void processList() {
    mliap = new MovieListItemAdapterPresenter(mliav);
    mliap.processList(StaticValues.volleyResponse);
    //Assert.assertEquals(3, mliap.getCount());
    Assert.assertEquals("Gone Girl", mliap.getMovie(1).getTitle());
  }
  
  @Test
  public void notifyOfUpdates_UpdatesAdapter() {
    mliap = new MovieListItemAdapterPresenter(mliav);
    mliap.notifyOfUpdates(9999);
    verify(mliav).triggerRefresh(9999);
  }
}
