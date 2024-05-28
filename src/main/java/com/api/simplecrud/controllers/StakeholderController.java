package com.api.simplecrud.controllers;


import com.api.simplecrud.models.StakeHolder;
import com.api.simplecrud.services.IStakeholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/stakeholders")
@CrossOrigin(origins = "http://localhost:4200")
public class StakeholderController {

    @Autowired
    private IStakeholderService stakeholderService;

    @GetMapping("/{type}")
    public ResponseEntity<?> getStakeholders(@PathVariable String type){
        List<StakeHolder> stakeholderByType = stakeholderService.getAllStakeholders(type);
    return ResponseEntity.ok(stakeholderByType);
    }
    @GetMapping("byId/{id}")
    public Optional<StakeHolder> getStakeholders(@PathVariable Long id){
        return stakeholderService.getStakeHolderById(id);
    }
}
