package com.jsp.flight.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.flight.dto.FlightSearchRequest;
import com.jsp.flight.entity.FlightInfo;
import com.jsp.flight.service.FlightService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @PostMapping("/fetch-and-store")
    public List<FlightInfo> fetchAndStoreFlights(@RequestBody FlightSearchRequest request) 
    {
        System.out.println("Received request from PostMan: " + request);
        request.getOdPairs().forEach(od -> 
        {
            if (od.getJDate() == null) 
            {
                od.setJDate(LocalDate.now().plusDays(2).toString()); // default date, formatted yyyy-MM-dd
            }
        });

        return flightService.fetchAndStoreFlights(request);
    }



    @GetMapping("/{flightNumber}")
    public FlightInfo getFlightByNumber(@PathVariable String flightNumber) {
        return flightService.getFlightByNumber(flightNumber);
    }

    @GetMapping
    public List<FlightInfo> getAllSortedByPrice() {
        return flightService.getAllFlightsSortedByPrice();
    }

    @GetMapping("/max-price")
    public FlightInfo getMaxPriceFlight() {
        return flightService.getMaxPricedFlight();
    }

    @GetMapping("/min-price")
    public FlightInfo getMinPriceFlight() {
        return flightService.getMinPricedFlight();
    }
}
