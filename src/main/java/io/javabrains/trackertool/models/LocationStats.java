package io.javabrains.trackertool.models;

public class LocationStats
{
    private String state;
    private String country;
    private Integer lastedTotalCases;
    private Integer previousTotalCases;
    private Float cr;


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

    public Integer getPreviousTotalCases() { return previousTotalCases; }

    public void setPreviousTotalCases(Integer previousTotalCases) { this.previousTotalCases = previousTotalCases; }

    public Float getCr() { return cr; }

    public void setCr(Float cr) { this.cr = cr; }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", lastedTotalCases=" + lastedTotalCases +
                ", previousTotalCases=" + previousTotalCases +
                ", cr=" + cr +
                '}';
    }
}
