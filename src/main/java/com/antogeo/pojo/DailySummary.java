package com.antogeo.pojo;

public class DailySummary {

    private int maxHumidity;
    private int maxTempM;
    private int minTempM;
    private double precipm;

    public DailySummary(int maxHumidity,
                        int maxTempM,
                        int minTempM,
                        double precipm) {
        this.maxHumidity = maxHumidity;
        this.maxTempM = maxTempM;
        this.minTempM = minTempM;
        this.precipm = precipm;
    }

    public int getMaxHumidity() {
        return maxHumidity;
    }

    public void setMaxHumidity(int maxHumidity) {
        this.maxHumidity = maxHumidity;
    }

    public int getMaxTempM() {
        return maxTempM;
    }

    public void setMaxTempM(int maxTempM) {
        this.maxTempM = maxTempM;
    }

    public int getMinTempM() {
        return minTempM;
    }

    public void setMinTempM(int minTempM) {
        this.minTempM = minTempM;
    }

    public double getPrecipm() {
        return precipm;
    }

    public void setPrecipm(double precipm) {
        this.precipm = precipm;
    }
}
