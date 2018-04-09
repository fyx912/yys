package com.yys;

import com.yys.domain.User;
import com.yys.repository.UserRepository;
import com.yys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ComponentScan
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired(required = true)
    private UserRepository dao;
    @Autowired
    private UserService userService;

    @Test
    public void findAll(){
//       Iterable<User>  userIterable = this.service.findAll();
        Iterable<User>  userIterable = this.userService.findAll();
       userIterable.forEach(user -> System.out.println("id \t"+user.getId()+"\t username \t"+user.getUserName()+ "\t password\t "+user.getPassword()));
    }

    @Test
    public void page(){ Page<User> page = this.userService.findAll(0,5);
       page.forEach(user ->System.out.println("size="+page.getSize()+" \tid\t"+user.getId()+"\tusername\t"+user.getUserName()+ "\tpassword\t"+user.getPassword()));
    }


    @Test
    public void update(){
       int id =  this.userService.updateById(38,7);
       System.out.println("id\t"+id);
    }

    @Test
    public void save(){
        User user = new User();
        user.setId(7);
        user.setUserName("fixe");
        user.setPassword("654321");
        user.setName("菲克斯");
        user.setPhone("13435873241");
        user.setAge(24);
        user.setDate(new Date());
        try{
            user =  this.userService.save(user);
            System.out.println("\tid\t"+user.getId()+"\tusername\t"+user.getUserName()+ "\tpassword\t"+user.getPassword());
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

}
