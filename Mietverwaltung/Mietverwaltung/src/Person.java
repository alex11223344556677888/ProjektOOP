import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person {
    private String vorname;
    private String nachname;
    private String geburtsdatum;
    private int age;

    // Konstruktor
    public Person(String vorname, String nachname, String geburtsdatum) {
        this.vorname = vorname;
        this.nachname = nachname;
        setGeburtsdatum(geburtsdatum);
    }

    public String getVorname() { return vorname; }

    public void setVorname(String vorname) { this.vorname = vorname; }

    public String getNachname() { return nachname; }

    public void setNachname(String nachname) { this.nachname = nachname; }

    public String getGeburtsdatum() { return geburtsdatum; }

    public void setGeburtsdatum(String geburtsdatum) {
        if (geburtsdatum == null || geburtsdatum.isEmpty()) {
            System.out.println("Ungültiges Geburtsdatum. Verwenden Sie das Format yyyy-MM-dd.");
            this.age = 0;
        } else {
            this.geburtsdatum = geburtsdatum;
            this.age = calculateAge(geburtsdatum);
        }
    }

    public int getAge() { return age; }

    // Methode zur Berechnung des Alters
    private int calculateAge(String geburtsdatum) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthDate = LocalDate.parse(geburtsdatum, formatter);
            LocalDate currentDate = LocalDate.now();
            return Period.between(birthDate, currentDate).getYears();
        } catch (DateTimeParseException e) {
            System.out.println("Ungültiges Geburtsdatum. Verwenden Sie das Format yyyy-MM-dd.");
            return 0; // Rückgabe 0 im Fehlerfall
        }
    }

    // Ausgabe Methode für Daten von Person
    public void Print() {
        System.out.println("____________________________");
        System.out.println("Vorname: " + vorname);
        System.out.println("Nachname: " + nachname);
        System.out.println("Alter: " + age);
        System.out.println("Geburtsdatum: " + geburtsdatum);
        System.out.println();
    }
}


