package org.example.springproject.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.springproject.Entities.Championnat;
import org.example.springproject.Services.IChampionnatService;

import java.util.List;

@RestController
@RequestMapping("/api/championnats")


public class ChampionnatController {

    private final IChampionnatService championnatService;

    public ChampionnatController(IChampionnatService championnatService) {
        this.championnatService = championnatService;
    }

    @GetMapping
    public List<Championnat> list() {
        return championnatService.listChampionnats();
    }

    @GetMapping("/{id}")
    public Championnat get(@PathVariable("id") Long id) {
        return championnatService.recupererChampionnat(id);
    }

    @PostMapping
    public Championnat add(@RequestBody Championnat championnat) {
        return championnatService.ajouterChampionnat(championnat);
    }

    @PostMapping("/bulk")
    public List<Championnat> addAll(@RequestBody List<Championnat> championnats) {
        return championnatService.ajouterChampionnats(championnats);
    }

    @PutMapping
    public Championnat update(@RequestBody Championnat championnat) {
        return championnatService.modifierChampionnat(championnat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        championnatService.supprimerChampionnat(id);
    }

    @PostMapping("/addWithCourses")
    public Championnat addWithCourses(@RequestBody Championnat championnat) {
        return championnatService.addChampionnatAndAssociatedCourses(championnat);
    }

}