package org.example.springproject.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.springproject.Entities.Sponsor;
import org.example.springproject.Services.ISponsorService;

import java.util.List;

@RestController
@RequestMapping("/api/sponsors")
@AllArgsConstructor
public class SponsorController {

    private ISponsorService sponsorService;

    @GetMapping
    public List<Sponsor> list() {
        return sponsorService.listSponsors();
    }

    @GetMapping("/{id}")
    public Sponsor get(@PathVariable Long id) {
        return sponsorService.recupererSponsor(id);
    }

    @PostMapping
    public Sponsor add(@RequestBody Sponsor sponsor) {
        return sponsorService.ajouterSponsor(sponsor);
    }

    @PutMapping
    public Sponsor update(@RequestBody Sponsor sponsor) {
        return sponsorService.modifierSponsor(sponsor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sponsorService.supprimerSponsor(id);
    }
}