package org.example.springproject.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.springproject.Entities.Contrat;
import org.example.springproject.Services.IContratService;
import org.example.springproject.DTO.ContratDto;


import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@AllArgsConstructor

public class ContratController {

    private IContratService contratService;

    @GetMapping
    public List<Contrat> list() {
        return contratService.listContrats();
    }

    @GetMapping("/{id}")
    public Contrat get(@PathVariable Long id) {
        return contratService.recupererContrat(id);
    }

    @PostMapping
    public Contrat add(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @PutMapping
    public Contrat update(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contratService.supprimerContrat(id);
    }

    @PostMapping("/addAndAffect/{idEquipe}/{idSponsor}")
    public Contrat addAndAffect(
            @RequestBody Contrat contrat,
            @PathVariable Long idEquipe,
            @PathVariable Long idSponsor) {
        return contratService
                .ajoutContratEtAffecterASponsorEtEquipe(contrat, idEquipe, idSponsor);
    }
    @PostMapping("/addAndAffect/byNames")
    public ContratDto addAndAffectByNames(
            @RequestBody Contrat contrat,
            @RequestParam String libelleEquipe,
            @RequestParam String nomSponsor,
            @RequestParam String pays) {
        return contratService.ajoutContratEtAffecterASponsorEtEquipe(
                contrat, libelleEquipe, nomSponsor, pays);
    }
}