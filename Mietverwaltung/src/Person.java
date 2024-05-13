public class Person {
    private String vorname;
    private String nachname;
    private String geburtsdatum;
    private int age;

        //Konstruktor
    public Person(String vorname, String nachname, String geburtsdatum, int age) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.age = age;
    }

    public String getVorname() {return vorname;}

    public void setVorname(String vorname) {this.vorname = vorname;}

    public String getNachname() {return nachname;}

    public void setNachname(String nachname) {this.nachname = nachname;}

    public String getGeburtsdatum() {return geburtsdatum;}

    public void setGeburtsdatum(String geburtsdatum) {this.geburtsdatum = geburtsdatum;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public void Print(){
        System.out.println("____________________________");
        System.out.println("Vorname: "+vorname);
        System.out.println("Nachname: "+nachname);
        System.out.println("Alter: "+age);
        System.out.println("Geburtsdatum: "+geburtsdatum);
        System.out.println();
    }
}
