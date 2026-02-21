package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.DetailChampionnat;
import org.example.springproject.Repository.DetailChampionnatRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailChampionnatService implements IDetailChampionnatService {

    private DetailChampionnatRepository repository;

    @Override
    public DetailChampionnat ajouterDetailChampionnat(DetailChampionnat detail) {
        return repository.save(detail);
    }

    @Override
    public List<DetailChampionnat> ajouterDetails(List<DetailChampionnat> details) {
        return repository.saveAll(details);
    }

    @Override
    public DetailChampionnat modifierDetailChampionnat(DetailChampionnat detail) {
        return repository.save(detail);
    }

    @Override
    public void supprimerDetailChampionnat(Long idDetail) {
        repository.deleteById(idDetail);
    }

    @Override
    public List<DetailChampionnat> listDetailChampionnats() {
        return repository.findAll();
    }

    @Override
    public DetailChampionnat recupererDetailChampionnat(Long idDetail) {
        return repository.findById(idDetail).orElse(null);
    }
}