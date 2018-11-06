package com.codingapi.position.dao;


import com.codingapi.position.model.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
@Component
public interface PersonRepository extends ElasticsearchRepository<Person, String> {




}
