package com.api.simplecrud.repositories;

import com.api.simplecrud.models.BillModel;
import org.springframework.data.repository.CrudRepository;


public interface IBillRepository extends CrudRepository<BillModel,Long> {
}
