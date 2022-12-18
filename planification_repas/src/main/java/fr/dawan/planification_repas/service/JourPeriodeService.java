package fr.dawan.planification_repas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.planification_repas.model.JourPeriode;
import fr.dawan.planification_repas.repository.JourPeriodeRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe de service qui gére le modèle {@link JourPeriode}
 * 
 * @author Kelly Ribeiro
 * @author Amandine Pesquet
 * @author Christine Dos Santos
 *
 */
@Service
@Slf4j
public class JourPeriodeService {
    //private static final Logger log = LoggerFactory.getLogger("log");
    private JourPeriodeRepository jourPeriodeRepository;

    @Autowired
    public JourPeriodeService(JourPeriodeRepository jourPeriodeRepository) {
        this.jourPeriodeRepository = jourPeriodeRepository;
    }

    public List<JourPeriode> rechercherTousLesJoursPeriodes() {
        log.info("Service - Obtenir la liste des jours/periodes");
        return (List<JourPeriode>) jourPeriodeRepository.findAll();

    }
    // Todo faire une methode getJourPeriodeByJourId&PeriodeId()

    public JourPeriode ajouterJourPeriode(JourPeriode jourPeriode) {
        //Todo: rechercher si le jourPeriode existe grace a la methode getJourPeriode
        // et di oui verifier si titre et image sont vide si oui ajouter sino msg erreur
        // jour Periode existe deja

        JourPeriode jourPeriodeEnregistre = jourPeriodeRepository.save(jourPeriode);
        log.debug("Service - JourPeriode ajouté avec ID: " + jourPeriodeEnregistre.getJourPeriodeId());
        return jourPeriodeEnregistre;
    }

    public void effacerToutesLesRecettesPlanning() {
    List<JourPeriode> JourPeriodes = (List<JourPeriode>) jourPeriodeRepository.findAll();

    for (JourPeriode jourPeriode:JourPeriodes) {
        jourPeriode.setTitreRecette(null);
        jourPeriode.setPhoto(null);
        jourPeriodeRepository.save(jourPeriode);
    }
    log.info("Service: Planning effacé...");
    }

}
