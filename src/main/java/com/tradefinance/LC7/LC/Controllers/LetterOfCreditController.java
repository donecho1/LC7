package com.tradefinance.LC7.LC.Controllers;

import com.tradefinance.LC7.LC.Entities.LetterOfCredit;
import com.tradefinance.LC7.LC.sevices.LetterOfCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LetterOfCreditController {

    @Autowired
    private LetterOfCreditService letterOfCreditService;

    public LetterOfCreditController() {

    }

    //CREATING USERS
    @PostMapping("/issueLc")
    public LetterOfCredit issueLetterOfCredit(@RequestBody LetterOfCredit letterOfCredit) {
        return letterOfCreditService.issueLetterOfCredit(letterOfCredit);
    }

    //FETCHING USERS
    @GetMapping("/viewAll")
    public ResponseEntity<Object> fetchLcs() {
        return letterOfCreditService.fetchLcs();
    }

    //GETTING USER BY ID
    @GetMapping("/FindBy/{id}")
    public ResponseEntity<Object> getLetterOfCreditByIdById(@PathVariable Long id) {

        return letterOfCreditService.getLCById(id);
    }

    //UPDATING USER BY ID
    @PutMapping("/UpdateLc/{id}")
    public ResponseEntity<Object> updateLetterOfCredit(
            @PathVariable Long id, @RequestBody LetterOfCredit letterOfCreditDetails) {
        return letterOfCreditService.updateLc(id, letterOfCreditDetails);
    }

    //DELETE USER BY ID
    @DeleteMapping("/DeleteLc/{id}")
    public ResponseEntity<Object> deleteLc(@PathVariable Long id) {
        return letterOfCreditService.deleteLc(id);
    }

    //FIND BY NAME
    @GetMapping("/byLcNumber/{lcNumber}")
    public ResponseEntity<Object> fetchLetterOfCreditByLetterOfCreditNumber(@PathVariable String letterOfCreditNumber) {
        return letterOfCreditService.fetchLetterOfCreditByLetterOfCreditNumber(letterOfCreditNumber);
    }
}
