package fr.dawan.formation.livre_recette.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface qui gère les methodes du crud pour {@link Categorie}
 *
 * @author Kelly Ribeiro
 * @author Amandine Pesquet
 * @author Christine Dos Santos
 */
public class CategorieRepository extends CrudRepository<Categorie,Integer> {
}
