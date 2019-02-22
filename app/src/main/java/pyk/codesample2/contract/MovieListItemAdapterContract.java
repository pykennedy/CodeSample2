package pyk.codesample2.contract;

import pyk.model.item.MovieItem;

public class MovieListItemAdapterContract {
  public interface MovieListItemAdapterView {
    void triggerRefresh();
    void requestNextPage();
  }
  
  public interface MovieListItemAdapterPresenter {
    void notifyOfUpdates();
    void pullData(int page);
    void processList(String raw);
    MovieItem getMovie(int index);
    int getCount();
  }
}
