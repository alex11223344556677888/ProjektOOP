package de.autovermietung.fachklassen;

public class Auftrag {
    private boolean kindersitz;
    private boolean dachbox;
    private boolean auslandsfahrt;
    private int versicherungsklasse;
    private boolean kilometerpaket;

    public Auftrag(int id, String fzgkategorie, boolean elektrofrahrzeug, boolean parkassistent, boolean fahrassistent, boolean klimatisiert, int kundennummer, int fuehrerscheinalter, boolean kindersitz, boolean dachbox, boolean auslandsfahrt, int versicherungsklasse, boolean kilometerpaket) {
        this.kindersitz = kindersitz;
        this.dachbox = dachbox;
        this.auslandsfahrt = auslandsfahrt;
        this.versicherungsklasse = versicherungsklasse;
        this.kilometerpaket = kilometerpaket;
    }



    public boolean isKindersitz() {
        return kindersitz;
    }

    public void setKindersitz(boolean kindersitz) {
        this.kindersitz = kindersitz;
    }

    public boolean isDachbox() {
        return dachbox;
    }

    public void setDachbox(boolean dachbox) {
        this.dachbox = dachbox;
    }

    public boolean isAuslandsfahrt() {
        return auslandsfahrt;
    }

    public void setAuslandsfahrt(boolean auslandsfahrt) {
        this.auslandsfahrt = auslandsfahrt;
    }

    public int getVersicherungsklasse() {
        return versicherungsklasse;
    }

    public void setVersicherungsklasse(int versicherungsklasse) {
        this.versicherungsklasse = versicherungsklasse;
    }

    public boolean isKilometerpaket() {
        return kilometerpaket;
    }

    public void setKilometerpaket(boolean kilometerpaket) {
        this.kilometerpaket = kilometerpaket;
    }
}
