package fr.dawan.planification_repas.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class JourPeriodeId implements Serializable {

    private static final long serialVersionUID = 1L;

    private int jourId;
    private int periodeId;

    public JourPeriodeId() {
    }

    public JourPeriodeId(int jourId, int periodeId) {
        this.jourId = jourId;
        this.periodeId = periodeId;
    }

    public int getJourId() {
        return jourId;
    }

    public void setJourId(int jourId) {
        this.jourId = jourId;
    }

    public int getPeriodeId() {
        return periodeId;
    }

    public void setPeriodeId(int periodeId) {
        this.periodeId = periodeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jourId, periodeId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JourPeriodeId other = (JourPeriodeId) obj;
        return jourId == other.jourId && periodeId == other.periodeId;
    }

}
