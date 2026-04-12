package org.example.springproject.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.springproject.Entities.DetailChampionnat;
import org.example.springproject.Services.IDetailChampionnatService;

import java.util.List;

@RestController
@RequestMapping("/api/details")
@AllArgsConstructor
public class DetailChampionnatController {

    private IDetailChampionnatService detailChampionnatService;

    @GetMapping
    public List<DetailChampionnat> list() {
        return detailChampionnatService.listDetailChampionnats();
    }

    @GetMapping("/{id}")
    public DetailChampionnat get(@PathVariable Long id) {
        return detailChampionnatService.recupererDetailChampionnat(id);
    }

    @PostMapping
    public DetailChampionnat add(@RequestBody DetailChampionnat detail) {
        return detailChampionnatService.ajouterDetailChampionnat(detail);
    }

    @PutMapping
    public DetailChampionnat update(@RequestBody DetailChampionnat detail) {
        return detailChampionnatService.modifierDetailChampionnat(detail);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        detailChampionnatService.supprimerDetailChampionnat(id);
    }

    @PostMapping("/addAndAffect/{idChampionnat}")
    public DetailChampionnat addAndAffect(
            @RequestBody DetailChampionnat dc,
            @PathVariable Long idChampionnat) {
        return detailChampionnatService
                .ajouterEtaffecterDetailChampionnatAChampionnat(dc, idChampionnat);
    }

}