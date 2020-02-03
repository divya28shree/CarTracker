package org.tracker.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.tracker.entity.Alert;

import java.util.Date;
import java.util.List;

public interface AlertRepository extends CrudRepository<Alert,String> {

    public List<Alert> findAllByVin(String vin);

    @Query("select alert from Alert alert where date > :dateparam")
    public List<Alert> findAllHighALert(@Param("dateparam") Date date);

}
