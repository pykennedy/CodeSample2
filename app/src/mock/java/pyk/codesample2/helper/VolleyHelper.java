package pyk.codesample2.helper;

import pyk.codesample2.contract.callback.Callback;
import pyk.codesample2.support.StaticValues;

public class VolleyHelper {
  private static final VolleyHelper instance = new VolleyHelper();
  
  public static VolleyHelper getInstance() { return instance; }
  
  void sendRequest(String url, Callback callback) {
    if(url.equals("failed")) {
      callback.onResponse("failed", false);
    } else {
      callback.onResponse(StaticValues.volleyResponse, true);
    }
  }
}
