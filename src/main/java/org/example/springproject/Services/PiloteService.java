package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.example.springproject.Entities.Equipe;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.Pilote;
import org.example.springproject.Repository.PiloteRepository;
import org.example.springproject.Repository.EquipeRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class PiloteService implements IPiloteService {

    private PiloteRepository piloteRepository;
    private EquipeRepository equipeRepository;

    @Override
    public String addPilote(Pilote p) {
        piloteRepository.save(p);
        return "Pilote ajouté avec succès : " + p.getLibelleP();
    }

    @Override
    public List<Pilote> listPilotes() {
        return piloteRepository.findAll();
    }

    @Override
    public Pilote recupererPilote(Long idPilote) {
        return piloteRepository.findById(idPilote).orElse(null);
    }

    @Override
    public Pilote modifierPilote(Pilote pilote) {
        return piloteRepository.save(pilote);
    }

    @Override
    public void supprimerPilote(Long idPilote) {
        piloteRepository.deleteById(idPilote);
    }

    @Override
    public Pilote affecterPiloteAEquipe(Long idPilote, Long idEquipe) {
        Pilote pilote = piloteRepository.findById(idPilote).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        if (pilote != null && equipe != null) {
            pilote.setEquipe(equipe);
            return piloteRepository.save(pilote);
        }
        return null;
    }

    @Override
    public void mettreAJourPointsEtClassement() {
        int anneeCourrante = java.time.LocalDate.now().getYear();

        List<Pilote> pilotes = piloteRepository.findAll();

        // Calculer les points de chaque pilote
        // (somme des nbrPoints dans ses positions pour l'année en cours)
        pilotes.forEach(pilote -> {
            if (pilote.getPositions() != null) {
                int totalPoints = pilote.getPositions().stream()
                        .filter(pos -> pos.getCourse() != null
                                && pos.getCourse().getDateCourse() != null
                                && pos.getCourse().getDateCourse().getYear() == anneeCourrante)
                        .mapToInt(pos -> pos.getNbrPoints() == null ? 0 : pos.getNbrPoints())
                        .sum();
                pilote.setNbrPointsTotal(totalPoints);
                piloteRepository.save(pilote);
            }
        });

        // Mettre à jour le classement en triant par points décroissants
        List<Pilote> pilotsTriés = piloteRepository.findAll().stream()
                .sorted((p1, p2) -> Integer.compare(
                        p2.getNbrPointsTotal() == null ? 0 : p2.getNbrPointsTotal(),
                        p1.getNbrPointsTotal() == null ? 0 : p1.getNbrPointsTotal()))
                .collect(java.util.stream.Collectors.toList());

        for (int i = 0; i < pilotsTriés.size(); i++) {
            pilotsTriés.get(i).setClassementGeneral(i + 1);
            piloteRepository.save(pilotsTriés.get(i));
        }
    }

}