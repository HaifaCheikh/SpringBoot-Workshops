package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.Equipe;
import org.example.springproject.Repository.EquipeRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class EquipeService implements IEquipeService {

    private EquipeRepository equipeRepository;

    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> listEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe recupererEquipe(Long idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public Equipe modifierEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public void supprimerEquipe(Long idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }
}
