package com.yys.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.lang.ref.Reference;
import java.util.List;

@Repository
public class BasicDaoImpl<T> implements  BasicDao<T>{
    @Autowired
    private MongoTemplate mongoTemplate;

    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void insert(T t) {
        mongoTemplate.insert(t);
    }

    @Override
    public List<T> findAll(Class<T> t) {
        return mongoTemplate.findAll(t);
    }

    @Override
    public List<T> findByObj(Query query,Class<T> entityClass) {
        return  mongoTemplate.find(query,entityClass);
    }
}
