import java.time.LocalDateTime;

public abstract  class Releve {
    protected String id;
    protected Capteur.typezone zone;
    protected String capteurId;
    protected LocalDateTime dateHeure;
  //constructor  
  public Releve(String id,Capteur.typezone zone, String capteurId, LocalDateTime dateHeure) {
        this.id = id;
        this.zone=zone;
        this.capteurId = capteurId;
        this.dateHeure = dateHeure;
    }   
//getters
    public String getId() { return id; }
     public Capteur.typezone getzone() { return zone; }
    public String getCapteurId() { return capteurId; }
    public LocalDateTime getDateHeure() { return dateHeure; }


}
