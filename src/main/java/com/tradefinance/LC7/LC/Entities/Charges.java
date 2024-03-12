package com.tradefinance.LC7.LC.Entities;

import com.tradefinance.LC7.LC.Enums.AmmortizeFee;
import com.tradefinance.LC7.LC.Enums.ChargesBorneBy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "charges_tbl")
public class Charges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chargeId;
//    @ManyToOne
//    @JoinColumn(name = "APPLICANT_ID" ,referencedColumnName = "applicant_id")
//    private Applicant applicant;
    private String amtDerivationType;
    private String chargeCode;
    private String chargeCurrency;
    private Long chargeAccount;
    private Long operativeChargeAccount;
    private BigDecimal chargeMinAmount;
    private BigDecimal chargeMinAmountCurrency;
    private BigDecimal chargeMaxAmountCurrency;
    private BigDecimal chargeMaxAmount;
    private BigDecimal totalAmount;
    private BigDecimal roundOffValue;
    private BigDecimal homeBranchCommission;
    private AmmortizeFee amortizeFee;
    //    @ManyToOne
//    @JoinColumn(name = "beneficiary_id")
//    private LcBeneficiaryDetails lcBeneficiaryDetails;
//    @ManyToMany(mappedBy = "accounts_tbl")
//    private List<Accounts> account;
    @Column(name = "charge_date", nullable = false)
    private Date chargeDate;
    private ChargesBorneBy chargesBorneBy;
    @Column(name = "immediate_amount", nullable = false)
    private Long immediateAmount;
    @Column(name = "split_amount", nullable = false)
    private Long splitAmount;
    @Column(name = "waiver_amount", nullable = false)
    private Long waiverAmount;
    private BigDecimal rate;
    private LocalDate deferredStartDate;
    private LocalDate deferredEndDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICANT_CHARGES",referencedColumnName = "letter_of_credit_id")
    private LetterOfCredit letterOfCredit;


}
