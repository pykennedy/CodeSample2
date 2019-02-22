package pyk.codesample2.presenter.adapter;

import pyk.codesample2.contract.MovieListItemAdapterContract;
import pyk.model.MovieList;
import pyk.model.item.MovieItem;

public class MovieListItemAdapterPresenter
    implements MovieListItemAdapterContract.MovieListItemAdapterPresenter {
  
  @Override public void notifyOfUpdates() {
  
  }
  
  @Override public void pullData(int page) {
  
  }
  
  @Override public void processList(String raw) {
  
  }
  
  @Override public MovieItem getMovie(int index) {
    return MovieList.getInstance().getMovies().get(index);
  }
  
  @Override public int getCount() {
    return MovieList.getInstance().getCount();
  }
}
