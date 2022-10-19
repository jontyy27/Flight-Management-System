package com.cg.fms.service;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dto.Schedule;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.repository.ScheduleDao;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	ScheduleDao scheduleDao;

	
	 // view all schedules
	 
	@Override
	public Iterable<Schedule> viewAllSchedule() {
		return scheduleDao.findAll();
	}

	 // view schedule by schedule id
	 
	@Override
	public Schedule viewSchedule(BigInteger scheduleId) {
		Optional<Schedule> findById = scheduleDao.findById(scheduleId);
		if (findById.isPresent()) {
			return findById.get();
		}
		else
			throw new RecordNotFoundException("Schedule with schedule Id: " + scheduleId + "not exists");
	    }
		
	 // adding a schedule
	 
	@Override
	public Schedule addSchedule(Schedule schedule) {
		Optional<Schedule> findById = scheduleDao.findById(schedule.getScheduleId());
		try {
		if (!findById.isPresent()) {
			scheduleDao.save(schedule);
			return schedule;
		} 
		else
			throw new RecordAlreadyPresentException(
					"Schedule with Id : " + schedule.getScheduleId() + " already present");
	     }
		catch(RecordAlreadyPresentException e)
		{
			return schedule;
		}
	}

	
	 // modifying a schedule
	 
	@Override
	public Schedule modifySchedule(Schedule schedule) {
		Optional<Schedule> findById = scheduleDao.findById(schedule.getScheduleId());
		if (findById.isPresent()) {
			scheduleDao.save(schedule);
		} 
		else
			throw new RecordNotFoundException("Schedule with Id: " + schedule.getScheduleId() + " not exists");
		return schedule;
	}

	 // deleting a schedule
	 
	@Override
	public String removeSchedule(BigInteger scheduleId) {
		Optional<Schedule> findById = scheduleDao.findById(scheduleId);
		if (findById.isPresent()) {
			scheduleDao.deleteById(scheduleId);
			return "Schedule removed";
		} else
			throw new RecordNotFoundException("Schedule with Id: " + scheduleId + " not exists");
	}
}