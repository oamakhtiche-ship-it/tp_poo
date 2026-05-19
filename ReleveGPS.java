import java.time.LocalDateTime;

public class ReleveGPS extends Releve {
    private double latitude;
    private double longitude;

//constructor
 public ReleveGPS(String id,Capteur.typezone zone, String capteurId,
                     LocalDateTime dateHeure,
                     double latitude, double longitude) {
        super(id,zone, capteurId, dateHeure);
        this.latitude = latitude;
        this.longitude = longitude;
    }   
//getters
public double getLatitude()  { return latitude; }
public double getLongitude() { return longitude; }
//setters
public void setLatitude(double latitude){this.latitude=latitude; }
public void setLongitude(double longitude){this.longitude=longitude; }

//declancher une alerte
 public Alerte genererAlerte(Plageseuil Plageseuils){
Plageseuil plageseuils2 = new Plageseuil(0.0,100);
 boolean estdansZone = Plageseuils.estdanslaplage(latitude) && plageseuils2.estdanslaplage(longitude);

    if (estdansZone) {return null;}

    else {
String message = "Animal sorti de sa zone lat=" + latitude + ", lon=" + + longitude;
boolean horszone=Plageseuils.horsmaxplage(latitude) || plageseuils2.horsmaxplage(longitude);
     if (horszone) {

            return new Alerte(
                capteurId,
                LocalDateTime.now(),
                message,
                Niveaugrav.CRITIQUE
            );
        }
        else {

            return new Alerte(
                capteurId,
                LocalDateTime.now(),
                message,
                Niveaugrav.AVERTISSEMENT
            );
        }
    }
}
    

 }

