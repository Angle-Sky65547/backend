package com.neuedu.backend.service;

import com.neuedu.backend.dao.CustomerDao;
import com.neuedu.backend.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<CustomerDao, Customer> {
}
