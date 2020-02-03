package org.tracker.service;


import org.tracker.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    Optional<Vehicle> findOne(String vin);
    void create(List<Vehicle> vehicle);
    Vehicle update(String vin, Vehicle vehicle);
    List<Vehicle> findAll();

}
