package com.example.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
    @GetMapping("/")
    public String index() {
        return "redirect:schedule";
    }

    @GetMapping("/schedule")
    public String schedule() {
        return "schedule";
    }

    @GetMapping("/task")
    public String myTask() {
        return "task";
    }

    @GetMapping("/myschedule")
    public String mySchedule() {
        return "myschedule";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
