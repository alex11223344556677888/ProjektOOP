package autovermietung.Testklassen;

import java.time.LocalDate;

import autovermietung.Fachklassen.Kunde;
import autovermietung.Fachklassen.PKW;
import autovermietung.Fachklassen.Vertrag;


import autovermietung.Verwaltungsklassen.Kundenverwaltung;
import autovermietung.Verwaltungsklassen.PKWVerwaltung;


public class VertragTest {
    
    
    public static void main(String[] args) {
        // Objekte erstellen
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        PKWVerwaltung pkwverwaltung = new PKWVerwaltung();
        
        // Beispiel Kunde und PKW
        Kunde kunde1 = kundenverwaltung.getKundeByKundennummer(123456);
        Kunde kunde2 = kundenverwaltung.getKundeByKundennummer(123456789);
        PKW pkw1 = pkwverwaltung.getPkwById(1002);
        PKW pkw2 = pkwverwaltung.getPkwById(1003);

        // Vertragsdetails definieren
        LocalDate vertragsbeginn = LocalDate.of(2023, 3, 1);
        LocalDate vertragsende = LocalDate.of(2023, 3, 10);

        // Vertrag erstellen
        Vertrag vertrag1 = new Vertrag(kunde1, pkw1, vertragsbeginn, vertragsende);
        vertrag1.erstelleVertrag(kunde1, pkw1, vertragsbeginn, vertragsende);
        Vertrag vertrag2 = new Vertrag(kunde2, pkw2, vertragsbeginn, vertragsende);
        vertrag2.erstelleVertrag(kunde2, pkw2, vertragsbeginn, vertragsende);
        

        
        

        // Vertrag anzeigen
        vertrag1.vertragAnzeigen(kunde1, pkw1);
        vertrag2.vertragAnzeigen(kunde2, pkw2);

    

        // Vertrag löschen
        vertrag1.vertragLoeschen(kunde1, pkw1);

        // Vertrag anzeigen
        vertrag1.vertragAnzeigen(kunde1, pkw1);
        vertrag2.vertragAnzeigen(kunde2, pkw2);
    }
}
