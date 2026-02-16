package com.appsdeveloper.ws.api.ResourceServer.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/status/check")
    public String status(){
        return "Working...";
    }
}
