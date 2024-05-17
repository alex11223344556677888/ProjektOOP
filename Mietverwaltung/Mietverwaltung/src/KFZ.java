public class KFZ {
    
    //Eigenschaften 

    private String fzgkategorie;
    private String getriebe;
    private String motorisierung;
    private String farbe;
    private String ausstattung;
    private String führerscheinklasse;
    private String kennzeichen;

    private boolean klimatisiert;
    private boolean beheizt;
    private boolean gebucht;

    private int anzahltüren;
    private int sitzplätze;
    private int co2emission;
    private int minalter;
    private int fzgnummer; 
    

        //Konstruktor

    public KFZ(String fzgkategorie,String getriebe,String motorisierung,String farbe,String ausstattung ,boolean klimatisiert ,boolean beheizt, int anzahltüren,int sitzplätze,int co2emission,int minalter,String führerscheinklasse, int fzgnummer, String kennzeichen,boolean gebucht){
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
        this.führerscheinklasse = führerscheinklasse;
        this.fzgnummer = fzgnummer;
        this.kennzeichen = kennzeichen; 
        this.gebucht = gebucht;
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

    public int getCo2emission() {return co2emission;}

    public void setCo2emission(int co2emission) {this.co2emission = co2emission;}

    public void setMinalter(int minalter){this.minalter = minalter;}
    
    public int getMinalter(){return minalter;}

    public void setFührerscheinklasse(String führerscheinklasse){this.führerscheinklasse=führerscheinklasse;}

    public String getFührerscheinklasse(){return führerscheinklasse;}

    public int getFzgnummer() {return fzgnummer;}

    public void setFzgnummer(int fzgnummer) {this.fzgnummer = fzgnummer;}

    public String getKennzeichen() {return kennzeichen;}

    public void setKennzeichen(String kennzeichen) {this.kennzeichen = kennzeichen;}

    public boolean isGebucht() {return gebucht;}

    public void setGebucht(boolean gebucht) {this.gebucht = gebucht;}


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
