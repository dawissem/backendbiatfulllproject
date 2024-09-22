package com.dawissem.biat.Entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "ID", nullable = false, length = 2)
    private String id;

    @Column(name = "NAME", nullable = false, length = 30)
    private String name;


}