package com.api.simplecrud.controllers;


import com.api.simplecrud.models.BillDetailModel;
import com.api.simplecrud.services.impl.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bill/details")
@CrossOrigin(origins = "http://localhost:4200")
public class BillDetailController {
    @Autowired
    private BillDetailService billDetailService;

    @PostMapping
    public ResponseEntity<BillDetailModel> create(@RequestBody BillDetailModel billModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(billDetailService.save(billModel));
    }
}
