package autovermietung.Fachklassen;



import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import autovermietung.Verwaltungsklassen.Kostenberechnung;
import autovermietung.Fachklassen.Auftrag;

public class Vertrag implements Serializable {
    private static final long serialVersionUID = 1L;
    private Kunde kunde; //Referenz zum Kundenobjekt
    private PKW pkw;     //Referenz zum PKW Objekt
    private Termin termin;
    //private LocalDate vertragsbeginn;
   // private LocalDate vertragsende;
    private Auftrag auftrag;
    private Kostenberechnung kostenberechnung;
    
    //Speicherung des Dateinamens für die Vertragsdaten
    private static final String VERTRAG_DATEI = "vertraege.dat";

   
    //Konstruktor
    public Vertrag(Kunde kunde, PKW pkw, Termin termin) {
    this.kunde = kunde;
    //System.out.println("Kunde set to: " + kunde);
    this.pkw = pkw;
    this.termin = termin;
    //this.vertragsbeginn = vertragsbeginn;
   //this.vertragsende = vertragsende;
    //this.auftrag = new Auftrag(1, "someCategory", true, true, true, true, 1, 1, true, true, true, 1, true); // create a new Auftrag object
    //this.kostenberechnung = new Kostenberechnung(kunde, pkw, auftrag); // pass the Auftrag object to Kostenberechnung
}
    //verschiedene set-Methoden

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public void setPkw(PKW pkw) {
        this.pkw = pkw;
    }
    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    //public void setVertragsbeginn(LocalDate vertragsbeginn) {
      //  this.vertragsbeginn = vertragsbeginn;
    //}

    //public void setVertragsende(LocalDate vertragsende) {
    //    this.vertragsende = vertragsende;
    //}

    
    //verschiedene get-Methoden

    public Kunde getKunde() {
        return kunde;
    }

    public PKW getPkw() {
        return pkw;
    }

    public double getGesamtpreis() {
        return kostenberechnung.getPreis();
    }
    public LocalDate getVertragsbeginn() {
        return termin.getStartzeitpunkt().toLocalDate();
    }

    public LocalDate getVertragsende() {
        return termin.getEndzeitpunkt().toLocalDate();
    }

    //definiert Darstellung des Vertragsobjekts
    public String toString() {
        return "Vertrag{" +
                "Kunde: " + kunde.getName() + " " + kunde.getVorname() + ", Kundennummer: " + kunde.getKundennummer() +
                ", PKW: " + pkw.getFzgmarke() + " " + pkw.getFzgkategorie() + ", PKW-ID: " + pkw.getId() +
                //", Termin: " + termin.getDate() + ", " + termin.getUhrzeit() +
                ", Termin: " + termin +
                //", Gesamtpreis: " + getGesamtpreis() +
                "}";
    }
    
    // Abspeichern der Verträge
    public void speichereVertraege(List<Vertrag> vertraege) {
        try (FileOutputStream fos = new FileOutputStream(VERTRAG_DATEI);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            System.out.println("Speichert " + vertraege.size() + " Verträge zum file...");
            oos.writeObject(vertraege);
            System.out.println("Verträge erfolgreich gespeichert!");
        } catch (Exception e) {
            System.out.println("Fehler beim Speichern der Verträge: " + e.getMessage());
        }
    }
    //Verträge laden
    public List<Vertrag> ladeVertraege() {
    List<Vertrag> vertraege = new ArrayList<>();
    File file = new File("vertraege.dat");
    

    // FIle erstellen, wenn es nicht schon besteht
    if (!file.exists()) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println("Fehler bei der Dateieinstellung " + e.getMessage());
        }
    }
    // Check ob das file leer ist
    if (file.length() == 0) {
        return vertraege; // Return an empty list wenn das file leer ist
    }

    // Verträge aus dem file laden
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
        vertraege = (List<Vertrag>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Fehler beim Laden der Verträge " + e.getMessage());
    }

    return vertraege;
}   
    //erstellt einen neuen Vertrag
    public void erstelleVertrag(Kunde kunde, PKW pkw, Termin termin) {
      //  if (kunde == null) {
        //    System.out.println("Kunde is null!");
        //    return;
       //}
        Vertrag vertrag = new Vertrag(kunde, pkw, termin);
        //vertrag.setKunde(kunde);
        List<Vertrag> vertraege = ladeVertraege();
        vertraege.add(vertrag);
        speichereVertraege(vertraege);
        System.out.println("Vertrag gespeichert: " + kunde + ", " + pkw + ", " + termin);
    }
    //zum löschen eines Vertrages
    public void vertragLoeschen(Kunde kunde, PKW pkw) {
        List<Vertrag> vertraege = ladeVertraege();
        System.out.println("Vorm Löschen: " + vertraege.size());
        for (int i = vertraege.size() - 1; i >= 0; i--) {
            Vertrag vertrag = vertraege.get(i);
            System.out.println("Betroffener Vertrag: " + vertrag.toString());
            if (vertrag != null && kunde != null && pkw != null) {
                if (vertrag.getKunde().getVorname().equals(kunde.getVorname()) &&
                    vertrag.getKunde().getName().equals(kunde.getName()) &&
                    vertrag.getPkw().getFzgkategorie().equals(pkw.getFzgkategorie()) &&
                    vertrag.getPkw().getFzgmarke().equals(pkw.getFzgmarke()) &&
                    vertrag.getPkw().getBaujahr() == pkw.getBaujahr()) {
                    System.out.println(" Passenden Vertrag gefunden:  " + vertrag.toString());
                    vertraege.remove(i);
                    System.out.println("Nach der Löschung: " + vertraege.size());
                    System.out.println("Speichern der aktualisierten Liste in der Datei..S");
                    speichereVertraege(vertraege);
                    System.out.println("Vertrag erfolgreich gelöscht!");
                    return;
                }
            }
        }
        System.out.println("Kein Vertrag gefunden!");
    }
    //vollständigen Vertrag anzeigen lassen
    public void vertragAnzeigen(Kunde kunde, PKW pkw) {
        List<Vertrag> vertraege = ladeVertraege();
        for (Vertrag vertrag : vertraege) {
            if (vertrag.getKunde()!= null && vertrag.getKunde().getVorname().equals(kunde.getVorname()) 
                    && vertrag.getKunde().getName().equals(kunde.getName()) 
                    && vertrag.getPkw()!= null && vertrag.getPkw().getFzgmarke().equals(pkw.getFzgmarke()) 
                    && vertrag.getPkw().getBaujahr() == pkw.getBaujahr()) {
                System.out.println(vertrag.toString());
                return;
            }
        }
        System.out.println("Kein Vertrag gefunden!");
    }
    
   
}
