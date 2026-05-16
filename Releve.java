import java.time.LocalDateTime;

public abstract  class Releve {
    protected String id;
    protected String capteurId;
    protected LocalDateTime dateHeure;
  //constructor  
  public Releve(String id, String capteurId, LocalDateTime dateHeure) {
        this.id = id;
        this.capteurId = capteurId;
        this.dateHeure = dateHeure;
    }   
//getters
    public String getId() { return id; }
    public String getCapteurId() { return capteurId; }
    public LocalDateTime getDateHeure() { return dateHeure; }


}
