package com.saurabh.android.esr;
import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class User {
    private String name;
    private Double lat;
    private Double lon;
    private Double altitude;
    private String number;
    private String email;


    public User(String name, String email, Double latitude, Double longitude, Double altitude, String number) {
        this.name = name;
        this.email = email;
        this.lat = latitude;
        this.lon = longitude;
        this.altitude = altitude;
        this.number = number;
    }

    public User(){};

    public String getName(){return name; }
    public Double getLatitude() {
        return lat;
    }
    public Double getLongitude() { return lon; }
    public String getNumber() { return number; }
    public Double getAltitude() {
        return altitude;
    }
    public String getEmail() { return email; }

    public void setLatitude(Double latitude) { this.lat = latitude; }
    public void setLongitude(Double longitude) { this.lon = longitude; }
    public void setAltitude(Double altitude) { this.altitude = altitude; }






}



