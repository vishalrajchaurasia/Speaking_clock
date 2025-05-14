package com.example.speaking_clock.service;

import com.example.speaking_clock.exception.InvalidTimeFormatException;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    private static final String[] NUMBERS = {
            "zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"
    };

    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty"
    };

    public String convertTimeToWords(String time) {
        if (!time.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (hour == 0 && minute == 0) return "It's Midnight";
        if (hour == 12 && minute == 0) return "It's Midday";

        String hourWord = convertNumberToWord(hour);
        String minuteWord = (minute == 0) ? "o'clock" : convertNumberToWord(minute);

        return "It's " + hourWord + (minute == 0 ? " " : " ") + minuteWord;
    }

    private String convertNumberToWord(int num) {
        if (num < 20) {
            return NUMBERS[num];
        } else {
            int tensPart = num / 10;
            int unitsPart = num % 10;
            return TENS[tensPart] + (unitsPart != 0 ? " " + NUMBERS[unitsPart] : "");
        }
    }
}
