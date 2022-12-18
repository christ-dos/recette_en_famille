package fr.dawan.planification_repas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.planification_repas.model.Jour;
import fr.dawan.planification_repas.repository.JourRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe de service qui gére le modèle {@link Jour}
 * 
 * @author Kelly Ribeiro
 * @author Amandine Pesquet
 * @author Christine Dos Santos
 *
 */
@Service
@Slf4j
public class JourService {
   // private static final Logger log = LoggerFactory.getLogger("log");
    private JourRepository jourRepository;

    @Autowired
    public JourService(JourRepository jourRepository) {
        this.jourRepository = jourRepository;
    }

    public List<Jour> rechercherTousLesJours() {
        log.info("Service - Obtenir la liste des jours");

        return (List<Jour>) jourRepository.findAll();

    }

    public Jour ajouterJour(Jour jour) {
        Jour jourEnregistrer = null;
        Jour jourRecherché = jourRepository.findByJour(jour.getJour());

        if (jour.getId() == 0 || jourRecherché == null) {
            jourEnregistrer = jourRepository.save(jour);
            log.debug("Service - Jour ajouté avec ID: " + jour.getId());
        }
        return jourEnregistrer;
    }

}
