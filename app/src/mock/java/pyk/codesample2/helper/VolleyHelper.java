package pyk.codesample2.helper;

import pyk.codesample2.contract.callback.Callback;

public class VolleyHelper {
  private static final VolleyHelper instance = new VolleyHelper();
  
  public static VolleyHelper getInstance() { return instance; }
  
  void sendRequest(String url, Callback callback) {
    if(url.equals("succeeded")) {
      callback.onResponse("succeeded", true);
    } else {
      callback.onResponse("failed", false);
    }
  }
}
