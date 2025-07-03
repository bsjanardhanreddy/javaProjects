package com.jsp.flight.service;

import java.util.List;

import com.jsp.flight.dto.FlightSearchRequest;
import com.jsp.flight.entity.FlightInfo;

public interface FlightService 
{
	List<FlightInfo>  fetchAndStoreFlights(FlightSearchRequest request);
	FlightInfo getFlightByNumber(String flightNumber);
	List<FlightInfo> getAllFlightsSortedByPrice();
	FlightInfo getMaxPricedFlight() ;
	FlightInfo getMinPricedFlight(); 

}
