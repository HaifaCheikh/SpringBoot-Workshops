package org.example.springproject.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosition;

    private Integer classement;

    private Integer nbrPoints;

    @ManyToOne
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Pilote pilote;

    @ManyToOne
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Course course;
}