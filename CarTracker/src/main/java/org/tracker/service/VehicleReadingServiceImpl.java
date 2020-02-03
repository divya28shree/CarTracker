package org.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tracker.entity.Alert;
import org.tracker.entity.Tires;
import org.tracker.entity.Vehicle;
import org.tracker.entity.VehicleReading;
import org.tracker.repository.AlertRepository;
import org.tracker.repository.VehicleReadingRepository;
import org.tracker.repository.VehicleRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleReadingServiceImpl implements VehicleReadingService{

    @Autowired
    VehicleReadingRepository repository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    AlertRepository alertRepository;

    @Override
    public VehicleReading createReading(VehicleReading reading) {

        VehicleReading vehicleReading = repository.save(reading);
        checkAlert(reading);
        return vehicleReading;
    }

    @Override
    public List<VehicleReading> getAllReading() {
        return (List<VehicleReading>) repository.findAll();
    }

    public void checkAlert(VehicleReading reading){
        Optional<Vehicle> vehicle = vehicleRepository.findById(reading.getVin());
        //RPM
        if(reading.getEngineRpm()>vehicle.get().getRedlineRpm())
        {
            Alert alert = new Alert();
            alert.setDate(new Date());
            alert.setPriority("HIGH");
            alert.setReason("Engine RPM High");
            alert.setVin(reading.getVin());
            alertRepository.save(alert);
        }
        //FUEL VOLUME
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if(reading.getFuelVolume() < 0.01*vehicle.get().getMaxFuelVolume())
        {
            Alert alert = new Alert();
            alert.setDate(new Date());
            alert.setPriority("MEDIUM");
            alert.setReason("FUEL Volume Low");
            alert.setVin(reading.getVin());
            alertRepository.save(alert);
        }
        //TIRE PRESSURE
        List<Integer> tiresList = new ArrayList<>();
        tiresList.add(reading.getTires().getFrontLeft());
        tiresList.add(reading.getTires().getFrontRight());
        tiresList.add(reading.getTires().getRearLeft());
        tiresList.add(reading.getTires().getRearRight());

        for(int tirePressure: tiresList){
            if(tirePressure< 32 || tirePressure >36){
                Alert alert = new Alert();
                alert.setDate(new Date());
                alert.setPriority("LOW");
                alert.setReason("Check Tire Pressure");
                alert.setVin(reading.getVin());
                alertRepository.save(alert);
            }
        }

        if(reading.isEngineCoolantLow() || reading.isCheckEngineLightOn())
        {
            Alert alert = new Alert();
            alert.setDate(new Date());
            alert.setPriority("LOW");
            alert.setReason("Check Engine Coolant/Engine Light");
            alert.setVin(reading.getVin());
            alertRepository.save(alert);
        }
    }
}
