package org.tracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.tracker.entity.VehicleReading;

public interface VehicleReadingRepository extends CrudRepository<VehicleReading, String> {


}
