package de.autovermietung.fachklassen;

import java.util.ArrayList;
import java.util.List;

public class TerminListe {
    private List<Termin> terminListe;

    public TerminListe() {
        this.terminListe = new ArrayList<>();
    }

    public void addTermin(Termin termin) {
        terminListe.add(termin);
    }

    public List<Termin> getTerminListe() {
        return terminListe;
    }
}