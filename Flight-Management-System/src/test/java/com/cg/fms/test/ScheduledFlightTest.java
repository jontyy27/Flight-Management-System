package com.cg.fms.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.fms.dto.Airport;
import com.cg.fms.dto.Flight;
import com.cg.fms.dto.Schedule;
import com.cg.fms.dto.ScheduledFlight;
import com.cg.fms.repository.ScheduledFlightDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduledFlightTest {
	
	@MockBean
	private ScheduledFlightDao scheduledFlightDao;
	
	@BeforeEach
	public void initInput() {
		
	}
	
	/* Tests the equals/hashcode methods of the ScheduledFlight class.
	 * 
	 */
	@Test()
	public final void testEquals() throws NullPointerException{
		Airport airport1 = new Airport("A101", "Spain", "Spain Airport");
		Airport airport2 = new Airport("A102", "India", "IGI Airport");
		Flight flight = new Flight(new BigInteger("101"),"C101","M101",200);
		Schedule schedule = new Schedule(new BigInteger("1"),airport1,airport2,"18-10-2022","19-10-2022");
		ScheduledFlight scheduledFlight1 = new ScheduledFlight();
		assertNotNull(scheduledFlight1);
		ScheduledFlight scheduledFlight2 = null;
		ScheduledFlight scheduledFlight3 = new ScheduledFlight(new BigInteger("101"),flight,120,schedule);
		ScheduledFlight scheduledFlight4 = new ScheduledFlight(new BigInteger("101"),flight,120,schedule);
		assertTrue(scheduledFlight3.equals(scheduledFlight4));
		assertFalse(scheduledFlight3.equals(scheduledFlight1));
		//assertEquals(scheduledFlight2.hashCode(), scheduledFlight3.hashCode());
	}
	
	/*
	 * Tests the toString() methods of the ScheduledFlight class.
	 */
	@Test
	public final void testToString() {
		Airport airport1 = new Airport("A101","Spain","Spain Airport");
		Airport airport2 = new Airport("A102","India","IGI Airport");
		Flight flight = new Flight(new BigInteger("101"),"C101","M101",200);
		Schedule schedule = new Schedule(new BigInteger("1"),airport1,airport2,"18-10-2020","19-10-2022");
		ScheduledFlight scheduledFlight1 = new ScheduledFlight(new BigInteger("101"),flight,120,schedule);
		
		String result = String.format("ScheduledFlight [scheduleFlightId=%3s, flight=%15s, availableSeats=%3s, schedule=%20s]", 
				scheduledFlight1.getScheduleFlightId(), scheduledFlight1.getFlight(), scheduledFlight1.getAvailableSeats(), scheduledFlight1.getSchedule());
		
		assertEquals(result, scheduledFlight1.toString());
	}
	
	/*
	 * Testing add ScheduledFlight
	 */
	@Test
	public final void testScheduledFlight() {
		Airport airport1 = new Airport("A101","Spain","Spain Airport");
		Airport airport2 = new Airport("A102","India","IGI Airport");
		BigInteger b1 = new BigInteger("101");
		Flight flight = new Flight(b1,"C101","M101",200);
		Schedule schedule = new Schedule(new BigInteger("1"),airport1,airport2,"18-10-2022","19-10-2022");
		ScheduledFlight scheduledFlight1 = new ScheduledFlight(b1,flight,120,schedule);
		assertEquals(b1, scheduledFlight1.getScheduleFlightId());
		assertEquals(120, scheduledFlight1.getAvailableSeats());
		assertEquals(flight, scheduledFlight1.getFlight());
		assertEquals(schedule, scheduledFlight1.getSchedule());
	}
}
