package de.autovermietung.verwaltungsklassen;

import de.autovermietung.fachklassen.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class PKWVerwaltung implements Serializable{
    private  List<PKW> pkwListe;
    private int pkwIDCounter = 1000;

    public PKWVerwaltung() {
        this.pkwListe = new ArrayList<>();

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pkwListe.ser"))) {
            out.writeObject(new ArrayList<>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //PKW hinzufügen
    // public void pkwHinzufuegen(String fzgkategorie, String fahrzeugmarke, String getriebe, int motorleistung, String farbe, String ausstattung, String kraftstoff, boolean klimatisiert, boolean beheizt, int baujahr, int anzahltueren, int sitzplaetze, int co2emission, int minalter, String fuehrerscheinklasse, int fzgnummer, String kennzeichen, boolean gebucht, boolean navi) {
    //     int id = pkwIDCounter++;
    //     PKW neuerPkw = new PKW(id, fzgkategorie, fahrzeugmarke, getriebe, motorleistung, farbe, ausstattung, kraftstoff, klimatisiert, beheizt, baujahr, anzahltueren, sitzplaetze, co2emission, minalter, fuehrerscheinklasse, fzgnummer, kennzeichen, gebucht, navi);
    //     if (!pkwListe.contains(neuerPkw)) {
    //         pkwListe.add(neuerPkw);
    //         System.out.println("PKW hinzugefügt: " + neuerPkw.getFahrzeugmarke() + " " + neuerPkw.getFzgkategorie());
    //     } else {
    //         System.out.println("PKW bereits in der Liste vorhanden.");
    //     }
        
    // }

    public void pkwHinzufuegen(String fzgkategorie, String fahrzeugmarke, String getriebe, int motorleistung, String farbe, String ausstattung, String kraftstoff, boolean klimatisiert, boolean beheizt, int baujahr, int anzahltueren, int sitzplaetze, int co2emission, int minalter, String fuehrerscheinklasse, int fzgnummer, String kennzeichen, boolean gebucht, boolean navi, boolean elektrofahrzeug, boolean fahrassistent, boolean parkassistent) {
        int id = pkwIDCounter++;
        PKW neuerPkw = new PKW(id, fzgkategorie, fahrzeugmarke, getriebe, motorleistung, farbe, ausstattung, kraftstoff, klimatisiert, beheizt, baujahr, anzahltueren, sitzplaetze, co2emission, minalter, fuehrerscheinklasse, fzgnummer, kennzeichen, gebucht, navi, elektrofahrzeug, fahrassistent, parkassistent);
        if (!pkwListe.contains(neuerPkw)) {
            pkwListe.add(neuerPkw);
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pkwListe.ser"))) {
                out.writeObject(pkwListe);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("PKW hinzugefügt: " + neuerPkw.getFahrzeugmarke() + " " + neuerPkw.getFzgkategorie());
        } else {
            System.out.println("PKW bereits in der Liste vorhanden.");
        }
    }


    public void pkwListeAusgebenAusDatei() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pkwListe.ser"))) {
            List<PKW> pkwListe = (List<PKW>) ois.readObject();
            System.out.println("Inhalt der PKW-Liste:");
            for (PKW pkw : pkwListe) {
                System.out.println("ID: " + pkw.getId());
                System.out.println("Fahrzeugmarke: " + pkw.getFahrzeugmarke());
                System.out.println("Fahrzeugkategorie: " + pkw.getFzgkategorie());
                System.out.println();
                // man könnte noch mehr eigenschaften ausgeben aber lassen erstmal so damits übersichtlicher ist
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Ausgeben der PKW-Liste: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Fehler beim Ausgeben der PKW-Liste: " + e.getMessage());
        }
    }

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



    public List<PKW> getPkwListe() {
        return this.pkwListe;
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
            System.out.println( pkw.getFahrzeugmarke() + " " + pkw.getFzgkategorie() + " " + pkw.getFarbe());
        }
    }
    //Liste ausgeben in Standardreihenfolge und in kurz mit Liste als Übergabeparameter
    public void pkwListeAusgebenKurz(List<PKW> pkwListe) {
        for (PKW pkw : pkwListe) {
            System.out.println("Marke: " + pkw.getFahrzeugmarke() + ", Kategorie: " + pkw.getFzgkategorie() + " Kraftstoff: " + pkw.getKraftstoff());
        }
    }

    //Sortierte Liste nach ID
    public void sortierePKWListeNachID() {
    Collections.sort(this.pkwListe, Comparator.comparing(PKW::getId));
    System.out.println("PKW-Liste nach ID sortiert:");
    for (PKW pkw : this.pkwListe) {
        System.out.println(pkw.getId() + " " + pkw.getFahrzeugmarke() + " " + pkw.getFzgkategorie());
        }
        System.out.println();
    }

    //Sortierte Liste nach ID mit Liste als Übergabeparameter
    public void sortierePKWListeNachID(List<PKW> pkwListe) {
        Collections.sort(pkwListe, Comparator.comparing(PKW::getId));
        System.out.println("PKW-Liste nach ID sortiert:");
        for (PKW pkw : pkwListe) {
            System.out.println(pkw.getId() + " " + pkw.getFahrzeugmarke() + " " + pkw.getFzgkategorie());
        }
        System.out.println();
    }

    //Sortierte Liste nach Motorisierung
    public void sortierePKWListeNachMotorisierung() {
        Collections.sort(this.pkwListe, Comparator.comparing(PKW::getMotorleistung));
        System.out.println("PKW-Liste nach Motorisierung sortiert:");
        for (PKW pkw : this.pkwListe) {
            System.out.println( pkw.getFahrzeugmarke() + " " + pkw.getFzgkategorie() + " " + pkw.getMotorleistung()+ "ps" );
        }
        System.out.println();
    }

    //Sortierte Liste nach Motorisierung mit Liste als Übergabeparameter
    public void sortierePKWListeNachMotorisierung(List<PKW> pkwListe) {
        Collections.sort(pkwListe, Comparator.comparing(PKW::getMotorleistung));
        System.out.println("PKW-Liste nach Motorisierung sortiert:");
        for (PKW pkw : pkwListe) {
            System.out.println(pkw.getId() + " " + pkw.getFahrzeugmarke() + " " + pkw.getFzgkategorie() + " "+ pkw.getMotorleistung() + "ps");
        }
        System.out.println();
    }

    //Sortierte Liste nach Baujahr
    public void sortierePKWListeNachBaujahr() {
        Collections.sort(this.pkwListe, Comparator.comparing(PKW::getBaujahr));
        System.out.println("PKW-Liste nach Baujahr sortiert:");
        for (PKW pkw : this.pkwListe) {
            System.out.println(pkw.getFahrzeugmarke() + " " + pkw.getFzgkategorie() + " " + pkw.getBaujahr());
        }
        System.out.println();
    }

    //Sortierte Liste nach Baujahr mit Liste als Übergabeparameter
    public void sortierePKWListeNachBaujahr(List<PKW> pkwListe) {
        Collections.sort(pkwListe, Comparator.comparing(PKW::getBaujahr));
        System.out.println("PKW-Liste nach Baujahr sortiert:");
        for (PKW pkw : pkwListe) {
            System.out.println( pkw.getFahrzeugmarke() + " " + pkw.getFzgkategorie() + " " + pkw.getBaujahr());
        }
        System.out.println();
    }

    //PKW Status auf gebucht setzen
    public void buchePKW(int id) {
        for (PKW pkw : pkwListe) {
            if (pkw.getId() == id) {
                pkw.setGebucht(true);
                System.out.println("PKW mit ID " + id + " wurde gebucht.");
                return;
            }
        }
        System.out.println("PKW mit ID " + id + " nicht gefunden.");
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

    //PKWs filtern
    public List<PKW> filterPKW(String attribut, String wert) {
        List<PKW> gefilterteListe = new ArrayList<>();
        for (PKW pkw : pkwListe) {
            switch (attribut) {
                case "antrieb":
                
                    if (pkw.getGetriebe().equals(wert)) {
                        gefilterteListe.add(pkw);         
                        System.out.println("Marke: " + pkw.getFahrzeugmarke() + ", Kategorie: " + pkw.getFzgkategorie() + " Getriebe: " + pkw.getGetriebe());            
                    }
                    break;
                case "marke":
                
                    if (pkw.getFahrzeugmarke().equals(wert)) {
                        gefilterteListe.add(pkw);                   
                        System.out.println("Marke: " + pkw.getFahrzeugmarke() + ", Kategorie: " + pkw.getFzgkategorie());                       
                    }
                    break;
                case "fahrzeugtyp":
                
                    if (pkw.getFzgkategorie().equals(wert)) {
                        gefilterteListe.add(pkw);                       
                        System.out.println("Marke: " + pkw.getFahrzeugmarke() + ", Kategorie: " + pkw.getFzgkategorie());                       
                    }
                    break;
                case "farbe":

                    if (pkw.getFarbe().equals(wert)) {
                        gefilterteListe.add(pkw);                      
                        System.out.println("Marke: " + pkw.getFahrzeugmarke() + ", Kategorie: " + pkw.getFzgkategorie() + ", Farbe: " + pkw.getFarbe());
                    }
                    break;
                    
                // Weitere Attribute hinzufügen, wenn nötig
                default:
                    System.out.println("Attribut nicht gefunden");
                    break;
            }
        }

        
        return gefilterteListe;
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
