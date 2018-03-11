package com.antogeo.service.rest.constants;

public enum ApiAttributes {

    // API attributes
    HISTORY("history"),
    DAILY_SUMMARY("dailysummary"),
    MAX_HUMIDITY("maxhumidity"),
    MAX_TEMP_M("maxtempm"),
    MIN_TEMP_M("mintempm"),
    PRECIPM("precipm");

    private final String value;

    ApiAttributes(final String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
