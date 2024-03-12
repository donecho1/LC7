package com.tradefinance.LC7.LC.sevices;

import com.tradefinance.LC7.LC.Entities.LetterOfCredit;
import com.tradefinance.LC7.LC.repositories.LetterOfCreditRepository;
import com.tradefinance.LC7.utils.Shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class LetterOfCreditService {
    @Autowired
    private LetterOfCreditRepository letterOfCreditRepository;

//    public LetterOfCredit issueLetterOfCredit(String applicantName, String form, String beneficiaryName, BigInteger amount, String issuingBank, String advisingBank, BigInteger Cif, Long applicantAccountNumber, String swiftMessage) {
//        LetterOfCredit letterOfCredit = new LetterOfCredit();
//        letterOfCredit.setForm(form);
//        letterOfCredit.setApplicantName(applicantName);
//        letterOfCredit.setBeneficiaryName(beneficiaryName);
//        letterOfCredit.setAmount(amount);
//        letterOfCredit.setIssuingBank(issuingBank);
//
//        // Generate unique letter of credit number
//        String letterOfCreditNumber = generateLetterOfCreditNumber();
//        letterOfCredit.setLetterOfCreditNumber(letterOfCreditNumber);
//
//        return letterOfCreditRepository.save(letterOfCredit);
//    }
//
//    private String generateLetterOfCreditNumber() {
//        Random random = new Random();
//        int randomNumber = random.nextInt(1000000); // Generate a random 6-digit number
//        String lcNumber = "LC-" + randomNumber;
//        return lcNumber;
//
//    }
    public ResponseEntity<Object> saveLetterOfCredit(LetterOfCredit letterOfCredit) {
        ApiResponse response = new ApiResponse();
        try {
            LetterOfCredit savedLC= letterOfCreditRepository.save(letterOfCredit);

            response.setMessage("Created");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setEntity(savedLC);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error occurred: " + e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //FIND USER BY FULL NAME
    public ResponseEntity<Object> fetchLetterOfCreditByLetterOfCreditNumber(String letterOfCreditNumber) {
        ApiResponse response = new ApiResponse();

        try {
            Optional<LetterOfCredit> letterOfCreditOptional = letterOfCreditRepository.findByLetterOfCreditNumber(letterOfCreditNumber);

            if (letterOfCreditOptional.isPresent()) {
                LetterOfCredit letterOfCredit = letterOfCreditOptional.get();
                response.setMessage("User3 retrieved successfully");
                response.setStatusCode(HttpStatus.OK.value());
                response.setEntity(letterOfCredit);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("LC not found for the given LCNumber: " + letterOfCreditNumber);
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error occurred while processing request");
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETING USER BY ID
    public ResponseEntity<Object> deleteLc(Long id) {
        ApiResponse response = new ApiResponse();
        try {
            Optional<LetterOfCredit> optionalLetterOfCredit = letterOfCreditRepository.findById(id);

            if (optionalLetterOfCredit.isPresent()) {
                LetterOfCredit letterOfCredit = optionalLetterOfCredit.get();

                letterOfCreditRepository.delete(letterOfCredit);

                response.setMessage("LCdeleted successfully");
                response.setStatusCode(HttpStatus.OK.value());

                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("LCnot found for id: " + id);
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error occurred: " + e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //GETTING USER BY ID
    public ResponseEntity<Object> getLCById(Long id) {
        ApiResponse response = new ApiResponse();
        try {
            Optional<LetterOfCredit> optionalLetterOfCredit = letterOfCreditRepository.findById(id);

            if (optionalLetterOfCredit.isPresent()) {
                LetterOfCredit letterOfCredit = optionalLetterOfCredit.get();
                response.setMessage("LC retrieved successfully");
                response.setStatusCode(HttpStatus.OK.value());
                response.setEntity(letterOfCredit);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("LC not found for id: " + id);
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error occurred: " + e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //UPDATING USER
    public ResponseEntity<Object> updateLc(Long id, LetterOfCredit letterOfCreditDetails) {
        ApiResponse response = new ApiResponse();
        try {
            Optional<LetterOfCredit> optionalLetterOfCredit = letterOfCreditRepository.findById(id);

            if (optionalLetterOfCredit.isPresent()) {
                LetterOfCredit letterOfCredit = optionalLetterOfCredit.get();

                // UpdateletterOfCredit details based onletterOfCreditDetails
                if (letterOfCreditDetails.getApplicant() != null) {
                    letterOfCredit.setApplicant(letterOfCreditDetails.getApplicant());
                }
                if (letterOfCreditDetails.getLetterOfCreditNumber() != null) {
                    letterOfCredit.setLetterOfCreditNumber(letterOfCreditDetails.getLetterOfCreditNumber());
                }
                if (letterOfCreditDetails.getAmount() != null) {
                   letterOfCredit.setAmount(letterOfCreditDetails.getAmount());
                }


                LetterOfCredit updatedLetterOfCredit = letterOfCreditRepository.save(letterOfCredit);

                response.setMessage("LC updated successfully");
                response.setStatusCode(HttpStatus.OK.value());
                response.setEntity(updatedLetterOfCredit);

                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("LCnot found for id: " + id);
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error occurred: " + e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//FETCHING ALL USERS

    public ResponseEntity<Object> fetchLcs() {
        ApiResponse response = new ApiResponse();
        try {
            List<LetterOfCredit> letterOfCredit = letterOfCreditRepository.findAll();

            response.setMessage("Found");
            response.setStatusCode(HttpStatus.FOUND.value());
            response.setEntity(letterOfCredit);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error occurred: " + e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




public LetterOfCredit issueLetterOfCredit(LetterOfCredit letterOfCredit) {
//        LetterOfCredit letterOfCredit = new LetterOfCredit();
//        letterOfCredit.setForm(form);
//        letterOfCredit.setApplicantName(applicantName);
//        letterOfCredit.setBeneficiaryName(beneficiaryName);
//        letterOfCredit.setAmount(amount);
//        letterOfCredit.setIssuingBank(issuingBank);

        // Generate unique letter of credit number
        String letterOfCreditNumber = generateLetterOfCreditNumber();
        letterOfCredit.setLetterOfCreditNumber(letterOfCreditNumber);

        return letterOfCreditRepository.save(letterOfCredit);
    }
    private String generateLetterOfCreditNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000000); // Generate a random 6-digit number
        String lcNumber = "LC-" + randomNumber;
        return lcNumber;

    }

}


