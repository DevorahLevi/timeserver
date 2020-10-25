package com.example.timeServer.controller;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

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

    public String getTimeZoneTime(String timeZone) {
        TimeZone zone = TimeZone.getTimeZone(timeZone);
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'ZZZ");
        dateformat.setTimeZone(zone);
        return dateformat.format(new Date());
        }
}