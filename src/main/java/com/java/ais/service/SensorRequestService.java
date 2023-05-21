package com.java.ais.service;

import com.java.ais.model.SensorRequest;

import java.util.List;

public interface SensorRequestService {

    SensorRequest addRequest(SensorRequest sensorRequest);

    List<SensorRequest> findByStatus(int status);
}
