package com.tradefinance.LC7.utils.Shared;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BaseApplicant {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long applicantId;
    private Long applicantCif;
    private Long accountNumber;
    private String name;
    private String applicantAddress;
    private String applicantCity;
    private Long applicantPostalCode;
    private String applicantCountry;

}
