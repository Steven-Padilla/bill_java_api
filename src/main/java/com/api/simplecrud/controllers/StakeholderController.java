package com.api.simplecrud.controllers;


import com.api.simplecrud.models.BillModel;
import com.api.simplecrud.models.StakeHolder;
import com.api.simplecrud.services.IStakeholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/stakeholders")
public class StakeholderController {

    @Autowired
    private IStakeholderService stakeholderService;

    @GetMapping("/{type}")
    public ResponseEntity<?> getSingle(@PathVariable String type){
        List<StakeHolder> singleBill = stakeholderService.getAllStakeholders(type);
    return ResponseEntity.ok(singleBill);

    }
}
