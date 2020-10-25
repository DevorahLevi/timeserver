package com.example.timeServer.controller;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class TimeService {

    public String getTime() {
        Instant instant = Instant.now();
        return instant.toString();
    }

    public Long getEpochTime() {
        Date date = new Date();
        return date.getTime(); // returns the time in epochTime

    }
}