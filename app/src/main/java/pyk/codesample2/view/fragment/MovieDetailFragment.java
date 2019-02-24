package pyk.codesample2.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pyk.codesample2.App;
import pyk.codesample2.R;
import pyk.model.MovieList;
import pyk.model.item.MovieItem;

public class MovieDetailFragment extends Fragment {
  
  private MovieList movieList;
  private ImageView backdrop;
  private TextView title;
  private TextView genres;
  private TextView rating;
  private TextView overview;
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    movieList = MovieList.getInstance();
    
    ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_moviedetail, container,
                                                      false);
    backdrop = rootView.findViewById(R.id.iv_backdrop_movieDetail);
    title = rootView.findViewById(R.id.tv_title_movieDetail);
    genres = rootView.findViewById(R.id.tv_genres_movieDetail);
    rating = rootView.findViewById(R.id.tv_rating_movieDetail);
    overview = rootView.findViewById(R.id.tv_overview_movieDetail);
    
    return rootView;
  }
  
  public void updateDetails(int i) {
    MovieItem movieItem = movieList.getMovies().get(i);
    String releaseDate = null;
    
    if(movieItem.getRelease_date() != null) {
      releaseDate = movieItem.getRelease_date().substring(0, 4);
    }
    
    title.setText(movieItem.getTitle() + " (" + releaseDate + ")");
    genres.setText(movieItem.getParsedGenres());
    rating.setText(Double.toString(movieItem.getVote_average()));
    overview.setText(movieItem.getOverview());
    Glide.with(App.getContext()).load(
        "http://image.tmdb.org/t/p/w1280/" + movieItem.getBackdrop_path()).into(backdrop);
  }
}
