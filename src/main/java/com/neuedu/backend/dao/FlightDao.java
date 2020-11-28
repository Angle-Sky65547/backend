package com.neuedu.backend.dao;

import com.neuedu.backend.model.Flight;

public interface FlightDao extends BaseDao<Flight>{

    void updateById(Long id);
}
