package com.exadel;

public class CustomObject {

    private String demographic;
    private String medium;
    private String breakValue;
    private Double reachPerc;
    private Double population;

    public void setDemographic(String demographic) {
        this.demographic = demographic;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public void setBreakValue(String breakValue) {
        this.breakValue = breakValue;
    }

    public void setReachPerc(Double reachPerc) {
        this.reachPerc = reachPerc;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "demographic='" + demographic + '\'' +
                ", medium='" + medium + '\'' +
                ", breakValue='" + breakValue + '\'' +
                ", reachPerc=" + reachPerc +
                ", population=" + population +
                '}';
    }
}
