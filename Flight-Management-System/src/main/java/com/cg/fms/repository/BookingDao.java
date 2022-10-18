package com.cg.fms.repository;
import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Booking;

@Repository
public interface BookingDao extends CrudRepository<Booking, BigInteger>{
	
}
