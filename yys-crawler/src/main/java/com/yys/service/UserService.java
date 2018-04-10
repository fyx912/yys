package com.yys.service;

import com.yys.domain.User;
import org.springframework.data.domain.Page;


public interface UserService<T> {
    Iterable<T> findAll();
    Page<T> findAll(int index, int size);
    int updateById(int age, int id);
    User save(T t);
    String  count(String code);
}
