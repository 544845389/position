package com.codingapi.position.controller;

import com.codingapi.position.ao.GetDistanceReq;
import com.codingapi.position.ao.GetNearbyReq;
import com.codingapi.position.ao.GetNearbyRes;
import com.codingapi.position.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
@RestController
@RequestMapping("position")
public class PositionController {


    @Autowired
    private PositionService positionService;


    /**
     * 获取附近
     * @param getNearbyReq
     * @return
     */
    @PostMapping("/getNearby")
    public List<GetNearbyRes> getNearby(@RequestBody GetNearbyReq getNearbyReq){
      return  positionService.getNearby(getNearbyReq);
    }


    /**
     * 获取距离  (米)
     * @param getDistanceReq
     * @return
     */
    @PostMapping("/getDistance")
    public double getDistance(@RequestBody GetDistanceReq getDistanceReq){
        return  positionService.getDistance(getDistanceReq);
    }




}
