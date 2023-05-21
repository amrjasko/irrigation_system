package com.java.ais.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "Plot_Land")
@Data
public class PlotLand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "plot_name")
    private String plotName;

    @Column(name = "crop_type")
    private String cropType;

    @Column(name = "soil_type")
    private Integer soilType;

    @Column(name = "area_size")
    private Integer areaSize;

    @Column(name = "irrigation_status")
    private int irrigationStatus;

    @Column(name = "WATER_REQUIREMENT")
    private Integer waterRequirement;

    @Column(name = "time_REQUIREMENT")
    private LocalDateTime timeRequirement;
}
