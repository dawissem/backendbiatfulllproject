package com.dawissem.biat.Dto;

import com.dawissem.biat.Entity.Deptaccountofficer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data

public class UserDto {
    private Long matricule;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private DeptaccountofficerDto agence;
}
