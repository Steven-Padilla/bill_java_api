package com.api.simplecrud.services.impl;

import com.api.simplecrud.models.BillModel;
import com.api.simplecrud.repositories.IBillRepository;
import com.api.simplecrud.services.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    private IBillRepository IBillRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BillModel> findAll() {
        return (List<BillModel>) IBillRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BillModel> findById(Long id) {
        return IBillRepository.findById(id);
    }

    @Override
    @Transactional
    public BillModel save(BillModel bill) {
        return IBillRepository.save(bill);
    }

    @Override
    @Transactional
    public Optional<BillModel> delete(Long id) {
        Optional<BillModel> optionalBill = IBillRepository.findById(id);
        optionalBill.ifPresent(dbBill -> {
            IBillRepository.delete(dbBill);
        });
        return optionalBill;
    }
}
