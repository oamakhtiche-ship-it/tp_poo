import java.time.LocalDateTime;

abstract class Capteurnum extends Capteur{
    protected Typemesure mesure;


//constructor
 public Capteurnum(String code,Statuscapt status,Plageseuil plageSeuils,String zoneID,Typemesure mesure){  
    
    super(code, status, plageSeuils,zoneID);
        this.mesure = mesure;
 }

//on doit lire les valeurs de fichier
 protected abstract double lireValeur();



 // le capteur numerique envoie les valeurs a le releve numerique
 public Releve envoyerReleve(){ 
    //traite le cas de capteur suspendu
        if (estSuspendu()) {
    System.out.println("Capteur est desactive");
            return null;
        }
        //sinon
        double valeur = lireValeur();
        Relevenum releve = new Relevenum(
            java.util.UUID.randomUUID().toString(), getcode(), LocalDateTime.now(), valeur, mesure);
        ajouterReleve(releve);
        
      //detection d'une Alerte
      releve.genererAlerte(getPlageSeuils());
 
return releve;
    }; 
 
 //getters
 public Typemesure getTypemesure() { return mesure; }
 //setters
    public void setTypeMesure(Typemesure mesure) { this.mesure = mesure; }
}
