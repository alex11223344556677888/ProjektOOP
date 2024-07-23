package fachklassen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Kunde extends Person {
    private int kundennummer;
    private int telefonnummer;
    private String fuehrerscheinklasse;
    private String email;
    private String zahlungsmittel;
    private String historie;
    private String strasse;
    private int hausnummer;
    private int postleitzahl;
    private String ort;
    private boolean kundenkarte;
    private int fuehrerscheinzeitraum;
    private String anmeldename;
    private String passwort;

    public Kunde(String vorname, String name, String geburtsdatum, int alter, int kundennummer, int telefonnummer, String fuehrerscheinklasse, String email, String zahlungsmittel, String historie, String strasse, int hausnummer, int postleitzahl, String ort, boolean kundenkarte, int fuehrerscheinzeitraum, String anmeldename, String passwort) {
        super(vorname, name, geburtsdatum, alter);
        this.kundennummer = kundennummer;
        this.telefonnummer = telefonnummer;
        this.fuehrerscheinklasse = fuehrerscheinklasse;
        this.email = email;
        this.zahlungsmittel = zahlungsmittel;
        this.historie = historie;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.postleitzahl = postleitzahl;
        this.ort = ort;
        this.kundenkarte = kundenkarte;
        this.fuehrerscheinzeitraum = fuehrerscheinzeitraum;
        this.anmeldename = anmeldename;
        this.passwort = passwort;

        // Save customer data to file
        saveDataToFile();
    }

    public void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("kunden.dat", true))) {
            writer.println(toString());
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }

    public static Kunde login(String anmeldename, String passwort) {
        try (BufferedReader reader = new BufferedReader(new FileReader("kunden.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Kunde kunde = fromString(line); // Create a Kunde object from the string
                if (kunde.getAnmeldename().equals(anmeldename) && kunde.getPasswort().equals(passwort)) {
                    return kunde;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data from file: " + e.getMessage());
        }
        return null; // Login failed
    }

    public static Kunde fromString(String str) {
        String[] data = str.split(", ");
        return new Kunde(
                extractField(data[0], "Vorname: "), // Vorname
                extractField(data[1], "Name: "), // Name
                extractField(data[2], "Geburtsdatum: "), // Geburtsdatum
                Integer.parseInt(extractField(data[3], "Alter: ")), // Alter
                Integer.parseInt(extractField(data[4], "Kundennummer: ")), // Kundennummer
                Integer.parseInt(extractField(data[5], "Telefonnummer: ")), // Telefonnummer
                extractField(data[6], "Fuehrerscheinklasse: "), // Fuehrerscheinklasse
                extractField(data[7], "Email: "), // Email
                extractField(data[8], "Zahlungsmittel: "), // Zahlungsmittel
                extractField(data[9], "Historie: "), // Historie
                extractField(data[10], "Strasse: "), // Strasse
                Integer.parseInt(extractField(data[11], "Hausnummer: ")), // Hausnummer
                Integer.parseInt(extractField(data[12], "Postleitzahl: ")), // Postleitzahl
                extractField(data[13], "Ort: "), // Ort
                Boolean.parseBoolean(extractField(data[14], "Kundenkarte: ")), // Kundenkarte
                Integer.parseInt(extractField(data[15], "Fuehrerscheinzeitraum: ")), // Fuehrerscheinzeitraum
                extractField(data[16], "Anmeldename: "), // Anmeldename
                extractField(data[17], "Passwort: ") // Passwort
        );
    }

    private static String extractField(String field, String prefix) {
        return field.substring(prefix.length()).trim();
    }

    @Override
    public String toString() {
        return "Vorname: " + getVorname() + ", " +
                "Name: " + getName() + ", " +
                "Geburtsdatum: " + getGeburtsdatum() + ", " +
                "Alter: " + getAlter() + ", " +
                "Kundennummer: " + kundennummer + ", " +
                "Telefonnummer: " + telefonnummer + ", " +
                "Fuehrerscheinklasse: " + fuehrerscheinklasse + ", " +
                "Email: " + email + ", " +
                "Zahlungsmittel: " + zahlungsmittel + ", " +
                "Historie: " + historie + ", " +
                "Strasse: " + strasse + ", " +
                "Hausnummer: " + hausnummer + ", " +
                "Postleitzahl: " + postleitzahl + ", " +
                "Ort: " + ort + ", " +
                "Kundenkarte: " + kundenkarte + ", " +
                "Fuehrerscheinzeitraum: " + fuehrerscheinzeitraum + ", " +
                "Anmeldename: " + anmeldename + ", " +
                "Passwort: " + passwort;
    }

    // Getters and setters

    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }

    public int getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getFuehrerscheinklasse() {
        return fuehrerscheinklasse;
    }

    public void setFuehrerscheinklasse(String fuehrerscheinklasse) {
        this.fuehrerscheinklasse = fuehrerscheinklasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZahlungsmittel() {
        return zahlungsmittel;
    }

    public void setZahlungsmittel(String zahlungsmittel) {
        this.zahlungsmittel = zahlungsmittel;
    }

    public String getHistorie() {
        return historie;
    }

    public void setHistorie(String historie) {
        this.historie = historie;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public boolean isKundenkarte() {
        return kundenkarte;
    }

    public void setKundenkarte(boolean kundenkarte) {
        this.kundenkarte = kundenkarte;
    }

    public int getFuehrerscheinzeitraum() {
        return fuehrerscheinzeitraum;
    }

    public void setFuehrerscheinzeitraum(int fuehrerscheinzeitraum) {
        this.fuehrerscheinzeitraum = fuehrerscheinzeitraum;
    }

    public String getAnmeldename() {
        return anmeldename;
    }

    public void setAnmeldename(String anmeldename) {
        this.anmeldename = anmeldename;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getKundenName() {
        return getVorname() + " " + getName();
    }
}
