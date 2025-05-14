package com.example.speaking_clock;

import com.example.speaking_clock.exception.InvalidTimeFormatException;
import com.example.speaking_clock.service.TimeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TimeServiceTest {

	private TimeService timeService;

	@Before
	public void setup() {
		timeService = new TimeService();
	}

	@Test
	public void testValidTime() {
		Assert.assertEquals("It's eight thirty four", timeService.convertTimeToWords("08:34"));
	}

	@Test
	public void testMidnight() {
		Assert.assertEquals("It's Midnight", timeService.convertTimeToWords("00:00"));
	}

	@Test
	public void testMidday() {
		Assert.assertEquals("It's Midday", timeService.convertTimeToWords("12:00"));
	}

	@Test(expected = InvalidTimeFormatException.class)
	public void testInvalidFormat() {
		timeService.convertTimeToWords("25:61");
	}
}
