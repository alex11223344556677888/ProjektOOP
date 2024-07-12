package de.autovermietung.testklassen;

import de.autovermietung.verwaltungsklassen.TerminVerwaltung;

public class TerminVerwaltungTest {
    private TerminVerwaltung terminVerwaltung;

    public void setup() {
        terminVerwaltung = new TerminVerwaltung();
    }

    public static void main(String[] args) {
        TerminVerwaltungTest test = new TerminVerwaltungTest();
        test.setup();

        // Aufrufe der jeweiligen Funktionen mit Datum als Parameter
        test.terminVerwaltung.testBuchePKW(1020, 1, 7, 2024, 28, 7, 2024);
        test.terminVerwaltung.testEntbuchePKW(1020, 16, 7, 2024, 18, 7, 2024);
        test.terminVerwaltung.testPruefeTermine();
        test.terminVerwaltung.testSpeichereTerminListeAlsDatei();
        test.terminVerwaltung.testPruefeBuchungsZeitraum(1020, 15, 7, 2024, 17, 7, 2024); 
        test.terminVerwaltung.testPruefeBuchungsZeitraum(1020, 28, 7, 2024, 31, 7, 2024);// Überprüfen, ob am 15.7. gebucht ist
    }
}
