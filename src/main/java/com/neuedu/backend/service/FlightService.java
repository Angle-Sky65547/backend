package com.neuedu.backend.service;

import com.neuedu.backend.dao.FlightDao;
import com.neuedu.backend.model.Flight;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends BaseService<FlightDao, Flight>{
    public void updateById(Long id) {
        dao.updateById(id);
    }
}
