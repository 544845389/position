package com.codingapi.position.ao;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
public class GetNearbyReq {


    /**
     * 目标纬度
     */
    private String  latitude;


    /**
     * 目标经度
     */
    private String  longitude;


    /**
     * 千米
     */
    private double distance;


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
