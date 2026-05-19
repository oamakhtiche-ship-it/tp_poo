import java.time.LocalDateTime;

public class CapteurGPS extends Capteur {
  //chaque animal a un capteur de ce type
 private String animalID;

  //constructor
  public CapteurGPS(String code,Statuscapt status,Plageseuil plageSeuils,typezone zoneID,String animalID){
    super( code, status, plageSeuils,zoneID);
    this.animalID=animalID;
   }

   
   //implementer la methode envoyer releve
  public Releve envoyerReleve(){
     //traite le cas de capteur suspendu
        if (estSuspendu()) {
    System.out.println("Capteur est desactive");
            return null;
        }
        //sinon(Simulation) 
        double latitude  = 36.70 + (Math.random() - 0.5) * 0.01;
        double longitude = 3.00  + (Math.random() - 0.5) * 0.01;
 
        ReleveGPS releve = new ReleveGPS(
            java.util.UUID.randomUUID().toString(),zoneID,getcode(),LocalDateTime.now(),latitude,longitude );
        ajouterReleve(releve);
        //detection d'une Alerte
    releve.genererAlerte(getPlageSeuils());
    Alerte alerteGPS=  releve.genererAlerte(getPlageSeuils());
    if (alerteGPS != null) {
                    pannAlertes.add(alerteGPS);
                }
        return releve;

   }

   //getters
 public String getAnimalId() { return animalID; }
   //setters
 public void setAnimalId(String animalId) { this.animalID = animalId; }
} 

