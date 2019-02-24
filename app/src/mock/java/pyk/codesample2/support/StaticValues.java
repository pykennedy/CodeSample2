package pyk.codesample2.support;

import java.util.ArrayList;
import java.util.List;

import pyk.model.item.MovieItem;

public class StaticValues {
  public static final String volleyResponse  =
      "{\"page\":1,\"total_results\":1904,\"total_pages\":96,\"results\":[{\"vote_count\":9082,\"id\":245891,\"video\":false,\"vote_average\":7.1,\"title\":\"John Wick\",\"popularity\":36.225,\"poster_path\":\"/5vHssUeVe25bMrof1HyaPyWgaP.jpg\",\"original_language\":\"en\",\"original_title\":\"John Wick\",\"genre_ids\":[28,53],\"backdrop_path\":\"/umC04Cozevu8nn3JTDJ1pc7PVTn.jpg\",\"adult\":false,\"overview\":\"Ex-hitman John Wick comes out of retirement to track down the gangsters that took everything from him.\",\"release_date\":\"2014-10-22\"},{\"vote_count\":9679,\"id\":210577,\"video\":false,\"vote_average\":7.9,\"title\":\"Gone Girl\",\"popularity\":34.732,\"poster_path\":\"/gdiLTof3rbPDAmPaCf4g6op46bj.jpg\",\"original_language\":\"en\",\"original_title\":\"Gone Girl\",\"genre_ids\":[9648,53,18],\"backdrop_path\":\"/8ZNGBfGoN3uI5Akj5vEUDMxvmGO.jpg\",\"adult\":false,\"overview\":\"With his wife's disappearance having become the focus of an intense media circus, a man sees the spotlight turned on him when it's suspected that he may not be innocent.\",\"release_date\":\"2014-10-01\"},{\"vote_count\":4656,\"id\":156022,\"video\":false,\"vote_average\":7.2,\"title\":\"The Equalizer\",\"popularity\":26.329,\"poster_path\":\"/2eQfjqlvPAxd9aLDs8DvsKLnfed.jpg\",\"original_language\":\"en\",\"original_title\":\"The Equalizer\",\"genre_ids\":[53,28,80],\"backdrop_path\":\"/hEJ52KqwOmyRpcihs10h7xOwN7e.jpg\",\"adult\":false,\"overview\":\"McCall believes he has put his mysterious past behind him and dedicated himself to beginning a new, quiet life. But when he meets Teri, a young girl under the control of ultra-violent Russian gangsters, he can’t stand idly by – he has to help her. Armed with hidden skills that allow him to serve vengeance against anyone who would brutalize the helpless, McCall comes out of his self-imposed retirement and finds his desire for justice reawakened. If someone has a problem, if the odds are stacked against them, if they have nowhere else to turn, McCall will help. He is The Equalizer.\",\"release_date\":\"2014-09-24\"}]}";
  public static final String volleyResponse2 =
      "{\"page\":2,\"total_results\":1904,\"total_pages\":96,\"results\":[{\"vote_count\":9082,\"id\":245891,\"video\":false,\"vote_average\":7.1,\"title\":\"John Wick 2\",\"popularity\":36.225,\"poster_path\":\"/5vHssUeVe25bMrof1HyaPyWgaP.jpg\",\"original_language\":\"en\",\"original_title\":\"John Wick\",\"genre_ids\":[28,53],\"backdrop_path\":\"/umC04Cozevu8nn3JTDJ1pc7PVTn.jpg\",\"adult\":false,\"overview\":\"Ex-hitman John Wick comes out of retirement to track down the gangsters that took everything from him.\",\"release_date\":\"2014-10-22\"},{\"vote_count\":9679,\"id\":210577,\"video\":false,\"vote_average\":7.9,\"title\":\"Gone Girl 2\",\"popularity\":34.732,\"poster_path\":\"/gdiLTof3rbPDAmPaCf4g6op46bj.jpg\",\"original_language\":\"en\",\"original_title\":\"Gone Girl\",\"genre_ids\":[9648,53,18],\"backdrop_path\":\"/8ZNGBfGoN3uI5Akj5vEUDMxvmGO.jpg\",\"adult\":false,\"overview\":\"With his wife's disappearance having become the focus of an intense media circus, a man sees the spotlight turned on him when it's suspected that he may not be innocent.\",\"release_date\":\"2014-10-01\"},{\"vote_count\":4656,\"id\":156022,\"video\":false,\"vote_average\":7.2,\"title\":\"The Equalizer\",\"popularity\":26.329,\"poster_path\":\"/2eQfjqlvPAxd9aLDs8DvsKLnfed.jpg\",\"original_language\":\"en\",\"original_title\":\"The Equalizer 2\",\"genre_ids\":[53,28,80],\"backdrop_path\":\"/hEJ52KqwOmyRpcihs10h7xOwN7e.jpg\",\"adult\":false,\"overview\":\"McCall believes he has put his mysterious past behind him and dedicated himself to beginning a new, quiet life. But when he meets Teri, a young girl under the control of ultra-violent Russian gangsters, he can’t stand idly by – he has to help her. Armed with hidden skills that allow him to serve vengeance against anyone who would brutalize the helpless, McCall comes out of his self-imposed retirement and finds his desire for justice reawakened. If someone has a problem, if the odds are stacked against them, if they have nowhere else to turn, McCall will help. He is The Equalizer.\",\"release_date\":\"2014-09-24\"}]}";
  
