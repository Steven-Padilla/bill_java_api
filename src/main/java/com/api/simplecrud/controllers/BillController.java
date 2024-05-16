package com.api.simplecrud.controllers;

import com.api.simplecrud.models.BillModel;
import com.api.simplecrud.models.StakeHolder;
import com.api.simplecrud.services.IBillService;
import com.api.simplecrud.services.IStakeholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bill")
@CrossOrigin(origins = "http://localhost:4200")
public class BillController {
    @Autowired
    private IBillService service;
    @Autowired
    private IStakeholderService serviceStakeholder;

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
    public ResponseEntity<BillModel> create(@RequestBody BillModel billModel, @RequestParam Long issuing, @RequestParam Long receiver){
        System.out.println(billModel.toString());
        Optional<StakeHolder> issuingEntity= serviceStakeholder.getStakeHolderById(issuing);
        Optional<StakeHolder> receiverEntity= serviceStakeholder.getStakeHolderById(receiver);
        if(issuingEntity.isPresent() && receiverEntity.isPresent()){
            StakeHolder issuingM = issuingEntity.get();
            StakeHolder receiverM = receiverEntity.get();
            billModel.setIssuing(issuingM);
            billModel.setReceiver(receiverM);
            System.out.println(issuingM.toString());

        }
        System.out.println(billModel.toString());
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
