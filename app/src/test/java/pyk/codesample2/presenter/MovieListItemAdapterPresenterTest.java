package pyk.codesample2.presenter;

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
import pyk.model.item.MovieItem;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class MovieListItemAdapterPresenterTest {
  private MovieListItemAdapterPresenter mliap;
  
  @Mock
  private TMDBHelper tmdbHelper;
  @Mock
  private MovieListItemAdapterContract.MovieListItemAdapterView mliav;
  
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
    movieItem = mliap.getMovie(0);
    Assert.assertEquals("John Wick", movieItem.getTitle());
    movieItem = mliap.getMovie(2);
    Assert.assertEquals("The Equalizer", movieItem.getTitle());
  }
  
  @Test
  public void getCount() {
    int count = mliap.getCount();
    Assert.assertEquals(3, count);
  }
  
  @Test
  public void pullData_CallsTMDBHelper() {
    mliap.pullData(0);
    verify(tmdbHelper).getMovies(eq(0), captor.capture());
  }
  
  @Test
  public void pullData_CallbackSucceeded() {
    mliap.pullData(0);
    verify(tmdbHelper).getMovies(eq(0), captor.capture());
    captor.getValue().onResponse(StaticValues.volleyResponse, false);
  }
  
  @Test
  public void pullData_CallbackFailed() {
    mliap.pullData(1);
    verify(tmdbHelper).getMovies(eq(0), captor.capture());
    captor.getValue().onResponse("Failed", false);
  }
  
  @Test
  public void processList() {
    mliap = new MovieListItemAdapterPresenter(mliav);
    mliap.processList(StaticValues.volleyResponse);
    Assert.assertEquals(3, mliap.getCount());
    Assert.assertEquals("Gone Girl", mliap.getMovie(1).getTitle());
  }
  
  @Test
  public void notifyOfUpdates_UpdatesAdapter() {
    mliap = new MovieListItemAdapterPresenter(mliav);
    mliap.notifyOfUpdates(9999);
    verify(mliav).triggerRefresh(9999);
  }
}
