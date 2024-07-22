package de.autovermietung.verwaltungsklassen;

import de.autovermietung.fachklassen.PKW;
import de.autovermietung.fachklassen.Termin;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

public class TerminVerwaltung {
    private List<Termin> terminListe;
    private List<PKW> pkwListe;
    private int terminIDCounter;


//Konstruktor der auf die pkwListe und terinListe Dateien lädt
    public TerminVerwaltung() {
        this.pkwListe = ladePKWListeAusDatei("pkwListe.ser");
        this.terminListe = ladeTerminListeAusDatei("terminListe.ser");
        if (terminListe.isEmpty()) {
            this.terminIDCounter = 5000;
        } else {
            int maxId = terminListe.stream().mapToInt(Termin::getId).max().orElse(4999);
            this.terminIDCounter = maxId + 1;
        }
    }

//Methode zum Laden der PKW-Liste aus der entsprechenden datei pkwListe, Warnung, da die Methode sonst geld unterstrichen ist.
    @SuppressWarnings("unchecked")
    private List<PKW> ladePKWListeAusDatei(String dateiname) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dateiname))) {
            return (List<PKW>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

//Methode zum Laden der Termin-Liste aus der entsprechenden datei terminListe, Warnung, da die Methode sonst geld unterstrichen ist.    
    @SuppressWarnings("unchecked")
    private List<Termin> ladeTerminListeAusDatei(String dateiname) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dateiname))) {
            return (List<Termin>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    

//get Methode für die pkwListe
    public List<PKW> getPkwListe() {
        return pkwListe;
    }

//get Methode für terminListe
    public List<Termin> getTerminListe() {
        return terminListe;
    }

//Methode prüft für die einzelnen PKWs in der pkwListe ob sie im Zeitraum der in der Methode definiert ist frei doer belegt sind, nur Ausgabe in konsole   
    public void pruefeTermine() {
    this.terminListe = ladeTerminListeAusDatei("terminListe.ser");
    LocalDate startDate = LocalDate.of(2024, 7, 1);
    LocalDate endDate = LocalDate.of(2024, 8, 1);

    for (PKW pkw : pkwListe) {
        System.out.println("PKW " + pkw.getId() + ":");
        for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
            LocalDateTime von = date.atStartOfDay();
            LocalDateTime bis = date.atTime(23, 59, 59);
            boolean available = true;
            for (Termin termin : terminListe) {
                if (termin.getPkw().equals(pkw) && termin.isGebucht() &&
                    !(bis.isBefore(termin.getStartzeitpunkt()) || von.isAfter(termin.getEndzeitpunkt()))) {
                    available = false;
                    break;
                }
            }
            if (available) {
                System.out.println("  - " + date + " frei");
            } else {
                System.out.println("  - " + date + " belegt");
            }
        }
    }
    System.out.println("Termine erfolgreich geprüft");
}

//findet PKWs in der Liste nach ihrer ID
    private PKW findePKWNachId(int pkwId) {
        for (PKW pkw : pkwListe) {
            if (pkw.getId() == pkwId) {
                return pkw;
            }
        }
        return null;
    }

//Prüft ob der PKW für einen Zeitraum im Format LocalDateTime ob der PKW verfügbar ist    
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

//speicherung der Termin-Liste in der entsprechenden Datei    
    public void speichereTerminListeAlsDatei(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(terminListe);
            System.out.println("Terminliste erfolgreich in Datei gespeichert");
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern der Terminliste: " + e.getMessage());
        }
    }

//Prüft ob das übergebene Datum zulässig ist
    private void validateDate(LocalDateTime dateTime) {
        if (dateTime.getYear() < 0) {
            throw new DateTimeException("Das Jahr muss eine positive Zahl sein.");
        }
        if (dateTime.getMonthValue() < 1 || dateTime.getMonthValue() > 12) {
            throw new DateTimeException("Der Monat muss zwischen 1 und 12 liegen.");
        }
        int dayOfMonth = dateTime.getDayOfMonth();
        int maxDayOfMonth = dateTime.toLocalDate().lengthOfMonth();
        if (dayOfMonth < 1 || dayOfMonth > maxDayOfMonth) {
            throw new DateTimeException("Der Tag muss zwischen 1 und " + maxDayOfMonth + " liegen."); //wegen unterschiedlichen Tagen pro Monat 
        }
    }

    
