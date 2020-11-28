package com.neuedu.backend.dao;

import com.neuedu.backend.model.Flight;

public interface TicketDao extends BaseDao<Flight>{
    void updateById(Long id);
}
