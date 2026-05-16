public class capteursol extends Capteurnum {

//constructeur
 public capteursol(String code,Statuscapt status,Plageseuil plageSeuils,String zoneID,Typemesure mesure) {
        super(code, status,plageSeuils,zoneID, mesure);
    }

    
//implementation de methode lirevaleur
 public double lireValeur() {     
    double min = getPlageSeuils().getmin() - 1.0;
        double max = getPlageSeuils().getmax() + 1.0;
    return min + Math.random() * (max - min);
    }
}
