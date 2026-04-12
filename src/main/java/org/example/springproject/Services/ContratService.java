package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.example.springproject.Entities.Equipe;
import org.example.springproject.Entities.Sponsor;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.Contrat;
import org.example.springproject.Repository.ContratRepository;
import org.example.springproject.Repository.EquipeRepository;
import org.example.springproject.Repository.SponsorRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratService implements IContratService {

    private ContratRepository contratRepository;
    private EquipeRepository equipeRepository;
    private SponsorRepository sponsorRepository;

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> ajouterContrats(List<Contrat> contrats) {
        return contratRepository.saveAll(contrats);
    }

    @Override
    public Contrat modifierContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void supprimerContrat(Long idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public List<Contrat> listContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat recupererContrat(Long idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public Contrat ajoutContratEtAffecterASponsorEtEquipe(Contrat contrat, Long idEquipe, Long idSponsor) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        Sponsor sponsor = sponsorRepository.findById(idSponsor).orElse(null);
        contrat.setEquipe(equipe);
        contrat.setSponsor(sponsor);
        return contratRepository.save(contrat);
    }

}