package fr.dawan.planification_repas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.planification_repas.model.Periode;
import fr.dawan.planification_repas.repository.PeriodeRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe de service qui gére le modèle {@link Periode}
 * 
 * @author Kelly Ribeiro
 * @author Amandine Pesquet
 * @author Christine Dos Santos
 *
 */
@Service
@Slf4j
public class PeriodeService {
    //private static final Logger log = LoggerFactory.getLogger("log");
    private PeriodeRepository periodeRepository;

    @Autowired
    public PeriodeService(PeriodeRepository periodeRepository) {
        this.periodeRepository = periodeRepository;
    }

    public List<Periode> rechercherToutesLesPeriodes() {
        log.info("Service: Obtenir la liste des periodes");
        return (List<Periode>) periodeRepository.findAll();

    }

    public Periode ajouterJourPeriode(Periode periode) {
        Periode periodeEnregistrer = null;
        Periode periodeRecherché = periodeRepository.findByPeriode(periode.getPeriode());

        if (periode.getId() == 0 || periodeRecherché == null) {
            periodeEnregistrer = periodeRepository.save(periode);
            log.debug("Service: Periode ajouté avec ID: " + periodeEnregistrer.getId());
        }
        return periodeEnregistrer;
    }

}
