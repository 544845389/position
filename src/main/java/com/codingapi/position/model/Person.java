package com.codingapi.position.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.GeoPointField;



/**
 * @author 侯存路
 * @date 2018/11/2
 * @company codingApi
 * @description
 */
@Document(indexName="elastic_search_project",type="person")
public class Person {


    @Id
    private  String id;

    @Field
    private String name;

    /**
     * 当前地理位置经纬度
     * lat纬度，lon经度 "40.715,-74.011"
     * 如果用数组则相反[-73.983, 40.719]
     */
    @GeoPointField
    private String address;


    private String geoDistance;

    public String getGeoDistance() {
        return geoDistance;
    }

    public void setGeoDistance(String geoDistance) {
        this.geoDistance = geoDistance;
    }

    public Person() {
    }

    public Person(String id , String name, String address ) {
        this.id = id;
        this.name = name;
        this.address = address;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