//Methode zur Prüfung alle PKWs nach ihrer ID, ob sie verfügbar sind. Zeitraum wird mit einzelnen Integern übergeben
    public boolean pruefeBuchungsZeitraum(int pkwId, int startTag, int startMonat, int startJahr, int endeTag, int endeMonat, int endeJahr) {
        try {
            LocalDateTime von = LocalDateTime.of(startJahr, startMonat, startTag, 0, 0);
            LocalDateTime bis = LocalDateTime.of(endeJahr, endeMonat, endeTag, 23, 59, 59);
            validateDate(von);
            validateDate(bis);
    
            PKW pkw = findePKWNachId(pkwId);
            if (pkw != null) {
                boolean isAvailable = isPKWAvailable(pkw, von, bis);
                if (!isAvailable) {
                    // Attribut "gebucht" auf true
                    pkw.setGebucht(true);
                    // Speichere  aktualisierte pkwListe
                    speicherePKWListe();
                }
                if (isAvailable) {
                    System.out.println("PKW ID: " + pkwId + " ist verfügbar von " + startTag + "." + startMonat + "." + startJahr + " bis " + endeTag + "." + endeMonat + "." + endeJahr);
                } else {
                    System.out.println("PKW ID: " + pkwId + " ist nicht verfügbar von " + startTag + "." + startMonat + "." + startJahr + " bis " + endeTag + "." + endeMonat + "." + endeJahr);
                }
                return !isAvailable;
            } else {
                System.out.println("PKW ID: " + pkwId + " nicht gefunden.");
                return false;
            }
        } catch (DateTimeException e) {
            System.err.println("Fehler bei der Überprüfung des Buchungszeitraums: " + e.getMessage());
            return false;
        }
    }
    
//Prüft für die gesamte PKW-Liste in der Datei für den übergegeben Zeitraum mit Int's, ob die PKWs verfügbar sind oder nicht
    public void pruefeBuchungsZeitraumPKWListe(int startTag, int startMonat, int startJahr, int endeTag, int endeMonat, int endeJahr) {
        try {
            LocalDateTime von = LocalDateTime.of(startJahr, startMonat, startTag, 0, 0);
            LocalDateTime bis = LocalDateTime.of(endeJahr, endeMonat, endeTag, 23, 59, 59);
    
            if (!validateDate(startTag, startMonat, startJahr, endeTag, endeMonat, endeJahr)) {
                throw new DateTimeException("Das Von-Datum darf nicht nach dem Bis-Datum liegen.");
            }
    
            // Lade die Terminliste aus der Datei
            List<Termin> terminListe = ladeTerminListeAusDatei("terminListe.ser");
    
            for (PKW pkw : pkwListe) {
                boolean isAvailable = true;
    
                for (Termin termin : terminListe) {
                    if (termin.getPkw().getId() == pkw.getId()) {
                        LocalDateTime terminVon = termin.getStartzeitpunkt();
                        LocalDateTime terminBis = termin.getEndzeitpunkt();
    
                        if (!(bis.isBefore(terminVon) || von.isAfter(terminBis))) {
                            isAvailable = false;
                            break;
                        }
                    }
                }
    
                pkw.setGebucht(!isAvailable);
    
                if (isAvailable) {
                    System.out.println("PKW ID: " + pkw.getId() + " ist verfügbar von " + startTag + "." + startMonat + "." + startJahr + " bis " + endeTag + "." + endeMonat + "." + endeJahr);
                } else {
                    System.out.println("PKW ID: " + pkw.getId() + " ist nicht verfügbar von " + startTag + "." + startMonat + "." + startJahr + " bis " + endeTag + "." + endeMonat + "." + endeJahr);
                }
            }
    
            // Speichere die aktualisierte PKW-Liste
            speicherePKWListe();
        } catch (DateTimeException e) {
            System.err.println("Fehler bei der Überprüfung des Buchungszeitraums: " + e.getMessage());
        }
    }
    
    
