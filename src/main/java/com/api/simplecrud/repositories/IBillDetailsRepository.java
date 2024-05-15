package com.api.simplecrud.repositories;

import com.api.simplecrud.models.BillDetailModel;
import org.springframework.data.repository.CrudRepository;

public interface IBillDetailsRepository extends CrudRepository<BillDetailModel,Long> {

}
