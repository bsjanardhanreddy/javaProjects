package com.jsp.flight.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.flight.entity.FlightInfo;

public interface FlightInfoRepository extends JpaRepository<FlightInfo, Long> 
{
	Optional<FlightInfo> findByFlightNumber(String flightNumber);
	
    List<FlightInfo> findByFareType(String fareType);
    List<FlightInfo> findByCarrier(String carrier);

    @Query("SELECT f FROM FlightInfo f WHERE f.flightNumber LIKE %:flightNumber%")
    List<FlightInfo> searchByFlightNumber(String flightNumber);

    Page<FlightInfo> findAll(Pageable pageable);
}