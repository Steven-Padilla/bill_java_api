package com.api.simplecrud.services.impl;

import com.api.simplecrud.models.BillDetailModel;
import com.api.simplecrud.repositories.IBillDetailsRepository;
import com.api.simplecrud.services.IBillDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillDetailService implements IBillDetailsService {
    @Autowired
    private IBillDetailsRepository repository;

    @Override
    @Transactional
    public BillDetailModel save(BillDetailModel bill) {
        return repository.save(bill);
    }
}
