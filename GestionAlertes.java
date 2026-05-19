import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestionAlertes {

 //  Liste de toutes les alertes ────────────────────────────────────────
    private List<Alerte> historique;

//constructor
    public GestionAlertes() {
        this.historique = new ArrayList<>();
    }

//ajouter une alerte
    public void ajouterAlerte(Alerte alerte) {
        if (alerte != null) {
            historique.add(alerte);
            System.out.println("  [ALERTE AJOUTEE] " 
                + alerte.getNiveaugrav() + " : " + alerte.getmessg());
        }
    }
// trieer les alertes selon le niveau de gravite
    public List<Alerte> trieralerte() {
    // filtrer seulement les ACTIVES
        List<Alerte> actives = new ArrayList<>();
    for (Alerte a : historique) {
        if (a.getStatutAlerte() == StatutAlerte.ACTIVE) {
            actives.add(a);
        }
    }

    actives.sort((a, b) -> prioriteNiveau(a.getNiveaugrav())
                         - prioriteNiveau(b.getNiveaugrav()));
    return actives;
}

private int prioriteNiveau(Niveaugrav n) {
    switch (n) {
        case CRITIQUE:      return 0;
        case AVERTISSEMENT: return 1;
        default:            return 2;
    }
}

        //afficher une loste des alertes
 public void afficherAlertes(List<Alerte>  actives){

        if (actives.isEmpty()) {
            System.out.println("  Aucune alerte detectee.");
                return;
        } 
    System.out.printf("  %-10s %-14s %-12s %-20s %s%n","CAPTEUR", "NIVEAU", "STATUT", "DATE/HEURE", "MESSAGE");
        System.out.println("  " + "-".repeat(80));

     for (Alerte a : actives) {
            System.out.printf("  %-10s %-14s %-12s %-20s %s%n", a.getcaptID(), a.getNiveaugrav(), a.getStatutAlerte(), a.getdatetime().toString(), a.getmessg());
        }
    }

  
    // 3. ACQUITTER UNE ALERTE
    public void acquitter(Alerte alerte) {
        if (historique.contains(alerte)) {
            alerte.acquitter();
            System.out.println("  Alerte acquittee : " + alerte.getmessg());
        } else {
            System.out.println("  Alerte introuvable.");
        }
    }

    // ══════════════════════════════════════════════════════════════════════
    // 4. SUPPRIMER UNE ALERTE
    // ══════════════════════════════════════════════════════════════════════
    public void supprimer(Alerte alerte) {
        if (historique.contains(alerte)) {
            alerte.supprimer();
            System.out.println("  Alerte supprimee : " + alerte.getmessg());
        } else {
            System.out.println("  Alerte introuvable.");
        }
    }

    //filterer les alertes 
    public List<Alerte> filtrerAlerte( String typeCapteur,  Niveaugrav niveau,LocalDateTime debut, LocalDateTime fin          ) {
    
        System.out.println("  HISTORIQUE DES ALERTES FILTRE");
        System.out.println("  Filtres :");
        System.out.println("    Type capteur : " + (typeCapteur == null ? "tous"  : typeCapteur));
        System.out.println("    Niveau       : " + (niveau      == null ? "tous"  : niveau));
        System.out.println("    De           : " + (debut       == null ? "debut" : debut));
        System.out.println("    A            : " + (fin         == null ? "fin"   : fin));
        System.out.println("  " + "-".repeat(80));

        List<Alerte> resultats = new ArrayList<>();

        for (Alerte a : historique) {

            // filtre type capteur
            if (typeCapteur != null 
             && !a.getcaptID().startsWith(typeCapteur)) continue;

            // filtre niveau
            if (niveau != null 
             && a.getNiveaugrav() != niveau) continue;

            // filtre periode
            if (debut != null 
             && a.getdatetime().isBefore(debut)) continue;
            if (fin != null   
             && a.getdatetime().isAfter(fin))    continue;

            resultats.add(a);
        }
      return resultats;
    }

    // getter pour l'historique
    public List<Alerte> getHistorique() { return historique; }
}