package com.java.ais.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "Alert_Logs")
@Data
public class AlertLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plot_id")
    private PlotLand plotOfLand;

    @Column(name = "alert_time")
    private LocalDateTime alertTime;

    @Column(name = "alert_message")
    private String alertMessage;
}