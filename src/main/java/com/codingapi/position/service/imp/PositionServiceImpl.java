package com.codingapi.position.service.imp;

import com.codingapi.position.ao.GetDistanceReq;
import com.codingapi.position.ao.GetNearbyReq;
import com.codingapi.position.ao.GetNearbyRes;
import com.codingapi.position.dao.PersonRepository;
import com.codingapi.position.model.Person;
import com.codingapi.position.service.PositionService;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
@Service
public class PositionServiceImpl implements PositionService {



    @Autowired
    private PersonRepository  personRepository;



    @Autowired
    private  ElasticsearchTemplate elasticsearchTemplate;




    @Override
    public List<GetNearbyRes> getNearby(GetNearbyReq getNearbyReq) {
        List<GetNearbyRes> list = new ArrayList<>();
        GeoDistanceQueryBuilder builder = QueryBuilders.geoDistanceQuery("address")
                .point(getNearbyReq.getLatitude(), getNearbyReq.getLongitude())
                .distance(getNearbyReq.getDistance(), DistanceUnit.KILOMETERS);

        GeoDistanceSortBuilder sortBuilder = SortBuilders.geoDistanceSort("address" , getNearbyReq.getLatitude() , getNearbyReq.getLongitude())
                .point(getNearbyReq.getLatitude(), getNearbyReq.getLongitude())
                .unit(DistanceUnit.KILOMETERS)
                .order(SortOrder.ASC);

        NativeSearchQueryBuilder builder1 = new NativeSearchQueryBuilder().withFilter(builder).withSort(sortBuilder).withPageable(PageRequest.of(getNearbyReq.getNowPage() , getNearbyReq.getPageSize()));
        SearchQuery searchQuery = builder1.build();
        List<Person> personList = elasticsearchTemplate.queryForList(searchQuery , Person.class);

        for (Person person:personList) {
            GetNearbyRes getNearbyRes = new GetNearbyRes();
            getNearbyRes.setId(person.getId());
            getNearbyRes.setAddress(person.getAddress());
            getNearbyRes.setName(person.getName());

            String []str =  person.getAddress().split(",");
            double distance = GeoDistance.ARC.calculate(Double.parseDouble(str[0]), Double.parseDouble(str[1]), getNearbyReq.getLatitude(), getNearbyReq.getLongitude(), DistanceUnit.METERS);
            getNearbyRes.setDistance(distance);
            list.add(getNearbyRes);
        }
        return  list;
    }



    @Override
    public double getDistance(GetDistanceReq getDistanceReq) {
        double distance = GeoDistance.ARC.calculate( getDistanceReq.getLatitude() , getDistanceReq.getLongitude() , getDistanceReq.getGoalLatitude() , getDistanceReq.getGoalLongitude() , DistanceUnit.METERS);
        return distance;
    }


}
