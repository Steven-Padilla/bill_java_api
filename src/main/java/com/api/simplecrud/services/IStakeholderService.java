package com.api.simplecrud.services;

import com.api.simplecrud.models.StakeHolder;

import java.util.List;
import java.util.Optional;

public interface IStakeholderService {
    List<StakeHolder> getAllStakeholders(String type);
    Optional<StakeHolder> getStakeHolderById(Long id);
}
