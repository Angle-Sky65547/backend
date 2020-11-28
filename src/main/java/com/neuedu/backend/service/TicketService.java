package com.neuedu.backend.service;

import com.neuedu.backend.dao.TicketDao;
import com.neuedu.backend.model.Flight;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
public class TicketService extends BaseService<TicketDao, Flight>{
    public void updateById(Long id) {
        dao.updateById(id);
    }
}
