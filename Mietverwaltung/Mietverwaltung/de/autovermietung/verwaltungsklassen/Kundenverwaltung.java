package verwaltungsklassen;   // das einzige was jetzt noch nicht passt sind die package bezeichnungen
import java.util.ArrayList;
import java.util.Scanner;

import fachklassen.Kunde;


public class Kundenverwaltung {
    private ArrayList<Kunde> kundenListe;
    private int kundennummerCounter;

    public Kundenverwaltung() {
        this.kundenListe = new ArrayList<>();
        this.kundennummerCounter = 100000000; // start with a unique 9-digit customer number
    }

    public void neuenKundenErstellen() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vorname: ");
        String vorname = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Geburtsdatum (DD.MM.YYYY): ");
        String geburtsdatum = scanner.nextLine();

        System.out.print("Alter: ");
        int alter = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        System.out.print("Telefonnummer: ");
        int telefonnummer = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        System.out.print("Führerscheinklasse: ");
        String fuehrerscheinklasse = scanner.nextLine();

        System.out.print("E-Mail: ");
        String email = scanner.nextLine();

        System.out.print("Zahlungsmittel: ");
        String zahlungsmittel = scanner.nextLine();

        System.out.print("Historie: ");
        String historie = scanner.nextLine();

        System.out.print("Strasse: ");
        String strasse = scanner.nextLine();

        System.out.print("Hausnummer: ");
        int hausnummer = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        System.out.print("Postleitzahl: ");
        int postleitzahl = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        System.out.print("Ort: ");
        String ort = scanner.nextLine();

        System.out.print("Kundenkarte (true/false): ");
        boolean kundenkarte = scanner.nextBoolean();
        scanner.nextLine(); // consume newline left-over

        System.out.print("Führerscheinzeitraum (in Jahren): ");
        int fuehrerscheinzeitraum = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        int kundennummer = kundennummerCounter++;
        Kunde kunde = new Kunde(vorname, name, geburtsdatum, alter, kundennummer, telefonnummer, fuehrerscheinklasse, email, zahlungsmittel, historie, strasse, hausnummer, postleitzahl, ort, kundenkarte, kundennummer,fuehrerscheinzeitraum);

        kundenListe.add(kunde);
        System.out.println("Kunde erfolgreich erstellt!");
    }

    public Kunde getKundeByKundennummer(int kundennummer) {
        for (Kunde kunde : kundenListe) {
            if (kunde.getKundennummer() == kundennummer) {
                return kunde;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Kundenverwaltung kv = new Kundenverwaltung();
        kv.neuenKundenErstellen();

        // Example usage:
        // Kunde kunde = kv.getKundeByKundennummer(100000001);
        // System.out.println(kunde.toString());
    }
}
