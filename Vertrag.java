package de.autovermietung.Fachklassen;
import de.autovermietung.Verwaltungsklassen.Kostenberechnung;
import de.autovermietung.Verwaltungsklassen.PKWVerwaltung;

import java.io.Serializable;

public class Vertrag implements Serializable {
    private int kundennummer;
    private int pkwID;
    private String fzgkategorie;
    private boolean elektrofrahrzeug;
    private boolean parkassistent;
    private boolean fahrassistent;
    private boolean klimatisiert;
    private int fuehrerscheinalter;
    private boolean kindersitz;
    private boolean dachbox;
    private boolean auslandsfahrt;
    private int versicherungsklasse;
    private boolean kilometerpaket;
    private double preis;

    public Vertrag(int kundennummer, int pkwID, String fzgkategorie, boolean elektrofrahrzeug, boolean parkassistent, boolean fahrassistent, boolean klimatisiert, int fuehrerscheinalter, boolean kindersitz, boolean dachbox, boolean auslandsfahrt, int versicherungsklasse, boolean kilometerpaket, double preis) {
        this.kundennummer = kundennummer;
        this.pkwID = pkwID;
        this.fzgkategorie = fzgkategorie;
        this.elektrofrahrzeug = elektrofrahrzeug;
        this.parkassistent = parkassistent;
        this.fahrassistent = fahrassistent;
        this.klimatisiert = klimatisiert;
        this.fuehrerscheinalter = fuehrerscheinalter;
        this.kindersitz = kindersitz;
        this.dachbox = dachbox;
        this.auslandsfahrt = auslandsfahrt;
        this.versicherungsklasse = versicherungsklasse;
        this.kilometerpaket = kilometerpaket;
        this.preis = preis;
    }

    public int getKundennummer() {
        return kundennummer;
    }
    public int getPkwID() {
        return pkwID;
    }


    public String getFzgkategorie() {
        return fzgkategorie;
    }

    public boolean isElektrofrahrzeug() {
        return elektrofrahrzeug;
    }

    public boolean isParkassistent() {
        return parkassistent;
    }

    public boolean isFahrassistent() {
        return fahrassistent;
    }

    public boolean isKlimatisiert() {
        return klimatisiert;
    }

    public int getFuehrerscheinalter() {
        return fuehrerscheinalter;
    }

    public boolean isKindersitz() {
        return kindersitz;
    }

    public boolean isDachbox() {
        return dachbox;
    }

    public boolean isAuslandsfahrt() {
        return auslandsfahrt;
    }

    public int getVersicherungsklasse() {
        return versicherungsklasse;
    }

    public boolean isKilometerpaket() {
        return kilometerpaket;
    }

    public double getPreis() {
        return preis;
    }
    //einen neuen Vertrag erstellen
    public static Vertrag erstelleVertrag(int kundennummer, int pkwID, String fzgkategorie, boolean elektrofrahrzeug, boolean parkassistent, boolean fahrassistent, boolean klimatisiert, int fuehrerscheinalter, boolean kindersitz, boolean dachbox, boolean auslandsfahrt, int versicherungsklasse, boolean kilometerpaket, double preis) {
        return new Vertrag(kundennummer, pkwID, fzgkategorie, elektrofrahrzeug, parkassistent, fahrassistent, klimatisiert, fuehrerscheinalter, kindersitz, dachbox, auslandsfahrt, versicherungsklasse, kilometerpaket, preis);
    }

    public void vertragAnzeigen() {                  //Soll den fertigen Vertrag anzeigen
        System.out.println("Vertrag Nr. " + kundennummer);
        System.out.println("Fahrzeug ID: " + pkwID);
        System.out.println("Fahrzeugkategorie: " + fzgkategorie);
        System.out.println("Elektrofahrzeug: " + elektrofrahrzeug);
        System.out.println("Parkassistent: " + parkassistent );
        System.out.println("Fahrassistent: " + fahrassistent );
        System.out.println("Klimatisiert: " + klimatisiert );
        System.out.println("Führerscheinalter: " + fuehrerscheinalter);
        System.out.println("Kindersitz: " + kindersitz );
        System.out.println("Dachbox: " + dachbox );
        System.out.println("Auslandsfahrt: " + auslandsfahrt);
        System.out.println("Versicherungsklasse: " + versicherungsklasse);
        System.out.println("Kilometerpaket: " + kilometerpaket );
        System.out.println("Preis: " + preis + " €");
    }
    //Soll einen vorhandenen Vertrag löschen
    public void vertragLoeschen() {
        kundennummer = 0;
        pkwID = 0;
        fzgkategorie = null;
        elektrofrahrzeug = false;
        parkassistent = false;
        fahrassistent = false;
        klimatisiert = false;
        fuehrerscheinalter = 0;
        kindersitz = false;
        dachbox = false;
        auslandsfahrt = false;
        versicherungsklasse = 0;
        kilometerpaket = false;
        preis = 0.0;
    }
        // einen vorhandenen Vertrag bearbeiten
    public void vertragBearbeiten(int neueKundennummer, int neuepkwID, String neueFzgkategorie, boolean neueElektrofrahrzeug, boolean neueParkassistent, boolean neueFahrassistent, boolean neueKlimatisiert, int neueFuehrerscheinalter, boolean neueKindersitz, boolean neueDachbox, boolean neueAuslandsfahrt, int neueVersicherungsklasse, boolean neueKilometerpaket, double neuePreis) {
        
        kundennummer = neueKundennummer;
        pkwID = neuepkwID;
        fzgkategorie = neueFzgkategorie;
        elektrofrahrzeug = neueElektrofrahrzeug;
        parkassistent = neueParkassistent;
        fahrassistent = neueFahrassistent;
        klimatisiert = neueKlimatisiert;
        fuehrerscheinalter = neueFuehrerscheinalter;
        kindersitz = neueKindersitz;
        dachbox = neueDachbox;
        auslandsfahrt = neueAuslandsfahrt;
        versicherungsklasse = neueVersicherungsklasse;
        kilometerpaket = neueKilometerpaket;
        preis = neuePreis;
    }}
