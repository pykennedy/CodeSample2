package pyk.codesample2.presenter.adapter;

import pyk.codesample2.contract.adapter.MovieListItemAdapterContract;
import pyk.codesample2.contract.callback.Callback;
import pyk.codesample2.helper.TMDBHelper;
import pyk.model.MovieList;
import pyk.model.item.MovieItem;

public class MovieListItemAdapterPresenter
    implements MovieListItemAdapterContract.MovieListItemAdapterPresenter {
  
  private TMDBHelper tmdbHelper;
  
  public MovieListItemAdapterPresenter() {
    tmdbHelper = TMDBHelper.getInstance();
  }
  
  @Override public void notifyOfUpdates() {
  
  }
  
  @Override public void pullData(int page) {
    tmdbHelper.getMovies(0, new Callback() {
      @Override public void onResponse(String response, boolean succeeded) {
        if(succeeded) {
          processList(response);
        }
      }
    });
  }
  
  @Override public void processList(String raw) {
  
  }
  
  @Override public MovieItem getMovie(int index) {
    return MovieList.getInstance().getMovies().get(index);
  }
  
  @Override public int getCount() {
    return MovieList.getInstance().getCount();
  }
  
  /****************************************************************************************
   dependency injection for testing, no production code allowed beyond this point
   ***************************************************************************************/
  
  public MovieListItemAdapterPresenter(TMDBHelper tmdbHelper) {
    this.tmdbHelper = tmdbHelper;
  }
}
