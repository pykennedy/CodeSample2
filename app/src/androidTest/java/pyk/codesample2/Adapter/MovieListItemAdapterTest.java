package pyk.codesample2.Adapter;

import android.os.IBinder;
import android.support.test.espresso.Root;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.WindowManager;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
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
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
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
  
  @Test
  public void endOfPages() {
    MainActivity activity = mainActivityActivityTestRule.getActivity();
    onView(ViewMatchers.withId(R.id.srl_list_fragmentMovieList)).perform(ViewActions.swipeUp());
    onView(ViewMatchers.withId(R.id.srl_list_fragmentMovieList)).perform(ViewActions.swipeUp());
    onView(ViewMatchers.withId(R.id.srl_list_fragmentMovieList)).perform(ViewActions.swipeUp());
    onView(withText("No More Movies to Pull!")).inRoot(new ToastMatcher()).check(
        matches(isDisplayed()));
  }
}

class ToastMatcher extends TypeSafeMatcher<Root> {
  
  @Override public void describeTo(Description description) {
    description.appendText("is toast");
  }
  
  @Override public boolean matchesSafely(Root root) {
    int type = root.getWindowLayoutParams().get().type;
    if ((type == WindowManager.LayoutParams.TYPE_TOAST)) {
      IBinder windowToken = root.getDecorView().getWindowToken();
      IBinder appToken    = root.getDecorView().getApplicationWindowToken();
      if (windowToken == appToken) {
        return true;
      }
    }
    return false;
  }
}