package com.antogeo.service.rest;

import com.antogeo.pojo.WeatherReport;

import java.io.IOException;

public interface WeatherRestService {

    /**
     * Gets the weather by state, city and date.
     *
     * @param weatherReport The weather report containing the state, city and date info.
     * @return The weather report containing the daily summary.
     * @throws IOException
     */
    WeatherReport getDailySummaryByCityDate(WeatherReport weatherReport) throws IOException;

}
