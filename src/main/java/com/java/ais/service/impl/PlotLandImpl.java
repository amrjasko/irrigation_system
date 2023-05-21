package com.java.ais.service.impl;

import com.java.ais.model.PlotLand;
import com.java.ais.repository.PlotLandRepository;
import com.java.ais.service.PlotLandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlotLandImpl implements PlotLandService {

    private final PlotLandRepository plotLandRepository;

    @Override
    public PlotLand addNewOrEdit(PlotLand plotLand) {
        return plotLandRepository.save(plotLand);
    }

    @Override
    public List<PlotLand> allPlots() {
        return plotLandRepository.findAll();
    }


    @Override
    public PlotLand findById(Long id) {
        return  plotLandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plot not found by id "));
    }

    @Override
    public List<PlotLand> findByIrrigationStatus(int status) {
        return plotLandRepository.findByIrrigationStatus(status);
    }
}
