package com.api.simplecrud.services.impl;

import com.api.simplecrud.models.StakeHolder;
import com.api.simplecrud.repositories.IStakeholderRepository;
import com.api.simplecrud.services.IStakeholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StakeholderServiceImpl implements IStakeholderService {

    @Autowired
    private IStakeholderRepository stakeholderRepository;

    @Override
    public List<StakeHolder> getAllStakeholders(String type) {
        return stakeholderRepository.findAllByType(type);
    }

    @Override
    public Optional<StakeHolder> getStakeHolderById(Long id) {
        return stakeholderRepository.findById(id);
    }
}
