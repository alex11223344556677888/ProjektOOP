import java.util.Scanner;
public class App 
{
    public static void main(String[] args) throws Exception 
    {
       
        Scanner scanner = new Scanner(System.in);
        boolean end = false;

      
        do 
        {
            System.out.println("Möchten Sie das Programm starten?");
            System.out.println("[1] Starten");
            System.out.println("[2] Beenden");

            int eingabe = scanner.nextInt();

            switch (eingabe) 
            {
                case 1:
                    System.out.println("Programm gestartet.");
                    //Programm2();
                    break;
                case 2:
                    end = true;
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte wählen Sie 1 oder 2.");
            }
        
        } while (!end);
            System.out.println("Programm beendet.");
    }
}


