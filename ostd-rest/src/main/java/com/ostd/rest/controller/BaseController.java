package com.ostd.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @RequestMapping(value ={"/user", "/home", "login"})
    public String forward(){
        return "forward:/";
    }
}
