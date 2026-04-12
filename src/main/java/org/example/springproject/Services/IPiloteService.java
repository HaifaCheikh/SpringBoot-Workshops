package org.example.springproject.Services;

import org.example.springproject.Entities.Pilote;
import java.util.List;

public interface IPiloteService {
    String addPilote(Pilote p);

    List<Pilote> listPilotes();

    Pilote recupererPilote(Long idPilote);

    Pilote modifierPilote(Pilote pilote);

    void supprimerPilote(Long idPilote);

    Pilote affecterPiloteAEquipe(Long idPilote, Long idEquipe);

    void mettreAJourPointsEtClassement();

}