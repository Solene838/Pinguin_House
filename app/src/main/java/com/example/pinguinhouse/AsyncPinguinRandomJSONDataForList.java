package com.example.pinguinhouse;

import android.os.AsyncTask;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncPinguinRandomJSONDataForList extends AsyncTask<String, Void, JSONObject> {
    private MyAdapter adapter;

    public AsyncPinguinRandomJSONDataForList(MyAdapter myAdapter) {
            this.adapter = myAdapter;
    }


    protected JSONObject doInBackground(String... strings) {
        Log.i("JFL", "in doInBackground");
        URL url = null;
        HttpURLConnection urlConnection = null;
        String result = null;
        try {
            url = new URL(strings[0]);
            Log.i("JFL", "in first try");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            urlConnection = (HttpURLConnection) url.openConnection(); // Open
            urlConnection.setRequestProperty("Accept", "application/json");
            Log.i("JFL", "in second try");
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream in = null;
        try {
            in = new BufferedInputStream(urlConnection.getInputStream());
            Log.i("JFL", "in third try");
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = readStream(in); // Read stream
        urlConnection.disconnect();
        JSONObject json = null;
        try {
            json = new JSONObject(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json; // returns the result

    }

    @Override
    protected void onPostExecute(JSONObject j) {
        if (j != null) {
            Log.i("JFL", "JSON data in async list: " + j);
            try {
                JSONArray array = j.getJSONArray("items");
                for (int i = 0; i < array.length(); i++) {
                    String text_url = array.getJSONObject(i).getJSONObject("media").getString("m");
                    Log.i("JFL", "Adding to adapter url : " + text_url);
                    String text_search = j.getString("authordisplay");
                    Log.i("JFL", "search: " + text_search);
                    String text_description = j.getString("spotlight");
                    Log.i("JFL", "description :" + text_description);
                    adapter.add(text_url);
                }
                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else
        {
            Log.i("JFL", "The JSON data are null");

        }

    }

    private String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while (i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }
}
