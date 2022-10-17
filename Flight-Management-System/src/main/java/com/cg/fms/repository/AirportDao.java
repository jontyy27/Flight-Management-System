package com.cg.fms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.fms.dto.Airport;

@Repository
public interface AirportDao extends CrudRepository<Airport, String> {

}