package de.autovermietung.verwaltungsklassen;

import de.autovermietung.fachklassen.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class PKWVerwaltung implements Serializable{
    private  List<PKW> pkwListe;
    private int pkwIDCounter = 1000;
   

//Konstrukor der auf die Datei zugreift oder eine bestellt
    public PKWVerwaltung() {
        this.pkwListe = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pkwListe.ser"))) {
            pkwListe = (List<PKW>) ois.readObject();
        } catch (IOException e) {
            // Falls Datei nicht da ist wird hier eine erstellt
        } catch (ClassNotFoundException e) {
            System.err.println("Fehler beim Laden der PKW-Liste: " + e.getMessage());
        }
        
    }

//get Liste für die pkwListe   
    public List<PKW> getPkwListe() {
        return this.pkwListe;
    }

//fügt einen PKW mit den entsprechend übergebenen Attributen hinzu, aber noch nicht in die Datei    
    public void pkwHinzufuegen(String fzgkategorie, String fzgmarke, String getriebe, int motorleistung, String farbe, String ausstattung, String kraftstoff, boolean klimatisiert, boolean beheizt, int baujahr, int anzahltüren, int sitzplätze, int co2emission, int minalter, String führerscheinklasse, int fzgnummer, String kennzeichen, boolean gebucht, boolean navi, boolean elektrofahrzeug, boolean fahrassistent, boolean parkassistent) {
        int id = pkwIDCounter++;
        PKW neuerPkw = new PKW(id, fzgkategorie, fzgmarke, getriebe, motorleistung, farbe, ausstattung, kraftstoff, klimatisiert, beheizt, baujahr, anzahltüren, sitzplätze, co2emission, minalter, führerscheinklasse, fzgnummer, kennzeichen, gebucht, navi, elektrofahrzeug, fahrassistent, parkassistent);
        if (!pkwListe.contains(neuerPkw)) {
            pkwListe.add(neuerPkw);
            System.out.println("PKW hinzugefügt: " + neuerPkw.getFzgmarke() + " " + neuerPkw.getFzgkategorie());
        } else {
            System.out.println("PKW bereits in der Liste vorhanden.");
        }
    }


//Speichermethode der die erstellen PKWs in eine Datei speichert   
    public void pkwSpeichern() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pkwListe.ser"))) {
        out.writeObject(pkwListe);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

//gibt die Liste der PKWs in verkürzter Form wieder
    public void pkwListeAusgebenAusDatei() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pkwListe.ser"))) {
            List<PKW> pkwListe = (List<PKW>) ois.readObject();
            System.out.println("Inhalt der PKW-Liste:");
            for (PKW pkw : pkwListe) {
                System.out.println("ID: " + pkw.getId());
                System.out.println("Fahrzeugmarke: " + pkw.getFzgmarke());
                System.out.println("Fahrzeugkategorie: " + pkw.getFzgkategorie());
                System.out.println();
                // man könnte noch mehr eigenschaften ausgeben aber lassen es so damits übersichtlicher ist
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Ausgeben der PKW-Liste: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Fehler beim Ausgeben der PKW-Liste: " + e.getMessage());
        }
    }

//Löscht einen PKW nach ID aus der Datei    
    public void pkwLoeschenAusDatei(int id) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pkwliste.ser"))) {
            pkwListe = (List<PKW>) ois.readObject();
            for (PKW pkw : pkwListe) {
                if (pkw.getId() == id) {
                    pkwListe.remove(pkw);
                    break;
                }
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pkwliste.ser"))) {
                oos.writeObject(pkwListe);
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Löschen des PKW: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Fehler beim Löschen des PKW: " + e.getMessage());
        }
    }



    
//Allgemeine Liste mit allen Eigenschaften ausgeben
    public void pkwListeAusgeben() {
        System.out.println("PKW-Liste:");
        for (PKW pkw : this.pkwListe) {
            System.out.println("\t" + pkw);
        }
    }

//Liste ausgeben in Standardreihenfolge und in kurz
    public void pkwListeAusgebenKurz() {
        System.out.println("PKW-Liste (kurz):");
        for (PKW pkw : this.pkwListe) {
            System.out.println( pkw.getFzgmarke() + " " + pkw.getFzgkategorie() + " " + pkw.getFarbe());
        }
    }

