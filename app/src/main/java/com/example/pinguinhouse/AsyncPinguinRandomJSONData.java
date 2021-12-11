package com.example.pinguinhouse;

import android.os.AsyncTask;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncPinguinRandomJSONData extends AsyncTask<String, Void, JSONObject> {
    private AppCompatActivity myActivity;

    public AsyncPinguinRandomJSONData(AppCompatActivity myActivity_) {
        myActivity = myActivity_;
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
        Log.i("JFL", "results: " + result);
        //ici on a bien le json attendu dans la variable result
        urlConnection.disconnect();
        JSONObject json = null;
        try {
            json = new JSONObject(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i("JFL", "JSON data in async inBackgd: " + json);
        return json; // returns the result

    }

    @Override
    protected void onPostExecute(JSONObject j) {
        Log.i("JFL", "JSON data in async PostExec: " + j);
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
