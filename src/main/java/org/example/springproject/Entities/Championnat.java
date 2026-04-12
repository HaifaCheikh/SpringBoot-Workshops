package org.example.springproject.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Championnat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChampionnat;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    private String libelleC;

    private Integer annee;

    @OneToMany(mappedBy = "championnat", cascade = CascadeType.ALL)
    private List<Course> courses;

    @OneToOne(mappedBy = "championnat")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private DetailChampionnat detailChampionnat;

}