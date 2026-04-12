package org.example.springproject.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.springproject.Entities.Pilote;
import org.example.springproject.Services.IPiloteService;
import java.util.List;

@RestController
@RequestMapping("/api/pilotes")
@AllArgsConstructor
public class PiloteController {

    private IPiloteService piloteService;

    // POST /api/pilotes/add
    @PostMapping("/add")
    public String addPilote(@RequestBody Pilote pilote) {
        return piloteService.addPilote(pilote);
    }

    // GET /api/pilotes/all
    @GetMapping("/all")
    public List<Pilote> listPilotes() {
        return piloteService.listPilotes();
    }

    // GET /api/pilotes/get/{id}
    @GetMapping("/get/{id}")
    public Pilote recupererPilote(@PathVariable Long id) {
        return piloteService.recupererPilote(id);
    }

    // PUT /api/pilotes/update
    @PutMapping("/update")
    public Pilote modifierPilote(@RequestBody Pilote pilote) {
        return piloteService.modifierPilote(pilote);
    }

    // DELETE /api/pilotes/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void supprimerPilote(@PathVariable Long id) {
        piloteService.supprimerPilote(id);
    }

    @PutMapping("/affecter/{idPilote}/{idEquipe}")
    public Pilote affecterPiloteAEquipe(
            @PathVariable Long idPilote,
            @PathVariable Long idEquipe) {
        return piloteService.affecterPiloteAEquipe(idPilote, idEquipe);
    }

}
