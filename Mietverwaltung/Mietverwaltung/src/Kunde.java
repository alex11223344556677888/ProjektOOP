import java.util.Random;
import java.util.Scanner;
public class Kunde extends Person{
    
    private int kundennummer;
    private int telefonnummer;
    private String führerscheinklasse;
    private String email;
    private String zahlungsmittel;
    private String historie;
    private String straße;
    private int hausnummer;
    private int postleitzahl;
    private String ort;
    private boolean kundenkarte;

        //Konstruktor
    public Kunde(String vorname, String nachname, String geburtsdatum, int age) {
            super(vorname, nachname, geburtsdatum, age);
    }
    


    public int getKundennummer() {return kundennummer;}

    public void setKundennummer(int kundennummer) {this.kundennummer = kundennummer;}

    public int getTelefonnummer() {return telefonnummer;}

    public void setTelefonnummer(int telefonnummer) {this.telefonnummer = telefonnummer;}

    public String getFührerscheinklasse() {return führerscheinklasse;}

    public void setFührerscheinklasse(String führerscheinklasse) {this.führerscheinklasse = führerscheinklasse;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getZahlungsmittel() {return zahlungsmittel;}

    public void setZahlungsmittel(String zahlungsmittel) {this.zahlungsmittel = zahlungsmittel;}

    public String getHistorie() {return historie;}

    public void setHistorie(String historie) {this.historie = historie;}

    public String getStraße() {return straße;}

    public void setStraße(String straße) {this.straße = straße;}

    public int getHausnummer() {return hausnummer;}

    public void setHausnummer(int hausnummer) {this.hausnummer = hausnummer;}

    public int getPostleitzahl() {return postleitzahl;}

    public void setPostleitzahl(int postleitzahl) {this.postleitzahl = postleitzahl;}

    public String getOrt() {return ort;}

    public void setOrt(String ort) {this.ort = ort;}

    public boolean isKundenkarte() {return kundenkarte;}

    public void setKundenkarte(boolean kundenkarte) {this.kundenkarte = kundenkarte;}

        //Methoden

        public void PrintKunde(){
            super.Print();
            System.out.println("Kundennummer: "+ kundennummer);
            System.out.println("Telefonnummer: "+ telefonnummer);
            System.out.println("Führerscheinklasse: "+ führerscheinklasse);
            System.out.println("Email: "+email);
            System.out.println("zahlungsmittel: "+zahlungsmittel);
            System.out.println("Anschrift ist: "+straße+" "+hausnummer+", "+postleitzahl+" "+ort);
            System.out.println("Kunde hat Kundenkarte: "+kundenkarte);
    
            System.out.println("_______________________________");
        }

        // Erstell 9-stellige Kundennummer 
        public int Kundennummergenerieren(){
            Random random = new Random();
        int kundennummer = random.nextInt(900000000) + 100000000;
        return kundennummer;
        
        }



   
    }


/* //Konstruktor
        public Kunde(String vorname, String nachname, String geburtsdatum, int age, int kundennummer, int telefonnummer,
        String führerscheinklasse, String email, String zahlungsmittel, String historie,String straße,int hausnummer,int postleitzahl, String ort, boolean kundenkarte) {
    super(vorname, nachname, geburtsdatum, age);
    this.kundennummer = kundennummer;
    this.telefonnummer = telefonnummer;
    this.führerscheinklasse = führerscheinklasse;
    this.email = email;
    this.zahlungsmittel = zahlungsmittel;
    this.historie = historie;
    this.straße = straße;
    this.hausnummer = hausnummer;
    this.postleitzahl = postleitzahl;
    this.ort = ort;
    this.kundenkarte = kundenkarte;
} */
