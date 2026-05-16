public class Capteurbio extends Capteurnum{
//chaque animla a ce type de capteur
    private String animalId; //pour savoir de quel animal


//constructeur 
public Capteurbio(String code,Statuscapt status,Plageseuil plageSeuils,String zoneID,Typemesure mesure,String animalID){
    super(code, status, plageSeuils, zoneID, mesure);
    this.animalId=animalID;
}

//implementer la methode lireValeur
public double lireValeur(){
     double min = getPlageSeuils().getmin() - 1.0;
        double max = getPlageSeuils().getmax() + 1.0;
        return min + Math.random() * (max - min);
};
   //getters
 public String getAnimalId() { return animalId; }
   //setters
 public void setAnimalId(String animalId) { this.animalId = animalId; }
}