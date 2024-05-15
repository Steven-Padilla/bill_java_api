package com.api.simplecrud.services;

import com.api.simplecrud.models.BillModel;

import java.util.List;
import java.util.Optional;

public interface IBillService {
    List<BillModel> findAll();
    Optional<BillModel> findById(Long id);
    BillModel save(BillModel bill);
    Optional<BillModel> delete(Long id);
}
