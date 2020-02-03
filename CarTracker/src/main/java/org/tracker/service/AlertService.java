package org.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tracker.entity.Alert;
import org.tracker.repository.AlertRepository;

import java.util.List;


public interface AlertService {

  List<Alert> findAlertByVin(String vin);

  List<Alert> findAllHighALert();

}
