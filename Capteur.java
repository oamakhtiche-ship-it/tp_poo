
import java.util.ArrayList;
import java.util.List;

abstract class Capteur implements Suspendable{
    //les attributs
   protected String code;
   protected  Statuscapt statut;
   protected Plageseuil plageSeuils;
   protected String zoneID;       // zone a laquelle le capteur est affecte
   protected List<Releve> historique;
    
//constructor
public Capteur(String code,Statuscapt status,Plageseuil plageSeuils,String zoneID){
this.code=code;
this.statut=Statuscapt.ACTIF;
this.zoneID = zoneID;
this.plageSeuils = plageSeuils;
this.historique = new ArrayList<>();
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
public String getzoneID(){return zoneID;}
public Statuscapt getstatus(){return statut;}
public Plageseuil getPlageSeuils() { return plageSeuils; }
   //  afficher tous l'historique
public List<Releve> getHistorique() {
        return historique;
    }

// setters
public void setcode(String code){this.code=code;}
public void setZoneId(String zoneId) { this.zoneID = zoneId; }
public void setStatut(Statuscapt statut) { this.statut = statut; }
public void setPlageSeuils(Plageseuil plageSeuils) { this.plageSeuils = plageSeuils; 
}
}



