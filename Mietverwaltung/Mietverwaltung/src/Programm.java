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


    public static void Kundenanlegen()
    {
        System.out.println("Hat Kunde bereits ein Konto ?");
        System.out.println("[1] ja ");
        System.out.println("[2] nein");

        Scanner scanner =new Scanner(System.in);
        int eingabe = scanner.nextInt();

        switch (eingabe) 
            {
                case 1:
                    
                    bestandskundenAufnehmen();
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

    public static void neuKundenaufnehmen() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        
        while (!valid) {
            Kunde konto1 = new Kunde(null, null, null, 0);
            
            System.out.println("Wie lautet der Vorname des Kunden: ");
            String vorname = scanner.nextLine();
            konto1.setVorname(vorname);

            System.out.println("Wie lautet der Nachname des Kunden: ");
            String nachname = scanner.nextLine();
            konto1.setNachname(nachname);

            System.out.println("Wie alt ist der Kunde: ");
            int alter = getIntInput(scanner);
            konto1.setAge(alter);

            System.out.println("Welche Führerscheinklasse besitzt der Kunde ? ");
            String führerscheinklasse = scanner.nextLine();
            konto1.setFührerscheinklasse(führerscheinklasse);

            System.out.println("Anschrift des Kunden: ");
            System.out.println("Straße:");
            String straße = scanner.nextLine();
            konto1.setStraße(straße);

            System.out.println("Hausnummer: ");
            int hausnummer = getIntInput(scanner);
            konto1.setHausnummer(hausnummer);

            System.out.println("Postleitzahl: ");
            int postleitzahl = getIntInput(scanner);
            konto1.setPostleitzahl(postleitzahl);

            System.out.println("Ort: ");
            String ort = scanner.nextLine();
            konto1.setOrt(ort);

            System.out.println("Telefonnummer des Kunden: ");
            int telefonnummer = getIntInput(scanner);
            konto1.setTelefonnummer(telefonnummer);

            System.out.println("Email des Kunden: ");
            String emailadresse = scanner.nextLine();
            konto1.setEmail(emailadresse);
            
            System.out.println("Kundenkarte ausdrucken ?  (ja/nein)");
            String kundenkarteString = scanner.nextLine();
            boolean kundenkarte;
            if (kundenkarteString.equalsIgnoreCase("ja")) {
                kundenkarte = true;
                System.out.println("Kundenkarte wird ausgedruckt");
            } else if (kundenkarteString.equalsIgnoreCase("nein")) {
                kundenkarte = false;
                System.out.println("Fahre fort ohne Kundenkarte ");
            } else {
                System.out.println("Ungültige Eingabe. Standardmäßig wird die Kundenkarte nicht ausgedruckt.");
                kundenkarte = false; // Standardmäßig keine Kundenkarte ausdrucken
            }
            konto1.setKundenkarte(kundenkarte);

            int kundennummer = konto1.generiereEinzigartigeKundennummer(); //generieren 9-stellige Kundennummer
            konto1.setKundennummer(kundennummer);
            konto1.PrintKunde();

            // Überprüfen, ob die Eingaben korrekt sind
            System.out.println("Sind die Angaben korrekt? (ja/nein)");
            String antwort = scanner.nextLine();
            if (antwort.equalsIgnoreCase("ja")) {
                valid = true;
            } else {
                System.out.println("Bitte geben Sie die Informationen erneut ein.");
            }
        }
    }

    // Hilfsmethode zum Lesen von Integer-Eingaben
    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine ganze Zahl ein.");
            scanner.next(); // Verwerfen der ungültigen Eingabe
        }
        return scanner.nextInt();
    }
        
    

    public static void bestandskundenAufnehmen()
        {
            Scanner scanner = new Scanner(System.in);            

            Kunde konto1 = new Kunde(null, null, null, 0);

            //Kunden durch Kundennumer aus dem system auslesen
            System.out.println("Geben sie die Kundennummer ein: ");
            int gesuchteKundennummer = scanner.nextInt();
            Kunde gefundenerKunde = Kunde.findeKundeMitKundennummer(gesuchteKundennummer);
            if (gefundenerKunde != null) {
                System.out.println("Kunde gefunden");
                System.out.println("Vorname: "+gefundenerKunde.getVorname());
                System.out.println("Nachname: "+ gefundenerKunde.getNachname());
                System.out.println("Alter: "+gefundenerKunde.getAge());
                System.out.println("Telefonnummer: "+gefundenerKunde.getTelefonnummer());
                System.out.println("Email-adresse: "+gefundenerKunde.getEmail());
                System.out.println("Anschrift: "+gefundenerKunde.getAnschrift());
                konto1.PrintKunde();

            }else System.out.println("Kunde nicht gefunden !");

        }

}




