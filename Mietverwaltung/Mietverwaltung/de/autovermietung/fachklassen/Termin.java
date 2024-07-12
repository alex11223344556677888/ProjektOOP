package de.autovermietung.fachklassen;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Termin implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Kunde kunde;
    private PKW pkw;
    private LocalDateTime startzeitpunkt;
    private LocalDateTime endzeitpunkt;
    private boolean gebucht;

    public Termin(int id, Kunde kunde, PKW pkw, LocalDateTime startzeitpunkt, LocalDateTime endzeitpunkt) {
        this.id = id;
        this.kunde = kunde;
        this.pkw = pkw;
        this.startzeitpunkt = startzeitpunkt;
        this.endzeitpunkt = endzeitpunkt;
        this.gebucht = true;
    }

    public int getId() {
        return id;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public PKW getPkw() {
        return pkw;
    }

    public LocalDateTime getStartzeitpunkt() {
        return startzeitpunkt;
    }

    public LocalDateTime getEndzeitpunkt() {
        return endzeitpunkt;
    }

    public boolean isGebucht() {
        return gebucht;
    }

    public void setGebucht(boolean gebucht) {
        this.gebucht = gebucht;
    }
}