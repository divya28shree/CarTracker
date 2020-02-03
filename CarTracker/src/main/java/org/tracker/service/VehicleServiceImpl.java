package org.tracker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tracker.entity.Vehicle;
import org.tracker.exception.ResourceNotFoundException;
import org.tracker.repository.VehicleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository repository;

    @Override
    public Optional<Vehicle> findOne(String vin) {

        Optional<Vehicle> vehicles = repository.findById(vin);
        return vehicles;
    }

    @Override
    public void create(List<Vehicle> vehicle) {
        for(Vehicle car: vehicle)
        {
            repository.save(car);
        }
    }

    @Override
    public Vehicle update(String vin, Vehicle vehicle) {
        return null;
    }

    @Override
    public List<Vehicle> findAll() {

        List<Vehicle> vehicles = (List<Vehicle>) repository.findAll();
        return vehicles;
    }
}
