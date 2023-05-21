package com.java.ais.service;

import com.java.ais.enums.IrrigationStatus;
import com.java.ais.enums.SensorStatus;
import com.java.ais.model.AlertLog;
import com.java.ais.model.PlotLand;
import com.java.ais.model.SensorRequest;
import com.java.ais.repository.AlertLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class SensorTask {

    private final PlotLandService plotLandService;
    private final SensorRequestService sensorRequestService;

    private final AlertLogRepository alertLogRepository;

    @Scheduled(fixedDelay = 5000)
    public void checkNotIrrigationPlots() {
        plotLandService
                .findByIrrigationStatus(IrrigationStatus.NOT_IRRIGATED.ordinal())
                .stream()
                .forEach(plotLand -> {
                            // create request
                            SensorRequest request = new SensorRequest();
                            request.setPlotOfLand(plotLand);
                            request.setRequestStatus(SensorStatus.NEW.ordinal());
                            request.setRequestDate(LocalDateTime.now());
                            sensorRequestService.addRequest(request);
                            //set time based on crop details
                        }
                );
    }

    @Scheduled(fixedDelay = 5000)
    public void checkActiveSensors() {
        sensorRequestService.findByStatus(SensorStatus.NEW.ordinal())
                .stream()
                .forEach(request -> {
                            request.setRequestStatus(SensorStatus.Pending.ordinal());
                            sensorRequestService.addRequest(request);
                        }
                );
        sensorRequestService.findByStatus(SensorStatus.Pending.ordinal())
                .stream()
                .forEach(request -> {
                            Duration duration = Duration.between(request.getRequestDate(), LocalDateTime.now());
                            if (duration.toHours() >= request.getPlotOfLand().getTimeRequirement().getHour()) {
                                request.setRequestStatus(SensorStatus.FAILED.ordinal());
                                AlertLog alertLog = new AlertLog();
                                alertLog.setPlotOfLand(request.getPlotOfLand());
                                alertLog.setAlertTime(LocalDateTime.now());
                                alertLog.setAlertMessage("Something wrong");
                                alertLogRepository.save(alertLog);
                            } else {
                                request.setRequestStatus(SensorStatus.DONE.ordinal());
                            }
                            sensorRequestService.addRequest(request);
                            PlotLand plotOfLand = request.getPlotOfLand();
                            plotOfLand.setIrrigationStatus(IrrigationStatus.IRRIGATED.ordinal());
                            plotLandService.addNewOrEdit(plotOfLand);
                        }
                );
    }
}
