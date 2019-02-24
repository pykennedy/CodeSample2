package pyk.codesample2.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import pyk.codesample2.R;
import pyk.codesample2.view.fragment.MovieDetailFragment;
import pyk.codesample2.view.fragment.MovieListFragment;

public class MainActivity extends AppCompatActivity {
  
  private ViewPager                 pager;
  private FragmentStatePagerAdapter pagerAdapter;
  private MovieListFragment movieListFragment;
  private MovieDetailFragment movieDetailFragment;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  
    pager = findViewById(R.id.vp_mainActivity);
    pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
    pager.setAdapter(pagerAdapter);
    pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
    
      @Override
      public void onPageSelected(int position) {}
    
      @Override
      public void onPageScrollStateChanged(int state) {}
    });
  }
  
  public void updateMovieDetailFragment(int i) {
    movieDetailFragment.updateDetails(i);
    pager.setCurrentItem(1);
  }
  
  private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    
    ScreenSlidePagerAdapter(FragmentManager fm) {
      super(fm);
    }
    
    @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0:
          movieListFragment = new MovieListFragment();
          return movieListFragment;
        case 1:
          movieDetailFragment = new MovieDetailFragment();
          return movieDetailFragment;
        default:
          movieListFragment = new MovieListFragment();
          return movieListFragment;
      }
    }
    
    @Override
    public int getCount() {
      return 2;
    }
  }
  
  @Override public void onBackPressed() {
    if (pager.getCurrentItem() == 1) {
      pager.setCurrentItem(0);
    } else {
      super.onBackPressed();
    }
  }
}
