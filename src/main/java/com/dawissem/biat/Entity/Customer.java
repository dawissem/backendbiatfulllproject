package com.dawissem.biat.Entity;

import com.dawissem.biat.Enum.CustomerEnum;
import com.dawissem.biat.Enum.GenderEnum;
import com.dawissem.biat.Enum.Legal_Doc_Enum;
import com.dawissem.biat.Enum.Nationality;
import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long CUSTOMER_ID;



    @Column(name = "CUSTOMER_TYPE")
    private CustomerEnum customerType;

    @Column(name = "shortName", length = 60)
    private String shortName;


    @Column(name = "GENDER")
    private GenderEnum gender;

    @Column(name = "DATE_BIRTH_CREATION")
    private Date dateBirthCreation;

    @Column(name = "ADDRESS", length = 60)
    private String address;

    @Column(name = "POST_CODE")
    private Long postCode;


    @Column(name = "LEGAL_DOC_NAME", nullable = false)
    private Legal_Doc_Enum legalDocName;

    @Column(name = "LEGAL_ID", length = 30)
    private String legalId;


    @ManyToOne
    @JoinColumn(name = "nationality", nullable = false)
    private Country nationality;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_OFFICER_ID")
    private Deptaccountofficer agence;

    @Column(name = "TEL", length = 20)
    private String tel;

    @Column(name = "MAIL", length = 30)
    private String mail;


}