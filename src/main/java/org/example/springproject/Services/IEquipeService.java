package org.example.springproject.Services;

import org.example.springproject.Entities.Equipe;
import java.util.List;

public interface IEquipeService {
    Equipe ajouterEquipe(Equipe equipe);
    List<Equipe> listEquipes();
    Equipe recupererEquipe(Long idEquipe);
    Equipe modifierEquipe(Equipe equipe);
    void supprimerEquipe(Long idEquipe);
}
