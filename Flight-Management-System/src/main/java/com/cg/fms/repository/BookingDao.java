package com.cg.fms.repository;
import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;
import com.cg.fms.dto.Booking;

public interface BookingDao extends CrudRepository<Booking, BigInteger>{
	
}
