public class Plageseuil {
    private double max;
    private double min;
    private double min2=min-10;
    private double max2=max+10;

    public Plageseuil(double min, double max) {
        if (min >= max)
            throw new IllegalArgumentException("valeur min doit etre strictement inferieure a valeur max");
        this.min = min;
        this.max = max;
    }
//get et set de max
    public double  getmax() { return max; }
    public void setmax(float max){this.max=max;}
 //get et set de min   
    public double getmin() { return min; }
    public void setmin(float min){this.min=min;}


//verifier si la valeur est dans la plageseuil
public boolean estdanslaplage(double val){
   return val>=min && val<=max;
}
//verifier si la valeur est hors les limites max
public boolean horsmaxplage(double val){
    return val<min2  || val>max2;
}
}
