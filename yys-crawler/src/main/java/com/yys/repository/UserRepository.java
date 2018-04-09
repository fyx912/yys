package com.yys.repository;


import com.yys.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public abstract interface UserRepository  extends BasicRepository<User,Integer> {
    Page findAll(Pageable pageable);

    @Modifying
    @Query(value = "update user u set u.age = :newAge where  u.id = :oldId " ,nativeQuery = true)
    int updateById(@Param("newAge") int newAge , @Param(value = "oldId") int oldId);

}
