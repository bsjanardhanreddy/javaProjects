package com.jsp.flight.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.jsp.flight.dto.FlightInfoDTO;
import com.jsp.flight.entity.FlightInfo;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class FlightMapper {

    public FlightInfoDTO toDTO(FlightInfo flight) {
        return new FlightInfoDTO(
                flight.getGwFlightKey(),
                flight.getCarrier(),
                flight.getFlightNumber(),
                flight.getFareType(),
                flight.getTotalAmount()
        );
    }

    public List<FlightInfoDTO> toDTOList(List<FlightInfo> flights) 
    {
        return flights.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}

