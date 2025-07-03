package com.jsp.flight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OdPair 
{
	
    private String origin;
    private String destination;
    private String jDate;
    private String cabinClass;
}
