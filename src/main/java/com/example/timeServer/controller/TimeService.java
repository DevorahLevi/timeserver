package com.example.timeServer.controller;

import com.example.timeServer.model.TimeResponse;
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

    public TimeResponse getTimeResponse() {
        Date date = new Date();
        //
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(new Date());
        //

        return TimeResponse.builder()
                .localTime(dateString)
                .epochMillis(date.getTime())
                .utcTime(getUTCDateFromLocalDate(date))
                .build();
    }

    private String getUTCDateFromLocalDate(Date date) //helper method (when have lot of helper methods, make a helper method class)
    {
        TimeZone zone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat();
        dateFormat.setTimeZone(zone);
        return dateFormat.format(date);
    }
}