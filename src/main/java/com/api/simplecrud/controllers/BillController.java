package com.api.simplecrud.controllers;

import com.api.simplecrud.models.BillModel;
import com.api.simplecrud.services.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {
    @Autowired
    private IBillService service;

    @GetMapping
    public List<BillModel> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingle(@PathVariable Long id){
        Optional<BillModel> singleBill = service.findById(id);
        if(singleBill.isPresent()){
            return ResponseEntity.ok(singleBill.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BillModel> create(@RequestBody BillModel billModel){
        System.out.println(billModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(billModel));
    }

    @PutMapping
    public ResponseEntity<BillModel> update( @RequestBody BillModel billModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(billModel));
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<BillModel> singleBill = service.delete(id);
        if(singleBill.isPresent()){
            return ResponseEntity.ok(singleBill.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
