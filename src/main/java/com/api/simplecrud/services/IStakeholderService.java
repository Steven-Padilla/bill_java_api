package com.api.simplecrud.services;

import com.api.simplecrud.models.StakeHolder;

import java.util.List;

public interface IStakeholderService {
    List<StakeHolder> getAllStakeholders(String type);
}
