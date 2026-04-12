package org.example.springproject.Services;

import org.example.springproject.Entities.Contrat;
import java.util.List;

public interface IContratService {

    Contrat ajouterContrat(Contrat contrat);

    List<Contrat> ajouterContrats(List<Contrat> contrats);

    Contrat modifierContrat(Contrat contrat);

    void supprimerContrat(Long idContrat);

    List<Contrat> listContrats();

    Contrat recupererContrat(Long idContrat);

    Contrat ajoutContratEtAffecterASponsorEtEquipe(Contrat contrat, Long idEquipe, Long idSponsor);
}

