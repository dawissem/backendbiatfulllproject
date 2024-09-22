package com.dawissem.biat.Dto;

import com.dawissem.biat.Entity.Currency;
import com.dawissem.biat.Entity.Customer;
import com.dawissem.biat.Entity.Deptaccountofficer;
import com.dawissem.biat.Enum.CategoryAccount;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountDto {

    private Long id;
    private CustomerDto customer;
    private DeptaccountofficerDto accountOfficer;
    private String accountTitle;

    private Currency currency;

    private CategoryAccount category;

    private BigDecimal workingBalance;
    private Date openingDate;
    private Date closureDate;



}
