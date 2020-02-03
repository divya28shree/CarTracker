package org.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tracker.entity.Alert;
import org.tracker.entity.Vehicle;
import org.tracker.service.AlertService;

import java.util.List;

@RestController
@RequestMapping(value = "/alert")
public class AlertController {

    @Autowired
    AlertService service;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public List<Alert> getAllAlertByVehicleId(@PathVariable("id") String id){
        List<Alert> alertList = service.findAlertByVin(id);
        return alertList;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> getAllAlertLastTwoHour(){
        List<Alert> alertList = service.findAllHighALert();
        return alertList;
    }


}
