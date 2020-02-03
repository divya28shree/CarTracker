package org.tracker.service;

import org.tracker.entity.VehicleReading;

import java.util.List;

public interface VehicleReadingService {

    VehicleReading createReading(VehicleReading reading);

    List<VehicleReading> getAllReading();
}
