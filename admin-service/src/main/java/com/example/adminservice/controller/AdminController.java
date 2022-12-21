package com.example.adminservice.controller;

import com.example.adminservice.pojo.Admin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/admin/{username}/{password}", method = RequestMethod.GET)
    public String checkAdmin(@PathVariable("username") String username,
                             @PathVariable("password") String password){
        Object ad = rabbitTemplate.convertSendAndReceive("Direct", "admin", username);
        Admin admin = (Admin) ad;
        if(admin.getUsername().equals(username) && admin.getPassword().equals(password)){
            return "Login Success";
        }else{
            return  "Failed to login";
        }
    }
}
