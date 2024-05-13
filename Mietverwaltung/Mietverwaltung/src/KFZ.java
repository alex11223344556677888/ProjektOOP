public class KFZ {
    
    //Eigenschaften 

    private String fzgkategorie;
    private String getriebe;
    private String motorisierung;
    private String farbe;
    private String ausstattung;

    private boolean klimatisiert;
    private boolean beheizt;

    private int anzahltüren;
    private int sitzplätze;
    private int co2emission;
    private int minalter;

        //Konstruktor

    public KFZ(String fzgkategorie,String getriebe,String motorisierung,String farbe,String ausstattung ,boolean klimatisiert ,boolean beheizt, int anzahltüren,int sitzplätze,int co2emission,int minalter){
        this.fzgkategorie = fzgkategorie;
        this.getriebe =getriebe;
        this.motorisierung = motorisierung;
        this.farbe = farbe;
        this.ausstattung = ausstattung;
        this.klimatisiert = klimatisiert;
        this.beheizt = beheizt;
        this.anzahltüren = anzahltüren;
        this.sitzplätze = sitzplätze;
        this.co2emission = co2emission;
        this.minalter = minalter;
    }

        //Getters & Setters

    public String getFzgkategorie() {return fzgkategorie;}

    public void setFzgkategorie(String fzgkategorie) {this.fzgkategorie = fzgkategorie;}

    public String getGetriebe() { return getriebe;}

    public void setGetriebe(String getriebe) {this.getriebe = getriebe;}

    public String getMotorisierung() {return motorisierung;}

    public void setMotorisierung(String motorisierung) {this.motorisierung = motorisierung;}

    public String getFarbe() {return farbe;}

    public void setFarbe(String farbe) {this.farbe = farbe;}

    public String getAusstattung() {return ausstattung;}

    public void setAusstattung(String ausstattung) {this.ausstattung = ausstattung;}

    public boolean isKlimatisiert() {return klimatisiert;}

    public void setKlimatisiert(boolean klimatisiert) {this.klimatisiert = klimatisiert;}

    public boolean isBeheizt() {return beheizt;}

    public void setBeheizt(boolean beheizt) { this.beheizt = beheizt;}

    public int getAnzahltüren() {return anzahltüren;}

    public void setAnzahltüren(int anzahltüren) {this.anzahltüren = anzahltüren;}

    public int getSitzplätze() {return sitzplätze;}

    public void setSitzplätze(int sitzplätze) {this.sitzplätze = sitzplätze;}

    public int getC2emission() {return co2emission;}

    public void setCo2emission(int co2emission) {this.co2emission = co2emission;}

    public void setminalter(int minalter){this.minalter = minalter;}
    
    public int getminalter(){return minalter;}

    public void Print(){
        System.out.println("_________________________________");
        System.out.println("Fahrzeugkategorie: "+fzgkategorie);
        System.out.println("Getriebart: "+getriebe);
        System.out.println("Antriebsart: "+motorisierung);
        System.out.println("Farbe des Fahrzeugs: "+farbe);
        System.out.println("Ausstatungpaket: "+ausstattung);
        System.out.println();
        System.out.println("Ist Klimatisiert: "+klimatisiert);
        System.out.println("Ist Behihzt: "+beheizt);
        System.out.println();
        System.out.println("Anzahl der Türen: "+anzahltüren);
        System.out.println("Anzahl der Sitzplätze: "+sitzplätze);
        System.out.println("Co2-Emissionen: "+co2emission);
        System.out.println();
        System.out.println("Mindest alter für das Fahrzeug: "+minalter);
        
    }

   
}
