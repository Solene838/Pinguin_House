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
                for(int k=0; k<1; k++) {
                    String text_url = j.getJSONArray("author").getJSONObject(0).getString("@uri");
                    Log.i("JFL", "Adding to adapter url : " + text_url);
                    String text_search = j.getJSONArray("author").getJSONObject(2).getString("authordisplay");
                    Log.i("JFL", "search: " + text_search);
                    String text_description = j.getJSONArray("author").getJSONObject(0).getString("spotlight");
                    Log.i("JFL", "description :" + text_description);
                    String newLine = System.getProperty("line.separator");
                    String output = new String("URL : " + text_url + newLine + newLine + "Author : " + text_search + newLine + newLine + "Description : " + text_description);
                    Log.i("JFL", "output: " + output);
                    adapter.add(output);
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
