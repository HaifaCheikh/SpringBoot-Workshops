package org.example.springproject.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private Float montant;

    private String annee;

    private Boolean archived;

    @ManyToOne
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Sponsor sponsor;

    @ManyToOne
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Equipe equipe;
}