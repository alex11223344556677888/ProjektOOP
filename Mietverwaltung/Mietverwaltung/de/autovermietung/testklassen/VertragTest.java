package autovermietung.Testklassen;

//import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.LocalTime;

import autovermietung.Fachklassen.Kunde;
import autovermietung.Fachklassen.PKW;
import autovermietung.Fachklassen.Termin;
import autovermietung.Fachklassen.Vertrag;


import autovermietung.Verwaltungsklassen.Kundenverwaltung;
import autovermietung.Verwaltungsklassen.PKWVerwaltung;


public class VertragTest {       
    
    
    public static void main(String[] args) {
        // Objekte erstellen
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        PKWVerwaltung pkwverwaltung = new PKWVerwaltung();

        Kunde kunde1 = new Kunde("Max", "Mustermann", "01.01.1990", 31, 123456, 12345678, "B", "max.mustermann@example.com", "EC-Karte", "Keine besonderen Vorkommnisse", "Musterstraße", 1, 12345, "Musterstadt", true, 10, "max123", "passwortMax");
       // Kunde kunde1 = new Kunde("Max", "Mustermann", "01.01.1990", 31, 123456, 12345678, "B", "max.mustermann@example.com", "EC-Karte", "Keine besonderen Vorkommnisse", "Musterstraße", 1, 12345, "Musterstadt", true, 10, "max123", "passwortMax");
        Kunde kunde2 = new Kunde("John", "Doe", "02.02.1992", 32, 789012, 34567890, "A", "john.doe@example.com", "Kreditkarte", "Keine besonderen Vorkommnisse", "Examplestraße", 2, 67890, "Examplestadt", true, 20, "johndoe", "passwordJohn");
        // Beispiel Kunde und PKW
        kundenverwaltung.neuenKundenErstellen(kunde1);
        kundenverwaltung.neuenKundenErstellen(kunde2);
        Kunde kundeByEmail = kundenverwaltung.getKundeByEmail("max.mustermann@example.com");
        Kunde kundeByKundennummer = kundenverwaltung.getKundeByKundennummer(kunde2.getKundennummer());
       // Kunde kunde1 = kundenverwaltung.getKundeByEmail("max.mustermann@example.com");
        //Kunde kunde2 = kundenverwaltung.getKundeByKundennummer(849877410);
        PKW pkw1 = pkwverwaltung.getPkwById(1003);
        PKW pkw2 = pkwverwaltung.getPkwById(1004);

        // Vertragsdetails definieren
        //LocalDate vertragsbeginn = LocalDate.of(2023, 3, 1);
        //LocalDate vertragsende = LocalDate.of(2023, 3, 10);
        Termin termin1 = new Termin(1, kunde1, pkw1, LocalDateTime.of(2023, 3, 1, 9, 0), LocalDateTime.of(2023, 3, 10, 17, 0));
        Termin termin2 = new Termin(2, kunde2, pkw2, LocalDateTime.of(2023, 3, 15, 12, 0), LocalDateTime.of(2023, 3, 20, 10, 0));

        //kundenverwaltung.displayKunde(kunde2);
        
        // Verträge erstellen
        Vertrag vertrag1 = new Vertrag(kundeByEmail, pkw1, termin1);
        vertrag1.erstelleVertrag(kundeByEmail, pkw1, termin1);
        Vertrag vertrag2 = new Vertrag(kundeByKundennummer, pkw2, termin2);
        vertrag2.erstelleVertrag(kundeByKundennummer, pkw2, termin2);
        

        
        

        // Verträge anzeigen
        vertrag1.vertragAnzeigen(kundeByEmail, pkw1);
        vertrag2.vertragAnzeigen(kundeByKundennummer, pkw2);

    

        // Vertrag löschen
        vertrag1.vertragLoeschen(kunde1, pkw1);

        // Noch vorhandene Verträge anzeigen
        vertrag1.vertragAnzeigen(kunde1, pkw1);
        vertrag2.vertragAnzeigen(kunde2, pkw2);
    }
}
