package pyk.codesample2.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
  private Listener.SwipyListener listener;
  
  public MovieListItemAdapter(Context context, Listener.SwipyListener listener) {
    presenter = new MovieListItemAdapterPresenter(this);
    this.context = context;
    this.listener = listener;
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
      if (context == null) {
        Log.e("asdf", "null");
      }
      LayoutInflater layoutInflater = LayoutInflater.from(context);
      view = layoutInflater.inflate(R.layout.item_movie, null);
    }
    
    TextView title = view.findViewById(R.id.tv_title_movieItem);
    
    title.setText(movieItem.getTitle());
    
    return view;
  }
  
  @Override public void triggerRefresh(int maxPages) {
    pageCount++;
    this.maxPages = maxPages;
    notifyDataSetChanged();
    listener.listPopulate();
  }
  
  @Override public void requestNextPage() {
    if(pageCount <= maxPages) {
      presenter.pullData(pageCount);
    }
  }
  
  @Override public void onError(String error) {
    listener.networkError(error);
  }
}
