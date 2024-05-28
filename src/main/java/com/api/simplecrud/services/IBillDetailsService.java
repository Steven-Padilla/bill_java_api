package com.api.simplecrud.services;

import com.api.simplecrud.models.BillDetailModel;

import java.util.Optional;

public interface IBillDetailsService {
    BillDetailModel save(BillDetailModel bill);
    Optional<BillDetailModel> delete(Long id);

}
