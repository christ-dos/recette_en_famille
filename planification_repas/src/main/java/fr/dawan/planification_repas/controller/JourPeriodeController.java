package fr.dawan.planification_repas.controller;

import fr.dawan.planification_repas.model.JourPeriode;
import fr.dawan.planification_repas.service.JourPeriodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class JourPeriodeController {
    @Autowired
    private JourPeriodeService jourPeriodeService;

    @PostMapping(value="/planification/ajouter")
    public JourPeriode ajouterRepasPlanning(JourPeriode jourPeriode){
        JourPeriode jourPeriodeAjouté = jourPeriodeService.ajouterJourPeriode(jourPeriode);
        log.debug("Controller - Repas ajouté au planning avec ID: " + jourPeriodeAjouté.getJourPeriodeId());
        return jourPeriodeAjouté;
    }

    @GetMapping(value="/planification/rechercherTous")
    public void rechercherToutesLesEntreePLanning(){
        jourPeriodeService.rechercherTousLesJoursPeriodes();
        log.info("Controller - Affichage de tous les elements du planning");
    }

    @DeleteMapping(value="/planification/effacerPlanning")
    public void effacerPlanning(){
        jourPeriodeService.effacerToutesLesRecettesPlanning();
        log.info("Controller - Planning effacé...");
    }

}
