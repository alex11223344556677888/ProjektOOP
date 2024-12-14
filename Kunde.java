package fachklassen;        // das einzige was jetzt noch nicht passt sind die package bezeichnungen

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

    // Konstruktor
    public Kunde(String vorname, String name, String geburtsdatum, int alter, int kundennummer, int telefonnummer, String fuehrerscheinklasse, String email, String zahlungsmittel, String historie, String strasse, int hausnummer, int postleitzahl, String ort, boolean kundenkarte, int fuehrerscheinzeitraum, int fuehrerscheinzeitraum2) {
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
    }

    // Getter and Setter
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

    public int getFuehrerscheinzeitraum(){
        return fuehrerscheinzeitraum;
    }
    public void setFuehrerscheinzeitraum(int fuehrerscheinzeitraum) {
        this.fuehrerscheinzeitraum = fuehrerscheinzeitraum;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "Kundennummer=" + kundennummer +
                ", Telefonnummer=" + telefonnummer +
                ", Fuehrerscheinklasse='" + fuehrerscheinklasse + '\'' +
                ", Email='" + email + '\'' +
                ", Zahlungsmittel='" + zahlungsmittel + '\'' +
                ", Historie='" + historie + '\'' +
                ", Strasse='" + strasse + '\'' +
                ", Hausnummer=" + hausnummer +
                ", Postleitzahl=" + postleitzahl +
                ", Ort='" + ort + '\'' +
                ", Kundenkarte=" + kundenkarte +
                "} " + super.toString();
    }
    }
