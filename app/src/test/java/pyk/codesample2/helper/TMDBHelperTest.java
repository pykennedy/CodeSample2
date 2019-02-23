package pyk.codesample2.helper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pyk.codesample2.contract.callback.Callback;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class TMDBHelperTest {
  private TMDBHelper tmdbHelper;
  
  @Mock
  private VolleyHelper volleyHelper;
  
  @Captor
  private ArgumentCaptor<Callback> captor;
  
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    tmdbHelper = new TMDBHelper(volleyHelper);
  }
  
  @Test
  public void getMovies_CallsVolley() {
    tmdbHelper.getMovies(0, new Callback() {
      @Override public void onResponse(String response, boolean succeeded) {
        // do nothing
      }
    });
    verify(volleyHelper).sendRequest(eq("succeeded"), captor.capture());
  }
  
  @Test
  public void getMovies_CallbackSucceeded() {
    // page 0 = force a success
    tmdbHelper.getMovies(0, new Callback() {
      @Override public void onResponse(String response, boolean succeeded) {
        // do nothing
      }
    });
    verify(volleyHelper).sendRequest(eq("succeeded"), captor.capture());
    captor.getValue().onResponse("succeeded", true);
  }
  
  @Test
  public void getMovies_CallbackFailed() {
    // page 1 = force a failure
    tmdbHelper.getMovies(1, new Callback() {
      @Override public void onResponse(String response, boolean succeeded) {
        // do nothing
      }
    });
    verify(volleyHelper).sendRequest(eq("failed"), captor.capture());
    captor.getValue().onResponse("failed", false);
  }
}
