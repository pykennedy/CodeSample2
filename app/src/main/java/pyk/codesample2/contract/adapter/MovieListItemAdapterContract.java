package pyk.codesample2.contract.adapter;

import pyk.model.item.MovieItem;

public class MovieListItemAdapterContract {
  public interface MovieListItemAdapterView {
    void triggerRefresh(int maxPages);
    void requestNextPage();
  }
  
  public interface MovieListItemAdapterPresenter {
    void notifyOfUpdates(int maxPages);
    void pullData(int page);
    void processList(String raw);
    MovieItem getMovie(int index);
    int getCount();
  }
}
