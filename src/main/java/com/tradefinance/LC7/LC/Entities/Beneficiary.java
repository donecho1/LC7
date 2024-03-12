package com.tradefinance.LC7.LC.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "beneficiary_tbl")
public class Beneficiary {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long beneficiaryId;
    private Long primaryBeneficiaryCif;
    private String primaryBeneficiaryName;
    private Long primaryBeneficiaryAcc;
    private String secondaryBeneficiaryName;
    private Long secondaryBeneficiaryAcc;
    private BigInteger transferableAmount;
    private String bankName;
    private String beneficiaryEmail;
    private Long beneficiaryAddress;
    private String beneficiaryCity;
    private  String state;
    private String beneficiaryPostalCode;
    private String beneficiaryCountry;
    private BigInteger lcValue;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private BigDecimal unverifiedLcValue;
    @OneToMany(mappedBy = "beneficiary")
    private List<LetterOfCredit> letterOfCredit;

}
