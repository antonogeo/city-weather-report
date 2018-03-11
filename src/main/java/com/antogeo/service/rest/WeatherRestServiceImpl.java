package com.antogeo.service.rest;

import com.antogeo.pojo.WeatherReport;
import com.antogeo.service.rest.constants.ApiAttributes;
import com.antogeo.service.rest.constants.HttpMethods;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.antogeo.pojo.DailySummary;

import java.io.*;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;

@Service
public class WeatherRestServiceImpl extends RestService implements WeatherRestService{

    @Value("${wunderground.url}")
    private String url;

    @Value("${wunderground.key}")
    private String apiKey;

    /** {@inheritDoc} */
    @Override
    public WeatherReport getDailySummaryByCityDate(WeatherReport weatherReport) throws IOException {

        // Format the date
        final String formattedDate = new SimpleDateFormat("yyyyMMdd").format(weatherReport.getDate());

        // Build url
        final String fullUrl = url + apiKey + "/history_" + formattedDate + "/q/" + weatherReport.getState() + "/" + weatherReport.getCity() + ".json";

        // Open HTTP connection
        HttpURLConnection connection = super.openConnection(fullUrl, HttpMethods.GET.get());

        // Transform response input stream into String
        final String responseJson = super.getStringResponse(connection.getInputStream());

        // End HTTP connection
        connection.disconnect();

        // Get the needed values from the json response, and build the daily summary
        DailySummary dailySummary = getObjectFromJsonResponse(responseJson);

        weatherReport.setDailySummary(dailySummary);

        return weatherReport;
    }

    /** {@inheritDoc} */
    @Override
    protected DailySummary getObjectFromJsonResponse(final String responseJson) throws IOException{
        JsonNode dailySummary = new ObjectMapper().readTree(new StringReader(responseJson)).get(ApiAttributes.HISTORY.get()).get(ApiAttributes.DAILY_SUMMARY.get()).get(0);
        return new DailySummary(dailySummary.get(ApiAttributes.MAX_HUMIDITY.get()).asInt(),
                dailySummary.get(ApiAttributes.MAX_TEMP_M.get()).asInt(),
                dailySummary.get(ApiAttributes.MIN_TEMP_M.get()).asInt(),
                dailySummary.get(ApiAttributes.PRECIPM.get()).asDouble());
    }


}