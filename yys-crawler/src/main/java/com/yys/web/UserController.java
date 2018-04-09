package com.yys.web;

import com.yys.domain.User;
import com.yys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "hello";
    }

    @RequestMapping("user")
    @ResponseBody
    public Iterable findAll(){
       return this.userService.findAll();
    }

    @RequestMapping(value = "user/{index}",method = RequestMethod.GET)
    @ResponseBody
    public Iterable page(@PathVariable int index){
        return this.userService.findAll(index,20);
    }

    @RequestMapping(value = "user",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable User user){
        this.userService.save(user);
        return "ok";
    }

    @RequestMapping(value = "user",method = RequestMethod.POST)
    @ResponseBody
    public String save(@PathVariable User user){
        this.userService.save(user);
        return "ok";
    }

}
