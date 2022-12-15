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

/**
 * Classe qui décrit un objet de type Periode
 * 
 * @author Kelly Ribeiro
 * @author Amandine Pesquet
 * @author Christine Dos Santos
 *
 */
@Entity
@Table(name = "periodes")
public class Periode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "periode_id")
    private int id;

    @Version
    private int vesion;

    @Column(length = 10, unique = true)
    private String periode;

    @OneToMany(mappedBy = "periode", cascade = CascadeType.ALL)
    private List<JourPeriode> JourPeriodes = new ArrayList<>();

    public Periode() {
        super();
    }

    public Periode(String periode) {
        this.periode = periode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public List<JourPeriode> getJourPeriodes() {
        return JourPeriodes;
    }

    public void setJourPeriodes(List<JourPeriode> jourPeriodes) {
        JourPeriodes = jourPeriodes;
    }

    @Override
    public String toString() {
        return "Periode [id=" + id + ", vesion=" + vesion + ", periode=" + periode + "]";
    }

}
