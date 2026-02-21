package org.example.springproject.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.springproject.Entities.Equipe;
import org.example.springproject.Services.IEquipeService;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
@AllArgsConstructor
public class EquipeController {

    private IEquipeService equipeService;

    @GetMapping
    public List<Equipe> list() {
        return equipeService.listEquipes();
    }

    @GetMapping("/{id}")
    public Equipe get(@PathVariable Long id) {
        return equipeService.recupererEquipe(id);
    }

    @PostMapping
    public Equipe add(@RequestBody Equipe equipe) {
        return equipeService.ajouterEquipe(equipe);
    }

    @PutMapping
    public Equipe update(@RequestBody Equipe equipe) {
        return equipeService.modifierEquipe(equipe);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        equipeService.supprimerEquipe(id);
    }
}
