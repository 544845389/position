package com.codingapi.position.service;

import com.codingapi.position.ao.GetNearbyReq;
import com.codingapi.position.model.Person;

import java.util.List;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
public interface PositionService {


    /**
     *
     * @param getNearbyReq
     * @return
     */
    List<Person> getNearby(GetNearbyReq getNearbyReq);
}
