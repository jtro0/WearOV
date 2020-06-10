package com.jtroo.wearov.util;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class APICallsHandler extends AsyncTask<String, Void, JsonReader> {

    @Override
    protected JsonReader doInBackground(String... urlString) {
        JsonReader json = null;
        try {
            URL url = new URL(urlString[0]);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            InputStream stream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(stream, "UTF-8");

            json = new JsonReader(inputStreamReader);
            json.beginObject();
            stream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    protected void onPostExecute(String data) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}