//Liste ausgeben in Standardreihenfolge und in kurz mit Liste als Übergabeparameter
    public void pkwListeAusgebenKurz(List<PKW> pkwListe) {
        for (PKW pkw : pkwListe) {
            System.out.println("Marke: " + pkw.getFzgmarke() + ", Kategorie: " + pkw.getFzgkategorie() + " Kraftstoff: " + pkw.getKraftstoff());
        }
    }

//Sortierte Liste nach ID
    public void sortierePKWListeNachID() {
        if (this.pkwListe.isEmpty()) {
            System.out.println("Die Liste ist leer");
            return;
        }
    Collections.sort(this.pkwListe, Comparator.comparing(PKW::getId));
    System.out.println("PKW-Liste nach ID sortiert:");
    for (PKW pkw : this.pkwListe) {
        System.out.println(pkw.getId() + " " + pkw.getFzgmarke() + " " + pkw.getFzgkategorie());
        }
        System.out.println();
    }

//Sortierte Liste nach ID mit Liste als Übergabeparameter
    public void sortierePKWListeNachID(List<PKW> pkwListe) {
        if (this.pkwListe.isEmpty()) {
            System.out.println("Die Liste ist leer");
            return;
        }
        Collections.sort(pkwListe, Comparator.comparing(PKW::getId));
        System.out.println("PKW-Liste nach ID sortiert:");
        for (PKW pkw : pkwListe) {
            System.out.println(pkw.getId() + " " + pkw.getFzgmarke() + " " + pkw.getFzgkategorie());
        }
        System.out.println();
    }

//Sortierte Liste nach Motorisierung
    public void sortierePKWListeNachMotorisierung() {
        if (this.pkwListe.isEmpty()) {
            System.out.println("Die Liste ist leer");
            return;
        }
        Collections.sort(this.pkwListe, Comparator.comparing(PKW::getMotorleistung));
        System.out.println("PKW-Liste nach Motorisierung sortiert:");
        for (PKW pkw : this.pkwListe) {
            System.out.println( pkw.getFzgmarke() + " " + pkw.getFzgkategorie() + " " + pkw.getMotorleistung()+ "ps" );
        }
        System.out.println();
    }

//Sortierte Liste nach Motorisierung mit Liste als Übergabeparameter
    public void sortierePKWListeNachMotorisierung(List<PKW> pkwListe) {
        if (this.pkwListe.isEmpty()) {
            System.out.println("Die Liste ist leer");
            return;
        }
        Collections.sort(pkwListe, Comparator.comparing(PKW::getMotorleistung));
        System.out.println("PKW-Liste nach Motorisierung sortiert:");
        for (PKW pkw : pkwListe) {
            System.out.println(pkw.getId() + " " + pkw.getFzgmarke() + " " + pkw.getFzgkategorie() + " "+ pkw.getMotorleistung() + "ps");
        }
        System.out.println();
    }

//Sortierte Liste nach Baujahr
    public void sortierePKWListeNachBaujahr() {
        if (this.pkwListe.isEmpty()) {
            System.out.println("Die Liste ist leer");
            return;
        }
        Collections.sort(this.pkwListe, Comparator.comparing(PKW::getBaujahr));
        System.out.println("PKW-Liste nach Baujahr sortiert:");
        for (PKW pkw : this.pkwListe) {
            System.out.println(pkw.getFzgmarke() + " " + pkw.getFzgkategorie() + " " + pkw.getBaujahr());
        }
        System.out.println();
    }

//Sortierte Liste nach Baujahr mit Liste als Übergabeparameter
    public void sortierePKWListeNachBaujahr(List<PKW> pkwListe) {
        if (this.pkwListe.isEmpty()) {
            System.out.println("Die Liste ist leer");
            return;
        }
        Collections.sort(pkwListe, Comparator.comparing(PKW::getBaujahr));
        System.out.println("PKW-Liste nach Baujahr sortiert:");
        for (PKW pkw : pkwListe) {
            System.out.println( pkw.getFzgmarke() + " " + pkw.getFzgkategorie() + " " + pkw.getBaujahr());
        }
        System.out.println();
    }

 
    

