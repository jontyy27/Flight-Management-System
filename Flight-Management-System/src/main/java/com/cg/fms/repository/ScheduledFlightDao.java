package com.cg.fms.repository;
import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.ScheduledFlight;

@Repository
public interface ScheduledFlightDao extends CrudRepository<ScheduledFlight, BigInteger>{

}