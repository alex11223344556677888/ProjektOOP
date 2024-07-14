package Verwaltungsklassen;

import fachklassen.Kunde;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Random;

public class Kundenverwaltung {
    private HashMap<Integer, Kunde> kundenMap;
    private int kundennummerCounter;

    public Kundenverwaltung() {
        this.kundenMap = new HashMap<>();
        this.kundennummerCounter = 100000000; // start with a unique 9-digit customer number
    }

    public void neuenKundenErstellen(Kunde kunde) {
        int neueKundennummer = generateRandomKundennummer();
        kunde.setKundennummer(neueKundennummer);
        kundenMap.put(neueKundennummer, kunde);
    }

    private int generateRandomKundennummer() {
        Random random = new Random();
        return kundennummerCounter + random.nextInt(900000000); // add a random number between 0 and 900,000,000
    }

    public Kunde getKundeByKundennummer(int kundennummer) {
        return kundenMap.get(kundennummer);
    }

    public void kundenLoeschen(int kundennummer) {
        if (!kundenMap.containsKey(kundennummer)) {
            throw new NoSuchElementException("Kunde nicht gefunden!");
        }
        kundenMap.remove(kundennummer);
    }

    public ArrayList<Kunde> getKundenListe() {
        return new ArrayList<>(kundenMap.values());
    }

    public void printKundenListe() {
        for (Kunde kunde : kundenMap.values()) {
            System.out.println("Nachname: " + kunde.getName() + ", Vorname: " + kunde.getVorname() + ", Kundennummer: " + kunde.getKundennummer());
        }
    }

    public void printKundenListeAlphabetisch() {
        ArrayList<Kunde> sortedList = new ArrayList<>(kundenMap.values());
        Collections.sort(sortedList, Comparator.comparing(Kunde::getName));
        for (Kunde kunde : sortedList) {
            System.out.println("Nachname: " + kunde.getName() + ", Vorname: " + kunde.getVorname() + ", Kundennummer: " + kunde.getKundennummer());
        }
    }

    public void displayKunde(Kunde kunde) {
        System.out.println("Nachname: " + kunde.getName() + ", Vorname: " + kunde.getVorname() + ", Kundennummer: " + kunde.getKundennummer() + "\n" +
                "Geburtsdatum: " + kunde.getGeburtsdatum() + ", Alter: " + kunde.getAlter() + "\n" +
                "Telefonnummer: " + kunde.getTelefonnummer() + ", Führerscheinklasse: " + kunde.getFuehrerscheinklasse() + "\n" +
                "E-Mail: " + kunde.getEmail() + ", Zahlungsmittel: " + kunde.getZahlungsmittel() + "\n" +
                "Historie: " + kunde.getHistorie() + ", Strasse: " + kunde.getStrasse() + "\n" +
                "Hausnummer: " + kunde.getHausnummer() + ", Postleitzahl: " + kunde.getPostleitzahl() + ", Ort: " + kunde.getOrt() + "\n" +
                "Kundenkarte: " + kunde.isKundenkarte() + ", Führerscheinzeitraum: " + kunde.getFuehrerscheinzeitraum());
    }

    public Kunde sucheNachName(String name) {
        for (Kunde kunde : kundenMap.values()) {
            if (kunde.getName().equalsIgnoreCase(name) || kunde.getVorname().equalsIgnoreCase(name) || kunde.getLoginName().equalsIgnoreCase(name)) {
                return kunde;
            }
        }
        return null;
    }

    public String getKundenName(int kundennummer) {
        Kunde kunde = getKundeByKundennummer(kundennummer);
        if (kunde!= null) {
            return kunde.getName();
        } else {
            return null;
        }
    }

    private Kunde kunde;
    public void setKundenName(String name) {
        if (kunde != null) { // Überprüfen, ob kunde nicht null ist
            kunde.setName(name); // Methode setName auf kunde aufrufen
        } else {
            System.err.println("Error: Kunde is null, cannot set name."); // Fehlermeldung ausgeben, falls kunde null ist
            // Alternativ: throw new IllegalStateException("Kunde is null, cannot set name.");
        }
    }

  
   
   
}
