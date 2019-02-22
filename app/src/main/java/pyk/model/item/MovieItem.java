package pyk.model.item;

import java.util.List;

public class MovieItem {
  private String        title;
  private String        release_date;
  private List<Integer> genre_ids;
  private double        vote_average;
  private String        overview;
  private String        poster_path;
  
  public MovieItem(String title, String release_date, List<Integer> genre_ids, double vote_average, String overview, String poster_path) {
    this.title = title;
    this.release_date = release_date;
    this.genre_ids = genre_ids;
    this.vote_average = vote_average;
    this.overview = overview;
    this.poster_path = poster_path;
  }
  
  public String getTitle() {
    return title;
  }
  
  public String getRelease_date() {
    return release_date;
  }
  
  public List<Integer> getGenre_ids() {
    return genre_ids;
  }
  
  public double getVote_average() {
    return vote_average;
  }
  
  public String getOverview() {
    return overview;
  }
}
