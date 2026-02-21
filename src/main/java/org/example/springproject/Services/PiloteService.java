package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.Pilote;
import org.example.springproject.Repository.PiloteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PiloteService implements IPiloteService {

    private PiloteRepository piloteRepository;

    @Override
    public Pilote ajouterPilote(Pilote pilote) {
        return piloteRepository.save(pilote);
    }

    @Override
    public List<Pilote> ajouterPilotes(List<Pilote> pilotes) {
        return piloteRepository.saveAll(pilotes);
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
    public List<Pilote> listPilotes() {
        return piloteRepository.findAll();
    }

    @Override
    public Pilote recupererPilote(Long idPilote) {
        return piloteRepository.findById(idPilote).orElse(null);
    }
}