package Verwaltungsklassen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Fachklassen.Kunde;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Kundenverwaltung {
    private HashMap<Integer, Kunde> kundenMap;
    private int kundennummerCounter;

    public Kundenverwaltung() {
        this.kundenMap = new HashMap<>();
        this.kundennummerCounter = 100000000; // start with a unique 9-digit customer number
    }

    public void neuenKundenErstellen(Kunde kunde) {
        kundenMap.put(kunde.getKundennummer(), kunde);
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

    public static void addKunde(Kunde kunde) {
        // Add the customer to the database or file
        kunde.saveDataToFile();
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

    public void searchKunde() {
        String searchQuery = JOptionPane.showInputDialog(null, "Suchen nach Name, Kundennummer oder Anmeldename:");
        if (searchQuery != null) {
            if (searchQuery.matches("\\d+")) { // search by customer number
                int kundennummer = Integer.parseInt(searchQuery);
                Kunde kunde = this.getKundeByKundennummer(kundennummer);
                if (kunde != null) {
                    this.displayKunde(kunde);
                } else {
                    JOptionPane.showMessageDialog(null, "Kunde nicht gefunden!");
                }
            } else { // search by name or login name
                Kunde kunde = this.sucheNachName(searchQuery); // search by name
                if (kunde != null) {
                    this.displayKunde(kunde);
                } else {
                    JOptionPane.showMessageDialog(null, "Kunde nicht gefunden!");
                }
            }
        }
    }
}