//PKW Status auf gebucht setzen
public void buchePKW(int id) {
    try {
        for (PKW pkw : pkwListe) {
            if (pkw.getId() == id) {
                if (pkw.isGebucht()) {
                    throw new RuntimeException("Fahrzeug ist bereits gebucht.");
                }
                pkw.setGebucht(true);
                pkwSpeichern();
                System.out.println("PKW mit ID " + id + " wurde gebucht.");
                return;
            }
        }
        throw new RuntimeException("PKW mit ID " + id + " nicht gefunden.");
    } catch (RuntimeException e) {
        System.err.println(e.getMessage());
    }
}

//PKW Status auf entbucht setzen
public void entbuchePKW(int id) {
    try {
        for (PKW pkw : pkwListe) {
            if (pkw.getId() == id) {
                if (!pkw.isGebucht()) {
                    throw new RuntimeException("Fahrzeug ist bereits ungebucht.");
                }
                pkw.setGebucht(false);
                pkwSpeichern();
                System.out.println("PKW mit ID " + id + " wurde entbucht.");
                return;
            }
        }
        throw new RuntimeException("PKW mit ID " + id + " nicht gefunden.");
    } catch (RuntimeException e) {
        System.err.println(e.getMessage());
    }
}
    

//PKW nach ID ausgeben
    public void ausgebenPKW(int id) {
        for (PKW pkw : pkwListe) {
            if (pkw.getId() == id) {
                System.out.println(pkw);
                return;
            }
        }
        System.out.println("PKW mit ID " + id + " nicht gefunden.");
    }

//PKWs filtern nach den Attributen Antrieb, Marke, Fahrzeugtyp, Farbe, Elektro und dem gebucht Status, aber auch ausgabe kompletter Liste bei ""
    public List<PKW> filterPKW(String attribut, String wert) {
        if (pkwListe.isEmpty()) {
            throw new RuntimeException("Die Liste ist leer.");
        }
        List<PKW> gefilterteListe = new ArrayList<>();
        for (PKW pkw : pkwListe) {
            switch (attribut) {
                case "antrieb":
                
                    if (pkw.getGetriebe().equals(wert)) {
                        gefilterteListe.add(pkw);         
                        System.out.println("Marke: " + pkw.getFzgmarke() + ", Kategorie: " + pkw.getFzgkategorie() + " Getriebe: " + pkw.getGetriebe());            
                    }
                    break;
                case "marke":
                
                    if (pkw.getFzgmarke().equals(wert)) {
                        gefilterteListe.add(pkw);                   
                        System.out.println("Marke: " + pkw.getFzgmarke() + ", Kategorie: " + pkw.getFzgkategorie());                       
                    }
                    break;
                case "fahrzeugtyp":
                
                    if (pkw.getFzgkategorie().equals(wert)) {
                        gefilterteListe.add(pkw);                       
                        System.out.println("Marke: " + pkw.getFzgmarke() + ", Kategorie: " + pkw.getFzgkategorie());                       
                    }
                    break;
                case "farbe":

                    if (pkw.getFarbe().equals(wert)) {
                        gefilterteListe.add(pkw);                      
                        System.out.println("Marke: " + pkw.getFzgmarke() + ", Kategorie: " + pkw.getFzgkategorie() + ", Farbe: " + pkw.getFarbe());
                    }
                    break;
                case "elektro":
                    boolean elektroWert = Boolean.parseBoolean(wert);
                    if (pkw.isElektrofahrzeug() == elektroWert) {
                        gefilterteListe.add(pkw);                      
                        System.out.println("Marke: " + pkw.getFzgmarke() + ", Kategorie: " + pkw.getFzgkategorie() + ", Elektrofahrzeug: " + pkw.isElektrofahrzeug());
                    }
                    break;
                case "":
                    if (pkw.getFzgmarke().equals(wert)) {
                        gefilterteListe.add(pkw);
                    }
                    break;
                case "gebucht":
                    boolean istGebucht = Boolean.parseBoolean(wert);
                    if (pkw.isGebucht() == istGebucht) {
                        gefilterteListe.remove(pkw);                      
                    }
                    break;
                
                default:
                    System.out.println("Attribut nicht gefunden");
                    break;
            }
        }
        return gefilterteListe;
    }

