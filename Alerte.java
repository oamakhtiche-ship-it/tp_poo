import java.time.LocalDateTime;

public class Alerte {
    private Capteur.typezone zone;
    private String capteurId;
    private LocalDateTime dateHeure;
    private String message;
    private Niveaugrav nivgravite;  
    private StatutAlerte statut;

    //constructor
    public Alerte( String capteurId, LocalDateTime dateHeure,String message, Niveaugrav nivgravite) {
      
        this.capteurId = capteurId;
        this.dateHeure = dateHeure;
        this.message = message;
        this.nivgravite = nivgravite;
        this.statut = StatutAlerte.ACTIVE;  
    
    }
    //methode pour acquittee une alerte
public void acquitter(){
    this.statut=StatutAlerte.ACQUITTEE;

}
//methode pour supprimer une alerte
public void supprimer(){
    this.statut=StatutAlerte.SUPPRIMEE;}


    //getters
    public String getcaptID(){return capteurId;}
    public LocalDateTime getdatetime(){return dateHeure;}
    public String getmessg(){return message;}
    public Niveaugrav getNiveaugrav(){return nivgravite;}
    public StatutAlerte getStatutAlerte(){return statut;}
    //setters
    public void setcaptID(String capteurId){this.capteurId= capteurId;}
    public void  getdatetime(LocalDateTime dateHeure){this.dateHeure= dateHeure;}
    public void  getmessg(String message){ this.message=message;}
    public void getStatutAlerte(StatutAlerte statut){ this.statut=statut;}



}
