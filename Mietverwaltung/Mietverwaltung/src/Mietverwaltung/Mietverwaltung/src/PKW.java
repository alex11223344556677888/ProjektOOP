public class PKW extends KFZ{


 

    public PKW(String fzgkategorie,String getriebe,String farbe,String ausstattung ,boolean klimatisiert ,boolean beheizt, int anzahltüren,int sitzplätze,int co2emission,int minalter,String führerscheinklasse, int fzgnummer, String kennzeichen,boolean gebucht, int motorleistung,String kraftstoff,boolean navi){
        super(fzgkategorie, getriebe,farbe,ausstattung , klimatisiert , beheizt,  anzahltüren, sitzplätze,co2emission, minalter,führerscheinklasse,  fzgnummer, kennzeichen, gebucht,  motorleistung, kraftstoff,navi);
    }
    


    public void PrintPKW(){
        super.Print();
        
    }
    
}
