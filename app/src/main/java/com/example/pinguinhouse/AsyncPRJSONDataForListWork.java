package com.example.pinguinhouse;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncPRJSONDataForListWork extends AsyncTask<String, Void, JSONObject> {
    private MyAdapter adapter;

    public AsyncPRJSONDataForListWork(MyAdapter myAdapter) {
        this.adapter = myAdapter;
    }


    protected JSONObject doInBackground(String... strings) {
        Log.i("work", "in doInBackground");
        URL url = null;
        HttpURLConnection urlConnection = null;
        String result = null;
        try {
            url = new URL(strings[0]);
            Log.i("work", "in first try");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            urlConnection = (HttpURLConnection) url.openConnection(); // Open
            urlConnection.setRequestProperty("Accept", "application/json");
            Log.i("work", "in second try");
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream in = null;
        try {
            in = new BufferedInputStream(urlConnection.getInputStream());
            Log.i("work", "in third try");
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
            Log.i("work", "JSON data in async list: " + j);
            try {
                for(int k=0; k<5; k++) {
                    String text_url = j.getJSONArray("work").getJSONObject(0).getString("@uri");
                    Log.i("work", "url : " + text_url);
                    String text_author_name = j.getJSONArray("work").getJSONObject(0).getString("authorweb");
                    Log.i("work", "search: " + text_author_name);
                    String text_about = j.getJSONArray("work").getJSONObject(0).getString("rgabout");
                    Log.i("work", "about: " + text_about);
                    String text_title = j.getJSONArray("work").getJSONObject(6).getString("titleweb");
                    Log.i("JFL", "description :" + text_title);
                    String newLine = System.getProperty("line.separator");

                    String output = new String("URL : " + text_url + newLine + newLine + "Title :"+ text_title + newLine + newLine + "Author : " + text_author_name + newLine + newLine + "Description : " + text_about);
                    Log.i("work", "output: " + output);
                    adapter.add(output);
                    Log.i("work", "in for boucle");
                }

                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else
        {
            Log.i("work", "The JSON data are null");

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


