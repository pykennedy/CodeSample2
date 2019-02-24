package pyk.codesample2.presenter.adapter;

import com.google.gson.Gson;

import pyk.codesample2.contract.adapter.MovieListItemAdapterContract;
import pyk.codesample2.contract.callback.Callback;
import pyk.codesample2.helper.TMDBHelper;
import pyk.model.MovieList;
import pyk.model.TMDBRawJson;
import pyk.model.item.MovieItem;

public class MovieListItemAdapterPresenter
    implements MovieListItemAdapterContract.MovieListItemAdapterPresenter {
  
  private TMDBHelper tmdbHelper;
  private MovieList movieList;
  private MovieListItemAdapterContract.MovieListItemAdapterView mliav;
  
  public MovieListItemAdapterPresenter(MovieListItemAdapterContract.MovieListItemAdapterView mliav) {
    tmdbHelper = TMDBHelper.getInstance();
    movieList = MovieList.getInstance();
    this.mliav = mliav;
  }
  
  @Override public void notifyOfUpdates(int maxPages) {
    mliav.triggerRefresh(maxPages);
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
    Gson gson = new Gson();
    /*
    due to the structure of TMDb JSON where all movie details are an entire node
    and not broken out into a hierarchy of movie id, then details i'm forced to first
    make a class that stores the whole json first, then pick out items.
    see TMDbRawJson for what's going on
    */
    TMDBRawJson json = gson.fromJson(raw, TMDBRawJson.class);
    if (json == null) {
      return;
    }
    // convert raw json to MovieItem objects
    for (MovieItem mi : json.getResults()) {
      // convert genre ID's to a concatenated genre string: genre1 | genre2 | genre3
      // using string builder for optimization
      StringBuilder genres = new StringBuilder("");
      for (int i : mi.getGenre_ids()) {
        if (genres.length() < 1) {
          genres.append(tmdbHelper.getGenre(i));
        } else {
          genres.append(" | ");
          genres.append(tmdbHelper.getGenre(i));
        }
      }
      mi.setParsedGenres(genres.toString());
  
      movieList.getMovies().add(mi);
    }
    
    notifyOfUpdates(json.getTotal_pages());
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
