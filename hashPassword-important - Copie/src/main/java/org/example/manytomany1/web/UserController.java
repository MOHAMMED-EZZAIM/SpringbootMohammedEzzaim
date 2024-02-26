package org.example.manytomany1.web;

import org.example.manytomany1.bean.UserEz;
import org.example.manytomany1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @GetMapping("/usrs/{name}")
    public UserEz findUserByUserName( @PathVariable String name) {
        return userService.findUserByUserName(name);
    }

    @Autowired
    private UserService userService;
    @GetMapping("/users/{usrename}")
    public UserEz user(@PathVariable String username){
        UserEz user=userService.findUserByUserName(username);
        return  user;
    }
}
