package com.tradefinance.LC7.LC.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "issued_lcs_tbl")
public class IssuedLcs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issued_lcs_id")
    private Long issuedLcId;
    private Long transactionNumber;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String currencyCode;
    private BigInteger amount;
    private String country;
    private String issuingBankBic;
    private String advisingBankBic;
    @OneToMany(fetch = FetchType.LAZY)
    private List<LetterOfCredit> letterOfCredits;
    @OneToOne(fetch = FetchType.LAZY)
    private Applicant applicant;
    @OneToOne(fetch = FetchType.LAZY)
    private Beneficiary beneficiary;





}
