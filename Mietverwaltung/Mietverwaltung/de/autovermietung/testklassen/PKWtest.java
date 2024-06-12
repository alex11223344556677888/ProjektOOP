package de.autovermietung.testklassen;

import de.autovermietung.fachklassen.PKW;
import de.autovermietung.verwaltungsklassen.PKWVerwaltung;
import java.util.List;

public class PKWtest  {

	public static void main(String[] args) {

		PKWVerwaltung pkwVerwaltung = new PKWVerwaltung();

        pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "Volkswagen", "Automatik", 75, "Blau", "Basis", "Benzin", true, true, 2015, 3, 5, 120, 18, "B", 1234, "VB-1234", false, true, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("Mittelklasse", "Audi", "Schaltgetriebe", 110, "Schwarz", "Komfort", "Diesel", true, true, 2018, 4, 5, 140, 20, "B", 5678, "AB-5678", false, true, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("SUV", "Toyota", "Automatik", 150, "Silber", "Luxus", "Benzin", true, true, 2020, 5, 7, 180, 22, "A", 9012, "TY-9012", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "Fiat", "Schaltgetriebe", 60, "Rot", "Basis", "Diesel", false, false, 2012, 3, 4, 100, 16, "B", 3456, "FI-3456", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("Mittelklasse", "BMW", "Automatik", 120, "Weiß", "Komfort", "Benzin", true, true, 2019, 4, 5, 140, 20, "A", 7890, "BM-7890", true, true, true, true, false);
        pkwVerwaltung.pkwHinzufuegen("Elektroauto", "Tesla", "Automatik", 250, "Schwarz", "Luxus", "Elektro", true, true, 2022, 5, 7, 200, 24, "A", 1111, "TE-1111", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Kombi", "Volkswagen", "Schaltgetriebe", 100, "Grau", "Basis", "Diesel", false, false, 2015, 3, 5, 120, 18, "B", 2345, "VW-2345", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("Sportwagen", "Porsche", "Automatik", 300, "Rot", "Luxus", "Benzin", true, true, 2020, 2, 4, 220, 26, "A", 5678, "PO-5678", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Mittelklasse", "Audi", "Schaltgetriebe", 110, "Blau", "Komfort", "Diesel", true, true, 2018, 4, 5, 140, 20, "A", 9012, "AU-9012", true, true, true, true, false);
        pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "Peugeot", "Automatik", 70, "Gelb", "Basis", "Benzin", false, false, 2013, 3, 4, 100, 16, "B", 3456, "PE-3456", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("SUV", "Hyundai", "Schaltgetriebe", 130, "Silber", "Luxus", "Diesel", true, true, 2021, 5, 7, 160, 22, "A", 1234, "HY-1234", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Elektroauto", "Nissan", "Automatik", 200, "Weiß", "Komfort", "Elektro", true, true, 2022, 5, 7, 180, 24, "A", 7890, "NI-7890", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Kombi", "Ford", "Schaltgetriebe", 90, "Grau", "Basis", "Benzin", false, false, 2016, 3, 5, 110, 18, "B", 5678, "FO-5678", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "Kia", "Schaltgetriebe", 65, "Rot", "Basis", "Benzin", false, false, 2014, 3, 4, 100, 16, "B", 9012, "KI-9012", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("Mittelklasse", "Skoda", "Automatik", 125, "Silber", "Komfort", "Diesel", true, true, 2019, 4, 5, 140, 20, "A", 3456, "SK-3456", true, true, true, true, false);
        pkwVerwaltung.pkwHinzufuegen("SUV", "Mazda", "Schaltgetriebe", 145, "Weiß", "Luxus", "Benzin", true, true, 2021, 5, 7, 160, 22, "A", 1234, "MA-1234", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Elektroauto", "Rivian", "Automatik", 220, "Schwarz", "Luxus", "Elektro", true, true, 2022, 5, 7, 200, 24, "A", 7890, "RI-7890", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Kombi", "Opel", "Schaltgetriebe", 105, "Grau", "Basis", "Diesel", false, false, 2017, 3, 5, 120, 18, "B", 5678, "OP-5678", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("Sportwagen", "Lamborghini", "Automatik", 350, "Rot", "Luxus", "Benzin", true, true, 2020, 2, 4, 250, 28, "A", 1111, "LA-1111", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Mittelklasse", "Honda", "Schaltgetriebe", 115, "Blau", "Komfort", "Benzin", true, true, 2018, 4, 5, 130, 20, "A", 9012, "HO-9012", true, true, true, true, false);
        pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "Suzuki", "Automatik", 75, "Gelb", "Basis", "Benzin", false, false, 2015, 3, 4, 100, 16, "B", 3456, "SU-3456", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("SUV", "Jeep", "Schaltgetriebe", 160, "Silber", "Luxus", "Diesel", true, true, 2021, 5, 7, 180, 24, "A", 1234, "JE-1234", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Elektroauto", "Audi", "Automatik", 240, "Weiß", "Luxus", "Elektro", true, true, 2022, 5, 7, 220, 26, "A", 7890, "AU-7890", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Kombi", "Seat", "Schaltgetriebe", 100, "Grau", "Basis", "Benzin", false, false, 2016, 3, 5, 110, 18, "B", 5678, "SE-5678", false, false, false, false, false);
        System.out.println();
        
        //pkwVerwaltung.sortierePKWListeNachMotorisierung();
        //pkwVerwaltung.sortierePKWListeNachBaujahr();
        //pkwVerwaltung.sortierePKWListeNachID();
        //pkwVerwaltung.filterPKW("antrieb", "Diesel");
		 //pkwVerwaltung.pkwListeAusgebenKurz();

         System.out.println("Filter nach Marke BMW");
         List<PKW> gefilterteListe = pkwVerwaltung.filterPKW("marke", "BMW");
         System.out.println();
         System.out.println("Filter nach Automatikgetriebe");
         List<PKW> gefilterteListe2 = pkwVerwaltung.filterPKW("antrieb", "Automatik");
         System.out.println();
         System.out.println("Filter nach Farbe weiß");
         List<PKW> gefilterteListe3 = pkwVerwaltung.filterPKW("farbe", "Weiß");
         System.out.println();
         System.out.println("Filter nach Fahrzeugtyp Cabrio");
         List<PKW> gefilterteListe4 = pkwVerwaltung.filterPKW("fahrzeugtyp", "Cabrio");
         System.out.println();
         pkwVerwaltung.sortierePKWListeNachID(gefilterteListe);
         pkwVerwaltung.sortierePKWListeNachID(gefilterteListe2);
         pkwVerwaltung.sortierePKWListeNachID(gefilterteListe3);
         pkwVerwaltung.sortierePKWListeNachID(gefilterteListe4);
         pkwVerwaltung.sortierePKWListeNachBaujahr(gefilterteListe);
         pkwVerwaltung.sortierePKWListeNachBaujahr(gefilterteListe2);
         pkwVerwaltung.sortierePKWListeNachBaujahr(gefilterteListe3);
         pkwVerwaltung.sortierePKWListeNachBaujahr(gefilterteListe4);
         pkwVerwaltung.sortierePKWListeNachMotorisierung(gefilterteListe);
         pkwVerwaltung.sortierePKWListeNachMotorisierung(gefilterteListe2);
         pkwVerwaltung.sortierePKWListeNachMotorisierung(gefilterteListe3);
         pkwVerwaltung.sortierePKWListeNachMotorisierung(gefilterteListe4);

        
         
         pkwVerwaltung.buchePKW(1002);
         pkwVerwaltung.ausgebenPKW(1002);

         pkwVerwaltung.pkwListeAusgebenAusDatei();
         pkwVerwaltung.pkwLoeschenAusDatei(1013);
         pkwVerwaltung.pkwLoeschenAusDatei(1014);
         pkwVerwaltung.pkwLoeschenAusDatei(1015);
         pkwVerwaltung.pkwLoeschenAusDatei(1016);
         pkwVerwaltung.pkwListeAusgebenAusDatei();

        

       
	}

}
