package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.Pilote;
import org.example.springproject.Repository.PiloteRepository;

@Service
@AllArgsConstructor
public class PiloteService implements IPiloteService {

    private PiloteRepository piloteRepository;

    @Override
    public String addPilote(Pilote p) {
        piloteRepository.save(p);
        return "Pilote ajouté avec succès";
    }
}
