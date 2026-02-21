package org.example.springproject.Controller;

import lombok.AllArgsConstructor;
import org.example.springproject.Services.IPiloteService;
import org.springframework.web.bind.annotation.*;
import org.example.springproject.Entities.Pilote;
import org.example.springproject.Services.IPositionService;

import java.util.List;

@RestController
@RequestMapping("/api/pilotes")
@AllArgsConstructor
public class PiloteController {

    private IPiloteService piloteService;

    @GetMapping
    public List<Pilote> list() {
        return piloteService.listPilotes();
    }

    @GetMapping("/{id}")
    public Pilote get(@PathVariable Long id) {
        return piloteService.recupererPilote(id);
    }

    @PostMapping
    public Pilote add(@RequestBody Pilote pilote) {
        return piloteService.ajouterPilote(pilote);
    }

    @PutMapping
    public Pilote update(@RequestBody Pilote pilote) {
        return piloteService.modifierPilote(pilote);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        piloteService.supprimerPilote(id);
    }
}
