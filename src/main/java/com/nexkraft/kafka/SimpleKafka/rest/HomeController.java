package com.nexkraft.kafka.SimpleKafka.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("kafka")
public class HomeController {

    @GetMapping("/home")
    public ModelAndView init() {
        return new ModelAndView("index");
    }
}
