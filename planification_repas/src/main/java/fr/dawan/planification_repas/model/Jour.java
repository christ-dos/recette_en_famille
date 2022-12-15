package fr.dawan.planification_repas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.NoArgsConstructor;

/**
 * Classe qui décrit un objet de type Jour
 * 
 * @author Kelly Ribeiro
 * @author Amandine Pesquet
 * @author Christine Dos Santos
 *
 */


@NoArgsConstructor
@Entity
@Table(name = "jours")
public class Jour implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jour_id")
    private int id;

    @Version
    private int vesion;

    @Column(length = 10, unique = true)
    private String jour;

    @OneToMany(mappedBy = "jour", cascade = CascadeType.ALL)
    private List<JourPeriode> JourPeriodes;


    public Jour(String jour) {
        this.jour = jour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVesion() {
        return vesion;
    }

    public List<JourPeriode> getJourPeriodes() {
        return JourPeriodes;
    }

    public void setJourPeriodes(List<JourPeriode> jourPeriodes) {
        JourPeriodes = jourPeriodes;
    }

    public void setVesion(int vesion) {
        this.vesion = vesion;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public void ajouterJourPeriode(JourPeriode JourPeriode) {

        if (this.JourPeriodes == null) {
            this.JourPeriodes = new ArrayList<>();
        }
        this.JourPeriodes.add(JourPeriode);

    }

    @Override
    public String toString() {
        return "Jour [id=" + id + ", vesion=" + vesion + ", jour=" + jour + "]";
    }

}
