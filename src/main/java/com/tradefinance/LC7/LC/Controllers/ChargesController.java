package com.tradefinance.LC7.LC.Controllers;

import com.tradefinance.LC7.LC.Entities.Charges;
import com.tradefinance.LC7.LC.sevices.ChargesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charges")
public class ChargesController {

    @Autowired
    private ChargesService chargesService;

    @GetMapping
    public ResponseEntity<List<Charges>> getAllCharges() {
        List<Charges> charges = chargesService.getAllCharges();
        return new ResponseEntity<>(charges, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Charges> getChargesById(@PathVariable Long chargeId) {
        Charges charges = chargesService.getChargesById(chargeId);
        if (charges != null) {
            return new ResponseEntity<>(charges, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Charges> saveCharges(@RequestBody Charges charges) {
        Charges savedCharges = chargesService.saveCharges(charges);
        return new ResponseEntity<>(savedCharges, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharges(@PathVariable Long chargeId) {
        chargesService.deleteCharges(chargeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Charges> updateCharges(@PathVariable Long chargeId, @RequestBody Charges updatedCharges) {
//        Charges savedCharges = chargesService.updateCharges(chargeId, updatedCharges);
//        if (savedCharges != null) {
//            return new ResponseEntity<>(savedCharges, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}