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
        log.info("Service: Obtenir la liste des jours/periodes");
        return (List<JourPeriode>) jourPeriodeRepository.findAll();

    }

    public JourPeriode ajouterJourPeriode(JourPeriode jourPeriode) {
        JourPeriode jourPeriodeEnregistrer = jourPeriodeRepository.save(jourPeriode);
        log.debug("Service: JourPeriode ajouté avec ID: " + jourPeriodeEnregistrer.getJourPeriodeId());
        return jourPeriodeEnregistrer;
    }

    public void effacerToutesLesRecettesPlanning() {

        log.info("Service: Planning effacé...");
    }

}
