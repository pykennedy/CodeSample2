package pyk.codesample2.Adapter;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pyk.codesample2.R;
import pyk.codesample2.support.StaticValues;
import pyk.codesample2.view.activity.MainActivity;
import pyk.model.MovieList;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MovieListItemAdapterTest {
  @Rule
  public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(
      MainActivity.class);
  
  @After
  public void cleanup() {
    MovieList.getInstance().getMovies().clear();
  }
  
  @Test
  public void itemsExist() {
    onView(withId(R.id.gv_list_fragmentMovieList)).check(
        matches(hasDescendant(withText(StaticValues.movieList.get(0).getTitle()))));
  }
  
  @Test
  public void swipeLoadsMoreMovies() {
    onView(ViewMatchers.withId(R.id.srl_list_fragmentMovieList)).perform(ViewActions.swipeUp());
    // hard coded because the test didn't like pulling from StaticValues for some reason.
    onView(withId(R.id.gv_list_fragmentMovieList)).check(
        matches(hasDescendant(withText("John Wick 2"))));
  }
}
