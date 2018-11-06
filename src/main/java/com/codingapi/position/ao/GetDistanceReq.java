package com.codingapi.position.ao;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
public class GetDistanceReq {


    private double latitude;


    private double longitude;


    private double goalLatitude;


    private double goalLongitude;


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getGoalLatitude() {
        return goalLatitude;
    }

    public void setGoalLatitude(double goalLatitude) {
        this.goalLatitude = goalLatitude;
    }

    public double getGoalLongitude() {
        return goalLongitude;
    }

    public void setGoalLongitude(double goalLongitude) {
        this.goalLongitude = goalLongitude;
    }
}
