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

    // POST /api/sponsors/add
    @PostMapping("/add")
    public Sponsor ajouterSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.ajouterSponsor(sponsor);
    }

    // POST /api/sponsors/addAll
    @PostMapping("/addAll")
    public List<Sponsor> ajouterSponsors(@RequestBody List<Sponsor> sponsors) {
        return sponsorService.ajouterSponsors(sponsors);
    }

    // PUT /api/sponsors/update
    @PutMapping("/update")
    public Sponsor modifierSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.modifierSponsor(sponsor);
    }

    // DELETE /api/sponsors/delete/{id}
    @DeleteMapping("/delete/{idSponsor}")
    public void supprimerSponsor(@PathVariable Long idSponsor) {
        sponsorService.supprimerSponsor(idSponsor);
    }

    // GET /api/sponsors/all
    @GetMapping("/all")
    public List<Sponsor> listSponsors() {
        return sponsorService.listSponsors();
    }

    // GET /api/sponsors/get/{id}
    @GetMapping("/get/{idSponsor}")
    public Sponsor recupererSponsor(@PathVariable Long idSponsor) {
        return sponsorService.recupererSponsor(idSponsor);
    }

    // PUT /api/sponsors/archiver/{id}
    @PutMapping("/archiver/{idSponsor}")
    public Boolean archiverSponsor(@PathVariable Long idSponsor) {
        return sponsorService.archiverSponsor(idSponsor);
    }
}
