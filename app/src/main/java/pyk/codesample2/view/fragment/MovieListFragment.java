package pyk.codesample2.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omadahealth.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.omadahealth.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import pyk.codesample2.R;

public class MovieListFragment extends Fragment {
  
  private SwipyRefreshLayout swipyRefreshLayout;
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_movielist, container,
                                                      false);
    RecyclerView recyclerView = rootView.findViewById(R.id.rv_list_fragmentMovieList);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    
    swipyRefreshLayout = rootView.findViewById(R.id.srl_list_fragmentMovieList);
    swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh(SwipyRefreshLayoutDirection direction) {
      
      }
    });
    
    return rootView;
  }
}
