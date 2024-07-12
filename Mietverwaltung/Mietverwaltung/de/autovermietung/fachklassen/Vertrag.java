package autovermietung.Fachklassen;
import autovermietung.Fachklassen.Kunde;
import autovermietung.Fachklassen.PKW;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vertrag {
    private Kunde kunde;
    private PKW pkw;
    private LocalDate vertragsbeginn;
    private LocalDate vertragsende;
    private double mietpreis;
    private double kilometerpreis;
    private int gebuchteTage;
    private int gebuchteKilometer;

    private static List<Vertrag> vertragsliste = new ArrayList<>();

    public Vertrag(Kunde kunde, PKW pkw, LocalDate vertragsbeginn, LocalDate vertragsende, double mietpreis, double kilometerpreis, int gebuchteTage, int gebuchteKilometer) {
        this.kunde = kunde;
        this.pkw = pkw;
        this.vertragsbeginn = vertragsbeginn;
        this.vertragsende = vertragsende;
        this.mietpreis = mietpreis;
        this.kilometerpreis = kilometerpreis;
        this.gebuchteTage = gebuchteTage;
        this.gebuchteKilometer = gebuchteKilometer;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public PKW getPkw() {
        return pkw;
    }

    public LocalDate getVertragsbeginn() {
        return vertragsbeginn;
    }

    public LocalDate getVertragsende() {
        return vertragsende;
    }

    public double getMietpreis() {
        return mietpreis;
    }

    public double getKilometerpreis() {
        return kilometerpreis;
    }

    public int getGebuchteTage() {
        return gebuchteTage;
    }

    public int getGebuchteKilometer() {
        return gebuchteKilometer;
    }

    
    public String toString() {
        return "Vertrag{" +
                "Kunde: " + kunde.getName() + " " + kunde.getVorname() + ", Kundennummer: " + kunde.getKundennummer() +
                ", PKW: " + pkw.getFzgmarke() + " " + pkw.getFzgkategorie() + ", PKW-ID: " + pkw.getId() +
                ", Vertragsbeginn: " + vertragsbeginn +
                ", Vertragsende: " + vertragsende +
                ", Mietpreis: " + mietpreis +
                ", Kilometerpreis: " + kilometerpreis +
                ", Gebuchte Tage: " + gebuchteTage +
                ", Gebuchte Kilometer: " + gebuchteKilometer +
                '}';
    }
    
    public static void erstelleVertrag(Kunde kunde, PKW pkw, LocalDate vertragsbeginn, LocalDate vertragsende, double mietpreis, double kilometerpreis, int gebuchteTage, int gebuchteKilometer) {
        Vertrag vertrag = new Vertrag(kunde, pkw, vertragsbeginn, vertragsende, mietpreis, kilometerpreis, gebuchteTage, gebuchteKilometer);
        vertragsliste.add(vertrag);
    }

    public static void vertragAnzeigen() {
        for (Vertrag vertrag : vertragsliste) {
            System.out.println(vertrag);
        }
    }

    public static void vertragLoeschen(Vertrag vertrag) {
        vertragsliste.remove(vertrag);
    }

    public static void vertragBearbeiten(Vertrag vertrag, Kunde kunde, PKW pkw, LocalDate vertragsbeginn, LocalDate vertragsende, double mietpreis, double kilometerpreis, int gebuchteTage, int gebuchteKilometer) {
        vertrag.kunde = kunde;
        vertrag.pkw = pkw;
        vertrag.vertragsbeginn = vertragsbeginn;
        vertrag.vertragsende = vertragsende;
        vertrag.mietpreis = mietpreis;
        vertrag.kilometerpreis = kilometerpreis;
        vertrag.gebuchteTage = gebuchteTage;
        vertrag.gebuchteKilometer = gebuchteKilometer;
    }
}
