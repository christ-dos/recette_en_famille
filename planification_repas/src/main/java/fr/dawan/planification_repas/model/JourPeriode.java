package fr.dawan.planification_repas.model;

import java.io.Serializable;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Classe qui décrit l'objet d'association entre la classe {@link Jour} et la
 * classe {@link Periode}
 * 
 * @author Kelly Ribeiro
 * @author Amandine Pesquet
 * @author Christine Dos Santos
 *
 */
@Entity
@Table(name = "jour_periodes")
public class JourPeriode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jour_periode_id")
    private int jourPeriodeId;

    @ManyToOne
    @JoinColumn(name = "jour_id")
    private Jour jour;

    @ManyToOne
    @JoinColumn(name = "periode_id")
    private Periode periode;

    @Column(name = "titre_recette", length = 150, nullable = true)
    private String titreRecette;

    @Lob
    private Byte[] photo;

    public JourPeriode() {
    }

    public JourPeriode(String titreRecette, Byte[] photo) {
        this.titreRecette = titreRecette;
        this.photo = photo;
    }

    public JourPeriode(Jour jour, Periode periode, String titreRecette, Byte[] photo) {
        this.jour = jour;
        this.periode = periode;
        this.titreRecette = titreRecette;
        this.photo = photo;
    }

    public int getJourPeriodeId() {
        return jourPeriodeId;
    }

    public void setJourPeriodeId(int jourPeriodeId) {
        this.jourPeriodeId = jourPeriodeId;
    }

    public Jour getJour() {
        return jour;
    }

    public void setJour(Jour jour) {
        this.jour = jour;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public String getTitreRecette() {
        return titreRecette;
    }

    public void setTitreRecette(String titreRecette) {
        this.titreRecette = titreRecette;
    }

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "JourPeriode [jourPeriodeId=" + jourPeriodeId + ", jour=" + jour + ", periode=" + periode
                + ", titreRecette=" + titreRecette + ", photo=" + Arrays.toString(photo) + "]";
    }

}
