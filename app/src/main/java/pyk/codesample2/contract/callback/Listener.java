package pyk.codesample2.contract.callback;

import pyk.model.item.MovieItem;

public class Listener {
  public interface SwipyListener {
    public void listPopulate();
    public void networkError(String error);
  }
  
  public interface movieItemClickListener {
    public void itemClicked(MovieItem movieItem);
  }
}
