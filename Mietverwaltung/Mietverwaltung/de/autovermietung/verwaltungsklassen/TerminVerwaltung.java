package de.autovermietung.verwaltungsklassen;

import de.autovermietung.fachklassen.PKW;
import de.autovermietung.fachklassen.Termin;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TerminVerwaltung {
    private List<Termin> terminListe;
    private List<PKW> pkwListe;

    public TerminVerwaltung() {
        this.terminListe = new ArrayList<>();
        this.pkwListe = ladePKWListeAusDatei("pkwListe.ser");
    }

    private List<PKW> ladePKWListeAusDatei(String dateiname) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dateiname))) {
            return (List<PKW>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<PKW> getPkwListe() {
        return pkwListe;
    }

    public void pruefeTermine() {
        LocalDate startDate = LocalDate.of(2024, 7, 1);
        LocalDate endDate = LocalDate.of(2024, 10, 1);

        for (PKW pkw : pkwListe) {
            System.out.println("PKW " + pkw.getId() + ":");
            for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
                LocalDateTime von = date.atStartOfDay();
                LocalDateTime bis = date.atTime(23, 59, 59);
                if (!isPKWAvailable(pkw, von, bis)) {
                    System.out.println("  - " + date + " belegt");
                } else {
                    System.out.println("  - " + date + " frei");
                }
            }
        }
        speichereTerminListeAlsDatei("TerminListe.ser");
    }

    public void buchePKW(int pkwId, LocalDateTime von, LocalDateTime bis) {
        PKW pkw = findePKWNachId(pkwId);
        if (pkw != null && isPKWAvailable(pkw, von, bis)) {
            Termin termin = new Termin(1030, null, pkw, von, bis);
            termin.setGebucht(true);
            terminListe.add(termin);
            System.out.println("PKW " + pkw.getId() + " gebucht von " + von + " bis " + bis);
        } else {
            System.out.println("PKW " + pkwId + " ist nicht verfügbar von " + von + " bis " + bis);
        }
    }

    public void entbuchePKW(int pkwId, LocalDateTime von, LocalDateTime bis) {
        PKW pkw = findePKWNachId(pkwId);
        if (pkw != null) {
            List<Termin> zuEntfernendeTermine = new ArrayList<>();
            List<Termin> neueTermine = new ArrayList<>();
            for (Termin termin : terminListe) {
                if (termin.getPkw().equals(pkw) && termin.isGebucht()) {
                    // Wenn der Entbuchungszeitraum den Buchungszeitraum überlappt
                    if (!(bis.isBefore(termin.getStartzeitpunkt()) || von.isAfter(termin.getEndzeitpunkt()))) {
                        zuEntfernendeTermine.add(termin);

                        // Falls der Entbuchungszeitraum innerhalb des Buchungszeitraums liegt
                        if (von.isAfter(termin.getStartzeitpunkt()) && bis.isBefore(termin.getEndzeitpunkt())) {
                            neueTermine.add(new Termin(termin.getId(), termin.getKunde(), termin.getPkw(), termin.getStartzeitpunkt(), von.minusSeconds(1)));
                            neueTermine.add(new Termin(termin.getId(), termin.getKunde(), termin.getPkw(), bis.plusSeconds(1), termin.getEndzeitpunkt()));
                        }
                        // Falls der Entbuchungszeitraum den Anfang des Buchungszeitraums betrifft
                        else if (von.isAfter(termin.getStartzeitpunkt())) {
                            neueTermine.add(new Termin(termin.getId(), termin.getKunde(), termin.getPkw(), termin.getStartzeitpunkt(), von.minusSeconds(1)));
                        }
                        // Falls der Entbuchungszeitraum das Ende des Buchungszeitraums betrifft
                        else if (bis.isBefore(termin.getEndzeitpunkt())) {
                            neueTermine.add(new Termin(termin.getId(), termin.getKunde(), termin.getPkw(), bis.plusSeconds(1), termin.getEndzeitpunkt()));
                        }
                    }
                }
            }
            terminListe.removeAll(zuEntfernendeTermine);
            terminListe.addAll(neueTermine);
            System.out.println("PKW " + pkw.getId() + " wurde entbucht von " + von + " bis " + bis);
        } else {
            System.out.println("PKW " + pkwId + " nicht gefunden.");
        }
    }

    private PKW findePKWNachId(int pkwId) {
        for (PKW pkw : pkwListe) {
            if (pkw.getId() == pkwId) {
                return pkw;
            }
        }
        return null;
    }

    private boolean isPKWAvailable(PKW pkw, LocalDateTime von, LocalDateTime bis) {
        for (Termin termin : terminListe) {
            if (termin.getPkw().equals(pkw) && termin.isGebucht()) {
                LocalDateTime terminVon = termin.getStartzeitpunkt();
                LocalDateTime terminBis = termin.getEndzeitpunkt();
                if (!(bis.isBefore(terminVon) || von.isAfter(terminBis))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void speichereTerminListeAlsDatei(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(terminListe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean pruefeBuchungsZeitraum(int pkwId, int startTag, int startMonat, int startJahr, int endeTag, int endeMonat, int endeJahr) {
        LocalDateTime von = LocalDateTime.of(startJahr, startMonat, startTag, 0, 0);
        LocalDateTime bis = LocalDateTime.of(endeJahr, endeMonat, endeTag, 23, 59, 59);
        PKW pkw = findePKWNachId(pkwId);
        if (pkw != null) {
            return !isPKWAvailable(pkw, von, bis);
        }
        return false;
    }

    public void setup() {
        this.terminListe = new ArrayList<>();
        this.pkwListe = ladePKWListeAusDatei("pkwListe.ser");
    }

    public void testBuchePKW(int pkwId, int startTag, int startMonat, int startJahr, int endeTag, int endeMonat, int endeJahr) {
        LocalDateTime von = LocalDateTime.of(startJahr, startMonat, startTag, 0, 0);
        LocalDateTime bis = LocalDateTime.of(endeJahr, endeMonat, endeTag, 23, 59, 59);
        buchePKW(pkwId, von, bis);
        System.out.println("Termin booked successfully for PKW ID: " + pkwId + " von " + von + " bis " + bis);
    }

    public void testEntbuchePKW(int pkwId, int startTag, int startMonat, int startJahr, int endeTag, int endeMonat, int endeJahr) {
        LocalDateTime von = LocalDateTime.of(startJahr, startMonat, startTag, 0, 0);
        LocalDateTime bis = LocalDateTime.of(endeJahr, endeMonat, endeTag, 23, 59, 59);
        entbuchePKW(pkwId, von, bis);
        System.out.println("Termin unbooked successfully for PKW ID: " + pkwId + " von " + von + " bis " + bis);
    }

    public void testPruefeTermine() {
        pruefeTermine();
        System.out.println("Termine checked successfully");
    }

    public void testSpeichereTerminListeAlsDatei() {
        speichereTerminListeAlsDatei("TerminListe.ser");
        System.out.println("Termin list saved to file successfully");
    }

    public void testPruefeBuchungsZeitraum(int pkwId, int startTag, int startMonat, int startJahr, int endeTag, int endeMonat, int endeJahr) {
        boolean gebucht = pruefeBuchungsZeitraum(pkwId, startTag, startMonat, startJahr, endeTag, endeMonat, endeJahr);
        System.out.println("PKW ID: " + pkwId + " gebucht von " + startTag + "." + startMonat + "." + startJahr + " bis " + endeTag + "." + endeMonat + "." + endeJahr + ": " + (gebucht ? "Ja" : "Nein"));
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
