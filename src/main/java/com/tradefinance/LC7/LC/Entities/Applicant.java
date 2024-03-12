package com.tradefinance.LC7.LC.Entities;

import com.tradefinance.LC7.utils.Shared.BaseApplicant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "applicant_tbl")
public class Applicant extends BaseApplicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicantId;
    private String issuingBankName;
    private String issuingBankBranch;
    private String issuingBankCountry;
    private String issuingBankBic;
    private String issuingBankRef;
    private String advisingBankName;
    private String advisingBankBranch;
    private String advisingBankCountry;
    private String advisingBankBic;
    private String advisingBankRef;
    private String reimbursingBankName;
    private String reimbursingBankBranch;
    private String reimbursingBankCountry;
    private String reimbursingBankBic;
    private String reimbursingBankRef;
    private String adviseThroughBankName;
    private String adviseThroughBankBranch;
    private String adviseThroughBankCountry;
    private String adviseThroughBankBic;
    private String adviseThroughBankRef;
    @OneToMany(mappedBy = "applicant")
    private List<LetterOfCredit> letterOfCredits;
    @OneToMany(mappedBy = "applicant")
    private List<Accounts> accounts;

}
