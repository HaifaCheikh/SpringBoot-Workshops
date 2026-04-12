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

    // POST /api/equipes/add
    @PostMapping("/add")
    public Equipe ajouterEquipe(@RequestBody Equipe equipe) {
        return equipeService.ajouterEquipe(equipe);
    }

    // GET /api/equipes/all
    @GetMapping("/all")
    public List<Equipe> listEquipes() {
        return equipeService.listEquipes();
    }

    // GET /api/equipes/get/{id}
    @GetMapping("/get/{id}")
    public Equipe recupererEquipe(@PathVariable Long id) {
        return equipeService.recupererEquipe(id);
    }

    // PUT /api/equipes/update
    @PutMapping("/update")
    public Equipe modifierEquipe(@RequestBody Equipe equipe) {
        return equipeService.modifierEquipe(equipe);
    }

    // DELETE /api/equipes/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void supprimerEquipe(@PathVariable Long id) {
        equipeService.supprimerEquipe(id);
    }
}