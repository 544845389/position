package com.codingapi.position.service;

import com.codingapi.position.ao.GetDistanceReq;
import com.codingapi.position.ao.GetNearbyReq;
import com.codingapi.position.ao.GetNearbyRes;
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
     * 获取附近
     * @param getNearbyReq
     * @return
     */
    List<GetNearbyRes> getNearby(GetNearbyReq getNearbyReq);


    /**
     * 获取距离
     * @param getDistanceReq
     * @return
     */
    double getDistance(GetDistanceReq getDistanceReq);
}
