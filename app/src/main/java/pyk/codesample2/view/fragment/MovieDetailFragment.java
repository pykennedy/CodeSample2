package pyk.codesample2.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pyk.codesample2.R;

public class MovieDetailFragment extends Fragment {
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_moviedetail, container,
                                                      false);
    
    return rootView;
  }
}
