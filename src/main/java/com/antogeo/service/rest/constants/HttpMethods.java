package com.antogeo.service.rest.constants;

public enum HttpMethods {

    // HTTP methods
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE")
    ;

    private final String value;

    HttpMethods(final String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
