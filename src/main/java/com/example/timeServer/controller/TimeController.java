package com.example.timeServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Tells spring that this is a 'rest' controller
@RequestMapping("/api/v1") //requires this before all other mappings
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/time")
    public String getTime() {
        return timeService.getTime();
    }

    @GetMapping("/epochTime")
    public Long getEpochTime() {
        return timeService.getEpochTime();
    }
}

/* Keyboard Shortcuts:

Ctrl + click --> brings you to the source/class of where a method is defined
Ctrl + backspace --> deletes the entire word
 */

/*
getTime should return UTC time (or GMT) because that is what e/o understands

Create a new endpoint that should take in the timezone and return the time of that timezone

Push up to github and submit the github link

Due: next sunday

 */