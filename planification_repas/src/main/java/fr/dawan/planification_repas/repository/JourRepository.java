package fr.dawan.planification_repas.repository;

import org.springframework.data.repository.CrudRepository;

import fr.dawan.planification_repas.model.Jour;

/**
 * Interface qui gère les methodes du crud pour {@link Jour}
 * 
 * @author Kelly Ribeiro
 * @author Amandine Pesquet
 * @author Christine Dos Santos
 */
public interface JourRepository extends CrudRepository<Jour, Integer> {
    Jour findByJour(String jour);

}
