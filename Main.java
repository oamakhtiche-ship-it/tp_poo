import java.util.ArrayList;
import java.util.List;

public class Main {

    // Liste globale des alertes (simule un panneau d'alertes)
    static List<Alerte> panneauAlertes = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║     SYSTEME DE GESTION INTELLIGENTE DE FERME          ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════
        // 1. TEST CAPTEURS ENVIRONNEMENTAUX (zone de culture)
        // ═══════════════════════════════════════════════════
        System.out.println("══════════════════════════════════════════");
        System.out.println("  1. CAPTEURS ENVIRONNEMENTAUX");
        System.out.println("══════════════════════════════════════════");

        Plageseuil plageTemp    = new Plageseuil(15.0, 35.0);  // 15°C - 35°C
        Plageseuil plageHumid   = new Plageseuil(40.0, 80.0);  // 40% - 80%
        Plageseuil plagePluv    = new Plageseuil(0.0,  50.0);  // 0mm - 50mm

        Capteurenvir captTemp  = new Capteurenvir("ENV-001", Statuscapt.ACTIF, plageTemp,  "ZONE-CULTURE-1", Typemesure.TEMPERATURE);
        Capteurenvir captHumid = new Capteurenvir("ENV-002", Statuscapt.ACTIF, plageHumid, "ZONE-CULTURE-1", Typemesure.HUMIDITE);
        Capteurenvir captPluv  = new Capteurenvir("ENV-003", Statuscapt.ACTIF, plagePluv,  "ZONE-CULTURE-1", Typemesure.PLUVIOMETRIE);

        System.out.println("\n-- Envoi de releves environnementaux --");
        testerCapteurNum(captTemp,  "Temperature",   plageTemp);
        testerCapteurNum(captHumid, "Humidite",      plageHumid);
        testerCapteurNum(captPluv,  "Pluviometrie",  plagePluv);

        // ═══════════════════════════════════════════════════
        // 2. TEST CAPTEURS DE SOL
        // ═══════════════════════════════════════════════════
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  2. CAPTEURS DE SOL");
        System.out.println("══════════════════════════════════════════");

        Plageseuil plagePH      = new Plageseuil(5.5, 7.5);
        Plageseuil plageHumSol  = new Plageseuil(20.0, 60.0);
        Plageseuil plageAzote   = new Plageseuil(10.0, 50.0);

        capteursol captPH     = new capteursol("SOL-001", Statuscapt.ACTIF, plagePH,     "ZONE-CULTURE-1", Typemesure.PH);
        capteursol captHumSol = new capteursol("SOL-002", Statuscapt.ACTIF, plageHumSol, "ZONE-CULTURE-1", Typemesure.TAUX_HUMIDITE_SOL);
        capteursol captAzote  = new capteursol("SOL-003", Statuscapt.ACTIF, plageAzote,  "ZONE-CULTURE-1", Typemesure.TENEUR_AZOTE);

        System.out.println("\n-- Envoi de releves de sol --");
        testerCapteurNum(captPH,     "pH du sol",       plagePH);
        testerCapteurNum(captHumSol, "Humidite sol",    plageHumSol);
        testerCapteurNum(captAzote,  "Teneur en azote", plageAzote);

        // ═══════════════════════════════════════════════════
        // 3. TEST CAPTEURS D'EAU (zone aquacole)
        // ═══════════════════════════════════════════════════
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  3. CAPTEURS D'EAU (zone aquacole)");
        System.out.println("══════════════════════════════════════════");

        Plageseuil plageTempEau = new Plageseuil(18.0, 28.0);
        Plageseuil plagePHEau   = new Plageseuil(6.5,  8.5);

        Capteurdeau captTempEau = new Capteurdeau("EAU-001", Statuscapt.ACTIF, plageTempEau, "ZONE-AQUA-1", Typemesure.TEMPERATURE);
        Capteurdeau captPHEau   = new Capteurdeau("EAU-003", Statuscapt.ACTIF, plagePHEau,   "ZONE-AQUA-1", Typemesure.PH);

        System.out.println("\n-- Envoi de releves d'eau --");
        testerCapteurNum(captTempEau, "Temperature eau",   plageTempEau);
        testerCapteurNum(captPHEau,   "pH eau",            plagePHEau);

        // ═══════════════════════════════════════════════════
        // 4. TEST CAPTEURS BIOMETRIQUES (animaux)
        // ═══════════════════════════════════════════════════
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  4. CAPTEURS BIOMETRIQUES (animaux)");
        System.out.println("══════════════════════════════════════════");

        Plageseuil plageTempCorp = new Plageseuil(37.5, 39.5);  // temperature vache
        Plageseuil plageActivite = new Plageseuil(20.0, 200.0); // pas/minute

        Capteurbio captTempCorp = new Capteurbio("BIO-001", Statuscapt.ACTIF, plageTempCorp, "ZONE-ELEVAGE-1", Typemesure.TEMPERATURE_CORPORELLE, "VACHE-001");
        Capteurbio captActivite = new Capteurbio("BIO-002", Statuscapt.ACTIF, plageActivite, "ZONE-ELEVAGE-1", Typemesure.ACTIVITE,                "VACHE-001");

        System.out.println("\n-- Envoi de releves biometriques --");
        System.out.println("Animal suivi : VACHE-001");
        testerCapteurNum(captTempCorp, "Temperature corporelle", plageTempCorp);
        testerCapteurNum(captActivite, "Activite (pas/min)",     plageActivite);

        // ═══════════════════════════════════════════════════
        // 5. TEST CAPTEUR GPS
        // ═══════════════════════════════════════════════════
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  5. CAPTEUR GPS");
        System.out.println("══════════════════════════════════════════");

