package com.yys.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

public abstract class BasicRepositoryImpl<T,I> implements BasicRepository<T,I> {

}
