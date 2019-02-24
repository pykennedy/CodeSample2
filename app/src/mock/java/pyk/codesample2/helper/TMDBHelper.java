package pyk.codesample2.helper;

import java.util.HashMap;

import pyk.codesample2.contract.callback.Callback;

public class TMDBHelper {
  private static final TMDBHelper               instance     = new TMDBHelper();
  private              VolleyHelper             volleyHelper;
  private              HashMap<Integer, String> genreMapping = new HashMap<>();
  
  private TMDBHelper() {
    this.volleyHelper = VolleyHelper.getInstance();
  }
  
  public static TMDBHelper getInstance() { return instance; }
  
  public void getMovies(int page, final Callback callback) {
    if (page <= 2) {
      volleyHelper.sendRequest("page " + page, new Callback() {
        @Override public void onResponse(String response, boolean succeeded) {
          if (succeeded) {
            callback.onResponse(response, true);
          } else {
            // should never happen
            callback.onResponse("failed", false);
          }
        }
      });
    } else if (page == 3) {
      callback.onResponse("No More Movies to Pull!", false);
    }
    else {
      volleyHelper.sendRequest("failed", new Callback() {
        @Override public void onResponse(String response, boolean succeeded) {
          if (succeeded) {
            // should never happen
            callback.onResponse(response, true);
          } else {
            callback.onResponse("failed", false);
          }
        }
      });
    }
  }
  
  public String getGenre(int id) {
    // hardcoded to avoid needless network calls for static data
    if (genreMapping.isEmpty()) {
      genreMapping.put(28, "Action");
      genreMapping.put(12, "Adventure");
      genreMapping.put(16, "Animation");
      genreMapping.put(35, "Comedy");
      genreMapping.put(80, "Crime");
      genreMapping.put(99, "Documentary");
      genreMapping.put(18, "Drama");
      genreMapping.put(10751, "Family");
      genreMapping.put(14, "Fantasy");
      genreMapping.put(36, "History");
      genreMapping.put(27, "Horror");
      genreMapping.put(10402, "Music");
      genreMapping.put(9648, "Mystery");
      genreMapping.put(10749, "Romance");
      genreMapping.put(878, "Science Fiction");
      genreMapping.put(10770, "TV Movie");
      genreMapping.put(53, "Thriller");
      genreMapping.put(10752, "War");
      genreMapping.put(37, "Western");
    }
    return genreMapping.get(id);
  }
  
  /****************************************************************************************
   dependency injection for testing, no production code allowed beyond this point
   ***************************************************************************************/
  
  public TMDBHelper(VolleyHelper volleyHelper) {
    this.volleyHelper = volleyHelper;
  }
}
