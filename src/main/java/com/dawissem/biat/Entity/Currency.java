package com.dawissem.biat.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @Column(name = "ID", nullable = false, length = 3)
    private String id;

    @Column(name = "NAME", nullable = false, length = 10)
    private String name;



}