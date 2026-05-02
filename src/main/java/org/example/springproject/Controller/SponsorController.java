package org.example.springproject.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.springproject.Entities.Sponsor;
import org.example.springproject.Services.ISponsorService;
import java.util.List;

@RestController
@RequestMapping("/api/sponsors")
@AllArgsConstructor
@Tag(
        name = "Sponsor",
        description = "API de gestion des sponsors du championnat"
)
public class SponsorController {

    private ISponsorService sponsorService;

    @Operation(
            summary = "Ajouter un sponsor",
            description = "Crée un nouveau sponsor. " +
                    "La dateCreation, archived et bloquerContrat " +
                    "sont initialisés automatiquement."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Sponsor créé avec succès",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Sponsor.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Données invalides",
                    content = @Content
            )
    })
    @PostMapping("/add")
    public Sponsor ajouterSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.ajouterSponsor(sponsor);
    }

    @Operation(
            summary = "Ajouter plusieurs sponsors",
            description = "Crée une liste de sponsors en une seule requête"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Sponsors créés avec succès"
    )
    @PostMapping("/addAll")
    public List<Sponsor> ajouterSponsors(
            @RequestBody List<Sponsor> sponsors) {
        return sponsorService.ajouterSponsors(sponsors);
    }

    @Operation(
            summary = "Modifier un sponsor",
            description = "Met à jour un sponsor existant. " +
                    "La dateDerniereModification est mise à jour automatiquement."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Sponsor modifié avec succès"),
            @ApiResponse(responseCode = "404",
                    description = "Sponsor non trouvé",
                    content = @Content)
    })
    @PutMapping("/update")
    public Sponsor modifierSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.modifierSponsor(sponsor);
    }

    @Operation(
            summary = "Supprimer un sponsor",
            description = "Supprime un sponsor par son identifiant"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Sponsor supprimé avec succès"),
            @ApiResponse(responseCode = "404",
                    description = "Sponsor non trouvé",
                    content = @Content)
    })
    @DeleteMapping("/delete/{idSponsor}")
    public void supprimerSponsor(
            @Parameter(
                    description = "ID du sponsor à supprimer",
                    required = true,
                    example = "1"
            )
            @PathVariable Long idSponsor) {
        sponsorService.supprimerSponsor(idSponsor);
    }

    @Operation(
            summary = "Lister tous les sponsors",
            description = "Retourne la liste complète de tous les sponsors"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Liste récupérée avec succès"
    )
    @GetMapping("/all")
    public List<Sponsor> listSponsors() {
        return sponsorService.listSponsors();
    }

    @Operation(
            summary = "Récupérer un sponsor par ID",
            description = "Retourne un sponsor spécifique selon son identifiant"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Sponsor trouvé"),
            @ApiResponse(responseCode = "404",
                    description = "Sponsor non trouvé",
                    content = @Content)
    })
    @GetMapping("/get/{idSponsor}")
    public Sponsor recupererSponsor(
            @Parameter(
                    description = "ID du sponsor à récupérer",
                    required = true,
                    example = "1"
            )
            @PathVariable Long idSponsor) {
        return sponsorService.recupererSponsor(idSponsor);
    }

    @Operation(
            summary = "Archiver un sponsor",
            description = "Met le champ 'archived' à true " +
                    "pour le sponsor spécifié"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "true si archivé, false si sponsor introuvable"),
            @ApiResponse(responseCode = "404",
                    description = "Sponsor non trouvé",
                    content = @Content)
    })
    @PutMapping("/archiver/{idSponsor}")
    public Boolean archiverSponsor(
            @Parameter(
                    description = "ID du sponsor à archiver",
                    required = true,
                    example = "1"
            )
            @PathVariable Long idSponsor) {
        return sponsorService.archiverSponsor(idSponsor);
    }
}