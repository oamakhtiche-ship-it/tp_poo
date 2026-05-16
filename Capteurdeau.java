public class Capteurdeau extends Capteurnum{


//constructeur
public Capteurdeau(String code,Statuscapt status,Plageseuil plageSeuils,String zoneID,Typemesure mesure){
    super(code, status, plageSeuils, zoneID, mesure);
}
//implementation de methode lireValeur
public double lireValeur() {
   double min = getPlageSeuils().getmin() - 1.0;
   double max = getPlageSeuils().getmax() + 1.0;
    return min + Math.random() * (max - min); 
} 
}