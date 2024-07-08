package de.autovermietung.verwaltungsklassen;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.autovermietung.fachklassen.PKW;

public class Terminplanung implements Serializable{
    private List<Termin> terminListe;
    private List<PKW> pkwListe;

    public Terminplanung(String pkwListeFile) {
        this.terminListe = new ArrayList<>();
        this.pkwListe = ladePKWListe(pkwListeFile);
    }

    @SuppressWarnings("unchecked")
    private List<PKW> ladePKWListe(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<PKW>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Fehler beim Laden der PKW-Liste: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void buchePKW(int pkwId, Date vonDatum, Date bisDatum) {
        PKW pkw = findePKW(pkwId);
        if (pkw != null) {
            Termin termin = new Termin(pkw, vonDatum, bisDatum);
            terminListe.add(termin);
        } else {
            System.out.println("PKW mit ID " + pkwId + " nicht gefunden.");
        }
    }

    private PKW findePKW(int pkwId) {
        for (PKW pkw : pkwListe) {
            if (pkw.getId() == pkwId) {
                return pkw;
            }
        }
        return null;
    }

    public void entbuchePKW(int i, Date vonDatum, Date bisDatum) {
        for (Termin termin : terminListe) {
            if (termin.getPkw().equals(i) && termin.getVonDatum().equals(vonDatum) && termin.getBisDatum().equals(bisDatum)) {
                terminListe.remove(termin);
                return;
            }
        }
    }

    public boolean istPKWVerfügbar(int i, Date vonDatum, Date bisDatum) {
        for (Termin termin : terminListe) {
            if (termin.getPkw().equals(i) && termin.getVonDatum().before(bisDatum) && termin.getBisDatum().after(vonDatum)) {
                return false;
            }
        }
        return true;
    }

    public List<Termin> getTerminListe() {
        return terminListe;
    }

    public static class Termin implements Serializable {
        private PKW pkw;
        private Date vonDatum;
        private Date bisDatum;

        public Termin(PKW pkw, Date vonDatum, Date bisDatum) {
            this.pkw = pkw;
            this.vonDatum = vonDatum;
            this.bisDatum = bisDatum;
        }

        public PKW getPkw() {
            return pkw;
        }

        public Date getVonDatum() {
            return vonDatum;
        }

        public Date getBisDatum() {
            return bisDatum;
        }
    }

    public void speichereTermine(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(terminListe);
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern der Termine: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void ladeTermine(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            terminListe = (List<Termin>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Fehler beim Laden der Termine: " + e.getMessage());
        }
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
