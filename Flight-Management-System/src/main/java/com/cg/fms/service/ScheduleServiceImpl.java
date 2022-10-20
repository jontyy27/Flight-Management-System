package com.cg.fms.service;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> viewSchedule(BigInteger scheduleId) {
		Optional<Schedule> findById = scheduleDao.findById(scheduleId);
		try {
			if (findById.isPresent()) {
				Schedule findSchedule = findById.get();
				return new ResponseEntity<Schedule>(findSchedule, HttpStatus.OK);
			}else
				throw new RecordNotFoundException("Schedule with schedule Id: " + scheduleId + " not exists");
		}catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
		
	 // adding a schedule
	 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<?> addSchedule(Schedule schedule) {
		Optional<Schedule> findById = scheduleDao.findById(schedule.getScheduleId());
		try {
		if (findById.isPresent()) {
			throw new RecordAlreadyPresentException(
					"Schedule with Id : " + schedule.getScheduleId() + " already present");
		}else {
			scheduleDao.save(schedule);
			return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
		} 	
	    }
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	
	 // modifying a schedule
	 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<?> modifySchedule(Schedule schedule) {
		Optional<Schedule> findById = scheduleDao.findById(schedule.getScheduleId());
		try {
			if (findById.isPresent()) {
				scheduleDao.save(schedule);
				return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
			}else
				throw new RecordNotFoundException("Schedule with Id: " + schedule.getScheduleId() + " not exists");
		}catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}	
	}

	 // deleting a schedule
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> removeSchedule(BigInteger scheduleId) {
		Optional<Schedule> findById = scheduleDao.findById(scheduleId);
		try {
			if (findById.isPresent()) {
				Schedule deleteId = findById.get();
				scheduleDao.deleteById(scheduleId);
				return new ResponseEntity<Schedule>(deleteId, HttpStatus.OK);
			}else
				throw new RecordNotFoundException("Schedule with Id: " + scheduleId + " not exists");
		} catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}