import java.util.Scanner;

public class Programm {
  
    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);

        System.out.println("neuen Kunden anlegen ?");
        System.out.println("[1] ja");
        System.out.println("[2] nein");

        int eingabe = scanner.nextInt();

            switch (eingabe) 
            {
                case 1:
                    Kundenanlegen();
                    break;
                case 2:
                   // end=true;
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte wählen Sie 1 oder 2.");
            }

    }


    public static void Kundenanlegen(){
        System.out.println("Hat Kunde bereits ein Konto ?");
        System.out.println("[1] ja ");
        System.out.println("[2] nein");

        Scanner scanner =new Scanner(System.in);
        int eingabe = scanner.nextInt();

        switch (eingabe) 
            {
                case 1:
                    
                   // bestandskundenAufnehmen();
                   // Zeitraumplanung Verfügbarkeits abfragen/Funktionen
                    break;
                case 2:
                    neuKundenaufnehmen();
                    // Zeitraumplanung Verfügbarkeits abfragen/Funktionen
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte wählen Sie 1 oder 2.");
            }
    
    }

    public static void neuKundenaufnehmen(){

        Scanner scanner =new Scanner(System.in);
        
        Kunde konto1 = new Kunde(null, null, null, 0);
        System.out.println("Wie lautet der Vorname des Kunden: ");
        String vorname =scanner.nextLine();
        konto1.setVorname(vorname);

        System.out.println("Wie lautet der Nachname des Kunden: ");
        String nachname= scanner.nextLine();
        konto1.setNachname(nachname);

        System.out.println("Wie alt ist der kunde: ");
        Integer alter =scanner.nextInt();
        scanner.nextLine(); // Zeilenumbruch
        konto1.setAge(alter);

        System.out.println("Anschrift des Kunden: ");
        System.out.println("Straße:");
        String straße =scanner.nextLine();
        konto1.setStraße(straße);

        System.out.println("Hausnummer: ");
        int hausnummer =scanner.nextInt();
        scanner.nextLine();// Zeilenumbruch
        konto1.setHausnummer(hausnummer);

        System.out.println("Postleitzahl:");
        Integer postleitzahl =scanner.nextInt();
        konto1.setPostleitzahl(postleitzahl);

        System.out.println("Ort:");
        String ort =scanner.nextLine();
        konto1.setOrt(ort);

        System.out.println("Kundenkarte ausdrucken ?  (ja/nein)");
        String kundenkarteString = scanner.nextLine();
        boolean kundenkarte;
        if (kundenkarteString.equalsIgnoreCase("ja")) {
            kundenkarte = true;
        } else if (kundenkarteString.equalsIgnoreCase("nein")) {
            kundenkarte = false;
        } else {
            System.out.println("Ungültige Eingabe. Standardmäßig wird die Kundenkarte nicht ausgedruckt.");
            kundenkarte = false; // Standardmäßig keine Kundenkarte ausdrucken
        }
        konto1.setKundenkarte(kundenkarte);
        int kundennummer = konto1.Kundennummergenerieren(); //generieren 9-stellige Kundennummer
        konto1.setKundennummer(kundennummer);


        
    }

    public void bestandskundenAufnehmen(){

    }

}




