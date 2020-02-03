package org.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tracker.entity.Alert;
import org.tracker.repository.AlertRepository;

import java.util.Date;
import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRepository alertRepository;

    @Override
    public List<Alert> findAlertByVin(String vin) {
        List<Alert> alertList = alertRepository.findAllByVin(vin);
        return alertList;
    }

    @Override
    public List<Alert> findAllHighALert() {
        Date date = new Date(System.currentTimeMillis()-7200*1000);
        List<Alert> alertList = alertRepository.findAllHighALert(date);
        return alertList;
    }
}
