package com.antogeo.service.export;

import com.antogeo.pojo.WeatherReport;

import java.io.IOException;

public interface ExportService {

    /**
     * Prints a txt file containing the weather report info.
     *
     * @param weatherReport The weather report object.
     * @throws IOException
     */
    void exportWeatherTxt(final WeatherReport weatherReport) throws IOException;
}