//Prüft ob das eingegebene Datum, welches inform von einzelnen start und ende Int's übergeben wird, zulässig ist 
    private boolean validateDate(int startTag, int startMonat, int startJahr, int endeTag, int endeMonat, int endeJahr) {
        try {
            LocalDate startDate = LocalDate.of(startJahr, startMonat, startTag);
            LocalDate endDate = LocalDate.of(endeJahr, endeMonat, endeTag);
    
            if (startDate.isAfter(endDate)) {
                return false;
            }
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

//Speichermethode für pkwListe     
    private void speicherePKWListe() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pkwListe.ser"))) {
            oos.writeObject(pkwListe);
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern der PKW-Liste: " + e.getMessage());
        }
    }

//finde PKW nach Id mit ID und der PKW-Liste als übergabe Parameter     
    @SuppressWarnings("unused")
    private PKW findePKWNachId(int pkwId, List<PKW> pkwListe) {
        for (PKW pkw : pkwListe) {
            if (pkw.getId() == pkwId) {
                return pkw;
            }
        }
        return null;
    }

//Ausgabe der Terminliste    
    public void terminListeAusgeben() {
        if (terminListe.isEmpty()) {
            throw new IllegalStateException("Keine Termine vorhanden.");
        }
        for (Termin termin : terminListe) {
            System.out.println("Termin ID: " + termin.getId() + ", PKW ID: " + termin.getPkw().getId() +
                    ", Start: " + termin.getStartzeitpunkt() + ", Ende: " + termin.getEndzeitpunkt() +
                    ", Gebucht: " + termin.isGebucht());
        }
    }

//Setup methode für den Test in der Testklasse     
    public void setup() {
        this.terminListe = ladeTerminListeAusDatei("terminListe.ser");
        this.pkwListe = ladePKWListeAusDatei("pkwListe.ser");
    }

