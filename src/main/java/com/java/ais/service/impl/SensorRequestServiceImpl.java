package com.java.ais.service.impl;

import com.java.ais.model.SensorRequest;
import com.java.ais.repository.SensorRequestRepository;
import com.java.ais.service.SensorRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorRequestServiceImpl implements SensorRequestService {

    private final SensorRequestRepository sensorRequestRepository;

    @Override
    public SensorRequest addRequest(SensorRequest sensorRequest) {
        return sensorRequestRepository.save(sensorRequest);
    }

    @Override
    public List<SensorRequest> findByStatus(int status) {
        return sensorRequestRepository.findByRequestStatus(status);
    }
}
