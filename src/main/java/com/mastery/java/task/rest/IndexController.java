package com.mastery.java.task.rest;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api(tags = "Start page", description = "Opening the start page index.html")
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
