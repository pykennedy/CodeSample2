package pyk.codesample2.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.omadahealth.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.omadahealth.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import pyk.codesample2.R;
import pyk.codesample2.view.adapter.MovieListItemAdapter;

public class MovieListFragment extends Fragment {
  
  private SwipyRefreshLayout swipyRefreshLayout;
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_movielist, container,
                                                      false);
    GridView             gridView     = rootView.findViewById(R.id.gv_list_fragmentMovieList);
    MovieListItemAdapter booksAdapter = new MovieListItemAdapter(getActivity());
    gridView.setAdapter(booksAdapter);
    
    swipyRefreshLayout = rootView.findViewById(R.id.srl_list_fragmentMovieList);
    swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh(SwipyRefreshLayoutDirection direction) {
      
      }
    });
    
    return rootView;
  }
}
