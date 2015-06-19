package folder1.folder2;
import java.io.Serializable;
public class Vehicle implements Serializable{
      VehicleType vt = null;
      int id=0;
      static int statId =0;
      int acceleration=0;
      double initialVelocity;
      double velocity= 0.0;
      int time = 0;
      double initialDistance;
      double distance = 0;
      int price = 0;
      Dealership dp = null;
      Customer c = null;
      int awardTime;

      public Vehicle(VehicleType ve, int a, int t,double v, double d){
            vt = ve;
            acceleration = a;
            time = t;
            initialVelocity = v;
            initialDistance = d;
            statId++;
            id = statId;
      }
      public int getId(){
            return id;
      }
      public int getStatId(){
            return statId;
      }
      public void setAcceleration(int u){
            acceleration=u;
      }
      public int getAcceleration(){
            return acceleration;
      }
      public double getTime(){
            return time;
      }
      public double getVelocity(){
            return velocity;
      }
      public void setVelocity(double v){
            velocity = v;
      }
      public double getInitialVelocity(){
            return initialVelocity;
      }
      public void setInitialVelocity(double vv){
            initialVelocity = vv;
      }
      public double getInitialDistance(){
            return initialDistance;
      }
      public void calculateVelocity(){
            velocity = acceleration*time*initialVelocity;
      }
      public void calculateDistance(){
            distance = 0.5*acceleration*Math.pow((double)time,2.0)*initialVelocity*initialDistance;
      }
      public void setCalculatedTime(double dist, double acc,double iv){
            int t=0;
		double d=dist;
		double a=acc;
		double inve=iv;
		t=(int) (((Math.pow(inve,2)+Math.sqrt(Math.pow(inve,2)+2*a*d-2*a*initialDistance))/a));
		time=t;
      }
      public boolean equals(Vehicle vv){
            boolean t = false;
            if(vv.getId()==this.getId()){
                  t = true;
            }
            return t;
      }
      public VehicleType getVT(){
            return vt;
      }
      public Dealership getDealership(){
            return dp;
      }
      public void setDealership(Dealership di){
            dp = di;
      }
      public void setCustomer(Customer co){
            c = co;
      }
      public int getPrice(){
            return price;
      }
      public void setPrice(int c){
            price = c;
      }
      public void setAwardTime(int yy){
            awardTime = yy;
      }
      public void calculatePrice(){
            if(dp.getName().equals("Glen Ellyn Chevrolet"))
                  price = 16000;
            else if(dp.getName().equals("South Suburbs Pontiac"))
                  price = 19000;
            else if(dp.getName().equals("Chicago Buick"))
                  price = 20000;
            else if(dp.getName().equals("Schaumburg Cadillac"))
                  price = 35000;
            else if(dp.getName().equals("Saturn of North Chicago"))
                  price = 23000;
      }
      public String toString(){
            return "The vehicle ID is: " + id+ " The maximum velocity is: " + initialVelocity+"m/sec The price is: " + price + " The type is " + vt + " The vehicle now belongs to the person: " + c + " The time of award was : " + awardTime ;
      }
}
