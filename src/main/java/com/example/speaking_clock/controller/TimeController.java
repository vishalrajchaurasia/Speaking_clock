package com.example.speaking_clock.controller;

import com.example.speaking_clock.service.TimeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/{time}")
    @Operation(summary = "Convert time to words", description = "Convert 24-hour time (HH:mm) into English words")
    public String getTimeInWords(@PathVariable String time) {
        return timeService.convertTimeToWords(time);
    }
}
