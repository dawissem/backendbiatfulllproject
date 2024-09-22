package com.dawissem.biat.Dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private Long matricule;
    private String password;
}
