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
    final String tmdbURL =
        "http://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2014-09-15&primary_release_date.lte=2014-10-22&page=" +
        page + "&api_key=64b6f3a69e5717b13ed8a56fe4417e71";
    
    volleyHelper.sendRequest(tmdbURL, new Callback() {
      @Override public void onResponse(String response, boolean succeeded) {
        if (succeeded) {
          callback.onResponse(response, true);
        } else {
          callback.onResponse(response, false);
        }
      }
    });
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
