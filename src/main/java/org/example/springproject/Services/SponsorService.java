package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.Sponsor;
import org.example.springproject.Repository.SponsorRepository;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class SponsorService implements ISponsorService {

    private SponsorRepository sponsorRepository;

    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {
        // Initialisation automatique
        sponsor.setDateCreation(LocalDate.now());
        sponsor.setArchived(false);
        sponsor.setBloquerContrat(false);
        return sponsorRepository.save(sponsor);
    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {
        sponsors.forEach(s -> {
            s.setDateCreation(LocalDate.now());
            s.setArchived(false);
            s.setBloquerContrat(false);
        });
        return sponsorRepository.saveAll(sponsors);
    }

    @Override
    public Sponsor modifierSponsor(Sponsor sponsor) {
        // dateDerniereModification initialisée automatiquement
        sponsor.setDateDerniereModification(LocalDate.now());
        return sponsorRepository.save(sponsor);
    }

    @Override
    public void supprimerSponsor(Long idSponsor) {
        sponsorRepository.deleteById(idSponsor);
    }

    @Override
    public List<Sponsor> listSponsors() {
        return sponsorRepository.findAll();
    }

    @Override
    public Sponsor recupererSponsor(Long idSponsor) {
        return sponsorRepository.findById(idSponsor).orElse(null);
    }

    @Override
    public Boolean archiverSponsor(Long idSponsor) {
        Sponsor sponsor = sponsorRepository.findById(idSponsor).orElse(null);
        if (sponsor != null) {
            sponsor.setArchived(true);
            sponsorRepository.save(sponsor);
            return true;
        }
        return false;
    }
}