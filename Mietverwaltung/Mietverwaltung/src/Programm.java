import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Programm {
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Automatische Beendigung nach 5 Minuten.");
                System.exit(0); // Beendet das Programm
            }
        }, 100000); // 5 Minuten in Millisekunden

        while (running) {
            System.out.println("Willkommen im Self service Programm der Autovermietung ?");
            System.out.println("Was möchten sie tun ?");
            System.out.println("[1] ein Fahrzeug  mieten");
            System.out.println("[2] nichts");
            System.out.println("[3] Testdaten laden");
            System.out.println("[4] Programm beenden");

            int eingabe = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (eingabe) {
                case 1:
                    Kundenanlegen();
                    break;
                case 2:
                    System.out.println("Kundenanlegung übersprungen.");
                    break;
                case 3:
                    ladeTestdaten();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte wählen Sie 1, 2, 3 oder 4.");
            }
        }

        scanner.close();
    }

    public static void Kundenanlegen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Haben sie bereits ein Konto?");
        System.out.println("[1] ja ");
        System.out.println("[2] nein");

        int eingabe = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (eingabe) {
            case 1:
                bestandskundenAufnehmen();
                break;
            case 2:
                neuKundenaufnehmen();
                break;
            default:
                System.out.println("Ungültige Eingabe. Bitte wählen Sie 1 oder 2.");
        }
    }

    public static void neuKundenaufnehmen() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;

        while (!valid) {
            System.out.println("Wie lautet ihr Vorname: ");
            String vorname = scanner.nextLine();

            System.out.println("Wie lautet ihr Nachname: ");
            String nachname = scanner.nextLine();

            System.out.println("Wie lautet ihr Geburtsdatum: (YYYY-MM-DD)");
            String geburtsdatum = scanner.nextLine();

            Kunde konto1 = new Kunde(vorname, nachname, geburtsdatum);

            System.out.println("Welche Führerscheinklasse besitzen sie: ");
            String fuehrerscheinklasse = scanner.nextLine();
            konto1.setFuehrerscheinklasse(fuehrerscheinklasse);

            System.out.println("ihre Anschrift:");
            System.out.println("Straße:");
            String strasse = scanner.nextLine();
            konto1.setStrasse(strasse);

            System.out.println("Hausnummer:");
            int hausnummer = getIntInput(scanner);
            konto1.setHausnummer(hausnummer);

            System.out.println("Postleitzahl:");
            int postleitzahl = getIntInput(scanner);
            konto1.setPostleitzahl(postleitzahl);

            System.out.println("Ort:");
            String ort = scanner.nextLine();
            konto1.setOrt(ort);

            System.out.println("Telefonnumme:");
            int telefonnummer = getIntInput(scanner);
            konto1.setTelefonnummer(telefonnummer);

            System.out.println("Email:");
            String emailadresse = scanner.nextLine();
            konto1.setEmail(emailadresse);

            System.out.println("Möchten sie eine Kundenkarte ausdrucken? (ja/nein)");
            String kundenkarteString = scanner.nextLine();
            boolean kundenkarte = kundenkarteString.equalsIgnoreCase("ja");
            konto1.setKundenkarte(kundenkarte);

            int kundennummer = Kunde.generiereEinzigartigeKundennummer();
            konto1.setKundennummer(kundennummer);
            Kunde.kundeHinzufuegen(konto1);
            konto1.PrintKunde();

            System.out.println("Sind die Angaben korrekt? (ja/nein)");
            String antwort = scanner.nextLine();
            if (antwort.equalsIgnoreCase("ja")) {
                valid = true;
            } else {
                System.out.println("Bitte geben Sie ihre Informationen erneut ein.");
            }
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine ganze Zahl ein.");
            scanner.next(); // Verwerfen der ungültigen Eingabe
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }

    public static void bestandskundenAufnehmen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben sie ihre Kundennummer ein: ");
        int gesuchteKundennummer = getIntInput(scanner);
        Kunde gefundenerKunde = Kunde.findeKundeMitKundennummer(gesuchteKundennummer);

        if (gefundenerKunde != null) {
            System.out.println("Konto gefunden");
            System.out.println("Vorname: " + gefundenerKunde.getVorname());
            System.out.println("Nachname: " + gefundenerKunde.getNachname());
            System.out.println("Alter: " + gefundenerKunde.getAge());
            System.out.println("Telefonnummer: " + gefundenerKunde.getTelefonnummer());
            System.out.println("Email-adresse: " + gefundenerKunde.getEmail());
            System.out.println("Anschrift: " + gefundenerKunde.getAnschrift());
            gefundenerKunde.PrintKunde();
        } else {
            System.out.println("Konto nicht gefunden!");
        }
    }

    public static void ladeTestdaten() {
        Kunde kunde1 = new Kunde("Max", "Mustermann", "1980-01-01");
        kunde1.setFuehrerscheinklasse("B");
        kunde1.setStrasse("Musterstraße");
        kunde1.setHausnummer(1);
        kunde1.setPostleitzahl(12345);
        kunde1.setOrt("Musterstadt");
        kunde1.setTelefonnummer(123456789);
        kunde1.setEmail("max.mustermann@example.com");
        kunde1.setKundenkarte(true);
        int kundennummer1 = Kunde.generiereEinzigartigeKundennummer();
        kunde1.setKundennummer(kundennummer1);
        Kunde.kundeHinzufuegen(kunde1);

        Kunde kunde2 = new Kunde("Erika", "Musterfrau", "1990-02-02");
        kunde2.setFuehrerscheinklasse("A");
        kunde2.setStrasse("Beispielweg");
        kunde2.setHausnummer(2);
        kunde2.setPostleitzahl(54321);
        kunde2.setOrt("Beispielstadt");
        kunde2.setTelefonnummer(987654321);
        kunde2.setEmail("erika.musterfrau@example.com");
        kunde2.setKundenkarte(false);
        int kundennummer2 = Kunde.generiereEinzigartigeKundennummer();
        kunde2.setKundennummer(kundennummer2);
        Kunde.kundeHinzufuegen(kunde2);

        System.out.println("Kunde1 Kundennummer: "+kunde1.getKundennummer());
        System.out.println("Kunde2 Kundennummer: "+kunde2.getKundennummer());

        System.out.println("Testdaten wurden geladen.");
    }
}




