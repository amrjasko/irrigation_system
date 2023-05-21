package com.java.ais.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Sensor_Requests")
@Data
public class SensorRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plot_id")
    private PlotLand plotOfLand;


    @Column(name = "request_status")
    private int requestStatus;

    @Column(name = "request_date")
    private LocalDateTime requestDate;

}