//PKWs filtern nach den Attributen Antrieb, Marke, Fahrzeugtyp, Farbe, Elektro und dem gebucht Status, aber auch ausgabe kompletter Liste bei "" mit zusätzlichem Übergabeparameter, der Templiste 
//damit man auch nach mehreren Attributen filtern kann und nicht nur einem   
    public List<PKW> filterPKW(String attribut, String wert, List<PKW> tempList) {
        List<PKW> gefilterteListe = new ArrayList<>();
        for (PKW pkw : tempList) {
            switch (attribut) {
                case "antrieb":
                    if (pkw.getGetriebe().equals(wert)) {
                        gefilterteListe.add(pkw);
                    }
                    break;
                case "marke":
                    if (pkw.getFzgmarke().equals(wert)) {
                        gefilterteListe.add(pkw);
                    }
                    break;
                case "fahrzeugtyp":
                    if (pkw.getFzgkategorie().equals(wert)) {
                        gefilterteListe.add(pkw);
                    }
                    break;
                case "farbe":
                    if (pkw.getFarbe().equals(wert)) {
                        gefilterteListe.add(pkw);
                    }
                    break;
                case "elektrofahrzeug":
                    if (pkw.isElektrofahrzeug() == Boolean.parseBoolean(wert)) {
                        gefilterteListe.add(pkw);
                    }
                    break;
                case "":
                    if (pkw.getFzgmarke().equals(wert)) {
                        gefilterteListe.add(pkw);
                    }
                    break;
                case "gebucht":
                    boolean istGebucht = Boolean.parseBoolean(wert);
                    if (pkw.isGebucht() == istGebucht) {
                        gefilterteListe.remove(pkw);                      
                    }
                    break;
                default:
                    System.out.println("Attribut nicht gefunden");
                    break;
            }
        }
        return gefilterteListe;
    }

//deserialisiert die Liste    
    public List<PKW> deserializePkwListe(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<PKW>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error deserializing pkwListe.ser", e);
        }
    }

//Gibt aus, ob der PKW den Status gebucht, oder frei hat, also isGebucht =true oder false    
    public void checkPKWStatus(int pkwId) {
        PKW pkw = null;
        for (PKW p : pkwListe) {
            if (p.getId() == pkwId) {
                pkw = p;
                break;
            }
        }
    
        if (pkw != null) {
            System.out.println("PKW ID: " + pkwId + " gebucht: " + pkw.isGebucht());
        } else {
            System.out.println("PKW ID: " + pkwId + " nicht gefunden.");
        }
    }

//setzt alle PKWs in der Liste auf den Status nicht gebucht, sozusagen ein reset der PKWs, und speichert die neue Liste dann   
    public void PKWentbucheAlle() {
        for (PKW pkw : pkwListe) {
            pkw.setGebucht(false);
        }
        pkwSpeichern();
        System.out.println("Alle PKWs wurden entbucht.");
    }

}



































// public class PKWVerwaltung extends PKW {


//    // PKWVerwaltung pkwVerwaltung = new PKWVerwaltung(null, null, null, 0, null, null, null, false, false, 0, 0, 0, 0, 0, null, 0, null, false, false);

    
    
//     // PKW neuerPkw1 = new PKW("Kombi", "Mercedes Benz", "Automatik", 250, "Schwarz", "Leder", "Benzin", true, true, 2020, 4, 5, 120, 21, "B", 12345, "M-AB-123", false, true);
    
//    // PKW neuerPkw2 = new PKW("Coupe", "Maserati", "Manuell", 460, "Schwarz", "Leder", "Benzin", true, true, 2020, 4, 5, 120, 21, "B", 12345, "M-AB-123", false, true);
    
    
//    // pkwVerwaltung.pkwHinzufuegen(neuerPkw1);
//     // pkwVerwaltung.pkwHinzufuegen(neuerPkw2);


//     private List<PKW> pkwListe;

