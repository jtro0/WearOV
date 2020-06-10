package com.jtroo.wearov.locations;

import com.jtroo.wearov.util.Coordinate;

import java.util.ArrayList;

public class Station {
    private String id;
    private String type;
    private String stationId;
    private String stationType;
    private String name;
    private Place place;
    private Coordinate latLon;
    private ArrayList<String> urls;

    public Station(String id, String type, String stationId, String stationType, String name, Place place, Coordinate latLon, ArrayList<String> urls) {
        this.id = id;
        this.type = type;
        this.stationId = stationId;
        this.stationType = stationType;
        this.name = name;
        this.place = place;
        this.latLon = latLon;
        this.urls = urls;
    }

    public Station() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Coordinate getLatLon() {
        return latLon;
    }

    public void setLatLon(Coordinate latLon) {
        this.latLon = latLon;
    }

    public ArrayList<String> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<String> urls) {
        this.urls = urls;
    }
}
