package com.railwaybooking.railwaybookingsystem.model;

// package com.railwaybooking.model;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passengerName;
    private String trainName;
    private String source;
    private String destination;

    public Booking() {}

    public Booking(String passengerName, String trainName, String source, String destination) {
        this.passengerName = passengerName;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
    }

    public Long getId() { return id; }
    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }
    public String getTrainName() { return trainName; }
    public void setTrainName(String trainName) { this.trainName = trainName; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
}