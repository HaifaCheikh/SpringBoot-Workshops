package org.example.springproject.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class SponsorAspect {

    @Pointcut("execution(* org.example.springproject.Services.SponsorService.*(..))")
    public void sponsorServicePointcut() {}

    @Before("execution(* org.example.springproject.Services.SponsorService.ajouterSponsor(..))")
    public void beforeAjouterSponsor(JoinPoint joinPoint) {
        log.info("[SPONSOR - BEFORE] Ajout d'un nouveau sponsor...");
        log.info("[SPONSOR - BEFORE] Initialisation automatique :" +
                " dateCreation, archived=false, bloquerContrat=false");
    }

    @AfterReturning(
            pointcut = "execution(* org.example.springproject.Services.SponsorService.archiverSponsor(..))",
            returning = "result"
    )
    public void afterArchiverSponsor(JoinPoint joinPoint, Object result) {
        log.info("[SPONSOR - AFTER RETURNING] archiverSponsor exécuté");
        log.info("[SPONSOR - AFTER RETURNING] Résultat : {}", result);
        if (Boolean.TRUE.equals(result)) {
            log.info("[SPONSOR - AFTER RETURNING] ✔ Sponsor archivé avec succès");
        } else {
            log.warn("[SPONSOR - AFTER RETURNING] ✘ Sponsor introuvable");
        }
    }

    @Before("execution(* org.example.springproject.Services.SponsorService.supprimerSponsor(..))")
    public void beforeSupprimerSponsor(JoinPoint joinPoint) {
        log.warn("[SPONSOR - BEFORE] Suppression du sponsor avec id : {}",
                joinPoint.getArgs()[0]);
    }
}