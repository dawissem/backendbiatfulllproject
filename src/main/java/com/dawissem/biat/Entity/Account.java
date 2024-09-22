package com.dawissem.biat.Entity;

import com.dawissem.biat.Enum.CategoryAccount;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_OFFICER", nullable = false)
    private Deptaccountofficer accountOfficer;

    @Column(name = "ACCOUNT_TITLE", length = 60)
    private String accountTitle;

    @ManyToOne
    @JoinColumn(name = "CURRENCY")
    private Currency currency;


    @Column(name = "CATEGORY", nullable = false)
    private CategoryAccount category;

    @ColumnDefault("0.0000")
    @Column(name = "WORKING_BALANCE", precision = 10, scale = 4)
    private BigDecimal workingBalance;

    @Column(name = "OPENING_DATE")
    private Date openingDate;

    @Column(name = "CLOSURE_DATE")
    private Date closureDate;



}