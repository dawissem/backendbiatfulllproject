package com.dawissem.biat.Dto;

import com.dawissem.biat.Entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data

public class DeptaccountofficerDto {
    private Long id;
    private String name;

}
