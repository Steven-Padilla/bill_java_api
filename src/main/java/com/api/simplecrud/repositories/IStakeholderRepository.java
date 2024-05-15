package com.api.simplecrud.repositories;

import com.api.simplecrud.models.StakeHolder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStakeholderRepository extends CrudRepository<StakeHolder, Long> {
    public List<StakeHolder> findAllByType(String type);
}


