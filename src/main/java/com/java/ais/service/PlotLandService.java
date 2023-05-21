package com.java.ais.service;

import com.java.ais.model.PlotLand;
import com.java.ais.repository.PlotLandRepository;

import java.util.List;

public interface PlotLandService {

    PlotLand addNewOrEdit(PlotLand plotLand);

    List<PlotLand> allPlots();

    PlotLand findById(Long id);

    List<PlotLand> findByIrrigationStatus(int status);
}
