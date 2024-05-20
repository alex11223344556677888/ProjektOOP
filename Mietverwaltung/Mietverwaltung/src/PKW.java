public class PKW extends KFZ{
    private float fzghöhe;
    private float fzgbreite;
    private String kraftstoff;
    private boolean navi;
    private int minalter;
    private String motorleistung;
    private int anzahltüren;
    private int sitzplätze;
    private String getriebe; 
    private boolean klimatisiert;
    private boolean beheizt;

    public PKW (float fzghöhe,float fzgbreite,int fzggewicht, int zulässigesgewicht,
    String fzgkategorie,String getriebe,int motorleistung,String farbe,String ausstattung ,boolean klimatisiert ,boolean beheizt,
     int anzahltüren,int sitzplätze,int co2emission,int minalter,String fuehrerscheinklasse,String kennzeichen, int fzgnummer,boolean gebucht, boolean navi, String kraftstoff){

    super(fzgkategorie, getriebe, motorleistung, farbe, ausstattung , klimatisiert , beheizt, anzahltüren, sitzplätze, co2emission, 
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



    public String getKraftstoff() {
        return kraftstoff;
    }



    public void setKraftstoff(String kraftstoff) {
        this.kraftstoff = kraftstoff;
    }



    public boolean isNavi() {
        return navi;
    }



    public void setNavi(boolean navi) {
        this.navi = navi;
    }



    public int getMinalter() {
        return minalter;
    }



    public void setMinalter(int minalter) {
        this.minalter = minalter;
    }



    public String getMotorisierung() {
        return motorleistung;
    }



    public void setMotorisierung(String motorisierung) {
        this.motorleistung = motorisierung;
    }



    public int getAnzahltüren() {
        return anzahltüren;
    }



    public void setAnzahltüren(int anzahltüren) {
        this.anzahltüren = anzahltüren;
    }



    public int getSitzplätze() {
        return sitzplätze;
    }



    public void setSitzplätze(int sitzplätze) {
        this.sitzplätze = sitzplätze;
    }



    public String getGetriebe() {
        return getriebe;
    }



    public void setGetriebe(String getriebe) {
        this.getriebe = getriebe;
    }



    public boolean isKlimatisiert() {
        return klimatisiert;
    }



    public void setKlimatisiert(boolean klimatisiert) {
        this.klimatisiert = klimatisiert;
    }



    public boolean isBeheizt() {
        return beheizt;
    }



    public void setBeheizt(boolean beheizt) {
        this.beheizt = beheizt;
    }



    public void PrintLkw(){
        super.Print();
        System.out.println();
        System.out.println("Die Fahrzeuglänge beträgt: "+fzghöhe+"m");
        System.out.println("Die Fahrzeugbreite beträgt: "+fzgbreite+"m");

        System.out.println();
        System.out.println("Der Kraftstoff ist "+kraftstoff);
        System.out.println();
        System.out.println("____________________________________");
    }
    
}
