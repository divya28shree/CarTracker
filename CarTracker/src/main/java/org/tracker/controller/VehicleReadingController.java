package org.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tracker.entity.VehicleReading;
import org.tracker.service.VehicleReadingService;

import java.util.List;

@RestController
@RequestMapping(value = "/readings")
public class VehicleReadingController {

    @Autowired
    VehicleReadingService vehicleReadingService;

    @RequestMapping(method = RequestMethod.POST)
    public VehicleReading createVehicleReading(@RequestBody VehicleReading vehicleReading){
        System.out.println("Controller reading:  "+ vehicleReading.getVin());
        return vehicleReadingService.createReading(vehicleReading);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<VehicleReading> getAllReadings(){
        return vehicleReadingService.getAllReading();
    }

}
