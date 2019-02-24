package pyk.codesample2.contract.fragment;

import pyk.model.item.MovieItem;

public class MovieDetailFragmentContract {
  public interface MovieDetailFragmentView {
  
  }
  
  public interface MovieDetailFragmentPresenter {
    public MovieItem getMovie(int i);
  }
}
