package com.antogeo.service.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class RestService {

    /**
     * Opens a http connection.
     *
     * @param urlString The full url.
     * @param httpMethod The http method.
     * @return A HttpURLConnection.
     * @throws IOException
     */
    HttpURLConnection openConnection(final String urlString, final String httpMethod) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(httpMethod);
        return connection;
    }

    /**
     * Transform the response input stream into a json string.
     *
     * @param inputStream
     * @return The response in a json string format.
     * @throws IOException
     */
    String getStringResponse(final InputStream inputStream) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }

    /**
     * Gets an object from the json response.
     *
     * @param responseJson The json response
     * @return An object, that will be specified in the implementation of this abstract method.
     * @throws IOException
     */
    abstract Object getObjectFromJsonResponse(final String responseJson) throws IOException;

}
