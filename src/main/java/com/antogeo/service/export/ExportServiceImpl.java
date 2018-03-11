package com.antogeo.service.export;

import com.antogeo.pojo.WeatherReport;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Service
public class ExportServiceImpl implements ExportService{

    /** {@inheritDoc} */
    @Override
    public void exportWeatherTxt(final WeatherReport weatherReport) throws IOException {
        String formattedDate = new SimpleDateFormat("yyyyMMdd").format(weatherReport.getDate());

        // Create the content of the file
        List<String> lines = Arrays.asList(
                "Daily Summary for " + weatherReport.getCity() + ", " + weatherReport.getState() + ", " + formattedDate,
                "Max Percentage Humidity : " + weatherReport.getDailySummary().getMaxHumidity(),
                "Max Temp in C : " + weatherReport.getDailySummary().getMaxTempM(),
                "Min Temp in C : " + weatherReport.getDailySummary().getMinTempM(),
                "Precipitation in mm : " + weatherReport.getDailySummary().getPrecipm());

        // Create the file
        exportTxt(lines, weatherReport.getCity() + formattedDate);
    }

    /**
     * Prints a txt file.
     *
     * @param lines The list of the lines that need to be printed.
     * @param fileName The name of the file.
     * @throws IOException
     */
    private void exportTxt(List<String> lines, String fileName) throws IOException{
        Path file = Paths.get(fileName + ".txt");
        Files.write(file, lines, Charset.forName("UTF-8"));
    }
}
