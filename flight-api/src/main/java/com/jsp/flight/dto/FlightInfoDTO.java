package com.jsp.flight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightInfoDTO 
{
    private String gwFlightKey;
    private String carrier;
    private String flightNumber;
    private String fareType;
    private Double totalAmount;

}