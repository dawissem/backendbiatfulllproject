package com.dawissem.biat.Dto;

import com.dawissem.biat.Entity.Country;
import com.dawissem.biat.Enum.CustomerEnum;
import com.dawissem.biat.Enum.GenderEnum;
import com.dawissem.biat.Enum.Legal_Doc_Enum;
import lombok.Data;


import java.util.Date;

@Data
public class CustomerDto {
    private Long CUSTOMER_ID;
    private CustomerEnum customerType;
    private String shortName;
    private GenderEnum gender;
    private Date dateBirthCreation;
    private String address;
    private Long postCode;
    private Legal_Doc_Enum legalDocName;
    private String legalId;
    private Country nationality;
    private DeptaccountofficerDto agence;
    private String tel;
    private String mail;
}
