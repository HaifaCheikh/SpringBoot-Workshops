package org.example.springproject.Services;

import org.example.springproject.Entities.DetailChampionnat;
import java.util.List;

public interface IDetailChampionnatService {

    DetailChampionnat ajouterDetailChampionnat(DetailChampionnat detail);

    List<DetailChampionnat> ajouterDetails(List<DetailChampionnat> details);

    DetailChampionnat modifierDetailChampionnat(DetailChampionnat detail);

    void supprimerDetailChampionnat(Long idDetail);

    List<DetailChampionnat> listDetailChampionnats();

    DetailChampionnat recupererDetailChampionnat(Long idDetail);
}