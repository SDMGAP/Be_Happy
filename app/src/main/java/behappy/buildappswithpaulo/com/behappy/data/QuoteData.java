package behappy.buildappswithpaulo.com.behappy.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import behappy.buildappswithpaulo.com.behappy.controller.AppController;
import behappy.buildappswithpaulo.com.behappy.model.Quote;

/**
 * Created by paulodichone on 11/8/17.
 */

public class QuoteData {
    ArrayList<Quote> quoteArrayList = new ArrayList<>();

    public void getQuotes(final QuoteListAsyncResponse callBack) {
        String url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20";

        JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(Request.Method.GET,
                url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject quoteObject = response.getJSONObject(i);
                        Quote quote = new Quote();
                        quote.setQuote(quoteObject.getString("quote"));
                        quote.setAuthor(quoteObject.getString("name"));

                        Log.d("STUFFF::", quoteObject.getString("name"));

                        quoteArrayList.add(quote);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                if (null != callBack) callBack.processFinished(quoteArrayList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }
}
