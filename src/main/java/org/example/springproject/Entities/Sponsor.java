package org.example.springproject.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSponsor;

    private String nom;

    private String pays;

    private Float budgetAnnuel;

    private Boolean bloquerContrat;

    private Boolean archived;

    private LocalDate dateCreation;

    private LocalDate dateDerniereModification;

    @OneToMany(mappedBy = "sponsor")
    private List<Contrat> contrats;
}