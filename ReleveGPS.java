import java.time.LocalDateTime;

public class ReleveGPS extends Releve {
    private double latitude;
    private double longitude;

//constructor
 public ReleveGPS(String id, String capteurId,
                     LocalDateTime dateHeure,
                     double latitude, double longitude) {
        super(id, capteurId, dateHeure);
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
    double Min=-100;double Max=100;
    boolean estdansZone = latitude >= Plageseuils.getmin() && latitude <= Plageseuils.getmax() && longitude >= Plageseuils.getmin() && longitude <=Plageseuils.getmax() ;
    if (estdansZone){return null;}

    String message = "Animal sorti de sa zone  lat=" + latitude + ", lon=" + longitude;
   
    return new Alerte(
        capteurId,
        LocalDateTime.now(),
        message,
        Niveaugrav.CRITIQUE);}
    

 }

