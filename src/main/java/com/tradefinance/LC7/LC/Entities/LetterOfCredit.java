package com.tradefinance.LC7.LC.Entities;

import com.tradefinance.LC7.LC.Enums.*;
import com.tradefinance.LC7.LC.Enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "lc_tbl")
public class LetterOfCredit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "letter_of_credit_id")
    private Long letterOfCreditId;
    private String lcNumber;
    private String applicantName;
    private String beneficiaryName;
    private  String form;
    private ApplicableRules applicableRules;
    private Boolean isExpired;
    private String issuingBank;
    private Date shipmentDate;
    private String portOfDischarge;
    private String portOfLoading;
    private Date issueDate;
    private Date expiryDate;
    private String type;
    private String subType;
    @Enumerated(EnumType.STRING)
    private InlandForeign inlandForeign;
    private BigDecimal usance;
    private BigInteger amount;
    private Boolean transferable;
    private ShipmentTerms shipmentTerms;
    private Long negotiationPeriod;
    private String commodityCode;
    private String chargesBy;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date creationDate;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updateDate;


    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Applicant_Id",referencedColumnName = "applicantId")
    private Applicant applicant;
    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Beneficiary_Id",referencedColumnName = "beneficiaryId")
    private Beneficiary beneficiary;
    private DocumentName documentName;
    private  Integer numberOfCopies;
    private  Boolean signed;
    private String description;
    private Integer goodsQuantity;
    private BigInteger value;
    private Long countyOfOrigin;
    private String termsOfShipment;
    @Enumerated(EnumType.STRING)
    @Column(name = "partial_shipment", nullable = false)
    private PartialShipment partialShipment;
    @Enumerated(EnumType.STRING)
    @Column(name = "trans_shipment", nullable = false)
    private Transshipment transShipment;
    @OneToMany(mappedBy = "letterOfCredit")
    private List<Charges> charges;
//


}

