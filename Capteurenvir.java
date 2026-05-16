public class Capteurenvir extends Capteurnum{

    //constructor
  public Capteurenvir(String code,Statuscapt status,Plageseuil plageSeuils,String zoneID,Typemesure mesure){
    super(code, status, plageSeuils, zoneID, mesure);
}
//implemenatation de methode lireValeur
protected double lireValeur() {
   double min = getPlageSeuils().getmin() - 1.0;
   double max = getPlageSeuils().getmax() + 1.0;
    return min + Math.random() * (max - min); 
}   
}
