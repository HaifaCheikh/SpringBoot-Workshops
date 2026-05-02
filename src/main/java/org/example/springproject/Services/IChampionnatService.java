package org.example.springproject.Services;

import org.example.springproject.DTO.PiloteDto;
import org.example.springproject.Entities.Championnat;
import java.util.List;

public interface IChampionnatService {

    Championnat ajouterChampionnat(Championnat championnat);

    List<Championnat> ajouterChampionnats(List<Championnat> championnats);

    Championnat modifierChampionnat(Championnat championnat);

    void supprimerChampionnat(Long idChampionnat);

    List<Championnat> listChampionnats();

    Championnat recupererChampionnat(Long idChampionnat);

    Championnat addChampionnatAndAssociatedCourses(Championnat championnat);

    String affecterCourseAChampionnat(Long idCourse, Long idChampionnat);

    List<PiloteDto> listeWinners(Integer annee);


}
