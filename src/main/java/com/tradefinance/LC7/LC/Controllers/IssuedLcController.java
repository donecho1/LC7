package com.tradefinance.LC7.LC.Controllers;

import com.tradefinance.LC7.LC.Entities.IssuedLcs;
import com.tradefinance.LC7.LC.sevices.IssuedLcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issuedlcs")
public class IssuedLcController {

    @Autowired
    private IssuedLcService issuedLcService;

    @GetMapping
    public ResponseEntity<List<IssuedLcs>> getAllIssuedLcs() {
        List<IssuedLcs> issuedLcs = issuedLcService.getAllIssuedLcs();
        return new ResponseEntity<>(issuedLcs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssuedLcs> getIssuedLcById(@PathVariable Long id) {
        IssuedLcs issuedLc = issuedLcService.getIssuedLcById(id);
        if (issuedLc != null) {
            return new ResponseEntity<>(issuedLc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<IssuedLcs> saveIssuedLc(@RequestBody IssuedLcs issuedLc) {
        IssuedLcs savedIssuedLc = issuedLcService.saveIssuedLc(issuedLc);
        return new ResponseEntity<>(savedIssuedLc, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIssuedLc(@PathVariable Long id) {
        issuedLcService.deleteIssuedLc(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}