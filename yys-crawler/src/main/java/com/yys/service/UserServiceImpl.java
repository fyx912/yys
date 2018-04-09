package com.yys.service;

import com.yys.domain.User;
import com.yys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService<User> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Page<User> findAll(int index, int size) {
        return this.userRepository.findAll(new PageRequest(index,size));
    }

    @Override
    public int updateById(int age,int id) {
        return  this.userRepository.updateById(age,id);
    }

    @Override
    public User save(User user) {
        Assert.notNull(user,"user must not null");
        return this.userRepository.saveAndFlush(user);
    }
}
