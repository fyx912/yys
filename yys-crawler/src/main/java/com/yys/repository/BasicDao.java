package com.yys.repository;

import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public abstract interface BasicDao<T> {

   abstract void insert(T t);
   abstract List<T> findAll(Class<T> t);
   List<T>  findByObj(Query query, Class<T> entityClass);
}
