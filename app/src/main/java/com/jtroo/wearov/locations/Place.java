package com.jtroo.wearov.locations;

public class Place {
    private String name;
    private String regionCode;
    private String regionName;
    private boolean showRegion;
    private String countryCode;
    private String countryName;
    private boolean showCountry;

    public Place(String name, String regionCode, String regionName, boolean showRegion, String countryCode, String countryName, boolean showCountry) {
        this.name = name;
        this.regionCode = regionCode;
        this.regionName = regionName;
        this.showRegion = showRegion;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.showCountry = showCountry;
    }

    public Place() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public boolean isShowRegion() {
        return showRegion;
    }

    public void setShowRegion(boolean showRegion) {
        this.showRegion = showRegion;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean isShowCountry() {
        return showCountry;
    }

    public void setShowCountry(boolean showCountry) {
        this.showCountry = showCountry;
    }
}
