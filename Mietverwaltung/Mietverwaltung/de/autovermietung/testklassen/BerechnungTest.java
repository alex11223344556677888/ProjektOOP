package Testklassen;

import fachklassen.Auftrag;
import fachklassen.Kunde;
import fachklassen.PKW;
import Verwaltungsklassen.Kostenberechnung;

public class KostenrechnungTest {
    public static void main(String[] args) {
        // Beispielkunde erstellen
        Kunde kunde = new Kunde(
                "Max",
                "Mustermann",
                "01.01.1990",
                32,
                12345,
                12345678,
                "B",
                "max.mustermann@example.com",
                "EC-Karte",
                "Keine besonderen Vorkommnisse",
                "Musterstraße",
                1,
                12345,
                "Musterstadt",
                true,
                3, 3
        );

        // Beispiel-PKW erstellen
        PKW pkw = new PKW(
                1,
                "Kleinwagen",
                "VW",
                "Manuell",
                150,
                "Blau",
                "Klimaanlage, Navigation",
                "Benzin",
                true,
                true,
                2022,
                5,
                5,
                120,
                21,
                "B",
                123456,
                "M-AB 123",
                false,
                true,
                true,
                false, false
        );

        // Beispiel-Auftrag erstellen
        Auftrag auftrag = new Auftrag(
                1,
                "Kombi",
                false,
                true,
                true,
                true,
                12345,
                12,
                true,
                true,
                true,
                2,
                true
        );

        // Kostenberechnung erstellen und Preis ermitteln
        Kostenberechnung kostenberechnung = new Kostenberechnung(kunde, pkw, auftrag);
        double preis = kostenberechnung.getPreis();

        // Preis ausgeben
        System.out.println("Der Preis für das PKW beträgt: " + preis);
    }
}
