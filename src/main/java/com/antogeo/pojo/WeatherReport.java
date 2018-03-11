package com.antogeo.pojo;

import java.util.Date;

public class WeatherReport {

    private String state;
    private String city;
    private Date date;

    private DailySummary dailySummary;

    public WeatherReport(String state,
                         String city,
                         Date date) {
        this.state = state;
        this.city = city;
        this.date = date;
    }

    public WeatherReport(String state,
                         String city,
                         Date date,
                         DailySummary dailySummary) {
        this.state = state;
        this.city = city;
        this.date = date;
        this.dailySummary = dailySummary;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DailySummary getDailySummary() {
        return dailySummary;
    }

    public void setDailySummary(DailySummary dailySummary) {
        this.dailySummary = dailySummary;
    }
}
