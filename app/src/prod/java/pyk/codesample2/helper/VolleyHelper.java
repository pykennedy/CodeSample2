package pyk.codesample2.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import pyk.codesample2.App;
import pyk.codesample2.contract.callback.Callback;

public class VolleyHelper {
  private static final VolleyHelper instance = new VolleyHelper();
  private static final RequestQueue queue    = Volley.newRequestQueue(App.getContext());
  
  public static VolleyHelper getInstance() { return instance; }
  
  void sendRequest(String url, final Callback callback) {
    ConnectivityManager cm = (ConnectivityManager) App.getContext().getSystemService(
        Context.CONNECTIVITY_SERVICE);
    
    if(cm.getActiveNetworkInfo() == null) {
      callback.onResponse("No Internet Connection!", false);
    }
  
    StringRequest request =
        new StringRequest(Request.Method.GET, url,
                          new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                              callback.onResponse(response, true);
                            }
                          }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            callback.onResponse(error.toString(), false);
            Log.e("asdf", error.toString());
          }
        });
    queue.add(request);
  }
}