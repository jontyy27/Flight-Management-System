package com.cg.fms.service;

import java.math.BigInteger;
import com.cg.fms.dto.Schedule;

public interface ScheduleService {
	public Iterable<Schedule> viewAllSchedule();

	public Schedule viewSchedule(BigInteger scheduleId);

	public Schedule addSchedule(Schedule schedule);

	public Schedule modifySchedule(Schedule schedule);

	public String removeSchedule(BigInteger scheduleId);
}