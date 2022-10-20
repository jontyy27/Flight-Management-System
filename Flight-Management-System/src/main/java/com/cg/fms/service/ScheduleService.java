package com.cg.fms.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.cg.fms.dto.Schedule;

public interface ScheduleService {
	public Iterable<Schedule> viewAllSchedule();

	public ResponseEntity<?> viewSchedule(BigInteger scheduleId);

	public ResponseEntity<?> addSchedule(Schedule schedule);

	public ResponseEntity<?> modifySchedule(Schedule schedule);

	public ResponseEntity<?> removeSchedule(BigInteger scheduleId);
}