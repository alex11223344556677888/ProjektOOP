package verwaltungsklassen;

import fachklassen.Kunde;
import fachklassen.PKW;
import fachklassen.Auftrag;

public class Kostenberechnung {
    private Kunde kunde;
    private PKW pkw;
    private Auftrag auftrag;
    private double grundpreis;
    private double preis;

    public Kostenberechnung(Kunde kunde, PKW pkw, Auftrag auftrag) {
        this.kunde = kunde;
        this.pkw = pkw;
        this.auftrag = auftrag;
        this.grundpreis = calculateGrundpreis();
        this.preis = calculatePreis();
    }

    private double calculateGrundpreis() {
        if (pkw.getFzgkategorie().equals("SUV")) {
            return 90;
        } else if (pkw.getFzgkategorie().equals("Kombi")) {
            return 70;
        } else if (pkw.getFzgkategorie().equals("Kleinwagen")) {
            return 50;
        } else {
            return 0; // default value
        }
    }

    private double calculatePreis() {
        double grundpreis = calculateGrundpreis();

        if (pkw.isKlimatisiert()) {
            grundpreis *= 1.1;
        }

        if (kunde.getFuehrerscheinzeitraum() <= 2) {
            grundpreis *= 1.5;
        } else if (kunde.getFuehrerscheinzeitraum() >= 2 && kunde.getFuehrerscheinzeitraum() <= 4) {
            grundpreis *= 1.3;
        } else {
            grundpreis *= 1.2;
        }

        if (pkw.isElektrofahrzeug()) {
            grundpreis *= 0.8;
        }

        if (pkw.isParkassistent()) {
            grundpreis *= 1.15;
        }

        if (pkw.isFahrassistent()) {
            grundpreis *= 1.15;
        }

        if (auftrag.isKindersitz()) {
            grundpreis += 7;
        }

        if (auftrag.isDachbox()) {
            grundpreis += 7;
        }

        if (auftrag.isAuslandsfahrt()) {
            grundpreis += 7;
        }

        switch (auftrag.getVersicherungsklasse()) {
            case 1:
                grundpreis *= 1.3;
                break;
            case 2:
                grundpreis *= 1.6;
                break;
            case 3:
                grundpreis *= 1.9;
                break;
        }

        if (auftrag.isKilometerpaket()) {
            grundpreis += 30;
        }

        return grundpreis;
    }

    public double getPreis() {
        return preis;
    }
}
