package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.example.springproject.Entities.Championnat;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.DetailChampionnat;
import org.example.springproject.Repository.DetailChampionnatRepository;
import org.example.springproject.Repository.ChampionnatRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailChampionnatService implements IDetailChampionnatService {

    private DetailChampionnatRepository detailChampionnatRepository;
    private ChampionnatRepository championnatRepository;

    @Override
    public DetailChampionnat ajouterDetailChampionnat(DetailChampionnat detail) {
        return detailChampionnatRepository.save(detail);
    }

    @Override
    public List<DetailChampionnat> ajouterDetails(List<DetailChampionnat> details) {
        return detailChampionnatRepository.saveAll(details);
    }

    @Override
    public DetailChampionnat modifierDetailChampionnat(DetailChampionnat detail) {
        return detailChampionnatRepository.save(detail);
    }

    @Override
    public void supprimerDetailChampionnat(Long idDetail) {
        detailChampionnatRepository.deleteById(idDetail);
    }

    @Override
    public List<DetailChampionnat> listDetailChampionnats() {
        return detailChampionnatRepository.findAll();
    }

    @Override
    public DetailChampionnat recupererDetailChampionnat(Long idDetail) {
        return detailChampionnatRepository.findById(idDetail).orElse(null);
    }

    @Override
    public DetailChampionnat ajouterEtaffecterDetailChampionnatAChampionnat(DetailChampionnat dc, Long idChampionnat) {
        Championnat championnat = championnatRepository.findById(idChampionnat).orElse(null);
        if (championnat != null) {
            dc.setChampionnat(championnat);
            return detailChampionnatRepository.save(dc);
        }
        return null;
    }

}