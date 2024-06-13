package de.autovermietung.verwaltungsklassen;

import de.autovermietung.fachklassen.Auftrag;
import de.autovermietung.fachklassen.Kunde;
import de.autovermietung.fachklassen.PKW;

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
        } else if (pkw.getFzgkategorie().equals("Limousine")) {
            return 90;
        } else if (pkw.getFzgkategorie().equals("Coupe")) {
            return 100;
        } else if (pkw.getFzgkategorie().equals("Cabrio")) {
            return 110;
        } else {
            return 0; // default value
        }
    }

    private double calculatePreis() {
        double ergebnis =0;
        double grundpreis = calculateGrundpreis();
        

        if (pkw.isKlimatisiert()) {
            ergebnis = (grundpreis * 1.1 - grundpreis);
            System.out.println(ergebnis);
        }

        if (kunde.getFuehrerscheinzeitraum() <= 2) {
            ergebnis += (grundpreis * 1.5 - grundpreis);
            System.out.println(ergebnis);
        } else if (kunde.getFuehrerscheinzeitraum() >= 2 && kunde.getFuehrerscheinzeitraum() <= 4) {
            ergebnis += (grundpreis * 1.3 - grundpreis);
            System.out.println(ergebnis);
        } else {
            ergebnis += (grundpreis * 1.2 - grundpreis);
            System.out.println(ergebnis);
        }

        if (pkw.isElektrofahrzeug()) {
            ergebnis += (grundpreis * 0.8 - grundpreis);
            System.out.println(ergebnis);
        }

        if (pkw.isParkassistent()) {
            ergebnis += (grundpreis * 1.15 - grundpreis);
            System.out.println(ergebnis);
        }

        if (pkw.isFahrassistent()) {
            ergebnis += (grundpreis * 1.15 - grundpreis);
            System.out.println(ergebnis);
        }

        if (auftrag.isKindersitz()) {
            ergebnis +=7;
            System.out.println(ergebnis);
        }

        if (auftrag.isDachbox()) {
            ergebnis +=7;
            System.out.println(ergebnis);
        }

        if (auftrag.isAuslandsfahrt()) {
            ergebnis +=7;
            System.out.println(ergebnis);
        }

        switch (auftrag.getVersicherungsklasse()) {
            case 1:
            ergebnis += (grundpreis * 1.3 - grundpreis);
            System.out.println(ergebnis);
                break;
            case 2:
            ergebnis += (grundpreis * 1.6 - grundpreis);
            System.out.println(ergebnis);
                break;
            case 3:
            ergebnis += (grundpreis * 1.9 - grundpreis);
            System.out.println(ergebnis);
                break;
        }

        if (auftrag.isKilometerpaket()) {
            ergebnis += 30;
            System.out.println(ergebnis);
        }

        return ergebnis + grundpreis;
    }

    public double getPreis() {
        return preis;
    }
}


