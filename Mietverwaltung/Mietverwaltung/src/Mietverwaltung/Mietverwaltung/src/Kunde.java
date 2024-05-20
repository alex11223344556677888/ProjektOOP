import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

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

    private static Set<Integer> alleKundennummern = new HashSet<>();
    private static Map<Integer, Kunde> kundenMap = new HashMap<>();

    // Konstruktor
    public Kunde(String vorname, String nachname, String geburtsdatum) {
        super(vorname, nachname, geburtsdatum);
    }

    // Getter und Setter

    public int getKundennummer() { return kundennummer; }

    public void setKundennummer(int kundennummer) { this.kundennummer = kundennummer; }

    public int getTelefonnummer() { return telefonnummer; }

    public void setTelefonnummer(int telefonnummer) { this.telefonnummer = telefonnummer; }

    public String getFuehrerscheinklasse() { return fuehrerscheinklasse; }

    public void setFuehrerscheinklasse(String fuehrerscheinklasse) { this.fuehrerscheinklasse = fuehrerscheinklasse; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getZahlungsmittel() { return zahlungsmittel; }

    public void setZahlungsmittel(String zahlungsmittel) { this.zahlungsmittel = zahlungsmittel; }

    public String getHistorie() { return historie; }

    public void setHistorie(String historie) { this.historie = historie; }

    public String getStrasse() { return strasse; }

    public void setStrasse(String strasse) { this.strasse = strasse; }

    public int getHausnummer() { return hausnummer; }

    public void setHausnummer(int hausnummer) { this.hausnummer = hausnummer; }

    public int getPostleitzahl() { return postleitzahl; }

    public void setPostleitzahl(int postleitzahl) { this.postleitzahl = postleitzahl; }

    public String getOrt() { return ort; }

    public void setOrt(String ort) { this.ort = ort; }

    public boolean isKundenkarte() { return kundenkarte; }

    public void setKundenkarte(boolean kundenkarte) { this.kundenkarte = kundenkarte; }

    public String getAnschrift() { return strasse + " " + hausnummer + ", " + postleitzahl + " " + ort; }

    // Methoden

    public void PrintKunde() {
        super.Print();
        System.out.println("Kundennummer: " + kundennummer);
        System.out.println("Telefonnummer: " + telefonnummer);
        System.out.println("Führerscheinklasse: " + fuehrerscheinklasse);
        System.out.println("Email: " + email);
        System.out.println("Zahlungsmittel: " + zahlungsmittel);
        System.out.println("Anschrift ist: " + strasse + " " + hausnummer + ", " + postleitzahl + " " + ort);
        System.out.println("Kunde hat Kundenkarte: " + kundenkarte);
        System.out.println("_______________________________");
    }

    // Generiert eine einzigartige Kundennummer (9-stellig)
    public static int generiereEinzigartigeKundennummer() {
        Random random = new Random();
        int kundennummer;
        do {
            kundennummer = random.nextInt(900000000) + 100000000;
        } while (alleKundennummern.contains(kundennummer));
        alleKundennummern.add(kundennummer);
        return kundennummer;
    }

    // Methode zum Hinzufügen eines Kunden zur Map
    public static void kundeHinzufuegen(Kunde kunde) {
        kundenMap.put(kunde.getKundennummer(), kunde);
    }

    // Methode zum Suchen eines Kunden anhand der Kundennummer
    public static Kunde findeKundeMitKundennummer(int kundennummer) {
        return kundenMap.get(kundennummer);
    }
}



