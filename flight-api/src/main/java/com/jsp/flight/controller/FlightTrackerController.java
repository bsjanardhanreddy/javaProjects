package com.jsp.flight.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.flight.service.FlightTrackerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/live-flights")
@RequiredArgsConstructor
public class FlightTrackerController 
{
    private final FlightTrackerService flightTrackerService;

    @GetMapping("/get-flights")
    public ResponseEntity<?> getLiveFlights() 
    {
        return ResponseEntity.ok(flightTrackerService.getLiveFlightData());
    }
}
