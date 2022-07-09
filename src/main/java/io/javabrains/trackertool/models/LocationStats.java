package io.javabrains.trackertool.models;

public class LocationStats
{
    private String state;
    private String country;
    private Integer lastedTotalCases;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getLastedTotalCases() {
        return lastedTotalCases;
    }

    public void setLastedTotalCases(Integer lastedTotalCases) {
        this.lastedTotalCases = lastedTotalCases;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", lastedTotalCases=" + lastedTotalCases +
                '}';
    }
}
