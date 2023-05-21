package com.java.ais.repository;

import com.java.ais.model.SensorRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRequestRepository extends JpaRepository<SensorRequest,Long> {
    List<SensorRequest> findByRequestStatus(int requestStatus);
}
