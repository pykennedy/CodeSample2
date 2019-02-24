package pyk.codesample2.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.omadahealth.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.omadahealth.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import pyk.codesample2.R;
import pyk.codesample2.contract.callback.Listener;
import pyk.codesample2.view.activity.MainActivity;
import pyk.codesample2.view.adapter.MovieListItemAdapter;

public class MovieListFragment extends Fragment implements Listener.SwipyListener {
  
  private SwipyRefreshLayout swipyRefreshLayout;
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    setRetainInstance(true);
    ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_movielist, container,
                                                      false);
    GridView gridView = rootView.findViewById(
        R.id.gv_list_fragmentMovieList);
    final MovieListItemAdapter movieListItemAdapter = new MovieListItemAdapter(getActivity(), this,
                                                                               (MainActivity) getActivity());
    gridView.setAdapter(movieListItemAdapter);
    
    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ((MainActivity) getActivity()).updateMovieDetailFragment(i);
      }
    });
    
    swipyRefreshLayout = rootView.findViewById(R.id.srl_list_fragmentMovieList);
    swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh(SwipyRefreshLayoutDirection direction) {
        movieListItemAdapter.requestNextPage();
      }
    });
    
    return rootView;
  }
  
  @Override public void listPopulate() {
    if (swipyRefreshLayout != null) { // null check as it had crashed due to null pointer one time
      swipyRefreshLayout.setRefreshing(false); // on success, otherwise it will spin forever
    }
  }
  
  @Override public void networkError(String error) {
    if (swipyRefreshLayout != null) {
      swipyRefreshLayout.setRefreshing(false); // on fail, otherwise it will spin forever
    }
    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
  }
}
