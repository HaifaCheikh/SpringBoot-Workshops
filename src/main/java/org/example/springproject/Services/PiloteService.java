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

}