//     public PKWVerwaltung(String fzgkategorie, String fahrzeugmarke, String getriebe, int motorleistung, String farbe, String ausstattung, String kraftstoff, boolean klimatisiert, boolean beheizt, int baujahr, int anzahltüren, int sitzplätze, int co2emission, int minalter, String führerscheinklasse, String fzgnummer, String kennzeichen, boolean gebucht, boolean navi) {
//         super(fzgkategorie, fahrzeugmarke, getriebe, motorleistung, farbe, ausstattung, kraftstoff, klimatisiert, beheizt, baujahr, anzahltüren, sitzplätze, co2emission, minalter, führerscheinklasse, fzgnummer, kennzeichen, gebucht, navi);
//         this.pkwListe = new ArrayList<>();
//     }


//     //Konstruktor
//     // public PKWVerwaltung(String fzgkategorie,String fahrzeugmarke,String getriebe, int motorleistung,String farbe,String ausstattung , String kraftstoff ,boolean klimatisiert ,boolean beheizt, int baujahr, int anzahltüren,int sitzplätze,int co2emission,int minalter,String führerscheinklasse, int fzgnummer, String kennzeichen,boolean gebucht, boolean navi) {
//     //     super(fzgkategorie, fahrzeugmarke, getriebe, motorleistung, farbe, ausstattung, kraftstoff, klimatisiert, beheizt, baujahr, anzahltüren, sitzplätze, co2emission, minalter, führerscheinklasse, fzgnummer, kennzeichen, gebucht, navi);
//     //     this.pkwListe = new ArrayList<>();
//     // }

//     public void pkwHinzufuegen(String fzgkategorie, String fahrzeugmarke, String getriebe, int motorleistung, String farbe, String ausstattung, String kraftstoff, boolean klimatisiert, boolean beheizt, int baujahr, int anzahltueren, int sitzplaetze, int co2emission, int minalter, String fuehrerscheinklasse, int fzgnummer, String kennzeichen, boolean gebucht, boolean navi) {
//         PKW neuerPkw = new PKW(fzgkategorie, fahrzeugmarke, getriebe, motorleistung, farbe, ausstattung, kraftstoff, klimatisiert, beheizt, baujahr, anzahltueren, sitzplaetze, co2emission, minalter, fuehrerscheinklasse, fzgnummer, kennzeichen, gebucht, navi);
//         pkwListe.add(neuerPkw);
//         System.out.println("PKW hinzugefügt: " + neuerPkw.getFahrzeugmarke() + " " + neuerPkw.getFzgkategorie());
//     }



//     //PKW hinzufügen
//     //public void pkwHinzufuegen(PKW pkw) {
//     //     public void pkwHinzufuegen(String fzgkategorie, String fahrzeugmarke, String getriebe, int motorleistung, String farbe, String ausstattung, String kraftstoff, boolean klimatisiert, boolean beheizt, int baujahr, int anzahltueren, int sitzplaetze, int co2emission, int minalter, String fuehrerscheinklasse, int fzgnummer, String kennzeichen, boolean gebucht, boolean navi) {
       
//     //     PKW neuerPkw = new PKW("Limousine", "BMW", "Automatik", 250, "Schwarz", "Leder", "Benzin", true, true, 2020, 4, 5, 120, 21, "B", 12345, "M-AB-123", false, true);

//     //     pkwVerwaltung.pkwHinzufuegen()
//     //     pkwHinzufuegen(neuerPkw);

//     //     pkwListe.add(pkw);
//     //     System.out.println("Pkw hinzugefügt: " + pkw.getFahrzeugmarke() + " " + pkw.getFzgkategorie());
//     // }


//     //Alle PKWs mit allen Eigenscahften ausgeben
//     public void allePKWsAusgeben() {
//         if (pkwListe.isEmpty()) {
//             System.out.println("Es sind keine PKWs verfügbar.");
//         } else {
//             for (PKW pkw : pkwListe) {
//                 System.out.println();
//                 System.out.println(pkw);
//             }
//         }
//     }

//     //Liste
//     public List<PKW> getPkwListe() {
//         return pkwListe;
//     }

// }
