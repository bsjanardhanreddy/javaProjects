package com.jsp.flight.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightSearchRequest 
{
    private int numAdults ;
    private int numChildren;
    private int numInfants;
    private String journeyType;
    private List<OdPair> odPairs;

}
