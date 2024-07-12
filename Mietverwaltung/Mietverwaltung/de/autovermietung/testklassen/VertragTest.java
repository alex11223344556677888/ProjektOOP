package autovermietung.Testklassen;

import java.time.LocalDate;

import autovermietung.Fachklassen.Kunde;
import autovermietung.Fachklassen.PKW;
import autovermietung.Fachklassen.Vertrag;

import autovermietung.Verwaltungsklassen.PKWVerwaltung;
import autovermietung.Verwaltungsklassen.Kundenverwaltung;
import java.time.LocalDate;

public class VertragTest {
    public static void main(String[] args) {
        // Create instances of PkwVerwaltung and KundenVerwaltung
        PKWVerwaltung pkwverwaltung = new PKWVerwaltung();
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();

        // Get sample customer and car data
        Kunde kunde = kundenverwaltung.getKundeByKundennummer(123456789);
        //PKW pkw = pkwverwaltung.getPKWByID(1000);

        // Define contract details
        LocalDate vertragsbeginn = LocalDate.of(2023, 3, 1);
        LocalDate vertragsende = LocalDate.of(2023, 3, 10);
        double mietpreis = 50.0;
        double kilometerpreis = 0.25;
        int gebuchteTage = 10;
        int gebuchteKilometer = 500;

        // Create a sample contract
        Vertrag vertrag = new Vertrag(kunde, pkw, vertragsbeginn, vertragsende, mietpreis, kilometerpreis, gebuchteTage, gebuchteKilometer);

        // Print the contract details
        System.out.println("Vertrag Details:");
        System.out.println(vertrag);

        // Add the contract to the contract list
        Vertrag.erstelleVertrag(kunde, pkw, vertragsbeginn, vertragsende, mietpreis, kilometerpreis, gebuchteTage, gebuchteKilometer);

        // Print all contracts in the contract list
        System.out.println("\nAlle Verträge:");
        Vertrag.vertragAnzeigen();
    }
}