package fachklassen;


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

public class Vertrag implements Serializable {
    private static final long serialVersionUID = 1L;
    private Kunde kunde;
    private PKW pkw;
    private LocalDate vertragsbeginn;
    private LocalDate vertragsende;
    

    private static final String VERTRAG_DATEI = "vertraege.dat";

    public Vertrag(Kunde kunde, PKW pkw, LocalDate vertragsbeginn, LocalDate vertragsende) {
        this.kunde = kunde;
        this.pkw = pkw;
        this.vertragsbeginn = vertragsbeginn;
        this.vertragsende = vertragsende;
        
    }
    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public void setPkw(PKW pkw) {
        this.pkw = pkw;
    }

    public void setVertragsbeginn(LocalDate vertragsbeginn) {
        this.vertragsbeginn = vertragsbeginn;
    }

    public void setVertragsende(LocalDate vertragsende) {
        this.vertragsende = vertragsende;
    }

    
    

    public Kunde getKunde() {
        return kunde;
    }

    public PKW getPkw() {
        return pkw;
    }

    public LocalDate getVertragsbeginn() {
        return vertragsbeginn;
    }

    public LocalDate getVertragsende() {
        return vertragsende;
    }

    

    public String toString() {
        return "Vertrag{" +
                "Kunde: " + kunde.getName() + " " + kunde.getVorname() + ", Kundennummer: " + kunde.getKundennummer() +
                ", PKW: " + pkw.getFzgmarke() + " " + pkw.getFzgkategorie() + ", PKW-ID: " + pkw.getId() +
                ", Vertragsbeginn: " + vertragsbeginn +
                ", Vertragsende: " + vertragsende;
    }
    // Verträge abspeichern
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
        return vertraege; // Return an empty list if file is empty
    }

    // Verträge aus dem file laden
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
        vertraege = (List<Vertrag>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Fehler beim Laden der Verträge " + e.getMessage());
    }

    return vertraege;
}   
    //einen neuen Vetrag erstellen
    public void erstelleVertrag(Kunde kunde, PKW pkw, LocalDate vertragsbeginn, LocalDate vertragsende) {
        Vertrag vertrag = new Vertrag(kunde, pkw, vertragsbeginn, vertragsende);
        List<Vertrag> vertraege = ladeVertraege();
        vertraege.add(vertrag);
        speichereVertraege(vertraege);
        System.out.println("Vertrag gespeichert: " + kunde + ", " + pkw + ", " + vertragsbeginn + ", " + vertragsende);
    }
    //kompletten Vertrag löschen
    public void vertragLoeschen(Kunde kunde, PKW pkw) {
        List<Vertrag> vertraege = ladeVertraege();
        for (int i = 0; i < vertraege.size(); i++) {
            Vertrag vertrag = vertraege.get(i);
            if (vertrag != null && kunde != null && pkw != null) {
                if (vertrag.getKunde() != null && vertrag.getKunde().equals(kunde) && vertrag.getPkw().equals(pkw)) {
                    vertraege.remove(i);
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
            if (vertrag != null && kunde != null && pkw != null) {
                if (vertrag.getKunde().equals(kunde) && vertrag.getPkw().equals(pkw)) {
                    System.out.println(vertrag.toString());
                    return;
                }
            }
        }
        System.out.println("Kein Vertrag gefunden!");
    }

    
   
}
