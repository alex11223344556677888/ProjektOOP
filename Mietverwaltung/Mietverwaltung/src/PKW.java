public class PKW extends KFZ{
    private float fzghöhe;
    private float fzgbreite;
    private float ladelänge;
    private float ladevolumen;
    private int fzggewicht;
    private int zulässigesgewicht;

    public PKW (float fzghöhe,float fzgbreite,int fzggewicht, int zulässigesgewicht,
    String fzgkategorie,String getriebe,String motorisierung,String farbe,String ausstattung ,boolean klimatisiert ,boolean beheizt,
     int anzahltüren,int sitzplätze,int co2emission,int minalter,String fuehrerscheinklasse,String kennzeichen, int fzgnummer,boolean gebucht, boolean navi, String kraftstoff){

    super(fzgkategorie, getriebe, motorisierung, farbe, ausstattung , klimatisiert , beheizt, anzahltüren, sitzplätze, co2emission, 
        minalter,fuehrerscheinklasse,fzgnummer,kennzeichen,gebucht); 


    }
    public float getFzghöhe() {
        return fzghöhe;
    }
    public void setFzghöhe(float fzghöhe) {
        this.fzghöhe = fzghöhe;
    }
    public float getFzgbreite() {
        return fzgbreite;
    }
    public void setFzgbreite(float fzgbreite) {
        this.fzgbreite = fzgbreite;
    }
    public float getLadelänge() {
        return ladelänge;
    }
    public void setLadelänge(float ladelänge) {
        this.ladelänge = ladelänge;
    }
    public float getLadevolumen() {
        return ladevolumen;
    }
    public void setLadevolumen(float ladevolumen) {
        this.ladevolumen = ladevolumen;
    }
    public int getFzggewicht() {
        return fzggewicht;
    }
    public void setFzggewicht(int fzggewicht) {
        this.fzggewicht = fzggewicht;
    }
    public int getZulässigesgewicht() {
        return zulässigesgewicht;
    }
    public void setZulässigesgewicht(int zulässigesgewicht) {
        this.zulässigesgewicht = zulässigesgewicht;
    }
    public void PrintLkw(){
        super.Print();
        System.out.println();
        System.out.println("Die Fahrzeuglänge beträgt: "+fzghöhe+"m");
        System.out.println("Die Fahrzeugbreite beträgt: "+fzgbreite+"m");
        System.out.println();
        System.out.println("Die Ladelänge beträgt: "+ladelänge+"m");
        System.out.println("Das Ladevolumen beträgt: "+ladevolumen+"m^3");
        System.out.println();
        System.out.println("Das Fahrzeuggewicht beträgt: "+fzggewicht+"kg");
        System.out.println("Das maximal zulässige Gewicht des Fahrzeugs beträgt: "+zulässigesgewicht+"kg");
        System.out.println("____________________________________");
    }
    
}