//Methode zur löschung von Terminen in der terminListe Datei     
    public void loescheTermin(int terminId) {
        try {
            Termin terminZumLoeschen = null;
            for (Termin termin : terminListe) {
                if (termin.getId() == terminId) {
                    terminZumLoeschen = termin;
                    break;
                }
            }
    
            if (terminZumLoeschen != null) {
                terminListe.remove(terminZumLoeschen);
                System.out.println("Termin mit ID " + terminId + " wurde gelöscht.");
                speichereTerminListeAlsDatei("terminListe.ser");
            } else {
                throw new IllegalArgumentException("Termin mit ID " + terminId + " nicht gefunden.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Fehler beim Löschen des Termins: " + e.getMessage());
        }
    }

//Löscht alle Termine in der terminListe Datei, also resettet sie     
    public void loescheAlleTermine(PKWVerwaltung pkwVerwaltung) {
        terminListe.clear(); // Alle Termine aus der Liste entfernen
        speichereTerminListeAlsDatei("terminListe.ser"); // Leere Liste in die Datei schreiben
    
        // Rufe die Methode aus der PKWVerwaltung auf, um alle PKWs auf entbucht zu setzen
        pkwVerwaltung.PKWentbucheAlle();
        
        System.out.println("Alle Termine wurden gelöscht und alle PKWs wurden entbucht.");
    }

//Methode zum Buchen eines PKWs über seine ID, und den Buchungszeitraum der inform von Int's übergeben wird     
    public void buchePKW(int pkwId, int startTag, int startMonat, int startJahr, int endeTag, int endeMonat, int endeJahr) {
        try {
            LocalDateTime von = LocalDateTime.of(startJahr, startMonat, startTag, 0, 0);
            LocalDateTime bis = LocalDateTime.of(endeJahr, endeMonat, endeTag, 23, 59, 59);
            validateDate(von);
            validateDate(bis);
            if (von.isAfter(bis)) {
                throw new IllegalArgumentException("Startdatum muss vor dem Enddatum liegen.");
            }
            
            PKW pkw = findePKWNachId(pkwId);
            if (pkw == null) {
                throw new IllegalArgumentException("PKW mit ID " + pkwId + " nicht gefunden.");
            }
    
            // Überprüfen auf Überschneidung
            for (Termin termin : terminListe) {
                if (termin.getPkw().equals(pkw) && termin.isGebucht()) {
                    LocalDateTime terminVon = termin.getStartzeitpunkt();
                    LocalDateTime terminBis = termin.getEndzeitpunkt();
                    if (!(bis.isBefore(terminVon) || von.isAfter(terminBis))) {
                        throw new IllegalArgumentException("PKW " + pkwId + " ist bereits im Zeitraum " + terminVon + " bis " + terminBis + " gebucht.");
                    }
                }
            }
    
            Termin termin = new Termin(terminIDCounter++, null, pkw, von, bis);
            termin.setGebucht(true);
            terminListe.add(termin);
            System.out.println("PKW " + pkw.getId() + " gebucht von " + von + " bis " + bis);
            speichereTerminListeAlsDatei("terminListe.ser");
    
        } catch (DateTimeException | IllegalArgumentException e) {
            System.err.println("Fehler bei der Buchung: " + e.getMessage());
        }
    }

//Entbuchung eines PKWs über seine ID und den Zeitraum über Int's     
    public void entbuchePKW(int pkwId, int startTag, int startMonat, int startJahr, int endeTag, int endeMonat, int endeJahr) {
        try {
            PKW pkw = findePKWNachId(pkwId);
            if (pkw == null) {
                throw new IllegalArgumentException("PKW mit ID " + pkwId + " nicht gefunden.");
            }
            LocalDateTime von = LocalDateTime.of(startJahr, startMonat, startTag, 0, 0);
            LocalDateTime bis = LocalDateTime.of(endeJahr, endeMonat, endeTag, 23, 59, 59);
            validateDate(von);
            validateDate(bis);
            if (von.isAfter(bis)) {
                throw new IllegalArgumentException("Startdatum muss vor dem Enddatum liegen.");
            }
    
            List<Termin> zuEntfernendeTermine = new ArrayList<>();
            List<Termin> neueTermine = new ArrayList<>();
            for (Termin termin : terminListe) {
                if (termin.getPkw().equals(pkw) && termin.isGebucht()) {
                    if (!(bis.isBefore(termin.getStartzeitpunkt()) || von.isAfter(termin.getEndzeitpunkt()))) {
                        zuEntfernendeTermine.add(termin);
    
                        if (von.isAfter(termin.getStartzeitpunkt()) && bis.isBefore(termin.getEndzeitpunkt())) {
                            neueTermine.add(new Termin(terminIDCounter++, termin.getKunde(), termin.getPkw(), termin.getStartzeitpunkt(), von.minusSeconds(1)));
                            neueTermine.add(new Termin(terminIDCounter++, termin.getKunde(), termin.getPkw(), bis.plusSeconds(1), termin.getEndzeitpunkt()));
                        } else if (von.isAfter(termin.getStartzeitpunkt())) {
                            neueTermine.add(new Termin(terminIDCounter++, termin.getKunde(), termin.getPkw(), termin.getStartzeitpunkt(), von.minusSeconds(1)));
                        } else if (bis.isBefore(termin.getEndzeitpunkt())) {
                            neueTermine.add(new Termin(terminIDCounter++, termin.getKunde(), termin.getPkw(), bis.plusSeconds(1), termin.getEndzeitpunkt()));
                        }
                    }
                }
            }
            terminListe.removeAll(zuEntfernendeTermine);
            terminListe.addAll(neueTermine);
            System.out.println("PKW " + pkw.getId() + " wurde entbucht von " + von + " bis " + bis);
            speichereTerminListeAlsDatei("terminListe.ser");
        } catch (DateTimeException | IllegalArgumentException e) {
            System.err.println("Fehler bei der Entbuchung: " + e.getMessage());
        }
    }

//Speicherung der Termine in der terminListe Datei 
    public void speichereTerminListeAlsDatei() {
        speichereTerminListeAlsDatei("terminListe.ser");
        System.out.println("Terminliste erfolgreich in Datei gespeichert");
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
