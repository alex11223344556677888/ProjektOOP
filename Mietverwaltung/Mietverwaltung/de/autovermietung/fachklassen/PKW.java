package de.autovermietung.fachklassen;

import java.io.Serializable;

public class PKW implements Serializable{
    private int id;
    private String fzgkategorie;
    private String fzgmarke;
    private String getriebe;
    private String kraftstoff;
    
    private String farbe;
    private String ausstattung;
    private String führerscheinklasse;
    private String kennzeichen;

    private boolean klimatisiert;
    private boolean beheizt;
    //
    private boolean gebucht;
    //
    private boolean navi;
    private boolean elektrofahrzeug;
    private boolean fahrassistent;
    private boolean parkassistent;

    
    private int anzahltüren;
    private int sitzplätze;
    private int co2emission;
    private int minalter;
    private int fzgnummer; 
    private int motorleistung;
    private int baujahr;

    private Termin termin;

        //Konstruktor

        public PKW(int id, String fzgkategorie, String fzgmarke, String getriebe, int motorleistung, String farbe, String ausstattung, String kraftstoff, boolean klimatisiert, boolean beheizt, int baujahr, int anzahltüren, int sitzplätze, int co2emission, int minalter, String führerscheinklasse, int fzgnummer, String kennzeichen, boolean gebucht, boolean navi, boolean elektrofahrzeug, boolean fahrassistent, boolean parkassistent) {
        this.id = id;
        this.fzgkategorie = fzgkategorie;
        this.getriebe =getriebe;
        this.motorleistung = motorleistung;
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
        this.fzgmarke = fzgmarke;
        this.fahrassistent = fahrassistent;
        this.parkassistent = parkassistent;
        this.elektrofahrzeug = elektrofahrzeug;
        this.baujahr = baujahr;
        this.kraftstoff = kraftstoff;
    }

    // @Override
    // public String toString() {
    //     return "PKW{" +
    //             "ID='" + id + '\'' +
    //             "Fzgkategorie='" + fzgkategorie + '\'' +
    //             ", Fahrzeugmarke='" + fzgmarke + '\'' +
    //             ", Getriebe='" + getriebe + '\'' +
    //             ", Kraftstoff='" + kraftstoff + '\'' +
    //             ", Farbe='" + farbe + '\'' +
    //             ", Ausstattung='" + ausstattung + '\'' +
    //             ", Führerscheinklasse='" + führerscheinklasse + '\'' +
    //             ", Kennzeichen='" + kennzeichen + '\'' +
    //             ", Klimatisiert=" + klimatisiert +
    //             ", Beheizt=" + beheizt +
    //             ", Gebucht=" + gebucht +
    //             ", Navi=" + navi +
    //             ", Anzahltüren=" + anzahltüren +
    //             ", Sitzplätze=" + sitzplätze +
    //             ", CO2-Emission=" + co2emission +
    //             ", Mindestalter=" + minalter +
    //             ", Fzgnummer=" + fzgnummer +
    //             ", Motorleistung=" + motorleistung +
    //             ", Baujahr=" + baujahr +
                
    //             '}';
    // }
    @Override
    public String toString() {
        return "PKW{ " +
                "Fzgkategorie='" + fzgkategorie + '\'' +
                ", Fahrzeugmarke='" + fzgmarke + '\'' +
                ", Baujahr=" + baujahr +
                
                '}';
    }
 
    public String getFzgkategorie() {
        return fzgkategorie;
    }

    public void setFzgkategorie(String fzgkategorie) {
        this.fzgkategorie = fzgkategorie;
    }

    public String getGetriebe() {
        return getriebe;
    }

    public void setGetriebe(String getriebe) {
        this.getriebe = getriebe;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String getAusstattung() {
        return ausstattung;
    }

    public void setAusstattung(String ausstattung) {
        this.ausstattung = ausstattung;
    }

    public String getFührerscheinklasse() {
        return führerscheinklasse;
    }

    public void setFührerscheinklasse(String führerscheinklasse) {
        this.führerscheinklasse = führerscheinklasse;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
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

    public boolean isGebucht() {
        return gebucht;
    }

    public void setGebucht(boolean gebucht) {
        this.gebucht = gebucht;
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

    public int getCo2emission() {
        return co2emission;
    }

    public void setCo2emission(int co2emission) {
        this.co2emission = co2emission;
    }

    public int getMinalter() {
        return minalter;
    }

    public void setMinalter(int minalter) {
        this.minalter = minalter;
    }

    public int getFzgnummer() {
        return fzgnummer;
    }

    public void setFzgnummer(int fzgnummer) {
        this.fzgnummer = fzgnummer;
    }

    public int getMotorleistung() {
        return motorleistung;
    }

    public void setMotorleistung(int motorleistung) {
        this.motorleistung = motorleistung;
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

    public String getFzgmarke() {
        return fzgmarke;
    }

    public void setFzgmarke(String fahrzeugmarke) {
        this.fzgmarke = fahrzeugmarke;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isElektrofahrzeug() {
        return elektrofahrzeug;
    }

    public void setElektrofahrzeug(boolean elektrofahrzeug) {
        this.elektrofahrzeug = elektrofahrzeug;
    }

    public boolean isFahrassistent() {
        return fahrassistent;
    }

    public void setFahrassistent(boolean fahrassistent) {
        this.fahrassistent = fahrassistent;
    }

    public boolean isParkassistent() {
        return parkassistent;
    }

    public void setParkassistent(boolean parkassistent) {
        this.parkassistent = parkassistent;
    }
    public boolean istGebucht() {
        return gebucht;
    }

    public void buchen(Termin termin) {
        if (!gebucht) {
            this.gebucht = true;
            this.termin = termin;
        } else {
            System.out.println("Der PKW ist bereits gebucht!");
        }
    }

    public void entbuchen() {
        if (gebucht) {
            this.gebucht = false;
            this.termin = null;
        } else {
            System.out.println("Der PKW ist nicht gebucht!");
        }
    }

    public Termin getTermin() {
        return termin;
    }
    
    public void setTermin(Termin termin) {
        this.termin = termin;
    }

}
