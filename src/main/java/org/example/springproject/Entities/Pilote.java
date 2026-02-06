package org.example.springproject.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Pilote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPilote;

    private String libelleP;

    private Integer nbrPointsTotal;

    private Integer classementGeneral;

    @ManyToOne
    private Equipe equipe;

    @OneToMany(mappedBy = "pilote")
    private List<Position> positions;
}