        Plageseuil plageBidon = new Plageseuil(0.0, 1.0); // non utilise pour GPS
        CapteurGPS captGPS = new CapteurGPS("GPS-001", Statuscapt.ACTIF, plageBidon, "ZONE-ELEVAGE-1", "VACHE-001");

        System.out.println("\n-- Envoi de releve GPS --");
        Releve releveGPS = captGPS.envoyerReleve();
        if (releveGPS instanceof ReleveGPS) {
            ReleveGPS gps = (ReleveGPS) releveGPS;
            System.out.printf("  GPS [%s] -> lat=%.5f, lon=%.5f%n",
                captGPS.getcode(), gps.getLatitude(), gps.getLongitude());

            // Limites geographiques de la zone (simulation)
            double latMin = 36.695, latMax = 36.710;
            double lonMin = 2.995,  lonMax = 3.010;

            Alerte alerteGPS = gps.genererAlerte(captGPS.plageSeuils);
            if (alerteGPS != null) {
                panneauAlertes.add(alerteGPS);
                System.out.println("  ⚠ ALERTE GPS : " + alerteGPS.getmessg());
            } else {
                System.out.println("  ✓ Animal dans sa zone.");
            }
        }

        // ═══════════════════════════════════════════════════
        // 6. TEST SUSPENSION / REACTIVATION
        // ═══════════════════════════════════════════════════
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  6. TEST SUSPENSION / REACTIVATION");
        System.out.println("══════════════════════════════════════════\n");

        System.out.println("Statut de ENV-001 avant : " + captTemp.getstatus());
        captTemp.suspendre();
        System.out.println("Statut de ENV-001 apres suspension : " + captTemp.getstatus());

        Releve releveSuspendu = captTemp.envoyerReleve();
        System.out.println("Releve envoye pendant suspension : " + releveSuspendu);

        captTemp.reactiver();
        System.out.println("Statut de ENV-001 apres reactivation : " + captTemp.getstatus());

        // ═══════════════════════════════════════════════════
        // 7. TEST DEFAILLANCE
        // ═══════════════════════════════════════════════════
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  7. TEST DEFAILLANCE");
        System.out.println("══════════════════════════════════════════\n");

        captHumid.signalerDefaillance();
        System.out.println("Statut de ENV-002 : " + captHumid.getstatus());

        // ═══════════════════════════════════════════════════
        // 8. PANNEAU DES ALERTES
        // ═══════════════════════════════════════════════════
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  8. PANNEAU DES ALERTES");
        System.out.println("══════════════════════════════════════════\n");

        if (panneauAlertes.isEmpty()) {
            System.out.println("  Aucune alerte detectee.");
        } else {
            // Trier : CRITIQUE en premier
            panneauAlertes.sort((a, b) -> {
                if (a.getNiveaugrav() == Niveaugrav.CRITIQUE && b.getNiveaugrav() != Niveaugrav.CRITIQUE) return -1;
                if (b.getNiveaugrav() == Niveaugrav.CRITIQUE && a.getNiveaugrav() != Niveaugrav.CRITIQUE) return  1;
                return 0;
            });

            System.out.printf("  %-10s %-12s %-10s %s%n", "CAPTEUR", "NIVEAU", "STATUT", "MESSAGE");
            System.out.println("  " + "-".repeat(70));
            for (Alerte a : panneauAlertes) {
                System.out.printf("  %-10s %-12s %-10s %s%n",
                    a.getcaptID(),
                    a.getNiveaugrav(),
                    a.getStatutAlerte(),
                    a.getmessg());
            }

            // Acquitter la premiere alerte
            System.out.println("\n-- Acquittement de la 1ere alerte --");
            panneauAlertes.get(0).acquitter();
            System.out.println("  Statut apres acquittement : " + panneauAlertes.get(0).getStatutAlerte());
        }

        // ═══════════════════════════════════════════════════
        // 9. HISTORIQUE DES RELEVES
        // ═══════════════════════════════════════════════════
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  9. HISTORIQUE DES RELEVES (SOL-001)");
        System.out.println("══════════════════════════════════════════\n");

        // Envoyer quelques releves supplementaires pour l'historique
        for (int i = 0; i < 3; i++) captPH.envoyerReleve();

        List<Releve> hist = captPH.getHistorique();
        System.out.println("  Nombre de releves enregistres : " + hist.size());
        for (Releve r : hist) {
            if (r instanceof Relevenum) {
                Relevenum rn = (Relevenum) r;
                System.out.printf("  [%s] valeur=%.2f type=%s%n",
                    rn.getDateHeure(), rn.getvalue(), rn.gettypemesure());
            }
        }

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║              FIN DES TESTS                      ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    // ─── Méthode utilitaire ────────────────────────────────────────────────────
    // Envoie un releve, affiche la valeur et gere l'alerte si hors plage
    static void testerCapteurNum(Capteurnum capteur, String label, Plageseuil plage) {
        Releve r = capteur.envoyerReleve();
        if (r instanceof Relevenum) {
            Relevenum rn = (Relevenum) r;
            double val = rn.getvalue();
            boolean ok = plage.estdanslaplage(val);
            System.out.printf("  [%s] %s = %.2f  ->  %s%n",
                capteur.getcode(), label, val, ok ? "✓ Normal" : "⚠ HORS PLAGE");

            if (!ok) {
                Alerte alerte = rn.genererAlerte(plage);
                if (alerte != null) {
                    panneauAlertes.add(alerte);
                    System.out.printf("     >> Alerte [%s] : %s%n",
                        alerte.getNiveaugrav(), alerte.getmessg());
                }
            }
        }
    }
}