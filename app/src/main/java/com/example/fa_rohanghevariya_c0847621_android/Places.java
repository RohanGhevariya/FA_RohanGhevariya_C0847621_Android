package com.example.fa_rohanghevariya_c0847621_android;

public class Places {
    private String placeName;
    private String lat;
    private String lang;

    public Places(String placeName, String lat, String lang) {
        this.placeName = placeName;
        this.lat = lat;
        this.lang = lang;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Places{" +
                "placeName='" + placeName + '\'' +
                ", lat='" + lat + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
