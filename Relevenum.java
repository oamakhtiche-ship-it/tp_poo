import java.time.LocalDateTime;

public class Relevenum extends Releve {
    private double val;
    private Typemesure typemesure;
 //constructor
    public Relevenum(String id,Capteur.typezone zone, String capteurId, LocalDateTime dateHeure, double val, Typemesure typemesure) {
        super(id,zone, capteurId, dateHeure);
        this.val = val;
        this.typemesure = typemesure;
    } 
    
  //declancher une alerte  
    public Alerte genererAlerte(Plageseuil plageSeuils) {
        if (plageSeuils.estdanslaplage(val)) return null;
     String message = "Valeur " + val + " hors plage [" +  plageSeuils.getmin() + " - " +
                         plageSeuils.getmax() + "] pour " + typemesure;
        // Determine le niveau de gravite 
        if ( plageSeuils.horsmaxplage(val)){ 
 
     return new Alerte(
             getCapteurId(), LocalDateTime.now(), message, Niveaugrav.CRITIQUE );
    }
    else{ return new Alerte(
             getCapteurId(), LocalDateTime.now(), message, Niveaugrav. AVERTISSEMENT ) ;}
            
    }
    //getters
    public double getvalue(){ return this.val; } 
    public Typemesure gettypemesure(){ return this.typemesure; } 
    //setters
    public void setvalue (double val){this.val=val;}
}
