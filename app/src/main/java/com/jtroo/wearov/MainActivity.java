package com.jtroo.wearov;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.JsonReader;
import android.util.Log;
import android.widget.TextView;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import com.jtroo.wearov.locations.Place;
import com.jtroo.wearov.locations.Station;
import com.jtroo.wearov.util.APICallsHandler;
import com.jtroo.wearov.util.Coordinate;
import com.jtroo.wearov.util.CustomScrollingLayoutCallback;
import com.jtroo.wearov.util.StationAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends WearableActivity {

    private ArrayList<Station> stations;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textView = (TextView) findViewById(R.id.textView);
//        stations = getStationByName("van oldenbarne");
//
//        WearableRecyclerView recyclerView = (WearableRecyclerView) findViewById(R.id.recycler_launcher_view);
//
//        StationAdapter stationAdapter = new StationAdapter(stations);
//        CustomScrollingLayoutCallback customScrollingLayoutCallback =
//                new CustomScrollingLayoutCallback();
//        recyclerView.setLayoutManager(
//                new WearableLinearLayoutManager(this, customScrollingLayoutCallback));
//
//
//        recyclerView.setEdgeItemsCenteringEnabled(true);
//        recyclerView.setAdapter(stationAdapter);
//
//
//        for (int i=0; i < stations.size(); i++) {
//            Log.d("station", stations.get(i).getName());
//        }
        // Enables Always-on
        setAmbientEnabled();
    }

    private ArrayList<Station> getStationByName(String name) {
        String url = "https://api.9292.nl/0.1/locations?lang=nl-NL&type=station,stop&q=" + name;
        AsyncTask<String, Void, JsonReader> api = new APICallsHandler().execute(url);
        ArrayList<Station> stations;
        try {
            JsonReader json = api.get();
            stations = parseJSONForStations(json);
            json.close();
            return stations;
        } catch (ExecutionException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private ArrayList<Station> parseJSONForStations(JsonReader json) throws IOException {
        ArrayList<Station> stations = new ArrayList<>();

        json.skipValue();
        json.beginArray();

        while (json.hasNext()) {
            stations.add(parseJSONForStation(json));
        }
        json.endArray();
        return stations;
    }

    private Station parseJSONForStation(JsonReader json) throws IOException {
        Station station = new Station();
        json.beginObject();
        while (json.hasNext()) {
            String key = json.nextName();

            switch (key) {
                case "id":
                    station.setId(json.nextString());
                    break;
                case "type":
                    station.setType(json.nextString());
                    break;
                case "stationId":
                    station.setStationId(json.nextString());
                    break;
                case "stationType":
                    station.setStationType(json.nextString());
                    break;
                case "name":
                    station.setName(json.nextString());
                    break;
                case "place":
                    station.setPlace(getPlaceFromJSON(json));
                    break;
                case "latLong":
                    station.setLatLon(getLatLonFromJSON(json));
                    break;
                case "urls":
                    station.setUrls(getURLsFromJSON(json));
                    break;
                default:
                    json.skipValue();
            }
        }
        json.endObject();
        return station;
    }

    private ArrayList<String> getURLsFromJSON(JsonReader json) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();

        json.beginObject();
        while (json.hasNext()) {
            json.nextName();
            arrayList.add(json.nextString());
        }
        json.endObject();
        return arrayList;
    }

    private Coordinate getLatLonFromJSON(JsonReader json) throws IOException {
        json.beginObject();
        double lat = 0.0;
        double lon = 0.0;

        while (json.hasNext()) {
            String key = json.nextName();

            if (key.equals("lat"))
                lat = json.nextDouble();
            else if (key.equals("long")) {
                lon = json.nextDouble();
//                break;
            }
        }
        json.endObject();
        return new Coordinate(lat, lon);
    }

    private Place getPlaceFromJSON(JsonReader json) throws IOException {
        Place place = new Place();

        json.beginObject();
        while (json.hasNext()) {
            String key = json.nextName();

            switch (key) {
                case "name":
                    place.setName(json.nextString());
                    break;
                case "regionCode":
                    place.setRegionCode(json.nextString());
                    break;
                case "regionName":
                    place.setRegionName(json.nextString());
                    break;
                case "showRegion":
                    place.setShowRegion(json.nextBoolean());
                    break;
                case "countryCode":
                    place.setCountryCode(json.nextString());
                    break;
                case "countryName":
                    place.setCountryName(json.nextString());
                    break;
                case "showCountry":
                    place.setShowCountry(json.nextBoolean());
                    break;
                default:
                    json.skipValue();
            }
        }
        json.endObject();
        return place;
    }
}
