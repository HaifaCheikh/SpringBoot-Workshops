package org.example.springproject.Services;

import org.example.springproject.Entities.Pilote;
import java.util.List;

public interface IPiloteService {

    Pilote ajouterPilote(Pilote pilote);

    List<Pilote> ajouterPilotes(List<Pilote> pilotes);

    Pilote modifierPilote(Pilote pilote);

    void supprimerPilote(Long idPilote);

    List<Pilote> listPilotes();

    Pilote recupererPilote(Long idPilote);
}