package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.example.springproject.Entities.Equipe;
import org.example.springproject.Entities.Sponsor;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.Contrat;
import org.example.springproject.Repository.ContratRepository;
import org.example.springproject.Repository.EquipeRepository;
import org.example.springproject.Repository.SponsorRepository;
import org.example.springproject.DTO.ContratDto;


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

    @Override
    public void archiverContratsExpires() {
        int anneeCourrante = java.time.LocalDate.now().getYear();
        List<Contrat> tousLesContrats = contratRepository.findAll();
        tousLesContrats.forEach(c -> {
            if (c.getAnnee() != null &&
                    Integer.parseInt(c.getAnnee()) < anneeCourrante) {
                c.setArchived(true);
                contratRepository.save(c);
            }
        });
    }

    @Override
    public List<Contrat> getContratsActifs() {
        int anneeCourrante = java.time.LocalDate.now().getYear();
        return contratRepository.findAll().stream()
                .filter(c -> c.getAnnee() != null &&
                        Integer.parseInt(c.getAnnee()) >= anneeCourrante &&
                        Boolean.FALSE.equals(c.getArchived()))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public ContratDto ajoutContratEtAffecterASponsorEtEquipe(
            Contrat contrat,
            String libelleEquipe,
            String nomSponsor,
            String pays) {

        Equipe equipe = equipeRepository.findAll()
                .stream()
                .filter(e -> e.getLibelle().equals(libelleEquipe))
                .findFirst()
                .orElse(null);

        Sponsor sponsor = sponsorRepository.findAll()
                .stream()
                .filter(s -> s.getNom().equals(nomSponsor)
                        && s.getPays().equals(pays))
                .findFirst()
                .orElse(null);

        if (equipe != null && sponsor != null) {
            contrat.setEquipe(equipe);
            contrat.setSponsor(sponsor);
        }
        Contrat savedContrat = contratRepository.save(contrat);

        ContratDto dto = new ContratDto();
        dto.setIdContrat(savedContrat.getIdContrat());
        dto.setMontant(savedContrat.getMontant());
        dto.setAnnee(savedContrat.getAnnee());
        dto.setLibelleEquipe(equipe != null ? equipe.getLibelle() : null);
        dto.setNomSponsor(sponsor != null ? sponsor.getNom() : null);

        return dto;
    }

}