package org.tracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.tracker.entity.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, String> {

}
