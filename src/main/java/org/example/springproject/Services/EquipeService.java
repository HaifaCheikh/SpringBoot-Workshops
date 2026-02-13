package org.example.springproject.Services;
import org.example.springproject.Entities.Equipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.Equipe;
import org.example.springproject.Repository.EquipeRepository;

@Service
@AllArgsConstructor
public class EquipeService implements IEquipeService {

    EquipeRepository equipeRepository;

    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }
}

