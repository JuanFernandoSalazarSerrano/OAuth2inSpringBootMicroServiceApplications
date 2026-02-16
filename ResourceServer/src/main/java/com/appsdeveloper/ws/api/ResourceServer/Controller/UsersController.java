package com.appsdeveloper.ws.api.ResourceServer.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/users")
public class UsersController {

    // enviroment object
    @Autowired
    Environment env;

    @GetMapping("/status/check")
    public String status(){
        return "Working..." + env.getProperty("local.server.port");
    }
}
