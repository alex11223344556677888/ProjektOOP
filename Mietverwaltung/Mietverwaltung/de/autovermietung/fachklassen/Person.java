package fachklassen;        // das einzige was jetzt noch nicht passt sind die package bezeichnungen

public class Person {
    private String vorname;
    private String name;
    private String geburtsdatum;
    private int alter;

    // Konstruktor
    public Person(String vorname, String name, String geburtsdatum, int alter) {
        this.vorname = vorname;
        this.name = name;
        this.geburtsdatum = geburtsdatum;
        this.alter = alter;
    }

    // Getter and Setter
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Vorname='" + vorname + '\'' +
                ", Name='" + name + '\'' +
                ", Geburtsdatum='" + geburtsdatum + '\'' +
                ", Alter=" + alter +
                '}';
    }
}