  public static final List<MovieItem> movieList = buildMovieList();
  
  private static List<MovieItem> buildMovieList() {
    List<MovieItem> movieList = new ArrayList<>();
    List<Integer>   genres    = new ArrayList<>();
    
    genres.add(28);
    genres.add(53);
    movieList.add(new MovieItem(
        "John Wick"
        , "2014-10-22"
        , genres
        , 7.1
        , "Ex-hitman John Wick comes out of retirement to track down the gangsters that took everything from him."
        , "\\/5vHssUeVe25bMrof1HyaPyWgaP.jpg"
        , "\\/umC04Cozevu8nn3JTDJ1pc7PVTn.jpg"));
    
    genres.clear();
    genres.add(9648);
    genres.add(53);
    genres.add(18);
    movieList.add(new MovieItem(
        "Gone Girl"
        , "2014-10-01"
        , genres
        , 7.9
        , "With his wife's disappearance having become the focus of an intense media circus, a man sees the spotlight turned on him when it's suspected that he may not be innocent."
        , "\\/gdiLTof3rbPDAmPaCf4g6op46bj.jpg"
        , "\\/8ZNGBfGoN3uI5Akj5vEUDMxvmGO.jpg"));
    
    genres.clear();
    genres.add(53);
    genres.add(28);
    genres.add(80);
    movieList.add(new MovieItem(
        "The Equalizer"
        , "2014-09-24"
        , genres
        , 7.2
        , "McCall believes he has put his mysterious past behind him and dedicated himself to beginning a new, quiet life. But when he meets Teri, a young girl under the control of ultra-violent Russian gangsters, he can’t stand idly by – he has to help her. Armed with hidden skills that allow him to serve vengeance against anyone who would brutalize the helpless, McCall comes out of his self-imposed retirement and finds his desire for justice reawakened. If someone has a problem, if the odds are stacked against them, if they have nowhere else to turn, McCall will help. He is The Equalizer."
        , "\\/2eQfjqlvPAxd9aLDs8DvsKLnfed.jpg"
        , "\\/6bbZ6XyvgfjhQwbplnUh1LSj1ky.jpg"));
    
    genres.add(28);
    genres.add(53);
    movieList.add(new MovieItem(
        "John Wick 2"
        , "2014-10-22"
        , genres
        , 7.1
        , "Ex-hitman John Wick comes out of retirement to track down the gangsters that took everything from him."
        , "\\/5vHssUeVe25bMrof1HyaPyWgaP.jpg"
        , "\\/umC04Cozevu8nn3JTDJ1pc7PVTn.jpg"));
    
    genres.clear();
    genres.add(9648);
    genres.add(53);
    genres.add(18);
    movieList.add(new MovieItem(
        "Gone Girl 2"
        , "2014-10-01"
        , genres
        , 7.9
        , "With his wife's disappearance having become the focus of an intense media circus, a man sees the spotlight turned on him when it's suspected that he may not be innocent."
        , "\\/gdiLTof3rbPDAmPaCf4g6op46bj.jpg"
        , "\\/8ZNGBfGoN3uI5Akj5vEUDMxvmGO.jpg"));
    
    genres.clear();
    genres.add(53);
    genres.add(28);
    genres.add(80);
    movieList.add(new MovieItem(
        "The Equalizer 2"
        , "2014-09-24"
        , genres
        , 7.2
        , "McCall believes he has put his mysterious past behind him and dedicated himself to beginning a new, quiet life. But when he meets Teri, a young girl under the control of ultra-violent Russian gangsters, he can’t stand idly by – he has to help her. Armed with hidden skills that allow him to serve vengeance against anyone who would brutalize the helpless, McCall comes out of his self-imposed retirement and finds his desire for justice reawakened. If someone has a problem, if the odds are stacked against them, if they have nowhere else to turn, McCall will help. He is The Equalizer."
        , "\\/2eQfjqlvPAxd9aLDs8DvsKLnfed.jpg"
        , "\\/6bbZ6XyvgfjhQwbplnUh1LSj1ky.jpg"));
    
    return movieList;
  }
}
