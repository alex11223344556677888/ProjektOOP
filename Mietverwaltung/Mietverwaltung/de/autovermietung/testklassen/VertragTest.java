package Testklassen;

import java.time.LocalDate;

import fachklassen.Kunde;
import fachklassen.PKW;
import fachklassen.Vertrag;


import Verwaltungsklassen.Kundenverwaltung;
import Verwaltungsklassen.PKWVerwaltung;



public class VertragTest {
    public static void main(String[] args) {
        // Objekte
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        PKWVerwaltung pkwverwaltung = new PKWVerwaltung();
        
        // Beispiel Kunde und PKW
        Kunde kunde = kundenverwaltung.getKundeByKundennummer(123456789);
        PKW pkw = pkwverwaltung.getPkwById(1000);

        // Vertragsdetails definieren
        LocalDate vertragsbeginn = LocalDate.of(2023, 3, 1);
        LocalDate vertragsende = LocalDate.of(2023, 3, 10);

        // Vertrag erstellen
        Vertrag.erstelleVertrag(kunde, pkw, vertragsbeginn, vertragsende);

        // Vertrag anzeigen
        Vertrag.vertragAnzeigen(kunde, pkw);

        // Vertrag bearbeiten
        vertragsbeginn = LocalDate.of(2023, 3, 5);
        vertragsende = LocalDate.of(2023, 3, 15);
        Vertrag.vertragBearbeiten(kunde, pkw, vertragsbeginn, vertragsende);

        // Vertrag anzeigen nach Bearbeiten
        Vertrag.vertragAnzeigen(kunde, pkw);

        // Vertrag löschen
        Vertrag.vertragLoeschen(kunde, pkw);
    }
}
