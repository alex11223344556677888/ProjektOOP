package de.autovermietung.testklassen;

import de.autovermietung.fachklassen.PKW;
import de.autovermietung.verwaltungsklassen.PKWVerwaltung;
import java.util.List;

public class PKWtest  {

	// public static void main(String[] args) {

	// 	PKWVerwaltung pkwVerwaltung = new PKWVerwaltung();

   pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "VW", "Automatik", 75, "Blau", "Basis", "Benzin", true, true, 2015, 3, 5, 120, 18, "B", 1234, "VB-1234", false, true, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("Limousine", "Audi", "Schaltgetriebe", 110, "Schwarz", "Komfort", "Diesel", true, true, 2018, 4, 5, 140, 20, "B", 5678, "AB-5678", false, true, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("SUV", "Mercedes", "Automatik", 150, "Silber", "Luxus", "Benzin", true, true, 2020, 5, 7, 180, 22, "A", 9012, "ME-9012", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "Opel", "Schaltgetriebe", 60, "Rot", "Basis", "Diesel", false, false, 2012, 3, 4, 100, 16, "B", 3456, "OP-3456", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("Limousine", "BMW", "Automatik", 120, "Weiß", "Komfort", "Benzin", true, true, 2019, 4, 5, 140, 20, "A", 7890, "BM-7890", true, true, true, true, false);
        pkwVerwaltung.pkwHinzufuegen("Coupe", "Porsche", "Automatik", 250, "Schwarz", "Luxus", "Elektro", true, true, 2022, 5, 7, 200, 24, "A", 1111, "PO-1111", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Kombi", "VW", "Schaltgetriebe", 100, "Silber", "Basis", "Diesel", false, false, 2015, 3, 5, 120, 18, "B", 2345, "VW-2345", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("Coupe", "Porsche", "Automatik", 300, "Rot", "Luxus", "Benzin", true, true, 2020, 2, 4, 220, 26, "A", 5678, "PO-5678", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Limousine", "Audi", "Schaltgetriebe", 110, "Blau", "Komfort", "Diesel", true, true, 2018, 4, 5, 140, 20, "A", 9012, "AU-9012", true, true, true, true, false);
        pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "Opel", "Automatik", 70, "Weiß", "Basis", "Benzin", false, false, 2013, 3, 4, 100, 16, "B", 3456, "OP-3456", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("SUV", "Mercedes", "Schaltgetriebe", 130, "Silber", "Luxus", "Diesel", true, true, 2021, 5, 7, 160, 22, "A", 1234, "ME-1234", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("SUV", "BMW", "Automatik", 200, "Schwarz", "Komfort", "Elektro", true, true, 2022, 5, 7, 180, 24, "A", 7890, "BM-7890", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Kombi", "Opel", "Schaltgetriebe", 90, "Grau", "Basis", "Benzin", false, false, 2016, 3, 5, 110, 18, "B", 5678, "OP-5678", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "VW", "Schaltgetriebe", 65, "Rot", "Basis", "Benzin", false, false, 2014, 3, 4, 100, 16, "B", 9012, "VW-9012", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("Limousine", "Audi", "Automatik", 125, "Silber", "Komfort", "Diesel", true, true, 2019, 4, 5, 140, 20, "A", 3456, "AU-3456", true, true, true, true, false);
        pkwVerwaltung.pkwHinzufuegen("SUV", "Mercedes", "Schaltgetriebe", 145, "Weiß", "Luxus", "Benzin", true, true, 2021, 5, 7, 160, 22, "A", 1234, "ME-1234", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Cabrio", "Porsche", "Automatik", 220, "Schwarz", "Luxus", "Elektro", true, true, 2022, 5, 7, 200, 24, "A", 7890, "PO-7890", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Kombi", "Opel", "Schaltgetriebe", 105, "Grau", "Basis", "Diesel", false, false, 2017, 3, 5, 120, 18, "B", 5678, "OP-5678", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("Cabrio", "Porsche", "Automatik", 350, "Rot", "Luxus", "Benzin", true, true, 2020, 2, 4, 250, 28, "A", 1111, "PO-1111", true, true, true, true, true);
        pkwVerwaltung.pkwHinzufuegen("Limousine", "BMW", "Schaltgetriebe", 115, "Blau", "Komfort", "Benzin", true, true, 2018, 4, 5, 130, 20, "A", 9012, "BM-9012", true, true, true, true, false);
        pkwVerwaltung.pkwHinzufuegen("Kleinwagen", "VW", "Automatik", 75, "Gelb", "Basis", "Benzin", false, false, 2015, 3, 4, 100, 16, "B", 3456, "VW-3456", false, false, false, false, false);
        pkwVerwaltung.pkwHinzufuegen("SUV", "Mercedes", "Schaltgetriebe", 160, "Silber", "Luxus", "Diesel", true, true, 2021, 5, 7, 180, 24, "A", 1234, "ME-1234", true, true, true, true, true);
        
        System.out.println();
        pkwVerwaltung.pkwSpeichern();

    //     //pkwVerwaltung.sortierePKWListeNachMotorisierung();
    //     //pkwVerwaltung.sortierePKWListeNachBaujahr();
    //     //pkwVerwaltung.sortierePKWListeNachID();
    //     //pkwVerwaltung.filterPKW("antrieb", "Diesel");
	// 	 //pkwVerwaltung.pkwListeAusgebenKurz();

    //     //  System.out.println("Filter nach Marke BMW");
    //     //  List<PKW> gefilterteListe = pkwVerwaltung.filterPKW("marke", "BMW");
    //     //  System.out.println();
    //     //  System.out.println("Filter nach Automatikgetriebe");
    //     //  List<PKW> gefilterteListe2 = pkwVerwaltung.filterPKW("antrieb", "Automatik");
    //     //  System.out.println();
    //     //  System.out.println("Filter nach Farbe weiß");
    //     //  List<PKW> gefilterteListe3 = pkwVerwaltung.filterPKW("farbe", "Weiß");
    //     //  System.out.println();
    //     //  System.out.println("Filter nach Fahrzeugtyp Cabrio");
    //     //  List<PKW> gefilterteListe4 = pkwVerwaltung.filterPKW("fahrzeugtyp", "Cabrio");
    //     //  System.out.println();
    //     //  pkwVerwaltung.sortierePKWListeNachID(gefilterteListe);
    //     //  pkwVerwaltung.sortierePKWListeNachID(gefilterteListe2);
    //     //  pkwVerwaltung.sortierePKWListeNachID(gefilterteListe3);
    //     //  pkwVerwaltung.sortierePKWListeNachID(gefilterteListe4);
    //     //  pkwVerwaltung.sortierePKWListeNachBaujahr(gefilterteListe);
    //     //  pkwVerwaltung.sortierePKWListeNachBaujahr(gefilterteListe2);
    //     //  pkwVerwaltung.sortierePKWListeNachBaujahr(gefilterteListe3);
    //     //  pkwVerwaltung.sortierePKWListeNachBaujahr(gefilterteListe4);
    //     //  pkwVerwaltung.sortierePKWListeNachMotorisierung(gefilterteListe);
    //     //  pkwVerwaltung.sortierePKWListeNachMotorisierung(gefilterteListe2);
    //     //  pkwVerwaltung.sortierePKWListeNachMotorisierung(gefilterteListe3);
    //     //  pkwVerwaltung.sortierePKWListeNachMotorisierung(gefilterteListe4);

        
         
    //     //  pkwVerwaltung.buchePKW(1002);
    //     //  pkwVerwaltung.ausgebenPKW(1002);

    //      pkwVerwaltung.pkwListeAusgebenAusDatei();
    //     //  pkwVerwaltung.pkwLoeschenAusDatei(1010);
    //     //  pkwVerwaltung.pkwLoeschenAusDatei(1012);
    //     //  pkwVerwaltung.pkwLoeschenAusDatei(1009);
    //     //  pkwVerwaltung.pkwLoeschenAusDatei(1008);
    //     //  pkwVerwaltung.filterPKW("elektro", "true");
    //     //  pkwVerwaltung.pkwListeAusgebenAusDatei();
    //     //  pkwVerwaltung.buchePKW(1003);
    //     //  pkwVerwaltung.buchePKW(1004);
    //     //  pkwVerwaltung.buchePKW(1005);
    //     //  pkwVerwaltung.buchePKW(1006);
    //     //  pkwVerwaltung.buchePKW(1007);
    //     //  pkwVerwaltung.entbuchePKW(1003);
    //     //  pkwVerwaltung.entbuchePKW(1004);
    //     //  pkwVerwaltung.entbuchePKW(1005);
    //     //  pkwVerwaltung.entbuchePKW(1006);
    //     //  pkwVerwaltung.entbuchePKW(1007);

     
        

       
	// }
    

} 
