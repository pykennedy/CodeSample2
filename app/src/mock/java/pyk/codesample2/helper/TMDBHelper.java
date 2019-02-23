package pyk.codesample2.helper;

import pyk.codesample2.contract.callback.Callback;

public class TMDBHelper {
  private static final TMDBHelper instance = new TMDBHelper();
  private VolleyHelper volleyHelper;
  
  private TMDBHelper() {
    this.volleyHelper = VolleyHelper.getInstance();
  }
  
  public static TMDBHelper getInstance() { return instance; }
  
  public void getMovies(int page, final Callback callback) {
    if (page == 0) {
      volleyHelper.sendRequest("succeeded", new Callback() {
        @Override public void onResponse(String response, boolean succeeded) {
          if (succeeded) {
            callback.onResponse("succeeded", true);
          } else {
            // should never happen
            callback.onResponse("failed", false);
          }
        }
      });
    } else {
      volleyHelper.sendRequest("failed", new Callback() {
        @Override public void onResponse(String response, boolean succeeded) {
          if (succeeded) {
            // should never happen
            callback.onResponse("succeeded", true);
          } else {
            callback.onResponse("failed", false);
          }
        }
      });
    }
  }
  
  /****************************************************************************************
   dependency injection for testing, no production code allowed beyond this point
   ***************************************************************************************/
  
  public TMDBHelper(VolleyHelper volleyHelper) {
    this.volleyHelper = volleyHelper;
  }
}
