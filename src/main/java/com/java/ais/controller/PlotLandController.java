package com.java.ais.controller;

import com.java.ais.model.PlotLand;
import com.java.ais.service.PlotLandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plots")
@RequiredArgsConstructor
public class PlotLandController {

    private final PlotLandService service;

    @GetMapping
    public ResponseEntity<List<PlotLand>> getAll()
    {
        return new ResponseEntity<>(service.allPlots(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlotLand> addNew(@RequestBody PlotLand plotLand)
    {
        return new ResponseEntity<>(service.addNewOrEdit(plotLand), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PlotLand> update(@RequestBody PlotLand plotLand)
    {
        return new ResponseEntity<>(service.addNewOrEdit(plotLand), HttpStatus.OK);
    }
}
