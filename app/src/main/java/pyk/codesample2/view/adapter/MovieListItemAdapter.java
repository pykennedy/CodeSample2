package pyk.codesample2.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pyk.codesample2.App;
import pyk.codesample2.R;
import pyk.codesample2.contract.adapter.MovieListItemAdapterContract;
import pyk.codesample2.contract.callback.Listener;
import pyk.codesample2.presenter.adapter.MovieListItemAdapterPresenter;
import pyk.model.item.MovieItem;

public class MovieListItemAdapter extends BaseAdapter
    implements MovieListItemAdapterContract.MovieListItemAdapterView {
  
  private MovieListItemAdapterPresenter presenter;
  private Context                       context;
  private int                           pageCount = 1;
  private int                           maxPages  = 2;
  private Listener.SwipyListener        listener;
  
  public MovieListItemAdapter(Context context, Listener.SwipyListener listener) {
    presenter = new MovieListItemAdapterPresenter(this);
    this.context = context;
    this.listener = listener;
    // begin pulling movies immediately
    presenter.pullData(pageCount);
  }
  
  @Override public int getCount() {
    return presenter.getCount();
  }
  
  @Override public Object getItem(int i) {
    return null;
  }
  
  @Override public long getItemId(int i) {
    return 0;
  }
  
  @Override public View getView(int i, View view, ViewGroup viewGroup) {
    MovieItem movieItem = presenter.getMovie(i);
    
    if (view == null) {
      LayoutInflater layoutInflater = LayoutInflater.from(context);
      view = layoutInflater.inflate(R.layout.item_movie, null);
    }
    
    ImageView poster = view.findViewById(R.id.iv_poster_movieItem);
    TextView  title  = view.findViewById(R.id.tv_title_movieItem);
    TextView  rating = view.findViewById(R.id.tv_rating_movieItem);
    
    title.setText(movieItem.getTitle());
    rating.setText(Double.toString(movieItem.getVote_average()));
    
    Glide.with(App.getContext()).load(
        "http://image.tmdb.org/t/p/w300/" + movieItem.getPoster_path()).into(poster);
    
    return view;
  }
  
  @Override public void triggerRefresh(int maxPages) {
    // increment page count only on success
    pageCount++;
    // should the max page count change mid session
    this.maxPages = maxPages;
    notifyDataSetChanged();
    listener.listPopulate();
  }
  
  @Override public void requestNextPage() {
    // avoid network calls by not even attempting to pull data if at max pages
    if (pageCount <= maxPages) {
      presenter.pullData(pageCount);
    }
  }
  
  @Override public void onError(String error) {
    listener.networkError(error);
  }
}
