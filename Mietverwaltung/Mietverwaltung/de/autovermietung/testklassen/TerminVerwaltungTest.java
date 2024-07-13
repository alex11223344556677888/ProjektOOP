package de.autovermietung.testklassen;

import de.autovermietung.verwaltungsklassen.PKWVerwaltung;
import de.autovermietung.verwaltungsklassen.TerminVerwaltung;

public class TerminVerwaltungTest {
    private TerminVerwaltung terminVerwaltung;
    private PKWVerwaltung pkwVerwaltung; // PKWVerwaltung Instanz

    public void setup() {
        terminVerwaltung = new TerminVerwaltung();
        pkwVerwaltung = new PKWVerwaltung(); // Initialisiere PKWVerwaltung
    }

    public static void main(String[] args) {
        TerminVerwaltungTest test = new TerminVerwaltungTest();
        test.setup();

        // Aufrufe der jeweiligen Funktionen mit Datum als Parameter
        // test.terminVerwaltung.buchePKW(1020, 7, 7, 2024, 12, 7, 2024);
        // test.terminVerwaltung.buchePKW(1021, 9, 7, 2024, 15, 7, 2024);
        // test.terminVerwaltung.buchePKW(1019, 10, 7, 2024, 20, 7, 2024);
        // test.terminVerwaltung.pruefeTermine();
        // test.terminVerwaltung.speichereTerminListeAlsDatei();
        // test.terminVerwaltung.pruefeBuchungsZeitraum(1020, 7, 7, 2024, 9, 7, 2024);
        // test.terminVerwaltung.pruefeBuchungsZeitraumPKWListe(6, 7, 2024, 12, 7, 2024);
        // test.terminVerwaltung.buchePKW(1021, 1, 7, 2024, 10, 7, 2024);
        // test.terminVerwaltung.buchePKW(1020, 1, 7, 2024, 10, 7, 2024);
        // test.terminVerwaltung.buchePKW(1019, 1, 7, 2024, 10, 7, 2024);
        // test.terminVerwaltung.buchePKW(1021, 11, 7, 2024, 15, 7, 2024);
        // test.terminVerwaltung.buchePKW(1021, 13, 7, 2024, 18, 7, 2024);

        // test.terminVerwaltung.entbuchePKW(1019,1,7,2024,10,7,2024);
        // test.terminVerwaltung.entbuchePKW(1020, 1, 7, 2024, 5, 7, 2024);

        //test.terminVerwaltung.terminListeAusgeben();
        test.pkwVerwaltung.PKWentbucheAlle();
        test.pkwVerwaltung.checkPKWStatus(1001); // Überprüfe PKW Status
        test.pkwVerwaltung.checkPKWStatus(1002); // Überprüfe PKW Status
        test.pkwVerwaltung.checkPKWStatus(1003); // Überprüfe PKW Status
        test.pkwVerwaltung.checkPKWStatus(1004); // Überprüfe PKW Status
        test.pkwVerwaltung.checkPKWStatus(1005); // Überprüfe PKW Status
        test.pkwVerwaltung.checkPKWStatus(1006); // Überprüfe PKW Status
        

        // test.terminVerwaltung.loescheTermin(5000);
        // test.terminVerwaltung.loescheTermin(5005);
        // test.terminVerwaltung.loescheTermin(5004);
        // test.terminVerwaltung.loescheTermin(5003); 
        //test.terminVerwaltung.loescheAlleTermine(null);
    }
}
