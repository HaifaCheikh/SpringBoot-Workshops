package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springproject.Entities.Contrat;
import org.example.springproject.Entities.Equipe;
import org.example.springproject.Entities.Sponsor;
import org.example.springproject.Repository.EquipeRepository;
import org.example.springproject.Repository.SponsorRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SchedulerService {

    private IContratService contratService;
    private ISponsorService sponsorService;
    private IPiloteService piloteService;
    private EquipeRepository equipeRepository;
    private SponsorRepository sponsorRepository;

    @Scheduled(fixedRate = 30000)
    public void archiverContratsExpireesEtAffichageContratsActifsParEquipe() {

        // 1. Archiver les contrats dont l'année < année courante
        contratService.archiverContratsExpires();

        // 2. Afficher les contrats actifs par équipe
        List<Equipe> equipes = equipeRepository.findAll();
        equipes.forEach(equipe -> {
            if (equipe.getContrats() != null) {
                equipe.getContrats().stream()
                        .filter(c -> Boolean.FALSE.equals(c.getArchived()))
                        .forEach(c -> log.info(
                                "L'équipe {} a un contrat d'un montant de {} avec le sponsor {}",
                                equipe.getLibelle(),
                                c.getMontant(),
                                c.getSponsor() != null ? c.getSponsor().getNom() : "N/A"));
            }
        });
    }

    @Scheduled(cron = "0 0 9 * * MON")
    public void afficherPourcentageBudgetSponsors() {

        List<Sponsor> sponsors = sponsorRepository.findAll();
        sponsors.forEach(sponsor -> {
            Float pourcentage = sponsorService
                    .pourcentageBudgetAnnuelConsomme(sponsor.getIdSponsor());

            log.info("sponsor: {} pourcentage : {}",
                    sponsor.getNom(), pourcentage);

            if (pourcentage > 100) {
                log.info(
                        "budget dépassé!! vous ne pouvez plus faire de contrats");
                // Bloquer le contrat
                sponsor.setBloquerContrat(true);
                sponsorRepository.save(sponsor);

            } else if (pourcentage > 70) {
                log.info(
                        "attention budget presque consommé : {} % !", pourcentage);
            }
        });
    }

    @Scheduled(cron = "0 15 11 31 12 *")
    public void mettreAJourPointsEtClassementPilotes() {
        log.info("=== Mise à jour annuelle des points et classements des pilotes ===");
        piloteService.mettreAJourPointsEtClassement();
        log.info("=== Mise à jour terminée ===");
    }
}