package verwaltungsklassen;

import fachklassen.Kunde;
import fachklassen.PKW;

public class Kostenberechnung {
    private Kunde kunde;
    private PKW pkw;
    private double grundpreis;
    private double preis;

    public Kostenberechnung(Kunde kunde, PKW pkw) {
        this.kunde = kunde;
        this.pkw = pkw;
        this.grundpreis = calculateGrundpreis();
        this.preis = calculatePreis();
    }

    private double calculateGrundpreis() {
        if (pkw.getFzgkategorie().equals("suv")) {
            return 70;
        } else if (pkw.getFzgkategorie().equals("cabrio")) {
            return 50;
        } else {
            return 0; // default value
        }
    }

    private double calculatePreis() {
        double fuehrerscheinFaktor = calculateFuehrerscheinFaktor();
        double klimatisiertFaktor = pkw.isKlimatisiert() ? 1.1 : 1.0;
        return grundpreis * fuehrerscheinFaktor * klimatisiertFaktor;
    }

    private double calculateFuehrerscheinFaktor() {
        if (kunde.getFuehrerscheinzeitraum() < 2) {
            return 1.5;
        } else if (kunde.getFuehrerscheinzeitraum() >= 2 && kunde.getFuehrerscheinzeitraum() <= 4) {
            return 1.3;
        } else {
            return 1.2;
        }
    }

    public double getPreis() {
        return preis;
    }
  /**   Kunde kunde = new Kunde(vorname, name, geburtsdatum, alter, kundennummer, telefonnummer, fuehrerscheinklasse, email, zahlungsmittel, historie, strasse, hausnummer, postleitzahl, ort, kundenkarte, kundennummer,fuehrerscheinzeitraum); // create a Kunde object
PKW pkw = new PKW(klimatisiert,fzgkategorie); // create a PKW object

Kostenberechnung kostenberechnung = new Kostenberechnung(kunde, pkw);
double preis = kostenberechnung.getPreis();*/
}
