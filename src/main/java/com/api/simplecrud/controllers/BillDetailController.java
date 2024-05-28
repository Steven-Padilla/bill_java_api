package com.api.simplecrud.controllers;


import com.api.simplecrud.models.BillDetailModel;
import com.api.simplecrud.models.BillModel;
import com.api.simplecrud.services.impl.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<BillDetailModel> delete(@PathVariable Long id){
        Optional<BillDetailModel> singleBill = billDetailService.delete(id);
        if(singleBill.isPresent()){
            return ResponseEntity.ok(singleBill.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
