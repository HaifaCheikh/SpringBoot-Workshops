package org.example.springproject.Services;

import org.example.springproject.DTO.ContratDto;
import org.example.springproject.Entities.Contrat;
import java.util.List;
import org.example.springproject.DTO.ContratDto;

public interface IContratService {

    Contrat ajouterContrat(Contrat contrat);

    List<Contrat> ajouterContrats(List<Contrat> contrats);

    Contrat modifierContrat(Contrat contrat);

    void supprimerContrat(Long idContrat);

    List<Contrat> listContrats();

    Contrat recupererContrat(Long idContrat);

    Contrat ajoutContratEtAffecterASponsorEtEquipe(Contrat contrat, Long idEquipe, Long idSponsor);

    void archiverContratsExpires();

    List<Contrat> getContratsActifs();

    ContratDto ajoutContratEtAffecterASponsorEtEquipe(
            Contrat contrat,
            String libelleEquipe,
            String nomSponsor,
            String pays);
}
