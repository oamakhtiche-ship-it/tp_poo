
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

abstract class Capteur implements Suspendable{
    //les attributs
   protected String code;
   protected  Statuscapt statut;
   protected Plageseuil plageSeuils;
   public enum typezone{ELEVAGE,CULTURE,AQUACOLE}
   protected typezone zoneID;       // zone a laquelle le capteur est affecte
   protected List<Releve> historique;
   protected List<Alerte> pannAlertes;
    
//constructor
public Capteur(String code,Statuscapt status,Plageseuil plageSeuils,typezone zoneID){
this.code=code;
this.zoneID=zoneID;
this.statut=Statuscapt.ACTIF;
this.zoneID = zoneID;
this.plageSeuils = plageSeuils;
this.historique = new ArrayList<>();
this.pannAlertes=new ArrayList<>();
}
//chaque capteur envoie son releve a sa facon (abstraite)
public abstract Releve envoyerReleve();

// Enregistre un releve dans l'historique  
public void ajouterReleve(Releve releve) {
        historique.add(releve);
    }


// Implementation de l'interface Suspendable
    @Override
    //desactiver le capteur
    public void suspendre() {
        this.statut = Statuscapt.SUSPENDU;
        System.out.println("Capteur est suspendu");
    }
 //reactiver le capteur
    @Override
    public void reactiver() {
        this.statut = Statuscapt.ACTIF;
        System.out.println("Capteur reactive.");
    }
 
    @Override
    public boolean estSuspendu() {
        return this.statut == Statuscapt.SUSPENDU;
    }
     // Marquer le capteur comme defaillant
    public void signalerDefaillance() {
        this.statut = Statuscapt.DEFAILLANT;
        System.out.println("Capteurdefaillant.");
    }
   //  getters
public String getcode(){return code;}
public typezone getzoneID(){return zoneID;}
public Statuscapt getstatus(){return statut;}
public Plageseuil getPlageSeuils() { return plageSeuils; }
   //  afficher tous l'historique
public List<Releve> getHistorique() {
        return historique;
    }

// setters
public void setcode(String code){this.code=code;}
public void setZoneId(typezone zoneId) { this.zoneID = zoneId; }
public void setStatut(Statuscapt statut) { this.statut = statut; }
public void setPlageSeuils(Plageseuil plageSeuils) { this.plageSeuils = plageSeuils; }


//methode pour filtrer les releves
 public List<Releve> filtrerReleve(LocalDateTime debut, LocalDateTime fin ){
 List<Releve> resultats = new ArrayList<>();
 for (Releve a : historique) {
             // filtre periode
        if (debut != null  && a.getDateHeure().isBefore(debut)) continue;
        if (fin != null  &&  a.getDateHeure().isAfter(fin)) continue; 
  resultats.add(a);
        }
      return resultats;
 }

 //afficher la liste des releves
 public void afficheReleves(List<Releve> hist){
    if (hist.isEmpty()) {
        System.out.println("  Aucun releve detectee.");
        return;
        } 
    System.out.printf("  %-10s %-14s %-12s %-20s%n","ID", "capteurID", "Zone", "DATE/HEURE");
    System.out.println("  " + "-".repeat(80));
    for (Releve a : hist) {
         System.out.printf("  %-10s %-14s %-12s %-20s%n", a.getId(), a.getCapteurId(), a.getzone(), a.getDateHeure());
        }
    }

    
 }




