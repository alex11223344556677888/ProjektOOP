package de.autovermietung.testklassen;

import de.autovermietung.fachklassen.PKW;
import de.autovermietung.verwaltungsklassen.PKWVerwaltung;
import java.util.List;

public class PKWtest  {

	public static void main(String[] args) {
		PKWVerwaltung pkwVerwaltung = new PKWVerwaltung();

        pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "Volkswagen", "Automatik", 75, "Blau", " Basis", "Benzin", true, true, 2015, 3, 5, 120, 18, "B", 1234, "VB-1234", false, true);
        pkwVerwaltung.pkwHinzufuegen("Mittelklasse", "Audi", "Schaltgetriebe", 110, "Schwarz", "Komfort", "Diesel", true, true, 2018, 4, 5, 140, 20, "B", 5678, "AB-5678", false, true);
        pkwVerwaltung.pkwHinzufuegen("Oberklasse", "Mercedes", "Automatik", 220, "Weiß", "Luxus", "Benzin", true, true, 2020, 4, 5, 180, 25, "B", 9012, "MB-9012", false, true);
        pkwVerwaltung.pkwHinzufuegen("Kompaktklasse", "Opel", "Schaltgetriebe", 90, "Rot", "Sport", "Benzin", true, true, 2012, 3, 5, 130, 19, "B", 3456, "OL-3456", false, false);
        pkwVerwaltung.pkwHinzufuegen("SUV", "Toyota", "Automatik", 150, "Silber", "Premium", "Diesel", true, true, 2019, 5, 7, 160, 22, "B", 7890, "TY-7890", false, true);
        pkwVerwaltung.pkwHinzufuegen("Cabrio", "BMW", "Schaltgetriebe", 180, "Weiß", "Luxus", "Benzin", true, true, 2016, 2, 4, 190, 24, "B", 1111, "BM-1111", false, true);
        pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "Ford", "Automatik", 60, "Gelb", "Basis", "Benzin", true, true, 2014, 3, 5, 110, 17, "B", 4321, "FO-4321", false, true);
        pkwVerwaltung.pkwHinzufuegen("Mittelklasse", "Skoda", "Schaltgetriebe", 100, "Grau", "Komfort", "Diesel", true, true, 2017, 4, 5, 130, 20, "B", 6543, "SK-6543", false, true);
        pkwVerwaltung.pkwHinzufuegen("Oberklasse", "Porsche", "Automatik", 250, "Schwarz", "Luxus", "Benzin", true, true, 2022, 4, 5, 200, 28, "B", 9876, "PO-9876", false, true);
        pkwVerwaltung.pkwHinzufuegen("Kompaktklasse", "Renault", "Schaltgetriebe", 80, "Blau", "Sport", "Benzin", true, true, 2013, 3, 5, 120, 18, "B", 2109, "RE-2109", false, false);
        pkwVerwaltung.pkwHinzufuegen("SUV", "Nissan", "Automatik", 170, "Silber", "Premium", "Diesel", true, true, 2020, 5, 7, 170, 23, "B", 8765, "NI-8765", false, true);
        pkwVerwaltung.pkwHinzufuegen("Cabrio", "Mini", "Schaltgetriebe", 160, "Rot", "Luxus", "Benzin", true, true, 2018, 2, 4, 180, 25, "B", 5678, "MI-5678", false, true);
        pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "Peugeot", "Automatik", 70, "Weiß", "Basis", "Benzin", true, true, 2016, 3, 5, 100, 16, "B", 3456, "PE-3456", false, true);
        pkwVerwaltung.pkwHinzufuegen("Mittelklasse", "Hyundai", "Schaltgetriebe", 120, "Grau", "Komfort", "Diesel", true, true, 2019, 4, 5, 140, 21, "B", 1234, "HY-1234", false, true);
        pkwVerwaltung.pkwHinzufuegen("Oberklasse", "Jaguar", "Automatik", 280, "Schwarz", "Luxus", "Benzin", true, true, 2021, 4, 5, 220, 30, "B", 9012, "JA-9012", false, true);
        pkwVerwaltung.pkwHinzufuegen("Kompaktklasse", "Kia", "Schaltgetriebe", 95, "Blau", "Sport", "Benzin", true, true, 2015, 3, 5, 125, 19, "B", 4567, "KI-4567", false, false);

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

       
	}

}