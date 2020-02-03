package org.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tracker.entity.Vehicle;
import org.tracker.service.VehicleService;

import java.util.List;

@RestController

public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.PUT, value = "/vehicles")
    public void createVehicles(@RequestBody List<Vehicle> vehicles){
        vehicleService.create(vehicles);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vehicles")
    public List<Vehicle> findAll()
    {
        List<Vehicle> vehicles = vehicleService.findAll();
        return vehicles;
    }

}
