package com.jsp.flight.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flight_info")
public class FlightInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gw_flight_key")
    private String gwFlightKey;

    private String carrier;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "fare_type")
    private String fareType;

    @Column(name = "total_amount")
    private Double totalAmount;

}
