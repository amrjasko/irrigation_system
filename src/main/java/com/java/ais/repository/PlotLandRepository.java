package com.java.ais.repository;

import com.java.ais.model.PlotLand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlotLandRepository extends JpaRepository<PlotLand,Long> {

    List<PlotLand> findByIrrigationStatus(int irrigationStatus);
}
