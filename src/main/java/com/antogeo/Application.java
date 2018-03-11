package com.antogeo;

import com.antogeo.pojo.WeatherReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import com.antogeo.service.export.ExportService;
import com.antogeo.service.rest.WeatherRestService;

import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class Application {

    @Autowired
    private ExportService exportService;

    @Autowired
    private WeatherRestService weatherRestService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Calendar date = new GregorianCalendar(2017, Calendar.OCTOBER, 30);
            WeatherReport weatherReport = new WeatherReport("NY", "New_York", date.getTime());
            try {
                weatherReport = weatherRestService.getDailySummaryByCityDate(weatherReport);
                exportService.exportWeatherTxt(weatherReport);
            } catch (IOException e){
                e.printStackTrace();
            }
        };
    }
}